package com.wheelshare.app.servicesimp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wheelshare.app.dao.LocationDao;
import com.wheelshare.app.model.Location;
import com.wheelshare.app.services.LocationService;

@Service("LocationService")
@Transactional(readOnly=false)
public class LocationServiceImp implements LocationService{

	@Autowired
	LocationDao LocationDao;

	
	@Override
	public boolean addLocation(Location Location) {
		// TODO Auto-generated method stub
		return LocationDao.addLocation(Location);
	}

	@Override
	public boolean deleteLocation(long LocationId) {
		// TODO Auto-generated method stub
		return LocationDao.deleteLocation(LocationId);
	}

	@Override
	public Location getLocationById(long id) {
		// TODO Auto-generated method stub
		return LocationDao.getLocationById(id);
	}

	@Override
	public List<Location> getLocationList() {
		// TODO Auto-generated method stub
		return LocationDao.getLocationList();
	}

	@Override
	public List<Location> getLocationByCityId(long id) {
		// TODO Auto-generated method stub
		return LocationDao.getLocationByCityId(id);
	}

	
}
