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
package com.easy.facebook.android.apicall;


import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

import com.easy.facebook.android.data.Album;
import com.easy.facebook.android.data.Checkin;
import com.easy.facebook.android.data.Comment;
import com.easy.facebook.android.data.Events;
import com.easy.facebook.android.data.Feed;
import com.easy.facebook.android.data.Group;
import com.easy.facebook.android.data.Home;
import com.easy.facebook.android.data.JSONObjectDecode;
import com.easy.facebook.android.data.JSONSingleObjectDecode;
import com.easy.facebook.android.data.Message;
import com.easy.facebook.android.data.Note;
import com.easy.facebook.android.data.Page;
import com.easy.facebook.android.data.Person;
import com.easy.facebook.android.data.Photo;
import com.easy.facebook.android.data.User;
import com.easy.facebook.android.error.EasyFacebookError;
import com.easy.facebook.android.facebook.Facebook;
import com.easy.facebook.android.util.Util;
import android.os.Bundle;



public class GraphApi {

	private Facebook facebook;
	
    public GraphApi(Facebook facebook)
    {
        this.facebook = facebook;
       
    }
    
    
    
    
    /**********************************************SET METHODS  *****************************************/
    
    public String createMyNote(String message,String subject)  throws EasyFacebookError 
    {
    	return noteCall(message, subject, null); 
    }
    
    public String createNote(String message,String subject,String friendID)  throws EasyFacebookError 
    {
    	return noteCall(message, subject, friendID);
    }
    
	private String noteCall(String message,String subject,String friendID)  throws EasyFacebookError  {
		
		String postID = null;

		Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());
		params.putString("message", message);
		params.putString("subject", subject);
		

		
		if(friendID==null)
			friendID="me";
			
        try {
        	
        	String jsonResponse = Util.openUrl("https://graph.facebook.com/"+friendID+"/notes", "POST", params);
			 
			 JSONObject objectJSONErrorCheck = new JSONObject(jsonResponse);
			 
		       if(!objectJSONErrorCheck.isNull("error"))
		        {
		    	   throw new  EasyFacebookError(jsonResponse);
		    	   
		        }
		       
			 JSONObject json = new JSONObject(jsonResponse);
	            
	            if(json.has("id"))	
				postID=json.get("id").toString();
			
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}
		
