package com.wheelshare.app.controller;  
import java.util.Date;
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

import com.wheelshare.app.model.User;
import com.wheelshare.app.model.UserAuth;
import com.wheelshare.app.model.Status;
import com.wheelshare.app.services.UserService;
  
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService UserService;

	static final Logger logger = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/create", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE) 
	public @ResponseBody
	Status addUser(@RequestBody User user) {
		try { 
			Date date =new Date();
			user.setCreatedDate(date);  
			user.setUpdatedDate(date );
			System.out.println(user.getPassword());
			UserService.addUser(user); 
			return new Status(1, "User added Successfully !");
		} catch (Exception e) {
			// e.printStackTrace();
			return new Status(0, e.toString());
		}

	}
  
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public @ResponseBody
	User getUser(@PathVariable("id") long id) {
		User user = null;
		try {
			user = UserService.getUserById(id);
  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public @ResponseBody
	List<User> getCities() {  

		List<User> UserList = null;
		try {
			UserList = UserService.getUserList();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return UserList;
	}

	@RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Status deleteUser(@PathVariable("id") long id) {

		try {
			UserService.deleteUser(id);
			return new Status(1, "User deleted Successfully !");
		} catch (Exception e) {
			return new Status(0, e.toString());
		}

	}
}
