package com.wheelshare.app.daoimp;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.wheelshare.app.dao.UserAccountDao;
import com.wheelshare.app.model.TravelStatus;

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

}
