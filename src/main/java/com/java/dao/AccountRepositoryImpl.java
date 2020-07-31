package com.java.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.java.dto.Account;
import com.java.service.DatabaseException;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
	@Autowired
	HibernateTemplate template;

	@Override
	public void addAccount(String account) {
		Account a = new Account();
		a.setAccountNumber(Integer.parseInt(account));
		template.save(a);
	}

	@Override
	public Optional<Account> getAccount(int accountId) {
		System.out.println(accountId + " " + template.get(Account.class, accountId));
		return Optional.ofNullable(template.get(Account.class, accountId));
	}

	@Override
	public void withdrawMoney(String account, float money) {
		Account a = template.get(Account.class, Integer.parseInt(account));
		if (a != null) {
			float currBalance = a.getBalance() - money;
			if (currBalance > 0) {
				a.setBalance(a.getBalance() - money);
				template.update(a);
//				return true;
			} else {
				System.out.println("withdrowFail");
				throw new DatabaseException("Balance is not enough for withdraw");
//				return false;
			}
		} else {
			System.out.println("withdrowFail");
			throw new DatabaseException("Account not exist");
//			return false;
		}
	}

	@Override
	public void depositMoney(String account, float money) {
		Account a = template.get(Account.class, Integer.parseInt(account));
		if (a != null) {
			a.setBalance(a.getBalance() + money);
			template.update(a);
//			return true;
		} else {
			System.out.println("depositFail");
			throw new DatabaseException("Account not exist");
//			return false;
		}
	}
}
