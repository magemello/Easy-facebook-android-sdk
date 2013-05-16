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
package com.easy.facebook.android.facebook;

import java.io.IOException;
import java.net.MalformedURLException;
import org.json.JSONException;
import org.json.JSONObject;


import com.easy.facebook.android.error.EasyFacebookError;
import com.easy.facebook.android.util.Util;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.Toast;

public class FBLoginManager {
	private Activity activity;
	private String appID;
	private String permissions[];
	private int returnWindow;
	private static final int DEFAULT_AUTH_ACTIVITY_CODE = 32665;

	public FBLoginManager(Activity activity,int returnWindow,String appID, String permissions[]) {
		this.activity = activity;
		this.appID = appID;
		this.permissions = permissions;
		this.returnWindow = returnWindow;
	}

	public String[] getPermissions() {
		return permissions;
	}

	public void setPermissions(String[] permission) {
		this.permissions = permission;
	}



	public void login() {
		Intent intent = new Intent();
		intent.setClassName("com.facebook.katana",
				"com.facebook.katana.ProxyAuth");
        
        if (!validateAppSignatureForIntent(activity, intent)) {
            try {
				startDialogAuth(activity, permissions);
			} catch (EasyFacebookError e) {
	             ((LoginListener) activity).loginFail();

			}
        }
        else{
	        if (permissions.length > 0) {
	        	intent.putExtra("client_id", appID);
	            intent.putExtra("scope", TextUtils.join(",", permissions));
		        try {
		        	activity.startActivityForResult(intent, DEFAULT_AUTH_ACTIVITY_CODE);
		        } catch (ActivityNotFoundException e) {
		             ((LoginListener) activity).loginFail();
		      }
	        }
        }
	}
	
	public void loginSuccess(Intent data){
		
    	String expireTime = data.getStringExtra("expires_in");
    	String accessToken = data.getStringExtra("access_token");
        Facebook facebook = new Facebook(this,expireTime,accessToken);
        facebook.save();
        
        ((LoginListener) activity).loginSuccess(facebook);
	}

	protected Activity getActivity() {
		return activity;
	}
	

	public String getAppID() {
		return appID;
	}


	public void displayToast(String message) {
		Toast t = Toast.makeText(activity, message, 0);
		t.show();
	}

	public void loadFacebook() {
		
		LoggedInThread loggedInThread = new LoggedInThread(this,returnWindow,((LoginListener) activity),activity);
		loggedInThread.LoggedIn();

	}

	public boolean existsSavedFacebook() {
		SharedPreferences preferences = activity.getSharedPreferences(appID,
				0);
		return !preferences.getString("accessToken", "").equals("");
	}

	public void logout(Facebook facebook) throws EasyFacebookError  {
		SharedPreferences preferences = this.getActivity()
				.getSharedPreferences(appID, 0);
		android.content.SharedPreferences.Editor editor = preferences.edit();
		editor.putString("accessToken", "");
		editor.putString("uid", "");
		editor.clear();
		editor.commit();

        CookieSyncManager.createInstance(activity);
        CookieManager cookieManager = CookieManager.getInstance();
        cookieManager.removeAllCookie();
        
		Bundle params = new Bundle();
		params.putString("format", "json");
		params.putString("access_token",facebook.getAccessToken());
		params.putString("method", "auth.expireSession");
		String jsonResponse ="";


	        	
		  try {
				jsonResponse = Util.openUrl("https://api.facebook.com/restserver.php", "GET", params);
			
			if(!jsonResponse.equals("true"))
			{ 
				
			JSONObject objectJSONErrorCheck = new JSONObject(jsonResponse);
			
			  if(!objectJSONErrorCheck.isNull("error_msg"))
		        {
		    	   throw new  EasyFacebookError(jsonResponse);
		    	   
		        }
			 }
		}  catch (MalformedURLException e) {
			
			throw new EasyFacebookError(e.toString(),"MalformedURLException");
		} catch (IOException e) {
			
			throw new EasyFacebookError(e.toString(),"IOException");
		} catch (JSONException e) {
			
			throw new EasyFacebookError(e.toString(),"JSONException");
		}
	
		((LoginListener) activity).logoutSuccess();

	}
	