		return postID;
			
	}
	

    
	public String commetReply(String message,String commentID)  throws EasyFacebookError  {
		
		String postID = null;

		Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());
		params.putString("message", message);
		

		
			
        try {
        	
        	String jsonResponse = Util.openUrl("https://graph.facebook.com/"+commentID+"/comments", "POST", params);
			 
			 JSONObject objectJSONErrorCheck = new JSONObject(jsonResponse);
			 
		       if(!objectJSONErrorCheck.isNull("error"))
		        {
		    	   throw new  EasyFacebookError(jsonResponse);
		    	   
		        }
		       
			 JSONObject json = new JSONObject(jsonResponse);
	            
	            if(json.has("id"))	
				postID=json.get("id").toString();
			
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}
		
		return postID;
			
	}

	public String postLocationMy(String message,String longitude,String latitude,String pagePlaceID,ArrayList<String> userIdTag)  throws EasyFacebookError  {
		 
		return postLocation(message,null,longitude,latitude,pagePlaceID,userIdTag);
	}
	
	public String postLocationFriend(String message,String friendID,String longitude,String latitude,String pagePlaceID,ArrayList<String> userIdTag)  throws EasyFacebookError  {
		 			 
		return	 postLocation(message,friendID,longitude,latitude,pagePlaceID,userIdTag);
	}
	
	private String postLocation(String message,String friendID,String longitude,String latitude,String pagePlaceID,ArrayList<String> userIdTag)  throws EasyFacebookError  {
		
		String postID = null;

		Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());
		params.putString("message", message);
	    params.putString("coordinates", "{\"latitude\": \""+latitude+"\", \"longitude\": \""+longitude+"\"}");
		params.putString("place", pagePlaceID);

	    String tag = "";
	    int flagtag = 0;
	    for (String idtag : userIdTag) {
	    	tag = tag +  "," + idtag ;
	    	flagtag = 1;
	    }
	    
	    if(flagtag==1)
	    {
	    	tag = tag.substring(1, tag.length());
	    }
	    
		params.putString("tags", tag);

		if(friendID==null)
			friendID="me";
				
			
        try {
        	
        	String jsonResponse = Util.openUrl("https://graph.facebook.com/"+friendID+"/checkins", "POST", params);
			 
			 JSONObject objectJSONErrorCheck = new JSONObject(jsonResponse);
			 
		       if(!objectJSONErrorCheck.isNull("error"))
		        {
		    	   throw new  EasyFacebookError(jsonResponse);
		    	   
		        }
		       
			 JSONObject json = new JSONObject(jsonResponse);
	            
	            if(json.has("id"))	
				postID=json.get("id").toString();
			
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}
		
		return postID;
			
	}

    public String postToFriend(String message,String friendID,String urlPicture)  throws EasyFacebookError 
    {
    	return postCall(message,friendID,urlPicture,null,null,null,null,null,null,null,null,null);
    }
    
    public String postToFriend(String message,String friendID)  throws EasyFacebookError 
    {
    	return postCall(message,friendID,null,null,null,null,null,null,null,null,null,null);
    }
    
    public String postToFriend(String message,String friendID,String urlPicture,String actionsUrl,String actionsName,String link,String name,String privacy,String countries,String regions,String locales)  throws EasyFacebookError 
    {
    	return postCall(message,friendID,urlPicture,actionsUrl,actionsName,link,name,privacy,countries,regions,locales,null);
    }
    
	public String postToFriend(String message,String friendID,String urlPicture,String actionsUrl,String actionsName,String link,String name,String description) throws EasyFacebookError 
	{
		return postCall(message,friendID,urlPicture,actionsUrl,actionsName,link,name,null,null,null,null,description);
	}
	
	public String postToFriend(String message,String friendID,String urlPicture,String actionsUrl,String actionsName) throws EasyFacebookError 
	{
		return postCall(message,friendID,urlPicture,actionsUrl,actionsName,null,null,null,null,null,null,null);
	}
	
	public String postToFriend(String message,String friendID,String urlPicture,String countries,String regions,String locales) throws EasyFacebookError 
	{
		return postCall(message,friendID,urlPicture,null,null,null,null,null,countries,regions,locales,null);
	}
	
	
	public String setStatus(String message,String urlPicture) throws EasyFacebookError 
	{
		return postCall(message,null,urlPicture,null,null,null,null,null,null,null,null,null);
	}
	
	public String setStatus(String message) throws EasyFacebookError 
	{
		return postCall(message,null,null,null,null,null,null,null,null,null,null,null);
	}
	
	public String setStatus(String message,String urlPicture,String actionsUrl,String actionsName,String link,String name,String privacy,String countries,String regions,String locales) throws EasyFacebookError 
	{
		return postCall(message,null,urlPicture,actionsUrl,actionsName,link,name,privacy,countries,regions,locales,null);
	}
	
	public String setStatus(String message,String urlPicture,String actionsUrl,String actionsName,String link,String name) throws EasyFacebookError 
	{
		return postCall(message,null,urlPicture,actionsUrl,actionsName,link,name,null,null,null,null,null);
	}
	
	public String setStatus(String message,String urlPicture,String actionsUrl,String actionsName) throws EasyFacebookError 
	{
		return postCall(message,null,urlPicture,actionsUrl,actionsName,null,null,null,null,null,null,null);
	}
	
	public String setStatus(String message,String urlPicture,String countries,String regions,String locales) throws EasyFacebookError 
	{
		return postCall(message,null,urlPicture,null,null,null,null,null,countries,regions,locales,null);
	}
	

    
	private String postCall(String message,String friendID,String urlPicture,String actionsUrl,String actionsName,String link,String name,String privacy,String countries,String regions,String locales,String description)  throws EasyFacebookError  {
		
		String postID = null;

		Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());
		params.putString("message", message);
		
		
		if(description!=null)
			params.putString("description", description);
				
		if(actionsUrl!=null && actionsName!=null)
	     params.putString("actions", "{\"name\": \""+actionsName+"\", \"link\": \""+actionsUrl+"\"}");

		if(name!=null)
			params.putString("name", name);
		
		if(link!=null)
			params.putString("link", link);
		
		if(privacy!=null)
			params.putString("privacy", privacy);
		
		if(countries!=null && regions!=null  && locales!=null)
		     params.putString("targeting", "{\"countries\": \""+countries+"\", \"regions\": \""+regions+"\", \"locales\": \""+locales+"\"}");
		
		if(urlPicture!=null)
		  params.putString("picture", urlPicture);
		
		if(friendID==null)
			friendID="me";
		

			
        try {
        	
        	String jsonResponse = Util.openUrl("https://graph.facebook.com/"+friendID+"/feed", "POST", params);
			 
			 JSONObject objectJSONErrorCheck = new JSONObject(jsonResponse);
			 
		       if(!objectJSONErrorCheck.isNull("error"))
		        {
		    	   throw new  EasyFacebookError(jsonResponse);
		    	   
		        }
		       
			 JSONObject json = new JSONObject(jsonResponse);
	            
	            if(json.has("id"))	
				postID=json.get("id").toString();
			
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}
		
		return postID;
			
	}

	public String uploadPhoto(String message,String urlPicture) throws EasyFacebookError 
	{
		return uploadPhotoCall(message,null,urlPicture);
	}
	
	private String uploadPhotoCall(String message,String friendIDorAlbumID,String urlPicture)  throws EasyFacebookError  {
		
		String postID = null;

		Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());
		params.putString("message", message);
		
		
		if (urlPicture!=null)
		{String pictureName  =  urlPicture.substring(urlPicture.lastIndexOf('/'),urlPicture.length());
		params.putByteArray(pictureName, Util.loadPicture(urlPicture));}
		
		if(friendIDorAlbumID==null)
			friendIDorAlbumID="me";
		
        try {
        	
        	String jsonResponse = Util.openUrl("https://graph.facebook.com/"+friendIDorAlbumID+"/photos", "POST", params);
			 
			 JSONObject objectJSONErrorCheck = new JSONObject(jsonResponse);
			 
		       if(!objectJSONErrorCheck.isNull("error"))
		        {
		    	   throw new  EasyFacebookError(jsonResponse);
		    	   
		        }
		       
			 JSONObject json = new JSONObject(jsonResponse);
	            
	            if(json.has("id"))	
				postID=json.get("id").toString();
			
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}
		
		return postID;
			
	}
	
	
	
	public String createEvents(long  startTime,long  endTime,String name,String urlPicture,String privacy) throws EasyFacebookError  {
		
		return createEventsCall(startTime, endTime, name, urlPicture, privacy, "", "", "", "", "", "", "", "", "");
	}

	public String createEvents(long  startTime,long  endTime,String name,String privacy) throws EasyFacebookError  {
		
		return createEventsCall(startTime, endTime, name, null, privacy, "", "", "", "", "", "", "", "", "");
	}
	
	public String createEvents(long  startTime,long  endTime,String name,String urlPicture,String privacy,String description,String location,String street,String city,String state,
			String country,String latitude,String longitude,String zip)  throws EasyFacebookError {
		
		return createEventsCall(  startTime,  endTime, name, urlPicture, privacy, description, location, street, city, state,
				 country, latitude, longitude, zip);
	}
	
	public String createEvents(long  startTime,long  endTime,String name,String privacy,String description,String location,String street,String city,String state,
			String country,String latitude,String longitude,String zip) throws EasyFacebookError  {
		
		return createEventsCall(  startTime,  endTime, name, null, privacy, description, location, street, city, state,
				 country, latitude, longitude, zip);
	}
		
	private String createEventsCall(long  startTime,long  endTime,String name,String urlPicture,String privacy,String description,String location,String street,String city,String state,
									String country,String latitude,String longitude,String zip) throws EasyFacebookError  {

		String eventID=null;
		

		Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());
		params.putString("start_time", Long.toString(startTime).substring(0,10));
		params.putString("end_time", Long.toString(endTime).substring(0,10));
		params.putString("name", name);
		params.putString("description", description);
		params.putString("location", location);
		params.putString("street", street);
		params.putString("city", city);
		params.putString("state", state);
		params.putString("country", country);
		params.putString("latitude", latitude);
		params.putString("longitude", longitude);
		params.putString("zip", zip);
		params.putString("privacy", privacy);
		
		if (urlPicture!=null)
		{String pictureName  =  urlPicture.substring(urlPicture.lastIndexOf('/'),urlPicture.length());
		params.putByteArray(pictureName, Util.loadPicture(urlPicture));}
		
		


		try {
			
        	String jsonResponse = Util.openUrl("https://graph.facebook.com/me/events", "POST", params);
        	
			 JSONObject objectJSONErrorCheck = new JSONObject(jsonResponse);
			 
		       if(!objectJSONErrorCheck.isNull("error"))
		        {
		    	   throw new  EasyFacebookError(jsonResponse);
		    	   
		        }
		       
            JSONObject json = new JSONObject(jsonResponse);
            
            if(json.has("id"))	
			eventID=json.get("id").toString();
            
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}
         
            	
        return eventID;
			
	}
	
	
	public String createAlbum(String albumName)  throws EasyFacebookError 
	{
		return createAlbumCall(albumName,"","");
	}

	public String createAlbum(String albumName,String description)  throws EasyFacebookError 
	{
		return createAlbumCall(albumName,description,"");
	}
	
	public String createAlbum(String albumName,String description,String lcation)  throws EasyFacebookError 
	{
		return createAlbumCall(albumName,description,lcation);
	}

	
	private String createAlbumCall(String albumName,String description,String location)  throws EasyFacebookError 
    {
		String albumID = "";
    	Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());
		
		params.putString("name",albumName);
		params.putString("message",description);
		params.putString("location",location);
		
    	String jsonResponse;
		try {
			jsonResponse = Util.openUrl("https://graph.facebook.com/me/albums", "POST", params);

			 JSONObject objectJSONErrorCheck = new JSONObject(jsonResponse);
			 
		       if(!objectJSONErrorCheck.isNull("error"))
		        {
		    	   throw new  EasyFacebookError(jsonResponse);
		    	   
		        }
    	
        JSONObject json = new JSONObject(jsonResponse);
        
        if(json.has("id"))	
		albumID=json.get("id").toString();
        
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}

    return albumID;
    }   
	
	
	public String createFriendList(String frirndListName)  throws EasyFacebookError 
    {
		String frirndListID = "";
    	Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());
		
		params.putString("name",frirndListName);

		
    	String jsonResponse;
		try {
			jsonResponse = Util.openUrl("https://graph.facebook.com/me/friendlists", "POST", params);

    	
        JSONObject json = new JSONObject(jsonResponse);
        
        if(json.has("id"))	
        	frirndListID=json.get("id").toString();
        
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}

    return frirndListID;
    }   
	
	
	public String addMemberToFriendList(String frirndListID,String friendID)  throws EasyFacebookError 
    {

    	Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());
		
		
    	String jsonResponse = null;
		try {
			jsonResponse = Util.openUrl("https://graph.facebook.com/"+frirndListID+"/members/"+friendID, "POST", params);
	
			 JSONObject objectJSONErrorCheck = new JSONObject(jsonResponse);
			 
		       if(!objectJSONErrorCheck.isNull("error"))
		        {
		    	   throw new  EasyFacebookError(jsonResponse);
		    	   
		        }
		       
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}
    	

    return jsonResponse;
    } 

	
   /**********************************************GET METHODS**************************************************/
	
	public List<Album> getAlbumsFriends(String friendID,int limitAlbum)   throws EasyFacebookError 
	{
		return getAlbumsCall(friendID,limitAlbum);
	}
	
	public List<Album> getAllAlbumsFriends(String friendID)   throws EasyFacebookError 
	{
		return getAlbumsCall(friendID,-1);
	}
	
	public List<Album> getAlbumsMy(int limitAlbum)   throws EasyFacebookError 
	{
		return getAlbumsCall(null,limitAlbum);
	}
	
	public List<Album> getAllAlbumsMy()   throws EasyFacebookError 
	{
		return getAlbumsCall(null,-1);
	}
	
	
	private List<Album> getAlbumsCall(String friendID,int limitAlbum)   throws EasyFacebookError 
    {
		int numArrayElement = 0;
		int flagNext = 0;
		String until = "";
		int countAlbum = 0;
		
    	Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());
		
		if(friendID==null)
			friendID="me";
		
		String jsonResponse;
		List<Album> albumList = new ArrayList<Album>();
		
		try {
			jsonResponse = Util.openUrl("https://graph.facebook.com/"+friendID+"/albums", "GET", params);

			 JSONObject objectJSONErrorCheck = new JSONObject(jsonResponse);
			 
		       if(!objectJSONErrorCheck.isNull("error"))
		        {
		    	   throw new  EasyFacebookError(jsonResponse);
		    	   
		        }

		do{
		
        JSONObject objectJSON = new JSONObject(jsonResponse);
       
		 String jsonData="";
		 if(!objectJSON.isNull("data"))
           {jsonData = objectJSON.getString("data").toString();
		         
           	JSONObjectDecode jsonArray = new JSONObjectDecode(jsonData);
		
           	numArrayElement =  jsonArray.length();
           	
           	for(int i = 0; i < jsonArray.length() && (countAlbum<limitAlbum || limitAlbum<0); i++)
           	{
           		albumList.add(jsonArray.getAlbum(i));
           		countAlbum++;
           	}
           	
           	String paging="";
		    if(!objectJSON.isNull("paging"))
		    { paging = objectJSON.getString("paging");
		      
		       JSONObject objectnextJSON = new JSONObject(paging);
		       String next="";
		       if(!objectnextJSON.isNull("next"))
		        {
		    	   next = objectnextJSON.getString("next").toString();
		       	   if(!until.equals(next.substring(next.lastIndexOf("until=")+6,next.length()).toString()) && (countAlbum<limitAlbum || limitAlbum<0))
		       	   {
		       		flagNext = 1;  
		       		until = next.substring(next.lastIndexOf("until=")+6,next.length());
		       		params = new Bundle(); 
		    		params.putString("format", "json");
		    		params.putString("access_token",facebook.getAccessToken());
		    		params.putString("limit", "25");
		    		params.putString("until", until);
		    	    jsonResponse = Util.openUrl("https://graph.facebook.com/"+friendID+"/albums", "GET", params);
		    	    
				   objectJSONErrorCheck = new JSONObject(jsonResponse);
				 
			       if(!objectJSONErrorCheck.isNull("error"))
			        {
			    	   throw new  EasyFacebookError(jsonResponse);
			    	   
			        }
		       	   }
		       	   else
		       	   {
		       		flagNext = 0;   
		       	   }
		       		   
		    	}
            }
           }
		}while(flagNext==1 && numArrayElement>0 &&  (countAlbum<limitAlbum || limitAlbum<0));
           
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}
		
    return albumList;
    }   
	
	
	
	public List<Feed> getPostFriends(String friendID,int limitPost) throws EasyFacebookError 
	{
		return getPostCall(friendID,limitPost);
	}
	
	public List<Feed> getAllPostFriends(String friendID) throws EasyFacebookError 
	{
		return getPostCall(friendID,-1);
	}
	
	public List<Feed> getPostMy(int limitPost) throws EasyFacebookError 
	{
		return getPostCall(null,limitPost);
	}
	
	public List<Feed> getAllPostMy() throws EasyFacebookError 
	{
		return getPostCall(null,-1);
	}
	
	
	private List<Feed> getPostCall(String friendID,int limitPost) throws EasyFacebookError 
    {
		
		int flagNext = 0;
		String until = "";
		int countPost = 0;
		int numArrayElement = 0;
		
    	Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());
		
		if(friendID==null)
			friendID="me";
		
		String jsonResponse;
		List<Feed> feedList = new ArrayList<Feed>();

		
		try {
			jsonResponse = Util.openUrl("https://graph.facebook.com/"+friendID+"/feed", "GET", params);

			 JSONObject objectJSONErrorCheck = new JSONObject(jsonResponse);
			 
		       if(!objectJSONErrorCheck.isNull("error"))
		        {
		    	   throw new  EasyFacebookError(jsonResponse);
		    	   
		        }
		
		do{
		
			JSONObject objectJSON = new JSONObject(jsonResponse);
       
		 String jsonData="";
		 if(!objectJSON.isNull("data"))
           {jsonData = objectJSON.getString("data").toString();
		         
           	JSONObjectDecode jsonArray = new JSONObjectDecode(jsonData);
		
           	numArrayElement =  jsonArray.length();
           	
           	
           	for(int i = 0; i < jsonArray.length() && (countPost<limitPost || limitPost<0); i++)
           	{
           		feedList.add(jsonArray.getFeed(i));
           		countPost++;
           	}
           	
           	String paging="";
		    if(!objectJSON.isNull("paging"))
		    { paging = objectJSON.getString("paging");
		      
		       JSONObject objectnextJSON = new JSONObject(paging);
		       String next="";
		       if(!objectnextJSON.isNull("next"))
		        {
		    	   next = objectnextJSON.getString("next").toString();
		       	   if(!until.equals(next.substring(next.lastIndexOf("until=")+6,next.length()).toString()) && (countPost<limitPost || limitPost<0))
		       	   {
		       		flagNext = 1;  
		       		until = next.substring(next.lastIndexOf("until=")+6,next.length());
		       		params = new Bundle(); 
		    		params.putString("format", "json");
		    		params.putString("access_token",facebook.getAccessToken());
		    		params.putString("limit", "25");
		    		params.putString("until", until);
		    	    jsonResponse = Util.openUrl("https://graph.facebook.com/"+friendID+"/feed", "GET", params);
					   
		    	    objectJSONErrorCheck = new JSONObject(jsonResponse);
						 
				       if(!objectJSONErrorCheck.isNull("error"))
				        {
				    	   throw new  EasyFacebookError(jsonResponse);
				    	   
				        }
				       
		       	   }
		       	   else
		       	   {
		       		flagNext = 0;   
		       	   }
		       		   
		    	}
            }
           }
		}while(flagNext==1  && numArrayElement>0 && (countPost<limitPost || limitPost<0));
           
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}
    return feedList;
    }   
	
	

	
	public List<Home> getHome(int limitHome)   throws EasyFacebookError 
	{
		return getHomeCall(limitHome);
	}
	
	public List<Home> getAllHome()   throws EasyFacebookError 
	{
		return getHomeCall(-1);
	}
	
	
	private List<Home> getHomeCall(int limitHome)   throws EasyFacebookError 
    {
		int numArrayElement = 0;
		int flagNext = 0;
		String until = "";
		int countHome = 0;
		
    	Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());
		
		String jsonResponse;
		List<Home> homeList = new ArrayList<Home>();
		try {
			
			jsonResponse = Util.openUrl("https://graph.facebook.com/me/home", "GET", params);
		       
			 JSONObject objectJSONErrorCheck = new JSONObject(jsonResponse);
			 
		       if(!objectJSONErrorCheck.isNull("error"))
		        {
		    	   throw new  EasyFacebookError(jsonResponse);
		    	   
		        }
		
		do{
		
        JSONObject objectJSON = new JSONObject(jsonResponse);
       
		 String jsonData="";
		 if(!objectJSON.isNull("data"))
           {jsonData = objectJSON.getString("data").toString();
		         
           	JSONObjectDecode jsonArray = new JSONObjectDecode(jsonData);
		
           	numArrayElement =  jsonArray.length();
           	
           	for(int i = 0; i < jsonArray.length() && (countHome<limitHome || limitHome<0); i++)
           	{
           		homeList.add(jsonArray.getHome(i));
           		countHome++;
           	}
           	
           	String paging="";
		    if(!objectJSON.isNull("paging"))
		    { paging = objectJSON.getString("paging");
		      
		       JSONObject objectnextJSON = new JSONObject(paging);
		       String next="";
		       if(!objectnextJSON.isNull("next"))
		        {
		    	   next = objectnextJSON.getString("next").toString();
		       	   if(!until.equals(next.substring(next.lastIndexOf("until=")+6,next.length()).toString()) && (countHome<limitHome || limitHome<0))
		       	   {
		       		flagNext = 1;  
		       		until = next.substring(next.lastIndexOf("until=")+6,next.length());
		       		params = new Bundle(); 
		    		params.putString("format", "json");
		    		params.putString("access_token",facebook.getAccessToken());
		    		params.putString("limit", "25");
		    		params.putString("until", until);
		    	    jsonResponse = Util.openUrl("https://graph.facebook.com/me/home", "GET", params);
					   
		    	    objectJSONErrorCheck = new JSONObject(jsonResponse);
						 
				       if(!objectJSONErrorCheck.isNull("error"))
				        {
				    	   throw new  EasyFacebookError(jsonResponse);
				    	   
				        }
		       	   }
		       	   else
		       	   {
		       		flagNext = 0;   
		       	   }
		       		   
		    	}
            }
           }
		}while(flagNext==1 && numArrayElement>0 &&  (countHome<limitHome || limitHome<0));
           
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}
		
    return homeList;
    }   

	
	public Comment getComment(String commentId)   throws EasyFacebookError 
    {
		
		
    	Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());

		String jsonResponse;
		try {
			jsonResponse = Util.openUrl("https://graph.facebook.com/"+commentId, "GET", params);

			 JSONObject objectJSONErrorCheck = new JSONObject(jsonResponse);
			 
		       if(!objectJSONErrorCheck.isNull("error"))
		        {
		    	   throw new  EasyFacebookError(jsonResponse);
		    	   
		        }
		
		JSONSingleObjectDecode objectjson = new JSONSingleObjectDecode();
		return objectjson.getComment(jsonResponse);
		
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}
		 
	    
    }   
	
	public Events getEvent(String eventId)  throws EasyFacebookError 
    {
		
		
    	Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());
		
	 try {
			
		String jsonResponse = Util.openUrl("https://graph.facebook.com/"+eventId, "GET", params);
		
		JSONSingleObjectDecode objectjson = new JSONSingleObjectDecode();

		 JSONObject objectJSONErrorCheck = new JSONObject(jsonResponse);
		 
	       if(!objectJSONErrorCheck.isNull("error"))
	        {
	    	   throw new  EasyFacebookError(jsonResponse);
	    	   
	        }
	       
	    return objectjson.getEvent(jsonResponse);
	    
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}
    }   
	
	public List<Events> getEventsFriends(String friendID,int limitEvents)   throws EasyFacebookError 
	{
		return getEventsCall(friendID,limitEvents);
	}
	
	public List<Events> getAllEventsFriends(String friendID)   throws EasyFacebookError 
	{
		return getEventsCall(friendID,-1);
	}
	
	public List<Events> getEventsMy(int limitEvents)   throws EasyFacebookError 
	{
		return getEventsCall(null,limitEvents);
	}
	
	public List<Events> getAllEventsMy()   throws EasyFacebookError 
	{
		return getEventsCall(null,-1);
	}
	
	
	private List<Events> getEventsCall(String friendID,int limitEvents)  throws EasyFacebookError 
    {
		int numArrayElement = 0;
		int flagNext = 0;
		String until = "";
		int countEvents = 0;
		
    	Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());
		
		if(friendID==null)
			friendID="me";
		
		String jsonResponse;
		List<Events> eventsList = new ArrayList<Events>();
		
		try {
			jsonResponse = Util.openUrl("https://graph.facebook.com/"+friendID+"/events", "GET", params);

			 JSONObject objectJSONErrorCheck = new JSONObject(jsonResponse);
			 
		       if(!objectJSONErrorCheck.isNull("error"))
		        {
		    	   throw new  EasyFacebookError(jsonResponse);
		    	   
		        }

		do{
		
        JSONObject objectJSON = new JSONObject(jsonResponse);
       
		 String jsonData="";
		 if(!objectJSON.isNull("data"))
           {jsonData = objectJSON.getString("data").toString();
		         
           	JSONObjectDecode jsonArray = new JSONObjectDecode(jsonData);
           	
           	numArrayElement =  jsonArray.length();
		
           	for(int i = 0; i < jsonArray.length() && (countEvents<limitEvents || limitEvents<0); i++)
           	{
           		eventsList.add(jsonArray.getEvent(i));
           		countEvents++;
           	}
           	
           	String paging="";
		    if(!objectJSON.isNull("paging"))
		    { paging = objectJSON.getString("paging");
		      
		       JSONObject objectnextJSON = new JSONObject(paging);
		       String next="";
		       if(!objectnextJSON.isNull("next"))
		        {
		    	   next = objectnextJSON.getString("next").toString();
		       	   if(!until.equals(next.substring(next.lastIndexOf("until=")+6,next.length()).toString()) && (countEvents<limitEvents || limitEvents<0))
		       	   {
		       		flagNext = 1;  
		       		until = next.substring(next.lastIndexOf("until=")+6,next.length());
		       		params = new Bundle(); 
		    		params.putString("format", "json");
		    		params.putString("access_token",facebook.getAccessToken());
		    		params.putString("limit", "25");
		    		params.putString("until", until);
		    	    jsonResponse = Util.openUrl("https://graph.facebook.com/"+friendID+"/events", "GET", params);
					   
		    	    objectJSONErrorCheck = new JSONObject(jsonResponse);
						 
				       if(!objectJSONErrorCheck.isNull("error"))
				        {
				    	   throw new  EasyFacebookError(jsonResponse);
				    	   
				        }
		       	   }
		       	   else
		       	   {
		       		flagNext = 0;   
		       	   }
		       		   
		    	}
            }
           }
		}while(flagNext==1 && numArrayElement>0 &&  (countEvents<limitEvents || limitEvents<0));
           
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}
		
    return eventsList;
    }   
	
	

	public List<Person> getAllMaybeEvents(String eventId)   throws EasyFacebookError 
	{
		return getEventsResponseCall(eventId,-1,"maybe");
	}
	
	public List<Person> getMaybeEvents(String eventId,int limitEvents)   throws EasyFacebookError 
	{
		return getEventsResponseCall(eventId,limitEvents,"maybe");
	}
	
	public List<Person> getAllAttendingEvents(String eventId)   throws EasyFacebookError 
	{
		return getEventsResponseCall(eventId,-1,"attending");
	}
	
	public List<Person> getAttendingEvents(String eventId,int limitEvents)   throws EasyFacebookError 
	{
		return getEventsResponseCall(eventId,limitEvents,"attending");
	}
	
	public List<Person> getAllDeclineEvents(String eventId)   throws EasyFacebookError 
	{
		return getEventsResponseCall(eventId,-1,"declined");
	}
	
	public List<Person> getDeclineEvents(String eventId,int limitEvents)   throws EasyFacebookError 
	{
		return getEventsResponseCall(eventId,limitEvents,"declined");
	}
	
	
	private List<Person> getEventsResponseCall(String eventId,int limitEvents,String response)  throws EasyFacebookError 
    {
		int numArrayElement = 0;
		int flagNext = 0;
		String until = "";
		int countEvents = 0;
		
    	Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());
		
		String jsonResponse;
		List<Person> personList = new ArrayList<Person>();
		try {
	
			jsonResponse = Util.openUrl("https://graph.facebook.com/"+eventId+"/"+response, "GET", params);

			 JSONObject objectJSONErrorCheck = new JSONObject(jsonResponse);
			 
		       if(!objectJSONErrorCheck.isNull("error"))
		        {
		    	   throw new  EasyFacebookError(jsonResponse);
		    	   
		        }
	
		do{
		
        JSONObject objectJSON = new JSONObject(jsonResponse);
       
		 String jsonData="";
		 if(!objectJSON.isNull("data"))
           {jsonData = objectJSON.getString("data").toString();
		         
           	JSONObjectDecode jsonArray = new JSONObjectDecode(jsonData);
		
           	numArrayElement =  jsonArray.length();
		
           	for(int i = 0; i < jsonArray.length() && (countEvents<limitEvents || limitEvents<0); i++)
           	{
           		personList.add(jsonArray.getPerson(i));
           		countEvents++;
           	}
           	
           	String paging="";
		    if(!objectJSON.isNull("paging"))
		    { paging = objectJSON.getString("paging");
		      
		       JSONObject objectnextJSON = new JSONObject(paging);
		       String next="";
		       if(!objectnextJSON.isNull("next"))
		        {
		    	   next = objectnextJSON.getString("next").toString();
		       	   if(!until.equals(next.substring(next.lastIndexOf("until=")+6,next.length()).toString()) && (countEvents<limitEvents || limitEvents<0))
		       	   {
		       		flagNext = 1;  
		       		until = next.substring(next.lastIndexOf("until=")+6,next.length());
		       		params = new Bundle(); 
		    		params.putString("format", "json");
		    		params.putString("access_token",facebook.getAccessToken());
		    		params.putString("limit", "25");
		    		params.putString("until", until);
		    	    jsonResponse = Util.openUrl("https://graph.facebook.com/"+eventId+"/"+response, "GET", params);
					   
		    	    objectJSONErrorCheck = new JSONObject(jsonResponse);
						 
				       if(!objectJSONErrorCheck.isNull("error"))
				        {
				    	   throw new  EasyFacebookError(jsonResponse);
				    	   
				        }
		       	   }
		       	   else
		       	   {
		       		flagNext = 0;   
		       	   }
		       		   
		    	}
            }
           }
		}while(flagNext==1 && numArrayElement>0 &&  (countEvents<limitEvents || limitEvents<0));
           
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}
		
    return personList;
    }   
	
	
	public List<Person> getAllFriends()   throws EasyFacebookError 
	{
		return getFriendsCall(-1);
	}
	
	public List<Person> getFriends(int limitFriend)   throws EasyFacebookError 
	{
		return getFriendsCall(limitFriend);
	}
	
	
	private List<Person> getFriendsCall(int limitFriend)   throws EasyFacebookError 
    {
		int numArrayElement = 0;
		int flagNext = 0;
		String until = "";
		int countEvents = 0;
		
    	Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());
		
		String jsonResponse;
		List<Person> personList = new ArrayList<Person>();
		try {
			
			jsonResponse = Util.openUrl("https://graph.facebook.com/me/friends", "GET", params);
		
			 JSONObject objectJSONErrorCheck = new JSONObject(jsonResponse);
			 
		       if(!objectJSONErrorCheck.isNull("error"))
		        {
		    	   throw new  EasyFacebookError(jsonResponse);
		    	   
		        }
		
		
		do{
		
        JSONObject objectJSON = new JSONObject(jsonResponse);
       
		 String jsonData="";
		 if(!objectJSON.isNull("data"))
           {jsonData = objectJSON.getString("data").toString();
		         
           	JSONObjectDecode jsonArray = new JSONObjectDecode(jsonData);
		
           	numArrayElement =  jsonArray.length();
		
           	for(int i = 0; i < jsonArray.length() && (countEvents<limitFriend || limitFriend<0); i++)
           	{
           		personList.add(jsonArray.getPerson(i));
           		countEvents++;
           	}
           	
           	String paging="";
		    if(!objectJSON.isNull("paging"))
		    { paging = objectJSON.getString("paging");
		      
		       JSONObject objectnextJSON = new JSONObject(paging);
		       String next="";
		       if(!objectnextJSON.isNull("next"))
		        {
		    	   next = objectnextJSON.getString("next").toString();
		       	   if(!until.equals(next.substring(next.lastIndexOf("until=")+6,next.length()).toString()) && (countEvents<limitFriend || limitFriend<0))
		       	   {
		       		flagNext = 1;  
		       		until = next.substring(next.lastIndexOf("until=")+6,next.length());
		       		params = new Bundle(); 
		    		params.putString("format", "json");
		    		params.putString("access_token",facebook.getAccessToken());
		    		params.putString("limit", "25");
		    		params.putString("until", until);
		    	    jsonResponse = Util.openUrl("https://graph.facebook.com/me/friends", "GET", params);
					   
		    	    objectJSONErrorCheck = new JSONObject(jsonResponse);
						 
				       if(!objectJSONErrorCheck.isNull("error"))
				        {
				    	   throw new  EasyFacebookError(jsonResponse);
				    	   
				        }
		       	   }
		       	   else
		       	   {
		       		flagNext = 0;   
		       	   }
		       		   
		    	}
            }
           }
		}while(flagNext==1 && numArrayElement>0 &&  (countEvents<limitFriend || limitFriend<0));
           
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}
		 
    return personList;
    
    }
	
	
	
	public List<Group> getGroupsFriends(String friendID,int limitGroups)  throws EasyFacebookError 
	{
		return getGroupsCall(friendID,limitGroups);
	}
	
	public List<Group> getAllGroupsFriends(String friendID)   throws EasyFacebookError 
	{
		return getGroupsCall(friendID,-1);
	}
	
	public List<Group> getGroupsMy(int limitGroups)  throws EasyFacebookError 
	{
		return getGroupsCall(null,limitGroups);
	}
	
	public List<Group> getAllGroupsMy()  throws EasyFacebookError 
	{
		return getGroupsCall(null,-1);
	}
	
	
	private List<Group> getGroupsCall(String friendID,int limitGroups)   throws EasyFacebookError 
    {
		int numArrayElement = 0;
		int flagNext = 0;
		String until = "";
		int countGroups = 0;
		
    	Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());
		
		if(friendID==null)
			friendID="me";
		
		List<Group> groupsList = new ArrayList<Group>();
		try {
			
		String jsonResponse = Util.openUrl("https://graph.facebook.com/"+friendID+"/groups", "GET", params);
	
		 JSONObject objectJSONErrorCheck = new JSONObject(jsonResponse);
		 
	       if(!objectJSONErrorCheck.isNull("error"))
	        {
	    	   throw new  EasyFacebookError(jsonResponse);
	    	   
	        }
		
		do{
		
        JSONObject objectJSON = new JSONObject(jsonResponse);
       
		 String jsonData="";
		 if(!objectJSON.isNull("data"))
           {jsonData = objectJSON.getString("data").toString();
		         
           	JSONObjectDecode jsonArray = new JSONObjectDecode(jsonData);
		
           	numArrayElement =  jsonArray.length();
		
           	for(int i = 0; i < jsonArray.length() && (countGroups<limitGroups || limitGroups<0); i++)
           	{
           		groupsList.add(jsonArray.getGroup(i));
           		countGroups++;
           	}
           	
           	String paging="";
		    if(!objectJSON.isNull("paging"))
		    { paging = objectJSON.getString("paging");
		      
		       JSONObject objectnextJSON = new JSONObject(paging);
		       String next="";
		       if(!objectnextJSON.isNull("next"))
		        {
		    	   next = objectnextJSON.getString("next").toString();
		       	   if(!until.equals(next.substring(next.lastIndexOf("until=")+6,next.length()).toString()) && (countGroups<limitGroups || limitGroups<0))
		       	   {
		       		flagNext = 1;  
		       		until = next.substring(next.lastIndexOf("until=")+6,next.length());
		       		params = new Bundle(); 
		    		params.putString("format", "json");
		    		params.putString("access_token",facebook.getAccessToken());
		    		params.putString("limit", "25");
		    		params.putString("until", until);
		    	    jsonResponse = Util.openUrl("https://graph.facebook.com/"+friendID+"/groups", "GET", params);
					   
		    	    objectJSONErrorCheck = new JSONObject(jsonResponse);
						 
				       if(!objectJSONErrorCheck.isNull("error"))
				        {
				    	   throw new  EasyFacebookError(jsonResponse);
				    	   
				        }
		       	   }
		       	   else
		       	   {
		       		flagNext = 0;   
		       	   }
		       		   
		    	}
            }
           }
		}while(flagNext==1 && numArrayElement>0 &&  (countGroups<limitGroups || limitGroups<0));
           
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}
    return groupsList;
    }   
	
	public Group getGroup(String groupId)   throws EasyFacebookError 
    {
		
		
    	Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());

		String jsonResponse;
		try {
			jsonResponse = Util.openUrl("https://graph.facebook.com/"+groupId, "GET", params);
			
			JSONObject objectJSONErrorCheck = new JSONObject(jsonResponse);
			 
		       if(!objectJSONErrorCheck.isNull("error"))
		        {
		    	   throw new  EasyFacebookError(jsonResponse);
		    	   
		        }
		
		JSONSingleObjectDecode objectjson = new JSONSingleObjectDecode();

	    return objectjson.getGroup(jsonResponse);
	    
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}
    }   
	
	public Message getMessage(String messageID)   throws EasyFacebookError 
    {
		
    	Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());

		String jsonResponse;
		try {
			jsonResponse = Util.openUrl("https://graph.facebook.com/"+messageID, "GET", params);

		
		JSONSingleObjectDecode objectjson = new JSONSingleObjectDecode();

		 JSONObject objectJSONErrorCheck = new JSONObject(jsonResponse);
		 
	       if(!objectJSONErrorCheck.isNull("error"))
	        {
	    	   throw new  EasyFacebookError(jsonResponse);
	    	   
	        }
	       
	    return objectjson.getMessage(jsonResponse);
		
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}
    }   
	
	public List<Message> getInBoxMy(int limitInBox) throws EasyFacebookError 
	{
		return getInBoxCall(limitInBox);
	}
	
	public List<Message> getAllInBoxMy() throws EasyFacebookError 
	{
		return getInBoxCall(-1);
	}
	
	
	private List<Message> getInBoxCall(int limitInBox) throws EasyFacebookError 
    {
		int numArrayElement = 0;
		int flagNext = 0;
		String until = "";
		int countInBox = 0;
		
    	Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());
		
		
		String jsonResponse;
		List<Message> messageList = new ArrayList<Message>();
		
		try {
			jsonResponse = Util.openUrl("https://graph.facebook.com/me/inbox", "GET", params);

			 JSONObject objectJSONErrorCheck = new JSONObject(jsonResponse);
			 
		       if(!objectJSONErrorCheck.isNull("error"))
		        {
		    	   throw new  EasyFacebookError(jsonResponse);
		    	   
		        }
		
		
		do{
		
        JSONObject objectJSON = new JSONObject(jsonResponse);
       
		 String jsonData="";
		 if(!objectJSON.isNull("data"))
           {jsonData = objectJSON.getString("data").toString();
		         
           	JSONObjectDecode jsonArray = new JSONObjectDecode(jsonData);
		
           	numArrayElement =  jsonArray.length();
		
           	for(int i = 0; i < jsonArray.length() && (countInBox<limitInBox || limitInBox<0); i++)
           	{
           		messageList.add(jsonArray.getMessage(i));
           		countInBox++;
           	}
           	
           	String paging="";
		    if(!objectJSON.isNull("paging"))
		    { paging = objectJSON.getString("paging");
		      
		       JSONObject objectnextJSON = new JSONObject(paging);
		       String next="";
		       if(!objectnextJSON.isNull("next"))
		        {
		    	   next = objectnextJSON.getString("next").toString();
		       	   if(!until.equals(next.substring(next.lastIndexOf("until=")+6,next.length()).toString()) && (countInBox<limitInBox || limitInBox<0))
		       	   {
		       		flagNext = 1;  
		       		until = next.substring(next.lastIndexOf("until=")+6,next.length());
		       		params = new Bundle(); 
		    		params.putString("format", "json");
		    		params.putString("access_token",facebook.getAccessToken());
		    		params.putString("limit", "25");
		    		params.putString("until", until);
		    	    jsonResponse = Util.openUrl("https://graph.facebook.com/me/inbox", "GET", params);
					   
		    	    objectJSONErrorCheck = new JSONObject(jsonResponse);
						 
				       if(!objectJSONErrorCheck.isNull("error"))
				        {
				    	   throw new  EasyFacebookError(jsonResponse);
				    	   
				        }
		       	   }
		       	   else
		       	   {
		       		flagNext = 0;   
		       	   }
		       		   
		    	}
            }
           }
		}while(flagNext==1 && numArrayElement>0 &&  (countInBox<limitInBox || limitInBox<0));
           
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}
		 
    return messageList;
    }   
	
	
	public List<Note> getNote(int limitNote) throws EasyFacebookError 
	{
	 return getNoteCall(limitNote);
	}
	
	public List<Note> getAllNote() throws EasyFacebookError 
	{
	 return getNoteCall(-1);	
	}
	
	
	private List<Note> getNoteCall(int limitNote) throws EasyFacebookError 
    {
		int numArrayElement = 0;
		int flagNext = 0;
		String until = "";
		int countNote = 0;
		
    	Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());
		
		List<Note> noteList = new ArrayList<Note>();
		String jsonResponse;
		try {
			jsonResponse = Util.openUrl("https://graph.facebook.com/me/notes", "GET", params);
		
			JSONObject objectJSONErrorCheck = new JSONObject(jsonResponse);
			 
		       if(!objectJSONErrorCheck.isNull("error"))
		        {
		    	   throw new  EasyFacebookError(jsonResponse);
		    	   
		        }
	
		do{
		
        JSONObject objectJSON = new JSONObject(jsonResponse);
       
		 String jsonData="";
		 if(!objectJSON.isNull("data"))
           {jsonData = objectJSON.getString("data").toString();
		         
           	JSONObjectDecode jsonArray = new JSONObjectDecode(jsonData);
		
           	numArrayElement =  jsonArray.length();
		
           	for(int i = 0; i < jsonArray.length() && (countNote<limitNote || limitNote<0); i++)
           	{
           		noteList.add(jsonArray.getNote(i));
           		countNote++;
           	}
           	
           	String paging="";
		    if(!objectJSON.isNull("paging"))
		    { paging = objectJSON.getString("paging");
		      
		       JSONObject objectnextJSON = new JSONObject(paging);
		       String next="";
		       if(!objectnextJSON.isNull("next"))
		        {
		    	   next = objectnextJSON.getString("next").toString();
		       	   if(!until.equals(next.substring(next.lastIndexOf("until=")+6,next.length()).toString()) && (countNote<limitNote || limitNote<0))
		       	   {
		       		flagNext = 1;  
		       		until = next.substring(next.lastIndexOf("until=")+6,next.length());
		       		params = new Bundle(); 
		    		params.putString("format", "json");
		    		params.putString("access_token",facebook.getAccessToken());
		    		params.putString("limit", "25");
		    		params.putString("until", until);
		    	    jsonResponse = Util.openUrl("https://graph.facebook.com/me/notes", "GET", params);
					   
		    	    objectJSONErrorCheck = new JSONObject(jsonResponse);
						 
				       if(!objectJSONErrorCheck.isNull("error"))
				        {
				    	   throw new  EasyFacebookError(jsonResponse);
				    	   
				        }
		       	   }
		       	   else
		       	   {
		       		flagNext = 0;   
		       	   }
		       		   
		    	}
            }
           }
		}while(flagNext==1 && numArrayElement>0 &&  (countNote<limitNote || limitNote<0));
           
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}
		
    return noteList;
    }   
	
	public Page getPage(String pageId)throws EasyFacebookError 
    {
		
		
    	Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());

		String jsonResponse;
		try {
			jsonResponse = Util.openUrl("https://graph.facebook.com/"+pageId, "GET", params);
		
		JSONSingleObjectDecode objectjson = new JSONSingleObjectDecode();

		 JSONObject objectJSONErrorCheck = new JSONObject(jsonResponse);
		 
	       if(!objectJSONErrorCheck.isNull("error"))
	        {
	    	   throw new  EasyFacebookError(jsonResponse);
	    	   
	        }
	       
		return objectjson.getPage(jsonResponse);
		
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}
		
		
    }   
	
	
	public List<Photo> getPhotosFriends(String friendID,int limitPhotos) throws EasyFacebookError 
	{
		return getPhotosCall(friendID,limitPhotos);
	}
	
	public List<Photo> getAllPhotosFriends(String friendID) throws EasyFacebookError 
	{
		return getPhotosCall(friendID,-1);
	}
	
	public List<Photo> getPhotosMy(int limitPhotos) throws EasyFacebookError 
	{
		return getPhotosCall(null,limitPhotos);
	}
	
	public List<Photo> getAllPhotosMy() throws EasyFacebookError 
	{
		return getPhotosCall(null,-1);
	}
	
	
	private List<Photo> getPhotosCall(String friendID,int limitPhotos) throws EasyFacebookError 
    {
		int numArrayElement = 0;
		int flagNext = 0;
		String until = "";
		int countPhotos = 0;
		
    	Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());
		
		if(friendID==null)
			friendID="me";
		
		String jsonResponse;
		List<Photo> photosList = new ArrayList<Photo>();
		
		try {
			jsonResponse = Util.openUrl("https://graph.facebook.com/"+friendID+"/photos", "GET", params);
		
			 JSONObject objectJSONErrorCheck = new JSONObject(jsonResponse);
			 
		       if(!objectJSONErrorCheck.isNull("error"))
		        {
		    	   throw new  EasyFacebookError(jsonResponse);
		    	   
		        }
		       
		do{
		
        JSONObject objectJSON = new JSONObject(jsonResponse);
       
		 String jsonData="";
		 if(!objectJSON.isNull("data"))
           {jsonData = objectJSON.getString("data").toString();
		         
           	JSONObjectDecode jsonArray = new JSONObjectDecode(jsonData);
		
           	numArrayElement =  jsonArray.length();
		
           	for(int i = 0; i < jsonArray.length() && (countPhotos<limitPhotos || limitPhotos<0); i++)
           	{
           		photosList.add(jsonArray.getPhoto(i));
           		countPhotos++;
           	}
           	
           	String paging="";
		    if(!objectJSON.isNull("paging"))
		    { paging = objectJSON.getString("paging");
		      
		       JSONObject objectnextJSON = new JSONObject(paging);
		       String next="";
		       if(!objectnextJSON.isNull("next"))
		        {
		    	   next = objectnextJSON.getString("next").toString();
		       	   if(!until.equals(next.substring(next.lastIndexOf("until=")+6,next.length()).toString()) && (countPhotos<limitPhotos || limitPhotos<0))
		       	   {
		       		flagNext = 1;  
		       		until = next.substring(next.lastIndexOf("until=")+6,next.length());
		       		params = new Bundle(); 
		    		params.putString("format", "json");
		    		params.putString("access_token",facebook.getAccessToken());
		    		params.putString("limit", "25");
		    		params.putString("until", until);
		    	    jsonResponse = Util.openUrl("https://graph.facebook.com/"+friendID+"/photos", "GET", params);
					   
		    	    objectJSONErrorCheck = new JSONObject(jsonResponse);
						 
				       if(!objectJSONErrorCheck.isNull("error"))
				        {
				    	   throw new  EasyFacebookError(jsonResponse);
				    	   
				        }
		       	   }
		       	   else
		       	   {
		       		flagNext = 0;   
		       	   }
		       		   
		    	}
            }
           }
		}while(flagNext==1 && numArrayElement>0 &&  (countPhotos<limitPhotos || limitPhotos<0));
           
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}
    return photosList;
    }   
	
	
	public User getMyAccountInfo() throws EasyFacebookError 
	{
		return  getUserCall(null);
	}
	
	public User getUserInfo(String friendID) throws EasyFacebookError 
	{
		return getUserCall(friendID);
	}
	
	private User getUserCall(String friendID) throws EasyFacebookError 
	{
    	Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());
		
		if(friendID==null)
			friendID="me";

		String jsonResponse;
		try {
			jsonResponse = Util.openUrl("https://graph.facebook.com/"+friendID, "GET", params);
			
			 JSONObject objectJSONErrorCheck = new JSONObject(jsonResponse);
			 
		       if(!objectJSONErrorCheck.isNull("error"))
		        {
		    	   throw new  EasyFacebookError(jsonResponse);   
		        }
		       
			JSONSingleObjectDecode objectjson = new JSONSingleObjectDecode();
			return objectjson.getUser(jsonResponse);
			
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}
		
		

		 
    
	}
	
	
	public List<Checkin> searchLocation(String search,String longitude,String latitude,String distance,int limitCheckin)throws EasyFacebookError 
    {
		

		int countCheckin = 0;
    	Bundle params = new Bundle(); 

		List<Checkin> checkinList = new ArrayList<Checkin>();
			
		String jsonResponse;
		try {
			jsonResponse = Util.openUrl("https://graph.facebook.com/search?q="+search+"&type=place&center="+longitude+","+latitude+"&distance="+distance+"&access_token="+facebook.getAccessToken(), "GET", params);
		
			JSONObject objectJSONErrorCheck = new JSONObject(jsonResponse);
			 
		       if(!objectJSONErrorCheck.isNull("error"))
		        {
		    	   throw new  EasyFacebookError(jsonResponse);
		    	   
		        }
			
		 JSONObject objectJSON = new JSONObject(jsonResponse);
       
		 String jsonData="";
		 if(!objectJSON.isNull("data"))
           {jsonData = objectJSON.getString("data").toString();
		         
           	JSONObjectDecode jsonArray = new JSONObjectDecode(jsonData);
		
		
           	for(int i = 0; i < jsonArray.length() && (countCheckin<limitCheckin || limitCheckin<0); i++)
           	{
           		checkinList.add(jsonArray.getCheckin(i));
           		countCheckin++;
           	}
           } 	

	   	
		
		
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}
		
		return checkinList;
		
    }   

	
	
}