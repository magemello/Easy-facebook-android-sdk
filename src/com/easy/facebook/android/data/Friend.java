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


public class Friend
{
	private String uid;
    private String name;
    private String pic;
    private String profile_update_time;
    private String timezone;
    private String birthday_date;
    private String online_presence;
    private String locale;
    private String profile_url;
    private String website;
    private String is_blocked;
    
	public Friend() {
		super();
	}

    public Friend(String uid, String name, String pic, String profile_update_time, String timezone, String birthday_date, 
            String online_presence, String locale, String profile_url, String website, String is_blocked)
    {
        this.uid = uid;
        this.name = name;
        this.pic = pic;
        this.profile_update_time = profile_update_time;
        this.timezone = timezone;
        this.birthday_date = birthday_date;
        this.online_presence = online_presence;
        this.locale = locale;
        this.profile_url = profile_url;
        this.website = website;
        this.is_blocked = is_blocked;
    }

    public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getProfile_update_time() {
		return profile_update_time;
	}
	public void setProfile_update_time(String profile_update_time) {
		this.profile_update_time = profile_update_time;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public String getBirthday_date() {
		return birthday_date;
	}
	public void setBirthday_date(String birthday_date) {
		this.birthday_date = birthday_date;
	}
	public String getOnline_presence() {
		return online_presence;
	}
	public void setOnline_presence(String online_presence) {
		this.online_presence = online_presence;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getProfile_url() {
		return profile_url;
	}
	public void setProfile_url(String profile_url) {
		this.profile_url = profile_url;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getIs_blocked() {
		return is_blocked;
	}
	public void setIs_blocked(String is_blocked) {
		this.is_blocked = is_blocked;
	}


}
