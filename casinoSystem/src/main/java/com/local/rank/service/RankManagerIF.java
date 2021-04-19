package com.local.rank.service;

import com.omsa.rank.request.MoneyDeductionRequest;
import com.omsa.rank.request.PlayerRequest;

public interface RankManagerIF {

	/**
	 * Method for save Playerdetails in to DB
	 * 
	 * @return an object of PlayerDetails
	 * @param playerDetails
	 *            is passed
	 */
	public abstract PlayerRequest savePlayerDetails(PlayerRequest playerDetails);
	
	/**
	 * Method for save money deduction in to DB
	 * 
	 * @return an object of MoneyDeductionRequest
	 * @param moneyDeductionRequest
	 *            is passed
	 */
	public abstract MoneyDeductionRequest moneyDeductionDetails(MoneyDeductionRequest moneyDeductionRequest);
	
	/**
	 * Method for save money winningSerciceDetails in to DB
	 * 
	 * @return an object of MoneyDeductionRequest
	 * @param moneyDeductionRequest
	 *            is passed
	 */
	public abstract MoneyDeductionRequest winningSerciceDetails(MoneyDeductionRequest moneyDeductionRequest);
	
	
}
