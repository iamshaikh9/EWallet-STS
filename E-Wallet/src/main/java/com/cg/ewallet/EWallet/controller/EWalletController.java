package com.cg.ewallet.EWallet.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ewallet.EWallet.dto.EAccount;
import com.cg.ewallet.EWallet.dto.ETransactions;
import com.cg.ewallet.EWallet.exception.EWalletException;
import com.cg.ewallet.EWallet.service.IEWalletService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class EWalletController {
@Autowired	
IEWalletService service;

@PersistenceContext
EntityManager entityManager;

@PostMapping(value="/signUp")
public EAccount signUp(@RequestBody EAccount EAccount) throws EWalletException {
//	BankTransactions BankTransactions=new BankTransactions();
//	BankTransactions.setAmount(1000);
//	BankTransactions.setRecieverNumber("9768592991");
//	EAccount.setBankTransactions(BankTransactions);
	System.out.println(EAccount);
	
	return service.signUp(EAccount);
}

@GetMapping(value="/getAccount/{EId}")
public EAccount getAccount(@PathVariable int EId)throws EWalletException {
	return service.getAccounts(EId);
}

@GetMapping(value="/login")
public boolean Login(@RequestBody EAccount EAccount)throws EWalletException {
	return service.isAccountExist(EAccount);
}

@GetMapping(value="/getAllAccount")
public List<EAccount> getAllAccounts() throws EWalletException{
	System.out.println("called");
	return service.getAllAccount();
}

@PostMapping(value="/authenticate")
public long authenticate(@RequestBody EAccount EAccount) throws EWalletException{
	System.out.println("authenticate called");
	return service.authenticate(EAccount);
}


@PostMapping(value = "/addMoney/{EId}")
public String addMoney(@PathVariable int EId, @RequestBody EAccount EAccount)throws EWalletException {
	System.out.println(EAccount.getBalance());
	service.addMoney(EId, EAccount.getBalance());
	return "added";
}

@PostMapping(value = "/transferMoney/{EId}")
public String transferMoney(@PathVariable int EId,@RequestBody EAccount EAccount)throws EWalletException{
	System.out.println(EAccount.getBalance()+EAccount.getPhoneNo());
	service.transferMoney(EId, EAccount.getBalance(), EAccount.getPhoneNo());
	return "transferred";
}

@GetMapping(value="/getTransactions/{EId}")
public List<ETransactions> getTransactions(@PathVariable int EId){
	
	return service.getTransactions(EId);
	
}
//@PostMapping(value="/demo")
//public void demo(EAccount EAccount) throws EWalletException{
//	BankTransactions BankTransactions=new BankTransactions();
//	BankTransactions.setAmount(1000);
//	BankTransactions.setRecieverNumber("9768592991");
//	entityManager.persist(EAccount);
//}

//Edit Calls below this
@PutMapping(value="/updateFName/{EId}")
public String updateFName(@PathVariable int EId,@RequestBody EAccount eAccount) {
	service.updateFName(EId, eAccount.getFirstName());
	System.out.println(eAccount+"updateInString");
	System.out.println(eAccount.getFirstName());
	return "updated";
}




}
