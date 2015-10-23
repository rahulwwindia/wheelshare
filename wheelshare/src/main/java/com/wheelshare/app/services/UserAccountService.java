package com.wheelshare.app.services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.RequestBody;

import com.wheelshare.app.model.TravelStatus;
import com.wheelshare.app.model.User;

public interface UserAccountService {

	public boolean addSeaterRequest(TravelStatus travelStatus);
	public Set<User> getAllSeaterRequest(long userId, Date date);
	public Set<User> getAllRiderRequest(long userId, Date date);
	
	
}
