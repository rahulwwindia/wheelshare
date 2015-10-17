package com.wheelshare.app.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "RIDER")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Proxy(lazy = false)
public class Rider{   
   
	public Rider() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "USER_ID")  
	private long userId;
	@Column(name = "VEHICLE_TYPE")
	private String vehicleType;
	@Column(name = "VEHICLE_NO")
	private String vehicleNo;
	@Column(name = "CITY_ID")
	private long city;
	@Column(name = "FROM_LOC_ID")
	private long fromLocation;
	@Column(name = "TO_LOC_ID")
	private long toLocation;
	@Column(name = "TRAVEL_TIME")
	private String travel_time;
	@Temporal(TemporalType.DATE)
	@Column(name = "TRAVEL_DATE")
	private Date travel_date;
	@Column(name = "CAPACITY")
	private int capacity;
	@Column(name = "SHARE_WITH")
	private String shareWith;
	  
	@Type(type="yes_no")  
	@Column(name = "RIDER_ACTIVE")          
	private boolean active;	         

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE",updatable=false)
	private Date createdDate;  
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE",insertable=false)
	private Date updatedDate;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private User user;     

	public long getUserId() {
		return userId;
	}  

	public User getUser() {
		return user;
	} 

	public void setUser(User user) {
		this.user = user;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public long getCity() {
		return city;
	}

	public void setCity(long city) {
		this.city = city;
	} 
  
	public long getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(long fromLocation) {
		this.fromLocation = fromLocation;
	}

	public long getToLocation() {
		return toLocation;
	}

	public void setToLocation(long toLocation) {
		this.toLocation = toLocation;
	}

	public int getCapacity() {
		return capacity;
	}

	public String getTravel_time() {
		return travel_time;
	}

	public void setTravel_time(String travel_time) {
		this.travel_time = travel_time;
	}

	public Date getTravel_date() {
		return travel_date;
	}

	public void setTravel_date(Date travel_date) {
		this.travel_date = travel_date;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getShareWith() {
		return shareWith;
	}

	public void setShareWith(String shareWith) {
		this.shareWith = shareWith;
	}
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	

}
