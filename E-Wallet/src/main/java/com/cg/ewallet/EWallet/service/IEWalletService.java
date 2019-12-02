package com.cg.ewallet.EWallet.service;

import java.util.List;

import com.cg.ewallet.EWallet.dto.EAccount;
import com.cg.ewallet.EWallet.dto.ETransactions;
import com.cg.ewallet.EWallet.dto.EUsers;
import com.cg.ewallet.EWallet.exception.EWalletException;

public interface IEWalletService {
	public boolean isAccountExist(EAccount eAccount)throws EWalletException;
	public EAccount signUp(EAccount eAccount)throws EWalletException;
	public EAccount getAccounts(int EId)throws EWalletException;
	public List<EAccount> getAllAccount() throws EWalletException;
	public int authenticate(EAccount eAccount) throws EWalletException;
	public double addMoney(int EId,double amount) throws EWalletException;
	public double transferMoney(int EId,double amount,String recMobileNo) throws EWalletException;
	public List<ETransactions> getTransactions(int EId);
	public EAccount updateFName(int EId,String newFirstName);


}
