package com.local.rank.daos.repositories;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.local.rank.db.model.TransactionPlayer;

@Repository
public interface TransactionPlayerRepository extends CrudRepository<TransactionPlayer, Long> {

	@Query(value="select * from TRANSACTION_PLAYER where PLAYERID=?1 and TRANSACTIONID=?2",nativeQuery=true)
	public TransactionPlayer findTransactionPlayer(int playerId, int transactionId);
	
	@Transactional
	@Modifying
	@Query(value="update TRANSACTION_PLAYER set winningamount=?3, winningflag=?4 where PLAYERID=?1 and TRANSACTIONID=?2",nativeQuery=true)
	public void updateTransactionPlayer(int playerId, int transactionId,double winningamount,String winningflag);
}
