package com.wheelshare.app.daoimp;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wheelshare.app.dao.UserDao;
import com.wheelshare.app.model.User;
import com.wheelshare.app.model.UserAuth;
import com.wheelshare.app.utility.PasswordHash;

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
	public List<User> getUserList() {
		// TODO Auto-generated method stub
		return (List<User>) hibernateTemplate.find("from User");
	}

	@Override
	public boolean deleteUser(long id) {
		User user = hibernateTemplate.load(User.class, id);
		user.setActive(false);
		hibernateTemplate.update(user);
		return true;
	}

	@Override
	public boolean addUserAuth(UserAuth User) {
		hibernateTemplate.save(User);
		return true;
	}

	@Override
	public User getUserByUserNamePass(String userName, String password) {
		// TODO Auto-generated method stub
		boolean flag = false;
		List<User> user = (List<User>) hibernateTemplate.find("from User u where u.userName=?",userName);
		System.out.println("user :"+user);
		try { 
			if(user.size()!=0)
			flag = PasswordHash.validatePassword(password, user.get(0).getPassword());
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();  
		}    
		System.out.println("flag :"+flag);    
		if (flag)  
			return user.get(0);
		else
			return null;
	}

}
