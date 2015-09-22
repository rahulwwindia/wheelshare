package com.wheelshare.app.daoimp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wheelshare.app.dao.CityDao;
import com.wheelshare.app.model.City;

@Repository("cityDao")  
public class CityDaoImp implements CityDao {

	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public boolean addCity(City city) {
		// TODO Auto-generated method stub
		 hibernateTemplate.save(city);
		return true;
	}
      
	@Override
	public City getCityById(long id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.load(City.class, id);
	} 
	@Override
	public List<City> getCityList(){
		// TODO Auto-generated method stub    
		return (List<City>) hibernateTemplate.find("from City");
	}

	@Override  
	public boolean deleteCity(long id) {
		City city =hibernateTemplate.load(City.class, id);
		city.setActive(false);
		hibernateTemplate.update(city);
		return true;
	}


}
