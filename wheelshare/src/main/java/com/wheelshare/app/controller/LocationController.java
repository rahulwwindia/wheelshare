package com.wheelshare.app.controller;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wheelshare.app.model.Location;
import com.wheelshare.app.model.Status;
import com.wheelshare.app.services.LocationService;

@Controller
@RequestMapping("/location")
public class LocationController {
		static final Logger logger = Logger.getLogger(LocationController.class);

		@Autowired
		LocationService locationService;

		@RequestMapping(value = "/{id}", method = RequestMethod.GET)
		public @ResponseBody
		Location getLocation(@PathVariable("id") long id) {
			Location Location = null;
			try {
				Location = locationService.getLocationById(id);
	  
			} catch (Exception e) {
				e.printStackTrace();
			}  
			return Location;
		}
       
		@RequestMapping(value = "/byCity/{cityid}", method = RequestMethod.GET)
		public @ResponseBody
		List<Location> getLocationsByCityId(@PathVariable("cityid") long id) {
			List<Location> location = null;
			try {
				 location = locationService.getLocationByCityId(id);
	  
			} catch (Exception e) {
				e.printStackTrace();
			}
			return location;
		}

		
		
		@RequestMapping(value = "/list", method = RequestMethod.GET)
		public @ResponseBody
		List<Location> getCities() {  

			List<Location> LocationList = null;
			try {
				LocationList = locationService.getLocationList();

			} catch (Exception e) {
				e.printStackTrace();
			}

			return LocationList;
		}

		@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
		public @ResponseBody
		Status deleteLocation(@PathVariable("id") long id) {

			try {
				locationService.deleteLocation(id);
				return new Status(1, "Location deleted Successfully !");
			} catch (Exception e) {
				return new Status(0, e.toString());
			}

		}

	}