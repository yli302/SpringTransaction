package com.java.service;

import java.util.Optional;

import com.java.dto.Account;

public interface AccountService {
	public Optional<Account> getAccount(int accountId);

	public void transferMoney(String account1, String account2, float money);

	public void withdrawMoney(String account, float money);

	public void depositMoney(String account, float money);
}
