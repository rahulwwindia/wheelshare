package com.wheelshare.app.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Type;


@Entity
@Table(name = "LOCATION")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Location {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "LOCATIONID")
	private long localtionId;
    
	@Column(name = "LOCATION_NAME")
	private String locationName;
	
	/** One city can have multiple locations */
	@ManyToOne
	// Many candidates to one Group
	@JoinColumn(name = "CITYID" )
	@JsonIgnore 
	private City locCity;

	
	@Type(type="yes_no")  
	@Column(name = "LOCATION_ACTIVE")
	private boolean active;	         

	
	public long getLocaltionId() {
		return localtionId;
	}

	public void setLocaltionId(long localtionId) {
		this.localtionId = localtionId; 
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public City getLocCity() {
		return locCity;
	}

	public void setLocCity(City locCity) {
		this.locCity = locCity;
	}


	
}
