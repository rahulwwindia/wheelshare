package com.wheelshare.app.daoimp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wheelshare.app.dao.RiderDao;
import com.wheelshare.app.model.Rider;

@Repository("RiderDao")
public class RiderDaoImp implements RiderDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

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

	@Override
	public List<Rider> getRiderListWithLocDate(String fromDate, String toDate, String fromLocId, String toLocId,
			String cityId) throws ParseException {
		Session session = hibernateTemplate.getSessionFactory()
				.openSession();
		Criteria criteria = session.createCriteria(Rider.class);
		if(fromDate!=null){
			criteria.add(Restrictions.ge("travel_date",sdf.parse(fromDate)));
		}
		if(toDate!=null){
			criteria.add(Restrictions.le("travel_date",sdf.parse(toDate)));
		}
		if(fromLocId!=null){
			criteria.add(Restrictions.eq("fromLocation",Long.parseLong(fromLocId)));
		}
		if(toLocId!=null){
			criteria.add(Restrictions.eq("toLocation",Long.parseLong(toLocId)));
		}    
		if(cityId!=null){
			criteria.add(Restrictions.eq("city",Long.parseLong(cityId)));
		} 

		criteria.addOrder(Order.asc("travel_date"));
			
		return criteria.list();
	}

}
