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
import com.easy.facebook.android.util.Util;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

public class Facebook {

	private FBLoginManager fbManager;
	private String expireTime;
	private String accessToken;

	protected Facebook(FBLoginManager fbManager, String expireTime,
			String accessToken) {
		this.fbManager = fbManager;
		this.expireTime = expireTime;
		this.accessToken = accessToken;
	}

	public String getExpireTime() {
		return expireTime;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void save() {
		SharedPreferences preferences = fbManager.getActivity()
				.getSharedPreferences(fbManager.getAppID(), 0);
		android.content.SharedPreferences.Editor editor = preferences.edit();
		editor.putString("accessToken", accessToken);
		editor.putString("expireTime", expireTime);
		editor.commit();
	}

	public boolean sessionIsValid() {

		Bundle params = new Bundle();
		params.putString("format", "json");
		params.putString("access_token", getAccessToken());

		String jsonResponse;
		try {
			jsonResponse = Util.openUrl("https://graph.facebook.com/me/feed",
					"GET", params);

			JSONObject objectJSON = new JSONObject(jsonResponse);

			if (!objectJSON.isNull("error")) {
				Log.e("EasyFacebookAndroid",
						"Invalid EasyFacebookAndroid session");
				return false;
			}

			if (!objectJSON.isNull("data")) {
				return true;
			} else {
				Log.e("EasyFacebookAndroid",
						"Invalid EasyFacebookAndroid session");
				return false;
			}

		} catch (MalformedURLException e) {
			Log.e("EasyFacebookAndroid", e.toString());
			return false;
		} catch (IOException e) {
			Log.e("EasyFacebookAndroid", e.toString());
			return false;
		} catch (JSONException e) {
			Log.e("EasyFacebookAndroid", e.toString());
			return false;
		}

	}

}
