package com.java.dao;

import java.util.Optional;

import com.java.dto.Account;

public interface AccountRepository {
	public void addAccount(String account);

	public Optional<Account> getAccount(int accountId);

	public void withdrawMoney(String account, float money);

	public void depositMoney(String account, float money);
}
