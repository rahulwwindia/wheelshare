package com.wheelshare.app.dao;

import java.util.List;

import com.wheelshare.app.model.Status;
import com.wheelshare.app.model.User;

public interface UserDao {

	public boolean addUser(User User);

	public User getUserByUserNamePass(String userName, String password);

	public User getUserById(long id);

	public List<User> getUserList();

	public boolean deleteUser(long id);
	
	public User validateUser(String emailId, String phone);
	
	
}
