package com.wheelshare.app.utility;

import javax.annotation.PostConstruct;

import org.hibernate.SessionFactory;
import org.hibernate.event.service.spi.EventListenerRegistry;
import org.hibernate.event.spi.EventType;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HibernateEventWiring {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private UpdateDateListener listener;

    @PostConstruct
    public void registerListeners() {
    	System.out.println("******************************************");
        EventListenerRegistry registry = ((SessionFactoryImpl) sessionFactory).getServiceRegistry().getService(
        EventListenerRegistry.class);
        registry.getEventListenerGroup(EventType.PRE_INSERT).appendListener(listener);
        registry.getEventListenerGroup(EventType.PRE_UPDATE).appendListener(listener);
    }
}