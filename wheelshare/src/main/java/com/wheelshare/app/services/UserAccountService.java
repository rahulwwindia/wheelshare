package com.wheelshare.app.services;

import java.util.Date;
import java.util.Set;

import com.wheelshare.app.model.TravelStatus;
import com.wheelshare.app.model.User;

public interface UserAccountService {

	public boolean addSeaterRequest(TravelStatus travelStatus);
	public Set<User> getAllSeaterRequest(long userId, Date date);
	public Set<User> confirmAllRiderReq(long userId, Date date);
	
	
}
