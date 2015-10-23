package com.wheelshare.app.servicesimp;

import java.text.ParseException;
import java.util.Date;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wheelshare.app.dao.UserAccountDao;
import com.wheelshare.app.model.TravelStatus;
import com.wheelshare.app.model.User;
import com.wheelshare.app.services.UserAccountService;

@Service("UserAccountService")
@Transactional(readOnly=false)
public class UserAccountServiceImp implements UserAccountService {

	@Autowired
	UserAccountDao userAccountDao;
	
	@Override
	public boolean addSeaterRequest(TravelStatus travelStatus) {
		// TODO Auto-generated method stub
		return userAccountDao.addSeaterRequest(travelStatus);
	}

	@Override
	public Set<User> getAllSeaterRequest(long userId, Date date) {
		// TODO Auto-generated method stub
		try {
			return userAccountDao.getAllSeaterRequest(userId, date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Set<User> getAllRiderRequest(long userId, Date date) {
		// TODO Auto-generated method stub
		try {
			return userAccountDao.getAllRiderRequest(userId, date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


}
