package com.wheelshare.app.services;


import java.util.List;

import com.wheelshare.app.model.Location;

public interface LocationService {

	public boolean addLocation(Location Location);
	public Location getLocationById(long id);
	public List<Location> getLocationByCityId(long id);
	public List<Location> getLocationList();
	public boolean deleteLocation(long LocationId);
	
}
