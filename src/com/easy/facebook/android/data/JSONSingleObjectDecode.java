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

import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;


public class JSONSingleObjectDecode {

	public JSONSingleObjectDecode() {
		super();
	}

	public To getTo(String jsonString) throws JSONException {

		JSONObject json;

		json = new JSONObject(jsonString);

		String id = "";
		if (!json.isNull("id"))
			id = json.getString("id");

		String name = "";
		if (!json.isNull("name"))
			name = json.getString("name");

		return new To(id, name);

	}

	public Hometown getHometown(String jsonString) throws JSONException {

		JSONObject json;

		json = new JSONObject(jsonString);

		String id = "";
		if (!json.isNull("id"))
			id = json.getString("id");

		String name = "";
		if (!json.isNull("name"))
			name = json.getString("name");

		return new Hometown(id, name);

	}

	public Location getLocation(String jsonString) throws JSONException {

		JSONObject json;

		json = new JSONObject(jsonString);

		String id = "";
		if (!json.isNull("id"))
			id = json.getString("id");

		String name = "";
		if (!json.isNull("name"))
			name = json.getString("name");

		return new Location(id, name);

	}

	public School getSchool(String jsonString) throws JSONException {

		JSONObject json;

		json = new JSONObject(jsonString);

		String id = "";
		if (!json.isNull("id"))
			id = json.getString("id");

		String name = "";
		if (!json.isNull("name"))
			name = json.getString("name");

		return new School(id, name);

	}

	public Languages getLanguages(String jsonString) throws JSONException {

		JSONObject json;

		json = new JSONObject(jsonString);

		String id = "";
		if (!json.isNull("id"))
			id = json.getString("id");

		String name = "";
		if (!json.isNull("name"))
			name = json.getString("name");

		return new Languages(id, name);

	}

	public Position getPosition(String jsonString) throws JSONException {

		JSONObject json;

		json = new JSONObject(jsonString);

		String id = "";
		if (!json.isNull("id"))
			id = json.getString("id");

		String name = "";
		if (!json.isNull("name"))
			name = json.getString("name");

		return new Position(id, name);

	}

	public Education getEducation(String jsonString) throws JSONException {

		JSONObject json;

		json = new JSONObject(jsonString);

		String jsonSchool = "";
		School school = new School();
		if (!json.isNull("school")) {
			jsonSchool = json.getString("school");
			JSONObject schoolJSON = new JSONObject(jsonSchool);

			if (!schoolJSON.isNull("id"))
				school.setId(schoolJSON.get("id").toString());

			if (!schoolJSON.isNull("name"))
				school.setName(schoolJSON.get("name").toString());
		}

		String type = "";
		if (!json.isNull("type"))
			type = json.getString("type");

		return new Education(school, type);

	}

	public Work getWork(String jsonString) throws JSONException {

		JSONObject json;

		json = new JSONObject(jsonString);

		String jsonEmployer = "";
		Employer employer = new Employer();
		if (!json.isNull("employer")) {
			jsonEmployer = json.getString("employer");
			JSONObject employerJSON = new JSONObject(jsonEmployer);

			if (!employerJSON.isNull("id"))
				employer.setId(employerJSON.get("id").toString());

			if (!employerJSON.isNull("name"))
				employer.setName(employerJSON.get("name").toString());
		}

		String jsonLocation = "";
		Location location = new Location();
		if (!json.isNull("location")) {
			jsonLocation = json.getString("location");
			JSONObject locationJSON = new JSONObject(jsonLocation);

			if (!locationJSON.isNull("id"))
				location.setId(locationJSON.get("id").toString());

			if (!locationJSON.isNull("name"))
				location.setName(locationJSON.get("name").toString());
		}

		String jsonPosition = "";
		Position position = new Position();
		if (!json.isNull("position")) {
			jsonPosition = json.getString("position");
			JSONObject positionJSON = new JSONObject(jsonPosition);

			if (!positionJSON.isNull("id"))
				position.setId(positionJSON.get("id").toString());

			if (!positionJSON.isNull("name"))
				position.setName(positionJSON.get("name").toString());
		}

		String description = "";
		if (!json.isNull("description"))
			description = json.getString("description");

		String start_date = "";
		if (!json.isNull("start_date"))
			start_date = json.getString("start_date");

		return new Work(employer, location, position, description, start_date);

	}

