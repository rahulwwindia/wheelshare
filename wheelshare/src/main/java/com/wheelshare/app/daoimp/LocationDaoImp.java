package com.wheelshare.app.daoimp;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wheelshare.app.dao.LocationDao;
import com.wheelshare.app.model.Location;

@Repository("LocationDao")  
public class LocationDaoImp implements LocationDao {

	
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public boolean addLocation(Location location) {
		// TODO Auto-generated method stub
		 hibernateTemplate.save(location);
		return true;
	}
      
	@Override
	public Location getLocationById(long id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.load(Location.class, id);
	} 
	@Override
	public List<Location> getLocationList(){
		// TODO Auto-generated method stub    
		System.out.println("TESTT  NNN");
		return (List<Location>) hibernateTemplate.find("from Location");
	}

	@Override  
	public boolean deleteLocation(long id) {
		hibernateTemplate.delete(hibernateTemplate.load(Location.class, id));
		return true;
	}

	@Override
	public List<Location> getLocationByCityId(long id) {
		// TODO Auto-generated method stub
		return (List<Location>) hibernateTemplate.find("from Location where cityId=?",id);
	}

}
