package com.kannan.sample.account.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kannan.sample.account.vo.Account;

@Repository
public interface AccountRepo extends CrudRepository<Account, Long> {
	Account findByAccountNumber(Long accountNo);

	List<Account> findByUserName(String userName);

}
