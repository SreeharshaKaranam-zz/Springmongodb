package com.shivashankaripearlapt.details.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.shivashankaripearlapt.details.model.Account;


@Transactional
public interface AccountRepository extends MongoRepository<Account, String> {
	
	public Account findByUsername(String userName);
}