    private boolean validateAppSignatureForIntent(Activity activity,
            Intent intent) {

        ResolveInfo resolveInfo =
            activity.getPackageManager().resolveActivity(intent, 0);
        if (resolveInfo == null) {
            return false;
        }

        String packageName = resolveInfo.activityInfo.packageName;
        PackageInfo packageInfo;
        try {
            packageInfo = activity.getPackageManager().getPackageInfo(
                    packageName, PackageManager.GET_SIGNATURES);
        } catch (NameNotFoundException e) {
            return false;
        }

        for (Signature signature : packageInfo.signatures) {
            if (signature.toCharsString().equals(FB_APP_SIGNATURE)) {
                return true;
            }
        }
        return false;
    }
    
	private void startDialogAuth(Activity activityDialog, String[] permissions) throws EasyFacebookError {
        Bundle params = new Bundle();
        if (permissions.length > 0) {
            params.putString("scope", TextUtils.join(",", permissions));
        }
        CookieSyncManager.createInstance(activityDialog);
        dialog(activityDialog, "oauth", params, new LoginListener() {

            public void loginSuccess(Facebook facebook) {

            	CookieSyncManager.getInstance().sync();
                           
                ((LoginListener) activity).loginSuccess(facebook);

            }


			public void logoutSuccess() {
		        ((LoginListener) activity).logoutSuccess();

			}

			public void loginFail() {
		        ((LoginListener) activity).loginFail();

			}
        });
    }
	
    public void dialog(Context context, String action, Bundle parameters,
            final LoginListener listener) {

        String endpoint = "https://m.facebook.com/dialog/" + action;
        parameters.putString("display", "touch");
        parameters.putString("redirect_uri", "fbconnect://success");

        if (action.equals("oauth")) {
            parameters.putString("type", "user_agent");
            parameters.putString("client_id", appID);
        } else {
            parameters.putString("app_id", appID);
        }
        
        
        String url = endpoint + "?" + Util.encodeUrl(parameters);

        new FBLoginWithOutApi(context, url, listener,this).show();
        
    }

    public static final String FB_APP_SIGNATURE =
        "30820268308201d102044a9c4610300d06092a864886f70d0101040500307a310"
        + "b3009060355040613025553310b30090603550408130243413112301006035504"
        + "07130950616c6f20416c746f31183016060355040a130f46616365626f6f6b204"
        + "d6f62696c653111300f060355040b130846616365626f6f6b311d301b06035504"
        + "03131446616365626f6f6b20436f72706f726174696f6e3020170d30393038333"
        + "13231353231365a180f32303530303932353231353231365a307a310b30090603"
        + "55040613025553310b30090603550408130243413112301006035504071309506"
        + "16c6f20416c746f31183016060355040a130f46616365626f6f6b204d6f62696c"
        + "653111300f060355040b130846616365626f6f6b311d301b06035504031314466"
        + "16365626f6f6b20436f72706f726174696f6e30819f300d06092a864886f70d01"
        + "0101050003818d0030818902818100c207d51df8eb8c97d93ba0c8c1002c928fa"
        + "b00dc1b42fca5e66e99cc3023ed2d214d822bc59e8e35ddcf5f44c7ae8ade50d7"
        + "e0c434f500e6c131f4a2834f987fc46406115de2018ebbb0d5a3c261bd97581cc"
        + "fef76afc7135a6d59e8855ecd7eacc8f8737e794c60a761c536b72b11fac8e603"
        + "f5da1a2d54aa103b8a13c0dbc10203010001300d06092a864886f70d010104050"
        + "0038181005ee9be8bcbb250648d3b741290a82a1c9dc2e76a0af2f2228f1d9f9c"
        + "4007529c446a70175c5a900d5141812866db46be6559e2141616483998211f4a6"
        + "73149fb2232a10d247663b26a9031e15f84bc1c74d141ff98a02d76f85b2c8ab2"
        + "571b6469b232d8e768a7f7ca04f7abe4a775615916c07940656b58717457b42bd"
        + "928a2";


}
