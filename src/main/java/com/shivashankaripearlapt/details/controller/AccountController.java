package com.shivashankaripearlapt.details.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shivashankaripearlapt.details.model.Account;
import com.shivashankaripearlapt.details.model.Apartment;
import com.shivashankaripearlapt.details.repository.AccountRepository;

@CrossOrigin(origins = {"http://localhost:8080","http://10.96.114.108:8080"})
@RestController
@RequestMapping("/user")
public class AccountController {

	private final Logger logger=LoggerFactory
			.getLogger(AccountController.class);
	
	@Autowired
	AccountRepository accountRepository;
	
	/**
	 * GET /read --> Find the user from the database.
	 */
	@RequestMapping(method = {RequestMethod.GET , RequestMethod.OPTIONS}, value = "/verifyinfo/{username}")
	public Account displayUser(@PathVariable String username) {
		logger.info("In displayUser method:");
		Account account = accountRepository.findOne(username);
		logger.info("Account details:"+account.getUsername());
		return account;
	}
	
	/**
	 * POST /create --> Create a new apartment member details and save it in the
	 * database.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/createinfo")
	public Map<String, Object> create(@RequestBody Account account) {

		logger.info("In Create method:");
		accountRepository.save(account);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Account information created");
		dataMap.put("status", "success");
		return dataMap;
	}

}
