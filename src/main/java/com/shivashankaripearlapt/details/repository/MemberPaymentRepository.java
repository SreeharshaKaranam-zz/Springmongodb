package com.shivashankaripearlapt.details.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shivashankaripearlapt.details.model.MemberPaymentDetails;

public interface MemberPaymentRepository extends MongoRepository<MemberPaymentDetails, String> {

}
