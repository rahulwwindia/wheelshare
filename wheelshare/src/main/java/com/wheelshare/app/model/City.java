package com.wheelshare.app.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;

@Entity
@Table(name = "CITY")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Proxy(lazy = false)
public class City {
	private static final long serialVersionUID = 1L;
  
	@Id       
	@GeneratedValue
	@Column(name = "CITYID")
	private long cityId;
    
	@Column(name = "CITY_NAME")    
	private String cityName;
	
	// One city to many location  
	/** The result. */ 
	@OneToMany(mappedBy = "locCity", fetch=FetchType.LAZY,cascade = { CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE })
	@JsonIgnore
	private Set<Location> location;  
	   
	@Type(type="yes_no")  
	@Column(name = "CITY_ACTIVE")
	private boolean active;	         
	
	public Boolean isActive() {     
		return active;
	}   
 
	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getCityName() {
		return cityName;
	}  

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public long getCityId() {
		return cityId;
	}

	public void setCityId(long cityId) {
		this.cityId = cityId;
	}

	public Set<Location> getLocation() {
		return location;
	}

	public void setLocation(Set<Location> location) {
		this.location = location;
	}


}
