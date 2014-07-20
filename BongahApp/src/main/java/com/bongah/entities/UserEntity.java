package com.bongah.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="tbl_users")
public class UserEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
	private Integer id;

    @OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="user")
    @Fetch(FetchMode.SELECT)
    private List<PropertyEntity> properties;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "email_address")
    private String emailAddress;
    
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Column(name = "email_verification_status")
    private boolean emailVerification;
    
    @Column(name = "password")
    private String password;

    public List<PropertyEntity> getProperties()
    {
    	return properties;
    }

    public void setProperties(List<PropertyEntity> val)
    {
    	properties = val;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isEmailVerification() {
		return emailVerification;
	}

	public void setEmailVerification(boolean emailVerification) {
		this.emailVerification = emailVerification;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
