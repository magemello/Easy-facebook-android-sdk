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

public class Home {
	String id;
    From from;
    List<To> to;
    String picture;
    String link;
    String name;
    String caption;
    String description;
    String icon;
    String source;
    List<Actions> actions;
    String type;
    String created_time;
    String updated_time;
    String likes;
    List<Comment> comment;
    
	public Home() {
		super();
	}
	
    public Home(String id,
    From from,
    List<To> to,
    String picture,
    String link,
    String name,
    String caption,
    String description,
    String icon,
    String source,
    List<Actions> actions,
    String type,
    String created_time,
    String updated_time,
    String likes,
    List<Comment> comment)
    {
    	this.id = id;
    	this.from = from;
    	this.to = to;
        this.picture = picture;
        this.link  = link;
        this.name = name;
        this.caption = caption;
        this.description = description;
        this.icon = icon;
        this.source = source;
        this.actions = actions;
        this.type = type;
        this.created_time = created_time;
        this.updated_time = updated_time;
        this.likes = likes;
        this.comment = comment;
    
    }
    



	public List<Comment> getComment() {
		return comment;
	}




	public void setComment(List<Comment> comment) {
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

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}


	public List<Actions> getActions() {
		return actions;
	}

	public void setActions(List<Actions> actions) {
		this.actions = actions;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getLikes() {
		return likes;
	}

	public void setLikes(String likes) {
		this.likes = likes;
	}
    

}
