package com.java.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.dao.AccountRepository;
import com.java.dto.Account;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository rep;

	@Override
	public Optional<Account> getAccount(int accountId) {
		return rep.getAccount(accountId);
	}

	@Override
	public void transferMoney(String account1, String account2, float money) {
		rep.withdrawMoney(account1, money);
		rep.depositMoney(account2, money);
//		return (withdrawStatus && depositStatus);
	}

	@Override
	public void withdrawMoney(String account, float money) {
		rep.withdrawMoney(account, money);
	}

	@Override
	public void depositMoney(String account, float money) {
		rep.depositMoney(account, money);
	}
}