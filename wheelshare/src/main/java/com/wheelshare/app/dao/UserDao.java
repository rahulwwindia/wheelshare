package com.wheelshare.app.dao;


import java.util.List;

import com.wheelshare.app.model.User;
import com.wheelshare.app.model.UserAuth;

public interface UserDao {

	public boolean addUser(User User);
	
	public boolean addUserAuth(UserAuth User);

	public User getUserById(long id);

	public List<User> getUserList();

	public boolean deleteUser(long id);
}
