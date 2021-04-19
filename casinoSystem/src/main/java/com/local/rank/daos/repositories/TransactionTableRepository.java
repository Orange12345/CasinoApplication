package com.local.rank.daos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.local.rank.db.model.TransactionTable;

@Repository
public interface TransactionTableRepository extends CrudRepository<TransactionTable, Long>{

	/**
	 * Method  to find all TransactionTable  for a transactionid
	 * @param transactionid of type long
	 *            is passed
	 * @return TransactionTable is getting returned
	 */
	public TransactionTable findBytransactionid(long transactionid);
}
