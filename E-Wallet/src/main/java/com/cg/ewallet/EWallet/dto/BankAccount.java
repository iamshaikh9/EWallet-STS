//package com.cg.ewallet.EWallet.dto;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//
//@Entity
//public class BankAccount {
//
//	 @Id
//	 @GeneratedValue(strategy = GenerationType.AUTO)
//	 private int eId; 
//	 private String firstName;
//	 private String lastName;
//	 private String email;
//	 private String phoneNo;
//	 private String password;
//	 private double balance;
//	 @OneToMany	
//	 private List<BankTransactions> eTransactions=new ArrayList<BankTransactions>();
//	public int geteId() {
//		return eId;
//	}
//	public void seteId(int eId) {
//		this.eId = eId;
//	}
//	public String getFirstName() {
//		return firstName;
//	}
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//	public String getLastName() {
//		return lastName;
//	}
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public String getPhoneNo() {
//		return phoneNo;
//	}
//	public void setPhoneNo(String phoneNo) {
//		this.phoneNo = phoneNo;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public double getBalance() {
//		return balance;
//	}
//	public void setBalance(double balance) {
//		this.balance = balance;
//	}
//	public List<BankTransactions> geteTransactions() {
//		return eTransactions;
//	}
//	public void seteTransactions(BankTransactions eTransactions) {
//		this.eTransactions.add(eTransactions);
//	}
//	 
//	 
//}
