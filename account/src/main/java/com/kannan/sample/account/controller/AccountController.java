package com.kannan.sample.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kannan.sample.account.service.AccountService;
import com.kannan.sample.account.util.Custom204Exception;
import com.kannan.sample.account.util.CustomResponseEntity;
import com.kannan.sample.account.vo.Account;

@RestController
@RequestMapping("/api")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/account", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> listAccounts() throws Custom204Exception {
		List<Account> accounts = accountService.findAllAccount();
		if (accounts.isEmpty()) {
			throw new Custom204Exception("Accounts not found");
		}
		return buildResponseEntity(accounts);
	}

	@RequestMapping(value = "/account/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getAccount(@PathVariable("name") String name) throws Custom204Exception {
		List<Account> accounts = accountService.findByUserName(name);
		if (accounts.isEmpty()) {
			throw new Custom204Exception("Account details not found for the user name :" + name);
		}
		return buildResponseEntity(accounts);
	}

	private ResponseEntity<?> buildResponseEntity(List<Account> accounts) {
		CustomResponseEntity response = new CustomResponseEntity(HttpStatus.OK);
		response.setMessage("Success");
		response.setData(accounts);
		return new ResponseEntity<>(response, response.getStatus());
	}

}
