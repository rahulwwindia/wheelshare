package com.wheelshare.app.controller;

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
import com.wheelshare.app.services.UserAccountService;

@Controller
@RequestMapping("/account")
public class UserAccountController {
	
	@Autowired
	UserAccountService userAccountService;
	
	@RequestMapping(value = "/seatersRequest", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public @ResponseBody
	Status getSeatersRequest(@RequestBody Rider rider) {
		return null;
		
	}
	
	@RequestMapping(value = "/seaterRequest", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public @ResponseBody
	Status getSeatersRequest(@RequestBody TravelStatus travelStatus) {
		try{
		 userAccountService.addSeaterRequest(travelStatus);
		return new Status(1, "Travel Details added Successfully !");
	} catch (Exception e) {
		// e.printStackTrace();
		return new Status(0, e.toString());
	}

	}
	
	

}
