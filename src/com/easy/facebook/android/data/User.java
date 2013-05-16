/*  
*	Author: Mario Romano & Eugenio Romano
*   Title : Easy Facebook Android SDK
*
*   This file is part of Easy Facebook Android SDK.
*
*   Easy Facebook Android SDK is free software; you can redistribute it and/or modify
*   it under the terms of the GNU Lesser General Public License as published by
*   the Free Software Foundation; either version 3 of the License, or
*   (at your option) any later version.
*
*   Easy Facebook Android SDK is distributed in the hope that it will be useful,
*   but WITHOUT ANY WARRANTY; without even the implied warranty of
*   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*   GNU Lesser General Public License for more details.
*
*   You should have received a copy of the GNU Lesser General Public License
*   along with Nome-Programma; if not, write to the Free Software
*   Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
*/
package com.easy.facebook.android.data;

import java.util.List;

public class User {
	
	String id;
	String name;
	String first_name;
	String last_name;
	String gender;
	String locale;
	String link;
	String third_party_id;
	String timezone;
	String updated_time;
	String verified;
	String about;
	String bio;
	String birthday;
	List<Education> education;
	String email;
	Hometown hometown;
	List<String> interested_in;
	Location location;
	List<String> meeting_for;
	String political;
	String quotes;
	String relationship_status;
	String religion;
	Person significant_other;
	String website;
	List<Work> work;
	List<Languages> languages;
	
	
	public User() {
		super();
	}




	public User(String id, String name, String first_name, String last_name,
			String gender, String locale, String link, String third_party_id,
			String timezone, String updated_time, String verified,
			String about, String bio, String birthday,
			List<Education> education, String email, Hometown hometown,
			List<String> interested_in, Location location,
			List<String> meeting_for, String political, String quotes,
			String relationship_status, String religion,
			Person significant_other, String website, List<Work> work,
			List<Languages> languages) {
		super();
		this.id = id;
		this.name = name;
		this.first_name = first_name;
		this.last_name = last_name;
		this.gender = gender;
		this.locale = locale;
		this.link = link;
		this.third_party_id = third_party_id;
		this.timezone = timezone;
		this.updated_time = updated_time;
		this.verified = verified;
		this.about = about;
		this.bio = bio;
		this.birthday = birthday;
		this.education = education;
		this.email = email;
		this.hometown = hometown;
		this.interested_in = interested_in;
		this.location = location;
		this.meeting_for = meeting_for;
		this.political = political;
		this.quotes = quotes;
		this.relationship_status = relationship_status;
		this.religion = religion;
		this.significant_other = significant_other;
		this.website = website;
		this.work = work;
		this.languages = languages;
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




	public String getFirst_name() {
		return first_name;
	}




	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}




	public String getLast_name() {
		return last_name;
	}




	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}




	public String getGender() {
		return gender;
	}




	public void setGender(String gender) {
		this.gender = gender;
	}




	public String getLocale() {
		return locale;
	}




	public void setLocale(String locale) {
		this.locale = locale;
	}




	public String getLink() {
		return link;
	}




	public void setLink(String link) {
		this.link = link;
	}




	public String getThird_party_id() {
		return third_party_id;
	}




	public void setThird_party_id(String third_party_id) {
		this.third_party_id = third_party_id;
	}




	public String getTimezone() {
		return timezone;
	}




	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}




	public String getUpdated_time() {
		return updated_time;
	}




	public void setUpdated_time(String updated_time) {
		this.updated_time = updated_time;
	}




	public String getVerified() {
		return verified;
	}




	public void setVerified(String verified) {
		this.verified = verified;
	}




	public String getAbout() {
		return about;
	}




	public void setAbout(String about) {
		this.about = about;
	}




	public String getBio() {
		return bio;
	}




	public void setBio(String bio) {
		this.bio = bio;
	}




	public String getBirthday() {
		return birthday;
	}




	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}




	public List<Education> getEducation() {
		return education;
	}




	public void setEducation(List<Education> education) {
		this.education = education;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public Hometown getHometown() {
		return hometown;
	}




	public void setHometown(Hometown hometown) {
		this.hometown = hometown;
	}




	public List<String> getInterested_in() {
		return interested_in;
	}




	public void setInterested_in(List<String> interested_in) {
		this.interested_in = interested_in;
	}




	public Location getLocation() {
		return location;
	}




	public void setLocation(Location location) {
		this.location = location;
	}




	public List<String> getMeeting_for() {
		return meeting_for;
	}




	public void setMeeting_for(List<String> meeting_for) {
		this.meeting_for = meeting_for;
	}




	public String getPolitical() {
		return political;
	}




	public void setPolitical(String political) {
		this.political = political;
	}




	public String getQuotes() {
		return quotes;
	}




	public void setQuotes(String quotes) {
		this.quotes = quotes;
	}




	public String getRelationship_status() {
		return relationship_status;
	}




	public void setRelationship_status(String relationship_status) {
		this.relationship_status = relationship_status;
	}




	public String getReligion() {
		return religion;
	}




	public void setReligion(String religion) {
		this.religion = religion;
	}




	public Person getSignificant_other() {
		return significant_other;
	}




	public void setSignificant_other(Person significant_other) {
		this.significant_other = significant_other;
	}




	public String getWebsite() {
		return website;
	}




	public void setWebsite(String website) {
		this.website = website;
	}




	public List<Work> getWork() {
		return work;
	}




	public void setWork(List<Work> work) {
		this.work = work;
	}




	public List<Languages> getLanguages() {
		return languages;
	}




	public void setLanguages(List<Languages> languages) {
		this.languages = languages;
	}
	
	
	

}
