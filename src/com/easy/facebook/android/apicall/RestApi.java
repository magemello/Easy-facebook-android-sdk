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
import org.json.JSONArray;
import org.json.JSONException;
import com.easy.facebook.android.data.Album;
import com.easy.facebook.android.data.JSONObjectDecode;
import com.easy.facebook.android.data.Status;
import com.easy.facebook.android.error.EasyFacebookError;
import com.easy.facebook.android.facebook.Facebook;
import com.easy.facebook.android.util.Util;
import android.os.Bundle;



public class RestApi {

	private Facebook facebook;
	
    public RestApi(Facebook facebook)
    {
        this.facebook = facebook;
       
    }
    
    public String postToFriend(String message,String friendID,String urlPicture) throws EasyFacebookError  {
    	return postToFriendCall(message,friendID,urlPicture);
    }
    
    public String postToFriend(String message,String friendID) throws EasyFacebookError  {
    	return postToFriendCall(message,friendID,null);
    }
    
	private String postToFriendCall(String message,String friendID,String urlPicture) throws EasyFacebookError  {

		Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("method", "stream.publish"); 
		params.putString("access_token",facebook.getAccessToken());
		params.putString("message", message);
		params.putString("target_id", friendID);
		
		if (urlPicture!=null)
		{
		String pictureName  =  urlPicture.substring(urlPicture.lastIndexOf('/'),urlPicture.length());
		params.putString("attachment", "{\"media\": [{\"type\": \"image\",\"src\": \""+pictureName+"\", \"href\": \""+urlPicture+"\"}]}");
		}
		
		
		String jsonResponse ="";
        try {
        	
        	 jsonResponse = Util.openUrl("https://api.facebook.com/restserver.php", "POST", params);
        		
			
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		}
		
		return jsonResponse.replace("\"", "");
			
	}
	
	
	
	public String setStatus(String message,String urlPicture) throws EasyFacebookError  {
		return setStatusCall(message,urlPicture);
	}
	
	public String setStatus(String message) throws EasyFacebookError  {
		return setStatusCall(message,null);
	}
	
	private String setStatusCall(String message,String urlPicture) throws EasyFacebookError  {

		Bundle params = new Bundle(); 
		params.putString("format", "json");
		params.putString("method", "status.set"); 
		params.putString("access_token",facebook.getAccessToken());

		params.putString("status", message);
		
		if(urlPicture!=null)
		params.putString("picture", urlPicture);
			
		String jsonResponse = "";
		
        try {
        	
        	 jsonResponse = Util.openUrl("https://api.facebook.com/restserver.php", "POST", params);
			
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		}
		
		return jsonResponse;
			
	}
	
	
	
	
	
	
	public String inviteEvent(String eventID,String userID,String message) throws EasyFacebookError  {
		return inviteEventCall(eventID,userID,message);
	}
	
    private String inviteEventCall(String eventID,String userID,String message)  throws EasyFacebookError  {
        

		Bundle params = new Bundle(); 
		params.putString("method", "events.invite"); 
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());

		
		params.putString("eid", eventID);
		params.putString("uids", userID);
		
		params.putString("personal_message", message);

		String jsonResponse ="";
        try {
			
        	 jsonResponse = Util.openUrl("https://api.facebook.com/restserver.php", "POST", params);
            	
		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} 
		
		return jsonResponse;

    }
	
    
    public List<String> getFriendUIDs() throws EasyFacebookError  {
    	
    Bundle params = new Bundle();
    params.putString("format", "json");
    params.putString("method", "friends.get");
	params.putString("access_token",facebook.getAccessToken());

	
	String jsonResponse;
	List<String> stringList = new ArrayList<String>();
	
	try {
		jsonResponse = Util.openUrl("https://api.facebook.com/restserver.php", "POST", params);


    JSONArray jsonArray = new JSONArray(jsonResponse);
        
    for(int i = 0; i < jsonArray.length(); i++)
        stringList.add(jsonArray.get(i).toString().replaceAll("\"", ""));

	} catch (MalformedURLException e) {			
		
		throw new EasyFacebookError(e.toString(),"MalformedURLException");
	} catch (IOException e) {
		
		throw new EasyFacebookError(e.toString(),"IOException");
	} catch (JSONException e) {
		
		throw new EasyFacebookError(e.toString(),"JSONException");
	}


    return stringList;
    }   
	
    
    
    
    
    
    public List<Status> getStatus(int limit) throws EasyFacebookError  {
    	
    	return getStatusCall(new Integer(limit));
    }
    
    public List<Status> getAllStatus()  throws EasyFacebookError  {
    	
    	return getStatusCall(null);
    }
    
    public Status getCurrentStatus() throws EasyFacebookError  {
    	
    return getStatusCall(new Integer(1)).get(0);
    }
    
    private List<Status> getStatusCall(Integer limit)  throws EasyFacebookError  {
    	
    Bundle params = new Bundle();
    params.putString("format", "json");
    params.putString("method", "status.get");
	params.putString("access_token",facebook.getAccessToken());

    if(limit!=null)
    params.putString("limit", limit.toString());
	
    String jsonResponse;
    List<Status> statusList = new ArrayList<Status>();
    
	try {
		jsonResponse = Util.openUrl("https://api.facebook.com/restserver.php", "POST", params);

	
    

        JSONObjectDecode jsonArray = new JSONObjectDecode(jsonResponse);
        for(int i = 0; i < jsonArray.length(); i++)
            statusList.add(jsonArray.getStatus(i));

	} catch (MalformedURLException e) {			
		
		throw new EasyFacebookError(e.toString(),"MalformedURLException");
	} catch (IOException e) {
		
		throw new EasyFacebookError(e.toString(),"IOException");
	} catch (JSONException e) {
		
		throw new EasyFacebookError(e.toString(),"JSONException");
	}
	
    return statusList;
    }  
	
    
    
    public List<Album> getAlbumsFriends(String friendID)  throws EasyFacebookError  {
    	
		return getAlbumsCall(friendID);
	}
	
	public List<Album> getAlbumsMy()  throws EasyFacebookError  {
		
		return getAlbumsCall(null);
	}
	
	
	private  List<Album> getAlbumsCall(String friendID) throws EasyFacebookError  {
		
    	Bundle params = new Bundle(); 
		params.putString("format", "json");
	    params.putString("method", "photos.getAlbums");
		params.putString("access_token",facebook.getAccessToken());

		
		String jsonResponse;
		List<Album> albumList = new ArrayList<Album>();
		try {
			jsonResponse = Util.openUrl("https://api.facebook.com/restserver.php", "POST", params);
	
	
		

		JSONObjectDecode jsonArray = new JSONObjectDecode(jsonResponse);
		for(int i = 0; i < jsonArray.length(); i++)
		    albumList.add(jsonArray.getAlbum(i));

		} catch (MalformedURLException e) {			
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}

    return albumList;
    }   
	
	
}
