package com.local.rank.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MoneyDeductionRequest {
	@JsonProperty("playerID") 
    public int getPlayerID() { 
		 return this.playerID; } 
    public void setPlayerID(int playerID) { 
		 this.playerID = playerID; } 
    int playerID;
    @JsonProperty("transactionID") 
    public int getTransactionID() { 
		 return this.transactionID; } 
    public void setTransactionID(int transactionID) { 
		 this.transactionID = transactionID; } 
    int transactionID;
    @JsonProperty("bettingAmount") 
    public double getBettingAmount() { 
		 return this.bettingAmount; } 
    public void setBettingAmount(double bettingAmount) { 
		 this.bettingAmount = bettingAmount; } 
    double bettingAmount;
    @JsonProperty("promoCode") 
    public String getPromoCode() { 
		 return this.promoCode; } 
    public void setPromoCode(String promoCode) { 
		 this.promoCode = promoCode; } 
    String promoCode;

    @JsonProperty("transactionName") 
    public String getTransactionName() { 
		 return this.transactionName; } 
    public void setTransactionName(String transactionName) { 
		 this.transactionName = transactionName; } 
    String transactionName;
    
    double winningAmount;
    @JsonProperty("winningAmount") 
	public double getWinningAmount() {
		return winningAmount;
	}
	public void setWinningAmount(double winningAmount) {
		this.winningAmount = winningAmount;
	}
	@JsonProperty("winingFlag") 
	String winingFlag;
	public String getWiningFlag() {
		return winingFlag;
	}
	public void setWiningFlag(String winingFlag) {
		this.winingFlag = winingFlag;
	}
	
	 @JsonProperty("currentBalance") 
	    public double getCurrentBalance() { 
			 return this.currentBalance; } 
	    public void setCurrentBalance(double currentBalance) { 
			 this.currentBalance = currentBalance; } 
	    double currentBalance;
}
