package com.local.rank.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.local.rank.constant.RankConstants;
import com.local.rank.daos.repositories.PlayerDetailsRepository;
import com.local.rank.daos.repositories.TransactionPlayerRepository;
import com.local.rank.daos.repositories.TransactionTableRepository;
import com.local.rank.db.model.PlayerDetail;
import com.local.rank.db.model.TransactionPlayer;
import com.local.rank.db.model.TransactionTable;
import com.local.rank.request.MoneyDeductionRequest;
import com.local.rank.request.PlayerRequest;

@Service
public class RankManagerIFImpl implements RankManagerIF{

	@Autowired
	private PlayerDetailsRepository playerDetailsRepository;
	@Autowired
	private TransactionPlayerRepository transactionPlayerRepository;
	@Autowired
	private TransactionTableRepository transactionTableRepository;
	@Override
	public PlayerRequest savePlayerDetails(PlayerRequest playerDetails) {
		PlayerDetail plDetails=new PlayerDetail();
		if(playerDetails!=null)
		{
			/*plDetails.setPlayerid(!StringUtils.isEmpty(playerDetails.getPlayerID())
					? (long)playerDetails.getPlayerID() : null);*/

			plDetails.setPlayername(!StringUtils.isEmpty(playerDetails.getPlayerName())
					? playerDetails.getPlayerName() : null);
			plDetails.setDepositingamount(!StringUtils.isEmpty(playerDetails.getDepositingAmount())
					? (long)(playerDetails.getDepositingAmount()) : null);
			plDetails.setCurrentbalance(!StringUtils.isEmpty(playerDetails.getCurrentBalance())
					? (long)playerDetails.getCurrentBalance() : null);
		}
		playerDetailsRepository.save(plDetails);
		return playerDetails;
	}
	public MoneyDeductionRequest moneyDeductionDetails(MoneyDeductionRequest moneyDeductionRequest) {
		TransactionPlayer transactionPlayer=new TransactionPlayer();
		TransactionTable transactionTable=null;
		PlayerDetail playerDetail=playerDetailsRepository.findByplayerid(
				!StringUtils.isEmpty(moneyDeductionRequest.getPlayerID())?(long)moneyDeductionRequest.getPlayerID():null);

		transactionTable=(moneyDeductionRequest.getTransactionID()==0)?saveTransactionDetails(moneyDeductionRequest):transactionTableRepository.findBytransactionid(
				(long)moneyDeductionRequest.getTransactionID());

		transactionPlayer.setPlayerDetail(playerDetail);
		transactionPlayer.setTransactionTable(transactionTable);

		transactionPlayer.setBetingamount(StringUtils.isEmpty(moneyDeductionRequest.getPromoCode())
				?moneyDeductionRequest.getBettingAmount():0);
		
		transactionPlayer.setCreationdate(new Date());
		transactionPlayer.setWinningamount(!StringUtils.isEmpty(moneyDeductionRequest.getWinningAmount())?(long)moneyDeductionRequest.getWinningAmount():null);
		transactionPlayer.setWinningflag(!StringUtils.isEmpty(moneyDeductionRequest.getWiningFlag())?moneyDeductionRequest.getWiningFlag():RankConstants.VALUE_N);
		transactionPlayerRepository.save(transactionPlayer);
		moneyDeductionRequest.setTransactionID(StringUtils.isEmpty(transactionTable)? (int)transactionTable.getTransactionid() : null);
		return moneyDeductionRequest;
	}
	private TransactionTable saveTransactionDetails(MoneyDeductionRequest moneyDeductionRequest) {
		TransactionTable transactionTable=new TransactionTable();
		transactionTable.setTransactionname(!StringUtils.isEmpty(moneyDeductionRequest.getTransactionName())
				? moneyDeductionRequest.getTransactionName() : null);
		transactionTable.setTransactiondate(new Date());
		transactionTable=transactionTableRepository.save(transactionTable);
		return transactionTable;
	}
	public MoneyDeductionRequest winningSerciceDetails(MoneyDeductionRequest moneyDeductionRequest) {
		
		double currentBalance = 0;
		if(null!=moneyDeductionRequest)
		{
			moneyDeductionRequest.setCurrentBalance(operationalMethodForwinningSerciceDetails(moneyDeductionRequest,currentBalance));
			responseMapper(moneyDeductionRequest);
		}
		return moneyDeductionRequest;
	}
	private void responseMapper(MoneyDeductionRequest moneyDeductionRequest) {
		TransactionPlayer transactionPlayer=transactionPlayerRepository.findTransactionPlayer(moneyDeductionRequest.getPlayerID(),
				moneyDeductionRequest.getTransactionID());
		if(transactionPlayer!=null)
		{
			moneyDeductionRequest.setTransactionName(!StringUtils.isEmpty(transactionPlayer.getTransactionTable().getTransactionname())
					?transactionPlayer.getTransactionTable().getTransactionname():null);
			moneyDeductionRequest.setBettingAmount(transactionPlayer.getBetingamount()!=0
					?transactionPlayer.getBetingamount():0);
		}
		
	}
	private double operationalMethodForwinningSerciceDetails(MoneyDeductionRequest moneyDeductionRequest,
			double currentBalance) {
		transactionPlayerRepository.updateTransactionPlayer(
				moneyDeductionRequest.getPlayerID(),moneyDeductionRequest.getTransactionID(),moneyDeductionRequest.getWinningAmount()
				,moneyDeductionRequest.getWiningFlag());
		
		PlayerDetail playerDetail=playerDetailsRepository.findByplayerid(
				moneyDeductionRequest.getPlayerID()!=0?(long)moneyDeductionRequest.getPlayerID():null);
		
		if(playerDetail!=null && RankConstants.VALUE_Y.equalsIgnoreCase(moneyDeductionRequest.getWiningFlag())){
		currentBalance=(playerDetail.getCurrentbalance()==0 && playerDetail.getDepositingamount()!=0)
				?(moneyDeductionRequest.getWinningAmount() + playerDetail.getDepositingamount())
				:(moneyDeductionRequest.getWinningAmount() + playerDetail.getCurrentbalance());
		}
		else if(playerDetail!=null && RankConstants.VALUE_N.equalsIgnoreCase(moneyDeductionRequest.getWiningFlag()))
		{
			TransactionPlayer transactionPlayer=transactionPlayerRepository.findTransactionPlayer(moneyDeductionRequest.getPlayerID(),
					moneyDeductionRequest.getTransactionID());
			currentBalance=(playerDetail.getCurrentbalance()==0 && playerDetail.getDepositingamount()!=0)
					?(playerDetail.getDepositingamount()-transactionPlayer.getBetingamount())
					:(playerDetail.getCurrentbalance()-transactionPlayer.getBetingamount());
		}
		playerDetailsRepository.updatePlayerid(moneyDeductionRequest.getPlayerID(), currentBalance);
		return currentBalance;
	}

}