	public Employer getEmployer(String jsonString) throws JSONException {

		JSONObject json;

		json = new JSONObject(jsonString);

		String id = "";
		if (!json.isNull("id"))
			id = json.getString("id");

		String name = "";
		if (!json.isNull("name"))
			name = json.getString("name");

		return new Employer(id, name);

	}

	public Person getPerson(String jsonString) throws JSONException {

		JSONObject json;

		json = new JSONObject(jsonString);

		String id = "";
		if (!json.isNull("id"))
			id = json.getString("id");

		String name = "";
		if (!json.isNull("name"))
			name = json.getString("name");

		return new Person(id, name);

	}

	public Friend getFriend(String jsonString) throws JSONException {

		JSONObject json;

		json = new JSONObject(jsonString);

		String uid = "";
		if (!json.isNull("uid"))
			uid = json.getString("uid");

		String name = "";
		if (!json.isNull("name"))
			name = json.getString("name");

		String pic = "";
		if (!json.isNull("pic"))
			pic = json.getString("pic").replaceAll("\\\\", "");

		String profile_update_time = "";
		if (!json.isNull("profile_update_time"))
			profile_update_time = json.getString("profile_update_time");

		String timezone = "";
		if (!json.isNull("timezone"))
			timezone = json.getString("timezone");

		String birthday_date = "";
		if (!json.isNull("birthday_date"))
			birthday_date = json.getString("birthday_date");

		String online_presence = "";
		if (!json.isNull("online_presence"))
			online_presence = json.getString("online_presence");

		String locale = "";
		if (!json.isNull("locale"))
			locale = json.getString("locale");

		String profile_url = "";
		if (!json.isNull("profile_url"))
			profile_url = json.getString("profile_url");

		String website = "";
		if (!json.isNull("website"))
			website = json.getString("website");

		String is_blocked = "";
		if (!json.isNull("is_blocked"))
			is_blocked = json.getString("is_blocked");

		return new Friend(uid, name, pic, profile_update_time, timezone,
				birthday_date, online_presence, locale, profile_url, website,
				is_blocked);

	}

	public Feed getFeed(String jsonString) throws JSONException {

		JSONObject json;

		json = new JSONObject(jsonString);

		String id = json.getString("id");

		String likes = "";
		if (!json.isNull("likes"))
			likes = json.getString("likes");

		String jsonFrom = "";
		From from = new From();
		if (!json.isNull("from")) {
			jsonFrom = json.getString("from");
			JSONObject fromJSON = new JSONObject(jsonFrom);

			if (!fromJSON.isNull("id"))
				from.setId(fromJSON.get("id").toString());

			if (!fromJSON.isNull("name"))
				from.setName(fromJSON.get("name").toString());
		}

		String jsonto = "";
		List<To> toList = new ArrayList<To>();
		if (!json.isNull("to")) {
			jsonto = json.getString("to");

			JSONObject objectJSON = new JSONObject(jsonto);

			String jsonData = "";
			if (!objectJSON.isNull("data")) {
				jsonData = objectJSON.getString("data").toString();

				JSONObjectDecode tojsonArray = new JSONObjectDecode(jsonData);

				for (int i = 0; i < tojsonArray.length(); i++) {
					toList.add(tojsonArray.getTo(i));
				}
			}

		}

		String message = "";
		if (!json.isNull("message"))
			message = json.getString("message");

		String picture = "";
		if (!json.isNull("picture"))
			picture = json.getString("picture");

		String link = "";
		if (!json.isNull("link"))
			link = json.getString("link");

		String name = "";
		if (!json.isNull("name"))
			name = json.getString("name");

		String caption = "";
		if (!json.isNull("caption"))
			caption = json.getString("caption");

		String description = "";
		if (!json.isNull("description"))
			description = json.getString("description");

		String source = "";
		if (!json.isNull("source"))
			source = json.getString("source");

		String icon = "";
		if (!json.isNull("icon"))
			icon = json.getString("icon");

		String attribution = "";
		if (!json.isNull("attribution"))
			attribution = json.getString("attribution");

		String actions = "";
		if (!json.isNull("actions"))
			actions = json.getString("actions");

		String privacy = "";
		if (!json.isNull("privacy"))
			privacy = json.getString("privacy");

		String created_time = "";
		if (!json.isNull("created_time"))
			created_time = json.getString("created_time");

		String updated_time = "";
		if (!json.isNull("updated_time"))
			updated_time = json.getString("updated_time");

		String targeting = "";
		if (!json.isNull("targeting"))
			targeting = json.getString("targeting");

		String jsonComments = "";
		List<Comment> commentsList = new ArrayList<Comment>();
		if (!json.isNull("comments")) {
			jsonComments = json.getString("comments");

			JSONObject objectJSON = new JSONObject(jsonComments);

			String jsonData = "";
			if (!objectJSON.isNull("data")) {
				jsonData = objectJSON.getString("data").toString();

				JSONObjectDecode commentsjsonArray = new JSONObjectDecode(
						jsonData);

				for (int i = 0; i < commentsjsonArray.length(); i++) {
					commentsList.add(commentsjsonArray.getComment(i));
				}
			}

		}

		return new Feed(likes, id, from, toList, message, picture, link, name,
				caption, description, source, icon, attribution, actions,
				privacy, created_time, updated_time, targeting, commentsList);

	}

