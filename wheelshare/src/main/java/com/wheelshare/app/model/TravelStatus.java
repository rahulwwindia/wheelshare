package com.wheelshare.app.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "TRAVEL_STATUS")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Proxy(lazy = false)
public class TravelStatus{   
   
	public TravelStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "TRAVEL_ID")
	@GeneratedValue
	private long travelId;
	
	@Column(name = "RIDER_ID")
	private long riderId;
	
	@Column(name = "SEATER_ID")
	private long seaterId;
	
	@Column(name = "PAYMENT_CODE")
	private String paymentCode;
	
	@Column(name = "REQUEST_STATUS")
	private String requestStatus;
	
	@Column(name = "TRAVEL_DATE")
	private Date travelDate;
	
	@Column(name = "REQUEST_DATE")
	private Date requestDate;
	
	@Type(type="yes_no")  
	@Column(name = "TRAVEL_STATUS")          
	private boolean active;

	public long getTravelId() {
		return travelId;
	}

	public void setTravelId(long travelId) {
		this.travelId = travelId;
	}  


	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public boolean isActive() {
		return active;
	}

	public long getRiderId() {
		return riderId;
	}

	public void setRiderId(long riderId) {
		this.riderId = riderId;
	}

	public long getSeaterId() {
		return seaterId;
	}

	public void setSeaterId(long seaterId) {
		this.seaterId = seaterId;
	}

	public String getPaymentCode() {
		return paymentCode;
	}

	public void setPaymentCode(String paymentCode) {
		this.paymentCode = paymentCode;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "TravelStatus [travelId=" + travelId + ", riderId=" + riderId + ", seaterId=" + seaterId
				+ ", paymentCode=" + paymentCode + ", requestStatus=" + requestStatus + ", travelDate=" + travelDate
				+ ", requestDate=" + requestDate + ", active=" + active + "]";
	}	         

	
}
