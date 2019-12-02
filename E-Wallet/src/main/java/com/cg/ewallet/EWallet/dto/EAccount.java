package com.cg.ewallet.EWallet.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties(value= {"eTransactions"})
public class EAccount {
 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private int eId; 
 private String firstName;
 private String lastName;
 private String email;
 private String phoneNo;
 private String password;
 private double balance;
 @OneToMany(cascade = CascadeType.ALL,mappedBy = "eId")	
 private List<ETransactions> eTransactions=new ArrayList<ETransactions>();
 






public int geteId() {
	return this.eId;
}
public void seteId(int eId) {
	this.eId = eId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}

public List<ETransactions> geteTransactions() {
	return eTransactions;
}
public void seteTransactions(ETransactions eTransactions) {
	this.seteId(this.eId);
	this.eTransactions.add(eTransactions);
}

public EAccount() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "EAccount [eId=" + eId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
			+ ", phoneNo=" + phoneNo + ", password=" + password + ", balance=" + balance + ", eTransactions="
			+ eTransactions + "]";
}






 
 
	
}