	public Home getHome(String jsonString) throws JSONException {

		JSONObject json;

		json = new JSONObject(jsonString);

		String id = json.getString("id");

		String likes = "";
		if (!json.isNull("likes"))
			likes = json.getString("likes");

		String jsonFrom = "";
		From from = new From();
		if (!json.isNull("from")) {
			jsonFrom = json.getString("from");
			JSONObject fromJSON = new JSONObject(jsonFrom);

			if (!fromJSON.isNull("id"))
				from.setId(fromJSON.get("id").toString());

			if (!fromJSON.isNull("name"))
				from.setName(fromJSON.get("name").toString());
		}

		String jsonto = "";
		List<To> toList = new ArrayList<To>();
		if (!json.isNull("to")) {
			jsonto = json.getString("to");

			JSONObject objectJSON = new JSONObject(jsonto);

			String jsonData = "";
			if (!objectJSON.isNull("data")) {
				jsonData = objectJSON.getString("data").toString();

				JSONObjectDecode tojsonArray = new JSONObjectDecode(jsonData);

				for (int i = 0; i < tojsonArray.length(); i++) {
					toList.add(tojsonArray.getTo(i));
				}
			}

		}

		String picture = "";
		if (!json.isNull("picture"))
			picture = json.getString("picture");

		String link = "";
		if (!json.isNull("link"))
			link = json.getString("link");

		String name = "";
		if (!json.isNull("name"))
			name = json.getString("name");

		String caption = "";
		if (!json.isNull("caption"))
			caption = json.getString("caption");

		String description = "";
		if (!json.isNull("description"))
			description = json.getString("description");

		String icon = "";
		if (!json.isNull("icon"))
			icon = json.getString("icon");

		String source = "";
		if (!json.isNull("source"))
			source = json.getString("source");

		String jsonactions = "";
		List<Actions> actionsList = new ArrayList<Actions>();
		if (!json.isNull("actions")) {
			jsonactions = json.getString("actions");
			JSONObjectDecode actionsjsonArray = new JSONObjectDecode(
					jsonactions);

			for (int i = 0; i < actionsjsonArray.length(); i++) {
				actionsList.add(actionsjsonArray.getActions(i));
			}

		}

		String type = "";
		if (!json.isNull("type"))
			type = json.getString("type");

		String created_time = "";
		if (!json.isNull("created_time"))
			created_time = json.getString("created_time");

		String updated_time = "";
		if (!json.isNull("updated_time"))
			updated_time = json.getString("updated_time");

		String jsonComments = "";
		List<Comment> commentsList = new ArrayList<Comment>();
		if (!json.isNull("comments")) {
			jsonComments = json.getString("comments");

			JSONObject objectJSON = new JSONObject(jsonComments);

			String jsonData = "";
			if (!objectJSON.isNull("data")) {
				jsonData = objectJSON.getString("data").toString();

				JSONObjectDecode commentsjsonArray = new JSONObjectDecode(
						jsonData);

				for (int i = 0; i < commentsjsonArray.length(); i++) {
					commentsList.add(commentsjsonArray.getComment(i));
				}
			}

		}

		return new Home(id, from, toList, picture, link, name, caption,
				description, icon, source, actionsList, type, created_time,
				updated_time, likes, commentsList);

	}

