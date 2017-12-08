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

import com.shivashankaripearlapt.details.model.MemberPaymentDetails;
import com.shivashankaripearlapt.details.repository.MemberPaymentRepository;

@RestController
@RequestMapping ("/apt")
public class MemberPaymentController {
	
	private final Logger logger=LoggerFactory
			.getLogger(ApartmentMemberController.class);
	
	@Autowired
	MemberPaymentRepository memberPaymentRepository;
	/**
	 * POST /create --> Create a new apartment member details and save it in the
	 * database.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/createpaymentinfo")
	public Map<String, Object> create(@RequestBody MemberPaymentDetails memberPaymentDetails) {

		logger.info("In Create method:");
		memberPaymentRepository.save(memberPaymentDetails);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Member Payment information created");
		dataMap.put("status", "success");
		return dataMap;
	}

	/**
	 * PUT /update --> Update existing member details and save it in the
	 * database.
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/updatepaymentinfo/{blockNumber}")
	public Map<String, Object> update(@PathVariable String blockNumber,
			@RequestBody MemberPaymentDetails memberPaymentDtls) {

		logger.info("In update method:");
		MemberPaymentDetails memberPaymentDetails = new MemberPaymentDetails();
		memberPaymentDetails.setAmountPaid(memberPaymentDtls.getAmountPaid());
		memberPaymentDetails.setBlockNumber(blockNumber);
		memberPaymentDetails.setDueAmount(memberPaymentDtls.getDueAmount());
		memberPaymentDetails.setPaymentDate(memberPaymentDtls.getPaymentDate());
		memberPaymentDetails.setTransactionalNumber(memberPaymentDtls.getTransactionalNumber());
		memberPaymentRepository.save(memberPaymentDetails);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Member Payment information updated");
		dataMap.put("status", "success");
		return dataMap;
	}

	/**
	 * DELETE /delete --> delete the existing member details in the database.
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/deletepaymentinfo/{blockNumber}")
	public Map<String, Object> delete(@PathVariable String blockNumber) {

		memberPaymentRepository.delete(blockNumber);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Member Payment information deleted");
		dataMap.put("status", "success");
		return dataMap;
	}



}
