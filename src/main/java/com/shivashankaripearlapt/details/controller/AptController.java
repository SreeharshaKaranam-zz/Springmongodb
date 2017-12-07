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
import com.shivashankaripearlapt.details.repository.AptRepository;

@RestController
@RequestMapping("/apt")
public class AptController {
	
	 private final Logger logger = LoggerFactory.getLogger(AptController.class);

	@Autowired
	AptRepository aptRepository;
	
	//@Autowired
	//Apartment apt;

	/**
	 * POST /create --> Create a new apartment member details and save it in the
	 * database.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/createmember")
	public Map<String, Object> create(@RequestBody Apartment apartment) {

		logger.info("In Create method:");
		aptRepository.save(apartment);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "new member created successfully");
		dataMap.put("status", "success");
		return dataMap;
	}

	/**
	 * PUT /update --> Update existing member details and save it in the
	 * database.
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/updatemember/{blockNumber}")
	public Map<String, Object> update(@PathVariable String blockNumber,@RequestBody Apartment apartment) {

		logger.info("In update method:");
		Apartment apt=new Apartment();
		apt.setBlockNumber(blockNumber);
		apt.setMobileNumber(apartment.getMobileNumber());
		apt.setPrimaryMemberName(apartment.getPrimaryMemberName());
		apt.setSecondaryMemberName(apartment.getSecondaryMemberName());
		aptRepository.save(apt);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "new member updated successfully");
		dataMap.put("status", "success");
		return dataMap;
	}
	
	/**
	 * DELETE /delete --> delete the existing member details in the
	 * database.
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/delete/{blockNumber}")
	public Map<String, Object> delete(@RequestBody String blockNumber) {

		aptRepository.delete(blockNumber);;
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "new member updated successfully");
		dataMap.put("status", "success");
		return dataMap;
	}


}
