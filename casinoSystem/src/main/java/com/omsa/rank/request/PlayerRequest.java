package com.omsa.rank.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerRequest {
	@JsonProperty("playerID") 
    public int getPlayerID() { 
		 return this.playerID; } 
    public void setPlayerID(int playerID) { 
		 this.playerID = playerID; } 
    int playerID;
    @JsonProperty("playerName") 
    public String getPlayerName() { 
		 return this.playerName; } 
    public void setPlayerName(String playerName) { 
		 this.playerName = playerName; } 
    String playerName;
    @JsonProperty("depositingAmount") 
    public double getDepositingAmount() { 
		 return this.depositingAmount; } 
    public void setDepositingAmount(double depositingAmount) { 
		 this.depositingAmount = depositingAmount; } 
    double depositingAmount;
    @JsonProperty("currentBalance") 
    public double getCurrentBalance() { 
		 return this.currentBalance; } 
    public void setCurrentBalance(double currentBalance) { 
		 this.currentBalance = currentBalance; } 
    double currentBalance;
}
