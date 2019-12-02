//package com.cg.ewallet.EWallet.dto;
//
//import java.util.Date;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//public class BankTransactions {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private int transactionId;
//	@ManyToOne
//	private BankTransactions eId;
//	private double amount;
//	private String recieverNumber;
//	private String action;
//	private Date tDate;
//	public int getTransactionId() {
//		return transactionId;
//	}
//	public void setTransactionId(int transactionId) {
//		this.transactionId = transactionId;
//	}
//	public BankTransactions geteId() {
//		return eId;
//	}
//	public void seteId(BankTransactions eId) {
//		this.eId = eId;
//	}
//	public double getAmount() {
//		return amount;
//	}
//	public void setAmount(double amount) {
//		this.amount = amount;
//	}
//	public String getRecieverNumber() {
//		return recieverNumber;
//	}
//	public void setRecieverNumber(String recieverNumber) {
//		this.recieverNumber = recieverNumber;
//	}
//	public String getAction() {
//		return action;
//	}
//	public void setAction(String action) {
//		this.action = action;
//	}
//	public Date gettDate() {
//		return tDate;
//	}
//	public void settDate(Date tDate) {
//		this.tDate = tDate;
//	}
//	
//	
//	
//}
//
