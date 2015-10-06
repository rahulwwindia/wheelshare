package com.wheelshare.app.servicesimp;


import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wheelshare.app.dao.RiderDao;
import com.wheelshare.app.model.Rider;
import com.wheelshare.app.services.RiderService;

@Service("RiderService")
@Transactional(readOnly=false)
public class RiderServiceImp implements RiderService{

	@Autowired
	RiderDao riderDao;

	@Override
	public boolean addRider(Rider rider) {
		// TODO Auto-generated method stub
		return riderDao.addRider(rider);
	}

	@Override
	public boolean deleteRider(long riderId) {
		// TODO Auto-generated method stub
		return riderDao.deleteRider(riderId);
	}

	@Override
	public Rider getRiderByUserId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rider> getRiderList() {
		// TODO Auto-generated method stub
		return riderDao.getRiderList();
	}

	@Override
	public List<Rider> getRiderListWithLocDate(Date date, long fromLocId, long toLocId, long cityId) {
		List<Rider> riders=null;
		try {
			riders=riderDao.getRiderListWithLocDate(date, fromLocId, toLocId, cityId);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return riders;
	}

}