	public Events getEvent(String jsonString) throws JSONException {

		JSONObject json;

		json = new JSONObject(jsonString);

		String id = "";
		if (!json.isNull("id"))
			id = json.getString("id");

		String name = "";
		if (!json.isNull("name"))
			name = json.getString("name").toString();

		String description = "";
		if (!json.isNull("description"))
			description = json.getString("description").toString();

		String start_time = "";
		if (!json.isNull("start_time"))
			start_time = json.getString("start_time").toString();

		String end_time = "";
		if (!json.isNull("end_time"))
			end_time = json.getString("end_time").toString();

		String location = "";
		if (!json.isNull("location"))
			location = json.getString("location").toString();

		String privacy = "";
		if (!json.isNull("privacy"))
			privacy = json.getString("privacy").toString();

		String updated_time = "";
		if (!json.isNull("updated_time"))
			json.getString("updated_time").toString();

		String jsonVenue = "";
		Venue venue = new Venue();
		if (!json.isNull("venue")) {
			jsonVenue = json.getString("venue");
			JSONObject venueJSON = new JSONObject(jsonVenue);

			if (!venueJSON.isNull("street"))
				venue.setStreet(venueJSON.get("street").toString());

			if (!venueJSON.isNull("city"))
				venue.setCity(venueJSON.get("city").toString());

			if (!venueJSON.isNull("state"))
				venue.setState(venueJSON.get("state").toString());

			if (!venueJSON.isNull("country"))
				venue.setCountry(venueJSON.get("country").toString());

			if (!venueJSON.isNull("latitude"))
				venue.setLatitude(venueJSON.get("latitude").toString());

			if (!venueJSON.isNull("longitude"))
				venue.setLongitude(venueJSON.get("longitude").toString());

			if (!venueJSON.isNull("zip"))
				venue.setZip(venueJSON.get("zip").toString());
		}

		String jsonOwner = "";
		Owner owner = new Owner();
		if (!json.isNull("owner")) {
			jsonOwner = json.getString("owner");
			JSONObject ownerJSON = new JSONObject(jsonOwner);

			if (!ownerJSON.isNull("id"))
				owner.setId(ownerJSON.get("id").toString());

			if (!ownerJSON.isNull("name"))
				owner.setName(ownerJSON.get("name").toString());
		}

		return new Events(id, owner, name, description, start_time, end_time,
				location, venue, privacy, updated_time);

	}

	public Group getGroup(String jsonString) throws JSONException {

		JSONObject json;

		json = new JSONObject(jsonString);

		String id = json.getString("id");

		String icon = "";
		if (!json.isNull("icon"))
			icon = json.getString("icon").toString();

		String name = "";
		if (!json.isNull("name"))
			name = json.getString("name").toString();

		String description = "";
		if (!json.isNull("description"))
			description = json.getString("description").toString();

		String link = "";
		if (!json.isNull("link"))
			link = json.getString("link").toString();

		String privacy = "";
		if (!json.isNull("privacy"))
			privacy = json.getString("privacy").toString();

		String updated_time = "";
		if (!json.isNull("updated_time"))
			updated_time = json.getString("updated_time").toString();

		String jsonOwner = "";
		Owner owner = new Owner();
		if (!json.isNull("owner")) {
			jsonOwner = json.getString("owner");
			JSONObject ownerJSON = new JSONObject(jsonOwner);

			if (!ownerJSON.isNull("id"))
				owner.setId(ownerJSON.get("id").toString());

			if (!ownerJSON.isNull("name"))
				owner.setName(ownerJSON.get("name").toString());
		}

		return new Group(id, icon, owner, name, description, link, privacy,
				updated_time);

	}

