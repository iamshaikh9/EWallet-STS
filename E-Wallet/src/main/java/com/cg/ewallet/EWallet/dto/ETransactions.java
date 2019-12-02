package com.cg.ewallet.EWallet.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value= {"eId"})
public class ETransactions {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int transactionId;
@ManyToOne
@JoinColumn(name="e_Id")
private EAccount eId;
private double amount;
private String recieverNumber;
private String action;
private Date tDate;



public EAccount geteId() {
	return eId;
}



public void seteId(EAccount eId) {
	this.eId = eId;
}



public int getTransactionId() {
	return transactionId;
}



public void setTransactionId(int transactionId) {
	this.transactionId = transactionId;
}

public String getAction() {
	return action;
}



public void setAction(String action) {
	this.action = action;
}



public Date gettDate() {
	return tDate;
}



public void settDate(Date tDate) {
	this.tDate = tDate;
}



public double getAmount() {
	return amount;
}



public void setAmount(double amount) {
	this.amount = amount;
}



public String getRecieverNumber() {
	return recieverNumber;
}



public void setRecieverNumber(String recieverNumber) {
	this.recieverNumber = recieverNumber;
}







@Override
public String toString() {
	if(recieverNumber!=null) {
	return "ETransactions [transactionId=" + transactionId  + ", amount=" + amount + ", recieverNumber="
			+ recieverNumber + ", action=" + action + ", tDate=" + tDate + "]";
	}
	else {
	return "ETransactions [transactionId=" + transactionId +  ", amount=" + amount + ", action=" + action + ", tDate=" + tDate + "]";	
	}
}



public ETransactions(int transactionId, EAccount eId, double amount, String recieverNumber, String action, Date tDate) {
	super();
	this.transactionId = transactionId;
	this.eId = eId;
	this.amount = amount;
	this.recieverNumber = recieverNumber;
	this.action = action;
	this.tDate = tDate;
}



public ETransactions() {
	super();
	// TODO Auto-generated constructor stub
}










}
