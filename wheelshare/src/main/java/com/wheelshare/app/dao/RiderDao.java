package com.wheelshare.app.dao;


import java.util.List;

import com.wheelshare.app.model.Rider;

public interface RiderDao {

	public boolean addRider(Rider rider);
	
	public boolean deleteRider(long id);
	public List<Rider> getRiderList();

}
