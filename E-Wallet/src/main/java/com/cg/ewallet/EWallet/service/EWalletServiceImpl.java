package com.cg.ewallet.EWallet.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ewallet.EWallet.dao.IEWalletDao;
import com.cg.ewallet.EWallet.dto.EAccount;
import com.cg.ewallet.EWallet.dto.ETransactions;
import com.cg.ewallet.EWallet.dto.EUsers;
import com.cg.ewallet.EWallet.exception.EWalletException;
@Service
@Transactional
public class EWalletServiceImpl implements IEWalletService{
	
	@Autowired
	
	IEWalletDao dao;
	@Override
	public boolean isAccountExist(EAccount eAccount) throws EWalletException {
		
		return dao.isAccountExist(eAccount);
	}

	@Override
	public EAccount signUp(EAccount eAccount) throws EWalletException {
	
		return dao.signUp(eAccount);
	}

	@Override
	public EAccount getAccounts(int EId) throws EWalletException {
		
		return dao.getAccounts(EId);
	}

	@Override
	public List<EAccount> getAllAccount() throws EWalletException {
		
		return dao.getAllAccount();
	}

	@Override
	public int authenticate(EAccount eAccount) throws EWalletException {
	   return dao.authenticate(eAccount);
	}

	@Override
	public double addMoney(int EId, double amount) throws EWalletException {
		
		return dao.addMoney(EId, amount);
	}

	@Override
	public double transferMoney(int EId, double amount, String recMobileNo) throws EWalletException {
		// TODO Auto-generated method stub
		return dao.transferMoney(EId, amount, recMobileNo);
	}

	@Override
	public List<ETransactions> getTransactions(int EId) {
		
		return dao.getTransactions(EId);
	}

	@Override
	public EAccount updateFName(int EId, String newFirstName) {
	
		return dao.updateFName(EId, newFirstName);
	}

}
