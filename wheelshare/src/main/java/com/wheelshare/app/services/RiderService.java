package com.wheelshare.app.services;

import java.util.List;

import com.wheelshare.app.model.Rider;

public interface RiderService {

	public boolean addRider(Rider rider);

	public Rider getRiderByUserId(long id);

	public List<Rider> getRiderList();
	
	public List<Rider> getRiderListWithLocDate(String fromDate, String toDate, String fromLocId, String toLocId, String cityId);

	public boolean deleteRider(long riderId);

}
