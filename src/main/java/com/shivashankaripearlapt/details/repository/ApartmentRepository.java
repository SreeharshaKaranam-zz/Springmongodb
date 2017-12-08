package com.shivashankaripearlapt.details.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.shivashankaripearlapt.details.model.Apartment;

public interface ApartmentRepository extends MongoRepository<Apartment, Integer> {

}
