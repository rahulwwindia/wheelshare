package com.wheelshare.app.daoimp;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wheelshare.app.dao.UserDao;
import com.wheelshare.app.model.Rider;
import com.wheelshare.app.model.Status;
import com.wheelshare.app.model.TravelStatus;
import com.wheelshare.app.model.User;
import com.wheelshare.app.utility.Level;
import com.wheelshare.app.utility.PasswordHash;

@Repository("UserDao")
public class UserDaoImp implements UserDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.persist(user);
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
	public User getUserByUserNamePass(String userName, String password) {
		// TODO Auto-generated method stub
		boolean flag = false;
		List<User> user = (List<User>) hibernateTemplate.find("from User u where u.userName=?",userName);
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

	@Override
	public User validateUser(String emailId, String phone) {
		boolean flag = false;
		List<User> user = (List<User>) hibernateTemplate.find("from User u where u.emailId=? or u.phone=?",emailId,phone);
		if(user.size()!=0)  
				return user.get(0);
			else
				return null;

		}
	
	@Override
	public Status acceptUser(long riderId,long seaterId) {
		List<TravelStatus> travelStatus =(List<TravelStatus>) hibernateTemplate.find("from TravelStatus where riderId="+riderId+"and seaterId="+seaterId);
		if(travelStatus.size()!=0)
		{
			TravelStatus travelStatus2 = travelStatus.get(0);
			travelStatus2.setRequestStatus(Level.ACPT);
			Rider rider = hibernateTemplate.load(Rider.class, travelStatus2.getRiderId());
			int capacity=rider.getCapacity();
			rider.setCapacity(--capacity);
			hibernateTemplate.update(rider);
			hibernateTemplate.update(travelStatus2);
			return new Status(1, "Request Accepted Successfully.");
		}
		return new Status(0, "Problem in accepting request.");
	}

	@Override
	public Status rejectUser(long riderId, long seaterId) {
		List<TravelStatus> travelStatus =(List<TravelStatus>) hibernateTemplate.find("from TravelStatus where riderId="+riderId+"and seaterId="+seaterId);
		if(travelStatus.size()!=0)
		{
			TravelStatus travelStatus2 = travelStatus.get(0);
			travelStatus2.setRequestStatus(Level.RJCT);
			hibernateTemplate.update(travelStatus2);
			return new Status(1, "Request Rejected Successfully.");
		}
		return new Status(0, "Problem in accepting request.");

	}

		
}
