package com.shivashankaripearlapt.details.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shivashankaripearlapt.details.model.Apartment;
import com.shivashankaripearlapt.details.repository.ApartmentRepository;

@RestController
@RequestMapping("/apt")
public class ApartmentController {
	
	private final Logger logger=LoggerFactory
			.getLogger(ApartmentMemberController.class);
	
	@Autowired
	ApartmentRepository aptRepository;
	/**
	 * POST /create --> Create a new apartment member details and save it in the
	 * database.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/createinfo")
	public Map<String, Object> create(@RequestBody Apartment apartment) {

		logger.info("In Create method:");
		aptRepository.save(apartment);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Apartment information created");
		dataMap.put("status", "success");
		return dataMap;
	}

	/**
	 * PUT /update --> Update existing member details and save it in the
	 * database.
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/updateaptinfo/{pincode}")
	public Map<String, Object> update(@PathVariable int pincode,
			@RequestBody Apartment apartment) {

		logger.info("In update method:");
		Apartment apt = new Apartment();
		apt.setPincode(pincode);
		apt.setName(apartment.getName());
		apt.setNoOfFlats(apartment.getNoOfFlats());
		apt.setAddress(apartment.getAddress());
		aptRepository.save(apt);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Apartment information updated");
		dataMap.put("status", "success");
		return dataMap;
	}

	/**
	 * DELETE /delete --> delete the existing member details in the database.
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/deleteaptinfo/{pincode}")
	public Map<String, Object> delete(@PathVariable int pincode) {

		aptRepository.delete(pincode);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Apartment information deleted");
		dataMap.put("status", "success");
		return dataMap;
	}



}
