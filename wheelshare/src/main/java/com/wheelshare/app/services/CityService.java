package com.wheelshare.app.services;


import java.util.List;

import com.wheelshare.app.model.City;

public interface CityService {

	public boolean addCity(City city);
	public City getCityById(long id);
	public List<City> getCityList();
	public boolean deleteCity(long cityId);
	
}
