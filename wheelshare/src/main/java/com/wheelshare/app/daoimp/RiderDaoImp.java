package com.wheelshare.app.daoimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wheelshare.app.dao.RiderDao;
import com.wheelshare.app.model.Rider;
import com.wheelshare.app.model.Rider;

@Repository("RiderDao")
public class RiderDaoImp implements RiderDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public boolean addRider(Rider rider) {
		hibernateTemplate.save(rider);
		return true;
	}

	@Override
	public boolean deleteRider(long id) {
		Rider rider =hibernateTemplate.load(Rider.class, id);
		rider.setActive(false);
		hibernateTemplate.update(rider);
		return true;
	}

	@Override
	public List<Rider> getRiderList() {
		// TODO Auto-generated method stub
		return (List<Rider>) hibernateTemplate.find("from Rider");
	}

}
