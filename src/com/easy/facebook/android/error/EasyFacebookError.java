package com.easy.facebook.android.error;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;



public class EasyFacebookError extends Exception {


	private static final long serialVersionUID = -2307281367453577933L;
	String errorMessage;
	String errorType;
	
	
	public EasyFacebookError(String errorMessage,String errorType) {
		super(errorMessage);
		this.errorMessage = errorMessage;
		this.errorType = errorType;
		Log.e("EasyFacebookAndroid", this.errorMessage);
	}

	
    public EasyFacebookError(String message) {
        super(message);
        
        try { 
        JSONObject objectJSON = new JSONObject(message);

		String jsonMessage="";
		
		 if(!objectJSON.isNull("error"))
		 {
			 	jsonMessage = objectJSON.getString("error");
			 	JSONObject messageJSON = new JSONObject(jsonMessage);
			 	
			 	if(!messageJSON.isNull("type"))
			 		this.errorType = messageJSON.get("type").toString();
			 	
			 	if(!messageJSON.isNull("message"))
			 		this.errorMessage = messageJSON.get("message").toString();
			 	
				Log.e("EasyFacebookAndroid", this.errorMessage);

		 	}
		 
	        
        } catch (JSONException e) {
        	Log.e("EasyFacebookAndroid", "EasyFacebookError JSONException");
		}
      
    }

    public String toString()
    {
    	 return errorMessage;    
    }

}