	public Album getAlbum(String jsonString) throws JSONException {

		JSONObject json;

		json = new JSONObject(jsonString);

		String id = json.getString("id");

		String jsonFrom = "";
		From from = new From();
		if (!json.isNull("from")) {
			jsonFrom = json.getString("from");
			JSONObject fromJSON = new JSONObject(jsonFrom);

			if (!fromJSON.isNull("id"))
				from.setId(fromJSON.get("id").toString());

			if (!fromJSON.isNull("name"))
				from.setName(fromJSON.get("name").toString());
		}

		String name = "";
		if (!json.isNull("name"))
			name = json.getString("name");

		String description = "";
		if (!json.isNull("description"))
			description = json.getString("description");

		String location = "";
		if (!json.isNull("location"))
			location = json.getString("location");

		String link = "";
		if (!json.isNull("link"))
			link = json.getString("link");

		String privacy = "";
		if (!json.isNull("privacy"))
			privacy = json.getString("privacy");

		String count = "";
		if (!json.isNull("count"))
			count = json.getString("count");

		String updated_time = "";
		if (!json.isNull("updated_time"))
			updated_time = json.getString("updated_time");

		String created_time = "";
		if (!json.isNull("created_time"))
			created_time = json.getString("created_time");

		return new Album(id, from, name, description, location, link, privacy,
				count, created_time, updated_time);

	}

	public Message getMessage(String jsonString) throws JSONException {

		JSONObject json;

		json = new JSONObject(jsonString);

		String id = json.getString("id");

		String jsonFrom = "";
		From from = new From();
		if (!json.isNull("from")) {
			jsonFrom = json.getString("from");
			JSONObject fromJSON = new JSONObject(jsonFrom);

			if (!fromJSON.isNull("id"))
				from.setId(fromJSON.get("id").toString());

			if (!fromJSON.isNull("name"))
				from.setName(fromJSON.get("name").toString());
		}

		String jsonto = "";
		List<To> toList = new ArrayList<To>();
		if (!json.isNull("to")) {
			jsonto = json.getString("to");

			JSONObject objectJSON = new JSONObject(jsonto);

			String jsonData = "";
			if (!objectJSON.isNull("data")) {
				jsonData = objectJSON.getString("data").toString();

				JSONObjectDecode tojsonArray = new JSONObjectDecode(jsonData);

				for (int i = 0; i < tojsonArray.length(); i++) {
					toList.add(tojsonArray.getTo(i));
				}
			}

		}

		String jsonComments = "";
		List<Comment> commentsList = new ArrayList<Comment>();
		if (!json.isNull("comments")) {
			jsonComments = json.getString("comments");

			JSONObject objectJSON = new JSONObject(jsonComments);

			String jsonData = "";
			if (!objectJSON.isNull("data")) {
				jsonData = objectJSON.getString("data").toString();

				JSONObjectDecode commentsjsonArray = new JSONObjectDecode(
						jsonData);

				for (int i = 0; i < commentsjsonArray.length(); i++) {
					commentsList.add(commentsjsonArray.getComment(i));
				}
			}

		}

		String message = "";
		if (!json.isNull("message"))
			message = json.getString("message");

		String updated_time = "";
		if (!json.isNull("updated_time"))
			updated_time = json.getString("updated_time");

		String subject = "";
		if (!json.isNull("subject"))
			subject = json.getString("subject");

		return new Message(id, from, toList, message, updated_time, subject,
				commentsList);

	}

	public Actions getActions(String jsonString) throws JSONException {
		JSONObject json;

		json = new JSONObject(jsonString);

		String name = "";
		if (!json.isNull("name"))
			name = json.getString("name");

		String link = "";
		if (!json.isNull("link"))
			link = json.getString("link");

		return new Actions(name, link);

	}

	public Comment getComment(String jsonString) throws JSONException {
		JSONObject json;

		json = new JSONObject(jsonString);

		String id = "";
		if (!json.isNull("id"))
			id = json.getString("id");

		String message = "";
		if (!json.isNull("message"))
			message = json.getString("message");

		String created_time = "";
		if (!json.isNull("created_time"))
			created_time = json.getString("created_time");

		String jsonFrom = "";
		From from = new From();
		if (!json.isNull("from")) {
			jsonFrom = json.getString("from");
			JSONObject fromJSON = new JSONObject(jsonFrom);

			if (!fromJSON.isNull("id"))
				from.setId(fromJSON.get("id").toString());

			if (!fromJSON.isNull("name"))
				from.setName(fromJSON.get("name").toString());
		}

		String likes = "";
		if (!json.isNull("likes"))
			likes = json.getString("likes");

		return new Comment(id, message, created_time, from, likes);

	}

