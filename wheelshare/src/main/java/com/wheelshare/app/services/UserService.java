package com.wheelshare.app.services;


import java.util.List;

import com.wheelshare.app.model.User;

public interface UserService {

	public boolean addUser(User User);
	public User getUserByUserNamePass(String userName,String password);
	public User getUserById(long id);
	public List<User> getUserList();
	public boolean deleteUser(long UserId);
	public User validateUser(String emailId, String phone);
	
} 
