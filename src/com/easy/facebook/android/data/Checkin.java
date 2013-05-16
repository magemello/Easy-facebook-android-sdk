package com.easy.facebook.android.data;

public class Checkin {
	
	String id;
	String name;
	String category;
	Location location;
	
	
	
	
	public Checkin(String name, String category, Location location, String id) {
		super();
		this.name = name;
		this.category = category;
		this.location = location;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


}
