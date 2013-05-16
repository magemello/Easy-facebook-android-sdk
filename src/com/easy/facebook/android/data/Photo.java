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

public class Photo {
	
	String id;
	From from;
	List<Tag> tags;
	String name;
	String picture;
	String source;
	String height;
	String width;
	List<Images> images;
	String link;
	String icon;
	String created_time;
	String position;
	String updated_time;
	List<Comment> comments;
	
	
	
	public Photo() {
		super();
	}



	public Photo(String id, From from, List<Tag> tags, String name,
			String picture, String source, String height, String width,
			List<Images> images, String link, String icon, String created_time,
			String position, String updated_time, List<Comment> comments) {
		super();
		this.id = id;
		this.from = from;
		this.tags = tags;
		this.name = name;
		this.picture = picture;
		this.source = source;
		this.height = height;
		this.width = width;
		this.images = images;
		this.link = link;
		this.icon = icon;
		this.created_time = created_time;
		this.position = position;
		this.updated_time = updated_time;
		this.comments = comments;
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



	public List<Tag> getTags() {
		return tags;
	}



	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPicture() {
		return picture;
	}



	public void setPicture(String picture) {
		this.picture = picture;
	}



	public String getSource() {
		return source;
	}



	public void setSource(String source) {
		this.source = source;
	}



	public String getHeight() {
		return height;
	}



	public void setHeight(String height) {
		this.height = height;
	}



	public String getWidth() {
		return width;
	}



	public void setWidth(String width) {
		this.width = width;
	}



	public List<Images> getImages() {
		return images;
	}



	public void setImages(List<Images> images) {
		this.images = images;
	}



	public String getLink() {
		return link;
	}



	public void setLink(String link) {
		this.link = link;
	}



	public String getIcon() {
		return icon;
	}



	public void setIcon(String icon) {
		this.icon = icon;
	}



	public String getCreated_time() {
		return created_time;
	}



	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}



	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	public String getUpdated_time() {
		return updated_time;
	}



	public void setUpdated_time(String updated_time) {
		this.updated_time = updated_time;
	}



	public List<Comment> getComments() {
		return comments;
	}



	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	
	

}