	public Note getNote(String jsonString) throws JSONException {
		JSONObject json;
		json = new JSONObject(jsonString);

		String id = "";
		if (!json.isNull("id"))
			id = json.getString("id");

		String message = "";
		if (!json.isNull("message"))
			message = json.getString("message");

		String created_time = "";
		if (!json.isNull("created_time"))
			created_time = json.getString("created_time");

		String jsonFrom = "";
		From from = new From();
		if (!json.isNull("from")) {
			jsonFrom = json.getString("from");
			JSONObject fromJSON = new JSONObject(jsonFrom);

			if (!fromJSON.isNull("id"))
				from.setId(fromJSON.get("id").toString());

			if (!fromJSON.isNull("name"))
				from.setName(fromJSON.get("name").toString());
		}

		String updated_time = "";
		if (!json.isNull("updated_time"))
			updated_time = json.getString("updated_time");

		String icon = "";
		if (!json.isNull("icon"))
			icon = json.getString("icon");

		String subject = "";
		if (!json.isNull("subject"))
			subject = json.getString("subject");

		return new Note(id, from, subject, message, icon, created_time,
				updated_time);

	}

	public Page getPage(String jsonString) throws JSONException {

		JSONObject json;

		json = new JSONObject(jsonString);

		String id = "";
		if (!json.isNull("id"))
			id = json.get("id").toString();

		String name = "";
		if (!json.isNull("name"))
			name = json.get("name").toString();

		String picture = "";
		if (!json.isNull("picture"))
			picture = json.get("picture").toString();

		String link = "";
		if (!json.isNull("link"))
			link = json.get("link").toString();

		String category = "";
		if (!json.isNull("category"))
			category = json.get("category").toString();

		String website = "";
		if (!json.isNull("website"))
			website = json.get("website").toString();

		String description = "";
		if (!json.isNull("description"))
			description = json.get("description").toString();

		String likes = "";
		if (!json.isNull("likes"))
			likes = json.get("likes").toString();

		return new Page(id, name, picture, link, category, website,
				description, likes);

	}

	public Tag getTag(String jsonString) throws JSONException {

		JSONObject json;

		json = new JSONObject(jsonString);

		String id = "";
		if (!json.isNull("id"))
			id = json.get("id").toString();

		String name = "";
		if (!json.isNull("name"))
			name = json.get("name").toString();

		String x = "";
		if (!json.isNull("x"))
			x = json.get("x").toString();

		String y = "";
		if (!json.isNull("y"))
			y = json.get("y").toString();

		String created_time = "";
		if (!json.isNull("created_time"))
			created_time = json.get("created_time").toString();

		return new Tag(id, name, x, y, created_time);

	}

	public Images getImages(String jsonString) throws JSONException {

		JSONObject json;

		json = new JSONObject(jsonString);

		String height = "";
		if (!json.isNull("height"))
			height = json.get("height").toString();

		String width = "";
		if (!json.isNull("width"))
			width = json.get("width").toString();

		String source = "";
		if (!json.isNull("source"))
			source = json.get("source").toString();

		return new Images(height, width, source);

	}

	public Status getStatus(String jsonString) throws JSONException {

		JSONObject json;

		json = new JSONObject(jsonString);

		String message = "";
		if (!json.isNull("message"))
			message = json.get("message").toString();

		String time = "";
		if (!json.isNull("time"))
			time = json.get("time").toString();

		String status_id = "";
		if (!json.isNull("status_id"))
			status_id = json.get("status_id").toString();

		return new Status(message, time, status_id);

	}

