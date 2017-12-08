package com.shivashankaripearlapt.details.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import com.shivashankaripearlapt.details.model.ApartmentMember;

@Transactional
public interface ApartmentMemberRepository extends MongoRepository<ApartmentMember, String>{

}
