package com.kannan.sample.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kannan.sample.account.dao.AccountRepo;
import com.kannan.sample.account.vo.Account;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepo accountRepository;

	@Override
	public Account findByAccountNumber(Long accountNo) {
		return accountRepository.findByAccountNumber(accountNo);
	}

	@Override
	public List<Account> findByUserName(String userName) {
		return (List<Account>) accountRepository.findByUserName(userName);
	}

	@Override
	public List<Account> findAllAccount() {
		return (List<Account>) accountRepository.findAll();
	}

	@Override
	public boolean isAccountExist(Account account) {
		return findByAccountNumber(account.getAccountNumber()) != null;
	}

}
