package com.wheelshare.app.servicesimp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wheelshare.app.dao.CityDao;
import com.wheelshare.app.model.City;
import com.wheelshare.app.services.CityService;

@Service("cityService")
@Transactional(readOnly=false)
public class CityServiceImp implements CityService{

	@Autowired
	CityDao cityDao;

	
	@Override
	public boolean addCity(City city) {
		// TODO Auto-generated method stub
		return cityDao.addCity(city);
	}

	@Override
	public boolean deleteCity(long cityId) {
		// TODO Auto-generated method stub
		return cityDao.deleteCity(cityId);
	}

	@Override
	public City getCityById(long id) {
		// TODO Auto-generated method stub
		return cityDao.getCityById(id);
	}

	@Override
	public List<City> getCityList() {
		// TODO Auto-generated method stub
		return cityDao.getCityList();
	}

	
}
