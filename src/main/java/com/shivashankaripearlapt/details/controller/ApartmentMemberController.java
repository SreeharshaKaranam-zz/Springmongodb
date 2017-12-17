package com.shivashankaripearlapt.details.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shivashankaripearlapt.details.model.ApartmentMember;
import com.shivashankaripearlapt.details.model.MotorVehicleDetails;
import com.shivashankaripearlapt.details.repository.ApartmentMemberRepository;

@RestController
@RequestMapping("/apt")
public class ApartmentMemberController {

	private final Logger logger = LoggerFactory
			.getLogger(ApartmentMemberController.class);

	@Autowired
	ApartmentMemberRepository aptRepository;

	// @Autowired
	// Apartment apt;

	/**
	 * POST /create --> Create a new apartment member details and save it in the
	 * database.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/createmember")
	@CrossOrigin(origins = "http://localhost:9000")
	public Map<String, Object> createMember(
			@RequestBody ApartmentMember apartmentMember) {

		logger.info("In createMember method:");
		aptRepository.save(apartmentMember);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Member created");
		dataMap.put("status", "success");
		return dataMap;
	}

	/**
	 * PUT /update --> Update existing member details and save it in the
	 * database.
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/modifymember/{blockNumber}")
	@CrossOrigin(origins = "http://localhost:9000")
	public Map<String, Object> updateMember(@PathVariable String blockNumber,
			@RequestBody ApartmentMember apartmentMember) {

		logger.info("In updateMember method:");
		ApartmentMember apt = new ApartmentMember();
		apt.setBlockNumber(blockNumber);
		List<String> mobileNumberList = new ArrayList<String>();
		for (String mobilenumber : apartmentMember.getMobileNumbers()) {

			mobileNumberList.add(mobilenumber);
		}
		apt.setMobileNumbers(mobileNumberList);
		apt.setPrimaryMemberName(apartmentMember.getPrimaryMemberName());
		apt.setSecondaryMemberName(apartmentMember.getSecondaryMemberName());
		apt.setOccupyStatus(apartmentMember.getOccupyStatus());
		List<MotorVehicleDetails> motorVehicleDetailsList=new ArrayList<MotorVehicleDetails>();
		for(MotorVehicleDetails motorVehicleDetails:apartmentMember.getVehicleList())
		{
			
			motorVehicleDetailsList.add(motorVehicleDetails);
		}
		
		apt.setVehicleList(motorVehicleDetailsList);
		aptRepository.save(apt);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Member updated");
		dataMap.put("status", "success");
		return dataMap;
	}

	/**
	 * DELETE /delete --> delete the existing member details in the database.
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/deletemember/{blockNumber}")
	@CrossOrigin(origins = "http://localhost:9000")
	public Map<String, Object> deleteMember(@PathVariable String blockNumber) {

		logger.info("In deleteMember method:");
		aptRepository.delete(blockNumber);
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Member deleted");
		dataMap.put("status", "success");
		return dataMap;
	}

	/**
	 * GET /read --> Read a member by blockNumber from the database.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/displaymember/{blockNumber}")
	@CrossOrigin(origins = "http://localhost:9000")
	public ApartmentMember displayMember(@PathVariable String blockNumber) {
		logger.info("In displaymember method:");
		ApartmentMember apartmentMember = aptRepository.findOne(blockNumber);
		return apartmentMember;
	}

	/**
	 * GET /display --> display all the member by blockNumber from the database.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/displayallmembers")
	@CrossOrigin(origins = "http://localhost:9000")
	public List<ApartmentMember> displayAllMembers() {
		logger.info("In displayallmembers method:");
		List<ApartmentMember> apartmentMemberList = aptRepository
				.findAll(new Sort(Sort.Direction.ASC, "id"));
		return apartmentMemberList;
	}

	/**
	 * GET /count --> counts the member count from the database.
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/countmember")
	public Map<String, Object> membersCount() {
		logger.info("In membersCount method:");
		long memberCount = aptRepository.count();
		Map<String, Object> dataMap = new HashMap<String, Object>();
		dataMap.put("message", "Members count-" + memberCount);
		dataMap.put("status", "success");
		return dataMap;
	}

}
