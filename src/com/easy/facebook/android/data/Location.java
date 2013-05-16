package com.easy.facebook.android.data;

public class Location {

	String id;
	String name;
	String street;
	String city;
	String country;
	String zip;
	String latitude;
	String longitude;

	


	public Location() {
		super();
	}



	public Location(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Location(String id, String name,String  street,String city,String country,String zip,String latitude,String longitude) {
		super();
		this.id = id;
		this.name = name;
		this.street = street;
		this.city = city;
		this.country = country;
		this.zip = zip;
		this.latitude = latitude;
		this.longitude = longitude;
	}


	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}
	
	public String getStreet() {
		return street;
	}



	public void setStreet(String street) {
		this.street = street;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getCountry() {
		return country;
	}



	public void setCountry(String country) {
		this.country = country;
	}



	public String getZip() {
		return zip;
	}



	public void setZip(String zip) {
		this.zip = zip;
	}



	public String getLatitude() {
		return latitude;
	}



	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}



	public String getLongitude() {
		return longitude;
	}



	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	
}
