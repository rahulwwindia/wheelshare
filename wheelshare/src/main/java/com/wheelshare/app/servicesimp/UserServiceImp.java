package com.wheelshare.app.servicesimp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wheelshare.app.dao.UserDao;
import com.wheelshare.app.model.User;
import com.wheelshare.app.model.UserAuth;
import com.wheelshare.app.services.UserService;

@Service("UserService")
@Transactional(readOnly=false)
public class UserServiceImp implements UserService{

	@Autowired
	UserDao UserDao;

	
	@Override
	public boolean addUser(User User) {
		// TODO Auto-generated method stub
		return UserDao.addUser(User);
	}

	@Override
	public boolean deleteUser(long UserId) {
		// TODO Auto-generated method stub
		return UserDao.deleteUser(UserId);
	}

	@Override
	public User getUserById(long id) {
		// TODO Auto-generated method stub
		return UserDao.getUserById(id);
	}

	@Override
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return UserDao.getUserList();
	}

	@Override
	public boolean addUserAuth(UserAuth userAuth) {
		// TODO Auto-generated method stub
		return UserDao.addUserAuth(userAuth);
	}

	
}
