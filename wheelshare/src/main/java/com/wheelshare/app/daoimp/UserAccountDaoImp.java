/*
 * 
 */
package com.wheelshare.app.daoimp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.wheelshare.app.utility.Level;

// TODO: Auto-generated Javadoc
/**
 * The Class UserAccountDaoImp.
 */
@Repository("UserAccountDao")
public class UserAccountDaoImp implements UserAccountDao {

	/** The hibernate template. */
	@Autowired
	private HibernateTemplate hibernateTemplate;

	/** The sdf. */
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	/** The output df. */
	SimpleDateFormat outputDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	/* (non-Javadoc)
	 * @see com.wheelshare.app.dao.UserAccountDao#addSeaterRequest(com.wheelshare.app.model.TravelStatus)
	 */
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

	/* (non-Javadoc)
	 * @see com.wheelshare.app.dao.UserAccountDao#getAllSeaterRequest(long, java.util.Date)
	 */
	@Override
	public Set<User> getAllSeaterRequest(long userId, Date date) throws ParseException {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(TravelStatus.class);
		criteria.setProjection(Projections.property("seaterId"));
		if (date != null) {
			String fromDate =sdf.format(date)+" 00:00:00"; 
			String toDate =sdf.format(date)+" 23:59:59";  
			criteria.add(Restrictions.ge("travelDate",  outputDF.parse(fromDate))); 
			criteria.add(Restrictions.le("travelDate",  outputDF.parse(toDate))); 
		}
			criteria.add(Restrictions.eq("riderId", userId));  
		criteria.add(Restrictions.eq("active",true));
		criteria.add(Restrictions.in("requestStatus", new String[]{Level.PND,Level.ACPT,Level.CNF}));  
		criteria.addOrder(Order.asc("requestDate"));
		List travelStatus =  criteria.list();  
		Set<User> userList = new HashSet<>();   
		for (int i=0;i<travelStatus.size();i++) {  
				User user = hibernateTemplate.load(User.class, (Long) travelStatus.get(i));
				user.setPassword(null);
				userList.add(user);
  
		}    
		return userList;
	}

	/* (non-Javadoc)
	 * @see com.wheelshare.app.dao.UserAccountDao#confirmAllRiderReq(long, java.util.Date)
	 */
	@Override
	public Set<User> confirmAllRiderReq(long userId, Date date) throws ParseException {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(TravelStatus.class);
		criteria.setProjection(Projections.property("seaterId"));
		if (date != null) {
			String fromDate =sdf.format(date)+" 00:00:00"; 
			String toDate =sdf.format(date)+" 23:59:59";  
			criteria.add(Restrictions.ge("travelDate",  outputDF.parse(fromDate))); 
			criteria.add(Restrictions.le("travelDate",  outputDF.parse(toDate))); 
		} 
			criteria.add(Restrictions.eq("seaterId", userId));  
		criteria.add(Restrictions.eq("active",true));
		criteria.add(Restrictions.in("requestStatus", new String[]{Level.ACPT,Level.CNF}));  
		criteria.addOrder(Order.asc("requestDate"));
		List travelStatus =  criteria.list();  
		Set<User> userList = new HashSet<>();   
		for (int i=0;i<travelStatus.size();i++) {  
				User user = hibernateTemplate.load(User.class, (Long) travelStatus.get(i));
				user.setPassword(null);
				userList.add(user);
  
		}    
		return userList;
	}

}
