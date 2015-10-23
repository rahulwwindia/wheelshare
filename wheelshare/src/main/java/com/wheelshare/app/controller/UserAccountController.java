package com.wheelshare.app.controller;

import java.util.Set;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wheelshare.app.model.Rider;
import com.wheelshare.app.model.Status;
import com.wheelshare.app.model.TravelStatus;
import com.wheelshare.app.model.User;
import com.wheelshare.app.services.UserAccountService;

@Controller
@RequestMapping("/account")
public class UserAccountController {
	
	@Autowired
	UserAccountService userAccountService;
	
	
	@RequestMapping(value = "/seaterRequest", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public @ResponseBody
	Status addSeatersRequest(@RequestBody TravelStatus travelStatus) {
		try{
		 userAccountService.addSeaterRequest(travelStatus);
		return new Status(1, "Travel Details added Successfully !");
	} catch (Exception e) {
		// e.printStackTrace();
		return new Status(0, e.toString());
	}

	}
	
	@RequestMapping(value = "/getAllSeaterReq", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE) 
	public @ResponseBody
	Set<User> getAllSeatersRequest(@RequestBody TravelStatus travelStatus) {
		try{
		Set<User> travelerList=userAccountService.getAllSeaterRequest(travelStatus.getRiderId(),travelStatus.getTravelDate());
		return travelerList;
	} catch (Exception e) {
		// e.printStackTrace();
		return null;
	}

	}
	
	@RequestMapping(value = "/getAllRiderReq", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE) 
	public @ResponseBody
	Set<User> getAllRiderRequest(@RequestBody TravelStatus travelStatus) {
		try{
		Set<User> travelerList=userAccountService.getAllSeaterRequest(travelStatus.getRiderId(),travelStatus.getTravelDate());
		return travelerList;
	} catch (Exception e) {
		// e.printStackTrace();
		return null;
	}

	}
	

}
