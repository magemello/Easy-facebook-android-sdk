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

public class Comment {
	
	String id;
	String message;
	String created_time;
	From from;
	String likes;
	
	public Comment() {
		super();
	}

	public Comment(String id,
	String message,
	String created_time,
	From from,
	String likes)
	{
		this.id = id;
		this.message = message;
		this.created_time = created_time;
		this.from = from;
		this.likes = likes;
	}
	
	public String getLikes() {
		return likes;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCreated_time() {
		return created_time;
	}
	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}
	public From getFrom() {
		return from;
	}
	public void setFrom(From from) {
		this.from = from;
	}

	

}
