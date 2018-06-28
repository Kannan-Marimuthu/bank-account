package com.kannan.sample.account;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kannan.sample.account.dao.AccountRepo;
import com.kannan.sample.account.vo.Account;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AccountApplication.class)
public class AccountJpaIntegrationTest {

	@Autowired
	private AccountRepo accountRepo;

	@Test
	public void retreiveUserEntityTest() {
		List<Account> account = accountRepo.findByUserName("Kannan");
		assertNotNull(account);
		assertEquals("Kannan", account.get(0).getUserName());
	}

	@Test
	public void retreiveUserListTest() {
		List<Account> accountList = (List<Account>) accountRepo.findAll();
		assertNotNull(accountList);
		assertEquals(4, accountList.size());
	}
}
