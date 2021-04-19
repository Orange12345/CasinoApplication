package com.local.rank.db.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the TRANSACTION_PLAYER database table.
 * 
 */
@Entity
@Table(name="TRANSACTION_PLAYER")
@NamedQuery(name="TransactionPlayer.findAll", query="SELECT t FROM TransactionPlayer t")
public class TransactionPlayer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long transactionplayerid;

	private double betingamount;

	@Temporal(TemporalType.DATE)
	private Date creationdate;

	private double winningamount;

	private String winningflag;

	//bi-directional many-to-one association to PlayerDetail
	@OneToOne
	@JoinColumn(name="PLAYERID")
	private PlayerDetail playerDetail;

	//bi-directional many-to-one association to TransactionTable
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="TRANSACTIONID")
	private TransactionTable transactionTable;

	public TransactionPlayer() {
	}

	public long getTransactionplayerid() {
		return this.transactionplayerid;
	}

	public void setTransactionplayerid(long transactionplayerid) {
		this.transactionplayerid = transactionplayerid;
	}

	public double getBetingamount() {
		return this.betingamount;
	}

	public void setBetingamount(double betingamount) {
		this.betingamount = betingamount;
	}

	public Date getCreationdate() {
		return this.creationdate;
	}

	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}

	public double getWinningamount() {
		return this.winningamount;
	}

	public void setWinningamount(double winningamount) {
		this.winningamount = winningamount;
	}

	public String getWinningflag() {
		return this.winningflag;
	}

	public void setWinningflag(String winningflag) {
		this.winningflag = winningflag;
	}

	public PlayerDetail getPlayerDetail() {
		return this.playerDetail;
	}

	public void setPlayerDetail(PlayerDetail playerDetail) {
		this.playerDetail = playerDetail;
	}

	public TransactionTable getTransactionTable() {
		return this.transactionTable;
	}

	public void setTransactionTable(TransactionTable transactionTable) {
		this.transactionTable = transactionTable;
	}

}