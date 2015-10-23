package com.wheelshare.app.controller;

import java.util.Date;
import java.util.List;

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
import com.wheelshare.app.services.RiderService;
@Controller
@RequestMapping("/rider")
public class RiderController {
	
	@Autowired
	RiderService riderService;
	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public @ResponseBody
	Status addRider(@RequestBody Rider rider) {
		try { 
				riderService.addRider(rider); 
			return new Status(1, "Rider added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<Rider> getRiders() {  

		List<Rider> riderList = null;
		try {
			riderList = riderService.getRiderList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return riderList;
	}

	@RequestMapping(value = "/getRiders", method = RequestMethod.POST)
	public @ResponseBody
	List<Rider> getRidersFromLocDate(@RequestBody Rider rider ) {
		List<Rider> riderList = null;
		try {
			riderList = riderService.getRiderListWithLocDate(rider.getTravel_date(), rider.getFromLocation(), rider.getToLocation(), rider.getCity());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return riderList;
	}  
	@RequestMapping(value = "/acceptUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status acceptUser(@RequestBody TravelStatus travelStatus ) {
		Status status = null;
		try {
			status = riderService.acceptUser(travelStatus.getRiderId(), travelStatus.getSeaterId());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	@RequestMapping(value = "/rejectUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status rejectUser(@RequestBody TravelStatus travelStatus ) {
		Status status = null;
		try {
			status = riderService.rejectUser(travelStatus.getRiderId(), travelStatus.getSeaterId());

		} catch (Exception e) {  
			e.printStackTrace();
		}

		return status;
	}

}
