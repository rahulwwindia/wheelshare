package com.wheelshare.app.servicesimp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wheelshare.app.dao.UserAccountDao;
import com.wheelshare.app.model.TravelStatus;
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


}
