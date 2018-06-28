package com.kannan.sample.account.service;

import java.util.List;

import com.kannan.sample.account.vo.Account;

public interface AccountService {

	Account findByAccountNumber(Long accountNo);

	List<Account> findByUserName(String userName);

	List<Account> findAllAccount();

	boolean isAccountExist(Account account);
}
