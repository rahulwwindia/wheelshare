package com.wheelshare.app.services;

import java.util.Date;
import java.util.List;

import com.wheelshare.app.model.Rider;
import com.wheelshare.app.model.Status;

public interface RiderService {

	public boolean addRider(Rider rider);

	public Rider getRiderByUserId(long id);

	public List<Rider> getRiderList();
	
	public List<Rider> getRiderListWithLocDate(Date date, long fromLocId, long toLocId, long cityId);

	public boolean deleteRider(long riderId);
	public Status acceptUser(long riderId,long seaterId);
	public Status rejectUser(long riderId,long seaterId);

}
