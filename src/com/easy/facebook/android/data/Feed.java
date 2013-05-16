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

public class Feed {
	
	String likes;
	String id;
	From from;
	List<To> to;
	List<Comment> comment;
	String message;
	String picture;
	String link;
	String name;
	String caption;
	String description;
	String source;
	String icon;
	String attribution;
	String actions;
	String privacy;
	String created_time;
	String updated_time;
	String targeting;

	public Feed() {
		super();
	}
	
	public Feed(String likes,
	String id,
	From from,
	List<To>  to,
	String message,
	String picture,
	String link,
	String name,
	String caption,
	String description,
	String source,
	String icon,
	String attribution,
	String actions,
	String privacy,
	String created_time,
	String updated_time,
	String targeting,
	List<Comment> comment)
	{
		this.likes = likes;
		this.id = id;
		this.from = from;
		this.to = to;
		this.message = message;
		this.picture = picture;
		this.link = link;
		this.name = name;
		this.caption = caption;
		this.description = description;
		this.source = source;
		this.icon = icon; 
		this.attribution = attribution;
		this.actions = actions;
		this.privacy = privacy;
		this.created_time = created_time;
		this.updated_time = updated_time;
		this.targeting = targeting;
		this.comment = comment;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getAttribution() {
		return attribution;
	}

	public void setAttribution(String attribution) {
		this.attribution = attribution;
	}

	public String getActions() {
		return actions;
	}

	public void setActions(String actions) {
		this.actions = actions;
	}

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		this.privacy = privacy;
	}

	public String getCreated_time() {
		return created_time;
	}

	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}

	public String getUpdated_time() {
		return updated_time;
	}

	public void setUpdated_time(String updated_time) {
		this.updated_time = updated_time;
	}

	public String getTargeting() {
		return targeting;
	}

	public void setTargeting(String targeting) {
		this.targeting = targeting;
	}

}
