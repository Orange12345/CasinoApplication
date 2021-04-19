package com.local.rank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.local.rank.constant.RankConstants;
import com.local.rank.service.RankManagerIFImpl;
import com.omsa.rank.request.MoneyDeductionRequest;
import com.omsa.rank.request.PlayerRequest;
import com.omsa.rank.response.ResponseObjectListForDeductionAndMoney;
import com.omsa.rank.response.ResponseObjectListPlayer;

@RestController
public class CasinoRankController {
	@Autowired
	public RankManagerIFImpl rankManagerImpl;
	
	@RequestMapping(value=RankConstants.SAVE_INFO_PLAYER_ENDPOINT,method=RequestMethod.POST)
	public ResponseEntity<ResponseObjectListPlayer> savePlayerDetails(@RequestBody PlayerRequest playerRequest)
	{
		ResponseObjectListPlayer responseObjectListPlayer=new ResponseObjectListPlayer();
		PlayerRequest playerResponse=rankManagerImpl.savePlayerDetails(playerRequest);
		responseObjectListPlayer.setStatusCode(RankConstants.STATUS_CODE_SUCCESS);
		responseObjectListPlayer.setMessage(RankConstants.MESSAGE_SUCCESS);
		responseObjectListPlayer.setResponsePayload(playerResponse);
		return new ResponseEntity<>(responseObjectListPlayer, HttpStatus.OK);
	}
	
	@RequestMapping(value=RankConstants.MONEY_DEDUCTION_ENDPOINT,method=RequestMethod.POST)
	public ResponseEntity<ResponseObjectListForDeductionAndMoney> moneyDeductionDetails(@RequestBody MoneyDeductionRequest moneyDeductionRequest)
	{
		ResponseObjectListForDeductionAndMoney responseObjectListForDeductionAndMoney=new ResponseObjectListForDeductionAndMoney();
		MoneyDeductionRequest playerResponse=rankManagerImpl.moneyDeductionDetails(moneyDeductionRequest);
		responseObjectListForDeductionAndMoney.setStatusCode(RankConstants.STATUS_CODE_SUCCESS);
		responseObjectListForDeductionAndMoney.setMessage(RankConstants.MESSAGE_SUCCESS);
		responseObjectListForDeductionAndMoney.setResponsePayload(playerResponse);
		return new ResponseEntity<>(responseObjectListForDeductionAndMoney, HttpStatus.OK);
	}
	
	@RequestMapping(value=RankConstants.WINNING_DETAILS_ENDPOINT,method=RequestMethod.PUT)
	public ResponseEntity<ResponseObjectListForDeductionAndMoney> winningSerciceDetails(@RequestBody MoneyDeductionRequest moneyDeductionRequest)
	{
		ResponseObjectListForDeductionAndMoney responseObjectListForDeductionAndMoney=new ResponseObjectListForDeductionAndMoney();
		MoneyDeductionRequest playerResponse=rankManagerImpl.winningSerciceDetails(moneyDeductionRequest);
		responseObjectListForDeductionAndMoney.setStatusCode(RankConstants.STATUS_CODE_SUCCESS);
		responseObjectListForDeductionAndMoney.setMessage(RankConstants.MESSAGE_SUCCESS);
		responseObjectListForDeductionAndMoney.setResponsePayload(playerResponse);
		return new ResponseEntity<>(responseObjectListForDeductionAndMoney, HttpStatus.OK);
	}
}
