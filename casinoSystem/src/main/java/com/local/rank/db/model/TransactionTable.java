package com.local.rank.db.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the TRANSACTION_TABLE database table.
 * 
 */
@Entity
@Table(name="TRANSACTION_TABLE")
@NamedQuery(name="TransactionTable.findAll", query="SELECT t FROM TransactionTable t")
public class TransactionTable implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long transactionid;

	@Temporal(TemporalType.DATE)
	private Date transactiondate;

	private String transactionname;


	public TransactionTable() {
	}

	public long getTransactionid() {
		return this.transactionid;
	}

	public void setTransactionid(long transactionid) {
		this.transactionid = transactionid;
	}

	public Date getTransactiondate() {
		return this.transactiondate;
	}

	public void setTransactiondate(Date transactiondate) {
		this.transactiondate = transactiondate;
	}

	public String getTransactionname() {
		return this.transactionname;
	}

	public void setTransactionname(String transactionname) {
		this.transactionname = transactionname;
	}
}