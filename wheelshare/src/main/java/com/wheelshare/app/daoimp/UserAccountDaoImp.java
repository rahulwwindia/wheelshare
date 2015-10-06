package com.wheelshare.app.daoimp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wheelshare.app.dao.UserAccountDao;
import com.wheelshare.app.model.TravelStatus;
import com.wheelshare.app.model.User;

@Repository("UserAccountDao")
public class UserAccountDaoImp implements UserAccountDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public boolean addSeaterRequest(TravelStatus travelStatus) {
		// TODO Auto-generated method stub
		try {
			hibernateTemplate.saveOrUpdate(travelStatus);
			return true;

		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public Set<User> getAllSeaterRequest(String userId, String date) throws ParseException {
		Session session = hibernateTemplate.getSessionFactory()
				.openSession();
		Criteria criteria = session.createCriteria(TravelStatus.class);
		criteria.setProjection(Projections.property("seaterId"));
		if(date!=null){
			criteria.add(Restrictions.eq("travelDate",sdf.parse(date)));
		}
		if(userId!=null){
			criteria.add(Restrictions.eq("riderId",Long.parseLong(userId)));
		} 
  
		criteria.addOrder(Order.asc("requestDate"));    
		List<TravelStatus> travelStatus=criteria.list();
		System.out.println("travelStatus"+travelStatus.get(0));
		Set<User> userList= new HashSet<>();	
		for (TravelStatus traveler : travelStatus) {   
			User user =hibernateTemplate.load(User.class, traveler.getSeaterId());
			userList.add(user);
			System.out.println("user :::"+user);  
		}
		return userList;
	}
  
}
