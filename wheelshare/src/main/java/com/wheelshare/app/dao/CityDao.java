package com.wheelshare.app.dao;


import java.util.List;

import com.wheelshare.app.model.City;

public interface CityDao {

	public boolean addCity(City City);

	public City getCityById(long id);

	public List<City> getCityList();

	public boolean deleteCity(long id);
}
