package com.wheelshare.app.services;


import java.util.List;

import com.wheelshare.app.model.User;
import com.wheelshare.app.model.UserAuth;

public interface UserService {

	public boolean addUser(User User);
	public User getUserById(long id);
	public List<User> getUserList();
	public boolean deleteUser(long UserId);
	public boolean addUserAuth(UserAuth userAuth);
	
} 
