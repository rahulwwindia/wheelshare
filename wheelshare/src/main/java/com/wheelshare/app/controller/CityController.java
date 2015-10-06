package com.wheelshare.app.controller;  
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
   
import com.wheelshare.app.model.City;
import com.wheelshare.app.model.Status;
import com.wheelshare.app.services.CityService;
  
@Controller
@RequestMapping("/city")
public class CityController {

	@Autowired
	CityService cityService;

	static final Logger logger = Logger.getLogger(CityController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status addCity(@RequestBody City city) {
		try { 
			
			cityService.addCity(city); 
			return new Status(1, "City added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}
  
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	City getCity(@PathVariable("id") long id) {
		City City = null;
		try {
			City = cityService.getCityById(id);
  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return City;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<City> getCities() {  

		List<City> CityList = null;
		try {
			CityList = cityService.getCityList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return CityList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteCity(@PathVariable("id") long id) {

		try {
			cityService.deleteCity(id);
			return new Status(1, "City deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
