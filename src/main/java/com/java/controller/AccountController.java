package com.java.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.dto.Account;
import com.java.service.AccountService;
import com.java.service.DatabaseException;

@Controller
public class AccountController {
	@Autowired
	AccountService service;

	@GetMapping("/")
	public String getHome(Model model) {
		Optional<Account> a1 = service.getAccount(1);
		Optional<Account> a2 = service.getAccount(2);
		model.addAttribute("account1", a1.orElse(new Account()));
		model.addAttribute("account2", a2.orElse(new Account()));
		return "home";
	}

	@PostMapping("transfer")
	public String transfer(@RequestParam String accFrom, @RequestParam String accTo, @RequestParam float value) {
//		boolean isSuccess;
		try {
			service.transferMoney(accFrom, accTo, value);
		} catch (DatabaseException e) {
			return "fail";
		}
		return "success";
	}

	@PostMapping("deposit")
	public String deposit(@RequestParam String accFrom, @RequestParam float value) {
//		boolean isSuccess;
		try {
			service.depositMoney(accFrom, value);
		} catch (DatabaseException e) {
			return "fail";
		}
		return "success";
	}

	@PostMapping("withdraw")
	public String transfer(@RequestParam String accFrom, @RequestParam float value) {
//		boolean isSuccess;
		try {
			service.withdrawMoney(accFrom, value);
		} catch (DatabaseException e) {
			return "fail";
		}
		return "success";
	}
}