	public Photo getPhoto(String jsonString) throws JSONException {

		JSONObject json;

		json = new JSONObject(jsonString);

		String id = json.getString("id");

		String jsonFrom = "";
		From from = new From();
		if (!json.isNull("from")) {
			jsonFrom = json.getString("from");
			JSONObject fromJSON = new JSONObject(jsonFrom);

			if (!fromJSON.isNull("id"))
				from.setId(fromJSON.get("id").toString());

			if (!fromJSON.isNull("name"))
				from.setName(fromJSON.get("name").toString());
		}

		String jsonComments = "";
		List<Comment> commentsList = new ArrayList<Comment>();
		if (!json.isNull("comments")) {
			jsonComments = json.getString("comments");

			JSONObject objectJSON = new JSONObject(jsonComments);

			String jsonData = "";
			if (!objectJSON.isNull("data")) {
				jsonData = objectJSON.getString("data").toString();

				JSONObjectDecode commentsjsonArray = new JSONObjectDecode(
						jsonData);

				for (int i = 0; i < commentsjsonArray.length(); i++) {
					commentsList.add(commentsjsonArray.getComment(i));
				}
			}

		}

		String jsonImages = "";
		List<Images> images = new ArrayList<Images>();
		if (!json.isNull("images")) {
			jsonImages = json.getString("images");

			JSONObjectDecode imagesjsonArray = new JSONObjectDecode(jsonImages);

			for (int i = 0; i < imagesjsonArray.length(); i++) {
				images.add(imagesjsonArray.getImages(i));
			}

		}

		String jsonTags = "";
		List<Tag> tags = new ArrayList<Tag>();
		if (!json.isNull("images")) {
			jsonTags = json.getString("tags");

			JSONObject objectJSON = new JSONObject(jsonTags);

			String jsonData = "";
			if (!objectJSON.isNull("data")) {
				jsonData = objectJSON.getString("data").toString();

				JSONObjectDecode tagsjsonArray = new JSONObjectDecode(jsonData);

				for (int i = 0; i < tagsjsonArray.length(); i++) {
					tags.add(tagsjsonArray.getTag(i));
				}
			}

		}

		String name = "";
		if (!json.isNull("name"))
			name = json.getString("name");

		String picture = "";
		if (!json.isNull("picture"))
			picture = json.getString("picture");

		String source = "";
		if (!json.isNull("source"))
			source = json.getString("source");

		String height = "";
		if (!json.isNull("height"))
			height = json.getString("height");

		String width = "";
		if (!json.isNull("width"))
			width = json.getString("width");

		String link = "";
		if (!json.isNull("link"))
			link = json.getString("link");

		String icon = "";
		if (!json.isNull("icon"))
			icon = json.getString("icon");

		String created_time = "";
		if (!json.isNull("created_time"))
			created_time = json.getString("created_time");

		String position = "";
		if (!json.isNull("position"))
			position = json.getString("position");

		String updated_time = "";
		if (!json.isNull("updated_time"))
			updated_time = json.getString("updated_time");

		return new Photo(id, from, tags, name, picture, source, height, width,
				images, link, icon, created_time, position, updated_time,
				commentsList);

	}

