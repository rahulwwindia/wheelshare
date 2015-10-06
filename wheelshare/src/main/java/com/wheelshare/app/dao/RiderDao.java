package com.wheelshare.app.dao;


import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.wheelshare.app.model.Rider;

public interface RiderDao {

	public boolean addRider(Rider rider);
	
	public boolean deleteRider(long id);
	public List<Rider> getRiderList();
	public List<Rider> getRiderListWithLocDate(Date fromDate, long fromLocId, long toLocId, long cityId)throws ParseException;

}
