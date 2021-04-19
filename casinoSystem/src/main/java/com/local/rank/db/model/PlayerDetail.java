package com.local.rank.db.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the PLAYER_DETAILS database table.
 * 
 */
@Entity
@Table(name="PLAYER_DETAILS")
@NamedQuery(name="PlayerDetail.findAll", query="SELECT p FROM PlayerDetail p")
public class PlayerDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long playerid;

	private double currentbalance;

	private double depositingamount;

	private String playername;

	public PlayerDetail() {
	}

	public long getPlayerid() {
		return this.playerid;
	}

	public void setPlayerid(long playerid) {
		this.playerid = playerid;
	}

	public double getCurrentbalance() {
		return this.currentbalance;
	}

	public void setCurrentbalance(double currentbalance) {
		this.currentbalance = currentbalance;
	}

	public double getDepositingamount() {
		return this.depositingamount;
	}

	public void setDepositingamount(double depositingamount) {
		this.depositingamount = depositingamount;
	}

	public String getPlayername() {
		return this.playername;
	}

	public void setPlayername(String playername) {
		this.playername = playername;
	}
}