	public User getUser(String jsonString) throws JSONException {

		JSONObject json;

		json = new JSONObject(jsonString);

		String id = "";
		if (!json.isNull("id"))
			id = json.get("id").toString();

		String name = "";
		if (!json.isNull("name"))
			name = json.get("name").toString();

		String first_name = "";
		if (!json.isNull("first_name"))
			first_name = json.get("first_name").toString();

		String last_name = "";
		if (!json.isNull("last_name"))
			last_name = json.get("last_name").toString();

		String gender = "";
		if (!json.isNull("gender"))
			gender = json.get("gender").toString();

		String locale = "";
		if (!json.isNull("locale"))
			locale = json.get("locale").toString();

		String link = "";
		if (!json.isNull("link"))
			link = json.get("link").toString();

		String third_party_id = "";
		if (!json.isNull("third_party_id"))
			third_party_id = json.get("third_party_id").toString();

		String timezone = "";
		if (!json.isNull("timezone"))
			timezone = json.get("timezone").toString();

		String updated_time = "";
		if (!json.isNull("updated_time"))
			updated_time = json.get("updated_time").toString();

		String verified = "";
		if (!json.isNull("verified"))
			verified = json.get("verified").toString();

		String about = "";
		if (!json.isNull("about"))
			about = json.get("about").toString();

		String bio = "";
		if (!json.isNull("bio"))
			bio = json.get("bio").toString();

		String birthday = "";
		if (!json.isNull("birthday"))
			birthday = json.get("birthday").toString();

		List<Education> education = new ArrayList<Education>();
		if (!json.isNull("education")) {
			String jsoneducation = "";
			jsoneducation = json.getString("education");

			JSONObjectDecode educationjsonArray = new JSONObjectDecode(
					jsoneducation);

			for (int i = 0; i < educationjsonArray.length(); i++) {
				education.add(educationjsonArray.getEducation(i));
			}

		}

		String email = "";
		if (!json.isNull("email"))
			email = json.get("email").toString();

		String jsonHometown = "";
		Hometown hometown = new Hometown();
		if (!json.isNull("hometown")) {
			jsonHometown = json.getString("hometown");
			JSONObject hometownJSON = new JSONObject(jsonHometown);

			if (!hometownJSON.isNull("id"))
				hometown.setId(hometownJSON.get("id").toString());

			if (!hometownJSON.isNull("name"))
				hometown.setName(hometownJSON.get("name").toString());
		}

		String jsonLocation = "";
		Location location = new Location();
		if (!json.isNull("location")) {
			jsonLocation = json.getString("location");
			JSONObject locationJSON = new JSONObject(jsonLocation);

			if (!locationJSON.isNull("id"))
				location.setId(locationJSON.get("id").toString());

			if (!locationJSON.isNull("name"))
				location.setName(locationJSON.get("name").toString());
		}

		List<String> meeting_for = new ArrayList<String>();
		if (!json.isNull("meeting_for")) {
			String jsonmeeting_for = "";
			jsonmeeting_for = json.getString("meeting_for");

			JSONObjectDecode meeting_forjsonArray = new JSONObjectDecode(
					jsonmeeting_for);

			for (int i = 0; i < meeting_forjsonArray.length(); i++) {
				meeting_for.add(meeting_forjsonArray.getString(i));
			}

		}

		List<String> interested_in = new ArrayList<String>();
		if (!json.isNull("interested_in")) {
			String jsoninterested_in = "";
			jsoninterested_in = json.getString("interested_in");

			JSONObjectDecode interested_injsonArray = new JSONObjectDecode(
					jsoninterested_in);

			for (int i = 0; i < interested_injsonArray.length(); i++) {
				interested_in.add(interested_injsonArray.getString(i));
			}

		}

		String political = "";
		if (!json.isNull("political"))
			political = json.get("political").toString();

		String quotes = "";
		if (!json.isNull("quotes"))
			quotes = json.get("quotes").toString();

		String relationship_status = "";
		if (!json.isNull("relationship_status"))
			relationship_status = json.get("relationship_status").toString();

		String religion = "";
		if (!json.isNull("religion"))
			religion = json.get("religion").toString();

		String jsonPerson = "";
		Person significant_other = new Person();
		if (!json.isNull("significant_other")) {
			jsonPerson = json.getString("significant_other");
			JSONObject personJSON = new JSONObject(jsonPerson);

			if (!personJSON.isNull("id"))
				significant_other.setId(personJSON.get("id").toString());

			if (!personJSON.isNull("name"))
				significant_other.setName(personJSON.get("name").toString());
		}

		String website = "";
		if (!json.isNull("website"))
			website = json.get("website").toString();

		List<Work> work = new ArrayList<Work>();
		if (!json.isNull("work")) {
			String jsonwork = "";
			jsonwork = json.getString("work");

			JSONObjectDecode workjsonArray = new JSONObjectDecode(jsonwork);

			for (int i = 0; i < workjsonArray.length(); i++) {
				work.add(workjsonArray.getWork(i));
			}

		}

		List<Languages> languages = new ArrayList<Languages>();
		if (!json.isNull("languages")) {
			String jsonlanguages = "";
			jsonlanguages = json.getString("languages");

			JSONObjectDecode languagesjsonArray = new JSONObjectDecode(
					jsonlanguages);

			for (int i = 0; i < languagesjsonArray.length(); i++) {
				languages.add(languagesjsonArray.getLanguages(i));
			}

		}

		return new User(id, name, first_name, last_name, gender, locale, link,
				third_party_id, timezone, updated_time, verified, about, bio,
				birthday, education, email, hometown, interested_in, location,
				meeting_for, political, quotes, relationship_status, religion,
				significant_other, website, work, languages);

	}

}
