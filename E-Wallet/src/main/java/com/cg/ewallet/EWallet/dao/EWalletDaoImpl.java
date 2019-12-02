package com.cg.ewallet.EWallet.dao;


import java.util.Date;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.jca.cci.object.EisOperation;
import org.springframework.stereotype.Repository;

import com.cg.ewallet.EWallet.dto.EAccount;
import com.cg.ewallet.EWallet.dto.ETransactions;

import com.cg.ewallet.EWallet.exception.EWalletException;


@Repository
public class EWalletDaoImpl implements IEWalletDao {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public boolean isAccountExist(EAccount eAccount)throws EWalletException {
		TypedQuery<EAccount> tQuery=entityManager.createQuery("select acc from EAccount acc where acc.email=:emailVar and acc.phoneNo=:phoneVar",EAccount.class);
		tQuery.setParameter("emailVar", eAccount.getEmail());
		tQuery.setParameter("phoneVar", eAccount.getPhoneNo());
		//tQuery.setParameter("passwordVar", eAccount.getPassword());
		
	//EAccount eAccount2=	entityManager.find(EAccount.class, eAccount.getEmail());
    EAccount eAccount2=tQuery.getSingleResult();
	if(eAccount2!=null) {
		return true;
	}
	 return false;
	}

	@Override
	public EAccount signUp(EAccount eAccount) throws EWalletException{
		if(isAccountExist(eAccount)) {
			throw new EWalletException("Account already exist");
		}
		entityManager.persist(eAccount);
		return eAccount;
	}

	@Override
	public EAccount getAccounts(int EId) throws EWalletException {
//		TypedQuery<EAccount> tQuery=entityManager.createQuery("select acc from EAccount acc where email=:emailVar",EAccount.class);
//		tQuery.setParameter("emailVar", emailID);
		//EAccount account=tQuery.getSingleResult();
		EAccount acc=entityManager.find(EAccount.class,EId);
		if(acc==null) {
			throw new EWalletException("not found");
		}
		
		return acc;
	}

	@Override
	public List<EAccount> getAllAccount() throws EWalletException {
		TypedQuery<EAccount> tQuery=entityManager.createQuery("select acc from EAccount acc",EAccount.class);
		List<EAccount> accountList=tQuery.getResultList();
		return accountList;
	}

	@Override
	public int authenticate(EAccount eAccount) throws EWalletException {
//		EAccount acc=entityManager.find(EAccount.class, eUsers.getEmail());
//		if(acc!=null) {
//			if(acc.getPassword().equals(eUsers.getPassword())) {
//	
//			   return true;
//			}
//		}
//		return false;
		TypedQuery<EAccount> typedQuery=entityManager.createQuery("select acc from EAccount acc where (acc.email=:email or acc.phoneNo=:phoneNo) and acc.password=:password",EAccount.class);
		typedQuery.setParameter("email", eAccount.getEmail());
		typedQuery.setParameter("phoneNo", eAccount.getPhoneNo());
		typedQuery.setParameter("password", eAccount.getPassword());
		EAccount eAccount2=typedQuery.getSingleResult();
		return eAccount2.geteId();
	}

	@Override
	public double addMoney(int EId, double amount) throws EWalletException {
		EAccount eAccount=entityManager.find(EAccount.class, EId);
		double currentBalance=0,updatedBalance=0;
		if(eAccount!=null) {
		System.out.println(eAccount);
		currentBalance=eAccount.getBalance();
		updatedBalance=currentBalance+amount;
		
		eAccount.seteTransactions(setTransactions(eAccount,new Date(), amount, null, "Added"));
		eAccount.setBalance(updatedBalance);
		System.out.println("inside addMoney "+eAccount.geteTransactions());
		//entityManager.merge(eAccount);
		    
		}
		return updatedBalance;
	}

	@Override
	public double transferMoney(int EId, double amount, String recMobileNo) throws EWalletException {
		EAccount eAccount=entityManager.find(EAccount.class, EId);
		System.out.println(EId);
		System.out.println(eAccount+"transfer money wala");
		if(eAccount!=null) {
		   TypedQuery<EAccount> typedQuery =entityManager.createQuery("select acc from EAccount acc where acc.phoneNo=:recMobileNo",EAccount.class);
		   typedQuery.setParameter("recMobileNo", recMobileNo);
		   EAccount eAccount2=null;
		    eAccount2=typedQuery.getSingleResult();
		    System.out.println(eAccount2);
		   if(eAccount2!=null){
			   eAccount2.seteTransactions(setTransactions(eAccount2,new Date(), amount, null, "recieved"));
			   eAccount2.setBalance(eAccount2.getBalance()+amount);
			   entityManager.merge(eAccount2);
		   }
		 eAccount.seteTransactions(setTransactions(eAccount,new Date(), amount, recMobileNo, "transferred"));
		eAccount.setBalance(eAccount.getBalance()-amount);
		entityManager.merge(eAccount);
		}
		System.out.println("your"+eAccount.getBalance());
		return eAccount.getBalance();
	}
	
	public ETransactions setTransactions(EAccount id,Date tDate,double amount,String recieverNumber,String action) {
		ETransactions eTransactions=new ETransactions();
		eTransactions.settDate(tDate);
		eTransactions.setAmount(amount);
		eTransactions.setRecieverNumber(recieverNumber);
		eTransactions.setAction(action);
		eTransactions.seteId(id);
		
		return eTransactions;
	}

	@Override
	public List<ETransactions> getTransactions(int EId) {
		EAccount eAccount=entityManager.find(EAccount.class, EId);
		System.out.println(eAccount+"getTransactions wala");
		if(eAccount!=null) {
			 System.out.println(eAccount.geteTransactions());
		  return eAccount.geteTransactions();
		  
		 
		}
		return null;
//		TypedQuery<ETransactions> typedQuery=entityManager.createQuery("select eacc from ETransactions eacc",ETransactions.class);
//		List<ETransactions> eWList=typedQuery.getResultList();
//		System.out.println(eWList+"getTransactions wala");
//		return eWList;
	}

	@Override
	public EAccount updateFName(int EId, String newFirstName) {
		EAccount eAccount=entityManager.find(EAccount.class, EId);
		if(eAccount!=null) {
			System.out.println(eAccount+"updatefname");
			eAccount.setFirstName(newFirstName);
			return eAccount;
		}
		return null;
	}
	
	
	

}
