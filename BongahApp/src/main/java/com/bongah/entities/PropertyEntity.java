package com.bongah.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tbl_properties")
public class PropertyEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "property_id")
	private Integer id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private UserEntity user;
    
    @Column(name = "property_reference_number")
    private Integer propertyReferenceNumber;
    
    @Column(name = "street_number")
    private Integer streetNumber;
    
    @Column(name = "street_name")
    private String streetName;
    
    @Column(name = "city_name")
    private String cityName;
    
    @Column(name = "province_name")
    private String provinceName;

    @Column(name = "postal_code")
    private String postalCode;
    
    @Column(name = "longitude")
    private double longitude;
    
    @Column(name = "lattitude")
    private double latitude;
   
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public Integer getPropertyReferenceNumber() {
		return propertyReferenceNumber;
	}

	public void setPropertyReferenceNumber(Integer propertyReferenceNumber) {
		this.propertyReferenceNumber = propertyReferenceNumber;
	}

	public Integer getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(Integer streetNumber) {
		this.streetNumber = streetNumber;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
}
