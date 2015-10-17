package com.wheelshare.app.dao;


import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.wheelshare.app.model.TravelStatus;
import com.wheelshare.app.model.User;

public interface UserAccountDao {

	public boolean addSeaterRequest(TravelStatus travelStatus);
	public Set<User> getAllSeaterRequest(long userId, Date date)throws ParseException;

}
