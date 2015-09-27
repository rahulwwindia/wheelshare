package com.wheelshare.app.model;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PreUpdate;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;
import org.hibernate.annotations.Type;

import com.wheelshare.app.utility.PasswordHash;

@Entity
@Table(name = "USER_MASTER")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Proxy(lazy = false)
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private long userId;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "EMAILID")
	private String emailId;

	@Column(name = "USERNAME")
	private String userName;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "PHONE")
	private String phone;

	@Column(name = "GENDER")
	private String gender;
	@Column(name = "IDENTITY_TYPE")
	private String identityType;

	@Column(name = "IDENTITY_NO")
	private String identityNo;

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATED_DATE", nullable = false)
	private Date createdDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE", nullable = false)
	private Date updatedDate;

	@Type(type = "yes_no")
	@Column(name = "USER_ACTIVE")
	private boolean active;

	public UserAuth getUserAuth() {
		return userAuth;
	}

	public void setUserAuth(UserAuth userAuth) {
		this.userAuth = userAuth;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	@JsonIgnore
	private UserAuth userAuth;

	@Column(name = "PASSWORD")
	private String password;

	public Date getUpdatedDate() {
		return updatedDate;
	} 

	@PreUpdate
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		try {
			this.password = PasswordHash.createHash(password);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}

	@Transient
	@JsonIgnore
	private String rePassword;

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdentityType() {
		return identityType;
	}

	public void setIdentityType(String identityType) {
		this.identityType = identityType;
	}

	public String getIdentityNo() {
		return identityNo;
	}

	public void setIdentityNo(String identityNo) {
		this.identityNo = identityNo;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", lastName=" + lastName + ", emailId=" + emailId + ", userName=" + userName
				+ ", firstName=" + firstName + ", phone=" + phone + ", gender=" + gender + ", identityType="
				+ identityType + ", identityNo=" + identityNo + ", createdDate=" + createdDate + ", updatedDate="
				+ updatedDate + ", active=" + active + ", userAuth=" + userAuth + ", password=" + password
				+ ", rePassword=" + rePassword + "]";
	}

}
