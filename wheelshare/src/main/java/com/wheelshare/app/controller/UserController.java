package com.wheelshare.app.controller;  
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Produces;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.wheelshare.app.model.Status;
import com.wheelshare.app.model.TravelStatus;
import com.wheelshare.app.model.User;
import com.wheelshare.app.services.UserService;
  
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	static final Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public @ResponseBody
	Status addUser(@RequestBody User user) {
		User userValidator;
		try { 
			userValidator=userService.validateUser(user.getEmailId(), user.getPhone());
			if(userValidator==null)
			{
				System.out.println("User not exist");
			Date date =new Date();
			user.setCreatedDate(date);  
			user.setUpdatedDate(date );    
			userService.addUser(user);   
			return new Status(1, "User added Successfully !");
			}
			else
				return new Status(0, "User already exists");
		} catch (Exception e) {  
			// e.printStackTrace();
			return new Status(0, "Fail");
		} 

	}
  
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	User getUser(@PathVariable("id") long id) {
		User user = null;
		try {
			user = userService.getUserById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}  
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public @ResponseBody
    @Produces("application/json")
	String userLogin(@RequestBody  User loginDetails) {
		Map<String, Object> userResopnse= new HashMap<>(); 
		Status status = new Status();
		User user = null;  
		try { 
			user = userService.getUserByUserNamePass(loginDetails.getUserName(),loginDetails.getPassword());
		} catch (Exception e) { 
			userResopnse.put("status", new Status(0, "Fail"));
			userResopnse.put("user", user);
		}
		if(user!=null)
		{
			userResopnse.put("status", new Status(1, "Success"));
			userResopnse.put("user", user);
		}
		 else{ 
				userResopnse.put("status", new Status(0, "Fail"));
				userResopnse.put("user", user);
				}
		Gson gson = new Gson();
        String json = gson.toJson(userResopnse);

		return json;
	}


	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<User> getCities() {  

		List<User> UserList = null;
		try {
			UserList = userService.getUserList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return UserList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteUser(@PathVariable("id") long id) {

		try {
			userService.deleteUser(id);
			return new Status(1, "User deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
	
	@RequestMapping(value = "accept/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status acceptUser(@PathVariable("id") long id) {

		try {
			userService.deleteUser(id);
			return new Status(1, "User deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}

	@RequestMapping(value = "/acceptUser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody
	Status acceptUser(@RequestBody TravelStatus travelStatus ) {
		Status status = null;
		try {
			status = userService.acceptUser(travelStatus.getRiderId(), travelStatus.getSeaterId());

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
			status = userService.rejectUser(travelStatus.getRiderId(), travelStatus.getSeaterId());

		} catch (Exception e) {  
			e.printStackTrace();
		}

		return status;
	}

}
