package com.wheelshare.app.utility;

import java.util.Date;

import org.hibernate.event.spi.PreInsertEvent;
import org.hibernate.event.spi.PreInsertEventListener;
import org.hibernate.event.spi.PreUpdateEvent;
import org.hibernate.event.spi.PreUpdateEventListener;

import com.wheelshare.app.model.Rider;

public class UpdateDateListener implements PreInsertEventListener, PreUpdateEventListener {

	@Override
	public boolean onPreInsert(PreInsertEvent event) {
		onInsert(event.getEntity(), event.getState(), event.getPersister().getPropertyNames());
		return false;
	}

	@Override
	public boolean onPreUpdate(PreUpdateEvent event) {
		onUpdate(event.getEntity(), event.getState(), event.getPersister().getPropertyNames());
		return false;
	}

	private void setPropertyState(Object[] propertyStates, String[] propertyNames, String propertyName,
			Object propertyState) {
		for (int i = 0; i < propertyNames.length; i++) {
			if (propertyName.equals(propertyNames[i])) {
				propertyStates[i] = propertyState;
				return;
			}
		}
	}

	private void onInsert(Object entity, Object[] state, String[] propertyNames) {
		if (entity instanceof Rider) {
			Rider rider = (Rider) entity;
			Date date = new Date();
			rider.setCreatedDate(date);
			setPropertyState(state, propertyNames, "createdDate", date);
			rider.setUpdatedDate(date);
			setPropertyState(state, propertyNames, "updatedDate", date);
		}
	}

	private void onUpdate(Object entity, Object[] state, String[] propertyNames) {
		if (entity instanceof Rider) {
			Rider rider = (Rider) entity;
			Date date = new Date();
			setPropertyState(state, propertyNames, "createdDate", rider.getCreatedDate());
			rider.setUpdatedDate(date);
			setPropertyState(state, propertyNames, "updatedDate", date);
		}
	}

}