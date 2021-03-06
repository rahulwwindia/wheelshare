package com.wheelshare.app.daoimp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.wheelshare.app.model.Status;
import com.wheelshare.app.model.TravelStatus;
import com.wheelshare.app.utility.Level;

@Repository("RiderDao")
public class RiderDaoImp implements RiderDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public boolean addRider(Rider rider) {  
		hibernateTemplate.saveOrUpdate(rider);
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
	public List<Rider> getRiderListWithLocDate(Date date, long fromLocId, long toLocId,
			long cityId) throws ParseException {
		Session session = hibernateTemplate.getSessionFactory().openSession();  
		List riderList=null;
		Criteria criteria = session.createCriteria(Rider.class);

		if(date!=null){   
			criteria.add(Restrictions.eq("travel_date",date));
		}    
			criteria.add(Restrictions.eq("fromLocation",fromLocId));
			criteria.add(Restrictions.eq("toLocation",toLocId));
			criteria.add(Restrictions.eq("city",cityId));
			criteria.add(Restrictions.eq("active",true));
			criteria.add(Restrictions.gt("capacity",0));
			criteria.addOrder(Order.asc("travel_date"));
			riderList=criteria.list();
			if(riderList.isEmpty())
			{
				Criteria criteria2 = session.createCriteria(Rider.class);

				if(date!=null){   
					criteria2.add(Restrictions.eq("travel_date",date));
				}    
				criteria2.add(Restrictions.eq("fromLocation",fromLocId));
				criteria2.add(Restrictions.eq("city",cityId));
				criteria2.add(Restrictions.eq("active",true));
				criteria2.add(Restrictions.gt("capacity",0));
				criteria2.addOrder(Order.asc("travel_date"));
					riderList=criteria2.list();

			}
			 
		return riderList;
	}


}
