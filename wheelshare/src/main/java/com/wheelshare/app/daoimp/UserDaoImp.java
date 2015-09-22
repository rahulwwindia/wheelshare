package com.wheelshare.app.daoimp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wheelshare.app.dao.UserDao;
import com.wheelshare.app.model.User;
import com.wheelshare.app.model.UserAuth;

@Repository("UserDao")  
public class UserDaoImp implements UserDao {

	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.persist(user);
		UserAuth userAuth = new UserAuth();
		System.out.println(user.getPassword());
		userAuth.setPassword(user.getPassword());
		userAuth.setUserId(user.getUserId());
		user.setUserAuth(userAuth);
		 hibernateTemplate.save(user);
		return true;
	}  
      
	@Override
	public User getUserById(long id) { 
		// TODO Auto-generated method stub
		return hibernateTemplate.load(User.class, id);
	} 
	@Override
	public List<User> getUserList(){
		// TODO Auto-generated method stub    
		return (List<User>) hibernateTemplate.find("from User");
	}

	@Override  
	public boolean deleteUser(long id) {
		User user =hibernateTemplate.load(User.class, id);
		user.setActive(false);
		hibernateTemplate.update(user);
		return true;
	}

	@Override
	public boolean addUserAuth(UserAuth User) {
		 hibernateTemplate.save(User);
		return true;
	}


}
