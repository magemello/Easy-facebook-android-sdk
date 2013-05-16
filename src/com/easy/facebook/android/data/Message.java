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

public class Message {
	
	String id;
	From from;
	List<To> to;
	String message;
	String updated_time;
	String subject;
	List<Comment> comment;


	public Message() {
		super();
	}



	public Message(String id, From from, List<To> to, String message,
			String updated_time, String subject, List<Comment> comment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.message = message;
		this.updated_time = updated_time;
		this.subject = subject;
		this.comment = comment;
	}
	
	
	
	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public From getFrom() {
		return from;
	}



	public void setFrom(From from) {
		this.from = from;
	}



	public List<To> getTo() {
		return to;
	}



	public void setTo(List<To> to) {
		this.to = to;
	}



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}



	public String getUpdated_time() {
		return updated_time;
	}



	public void setUpdated_time(String updated_time) {
		this.updated_time = updated_time;
	}



	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	public List<Comment> getComment() {
		return comment;
	}



	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	

}
