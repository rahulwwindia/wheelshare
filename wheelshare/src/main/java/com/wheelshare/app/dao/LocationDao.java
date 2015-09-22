package com.wheelshare.app.dao;


import java.util.List;

import com.wheelshare.app.model.Location;

public interface LocationDao {

	public boolean addLocation(Location location);
	public Location getLocationById(long id);
	public List<Location> getLocationByCityId(long id);
	public List<Location> getLocationList();
	public boolean deleteLocation(long id);
}
