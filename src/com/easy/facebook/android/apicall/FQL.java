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
import com.easy.facebook.android.data.Friend;
import com.easy.facebook.android.data.JSONObjectDecode;
import com.easy.facebook.android.error.EasyFacebookError;
import com.easy.facebook.android.facebook.Facebook;
import com.easy.facebook.android.util.Util;

import android.os.Bundle;

public class FQL {

	private Facebook facebook;

	public FQL(Facebook facebook) {
		this.facebook = facebook;

	}

	public List<Friend> getFriends(String uids[]) throws EasyFacebookError {

		String whereClause = "";
		List<Friend> friendList = new ArrayList<Friend>();

		for (int i = 0; i < uids.length - 1; i++)
			whereClause = (new StringBuilder(String.valueOf(whereClause)))
					.append("uid = ").append(uids[i]).append(" OR ").toString();

		whereClause = (new StringBuilder(String.valueOf(whereClause)))
				.append("uid = ").append(uids[uids.length - 1]).toString();

		Bundle params = new Bundle();
		params.putString("format", "json");
		params.putString("access_token", facebook.getAccessToken());
		params.putString("method", "fql.query");
		String fqlQuery = (new StringBuilder(
				"SELECT uid, name, pic, profile_update_time, timezone, birthday_date, status, online_presence, locale, profile_url, website, is_blocked FROM user WHERE "))
				.append(whereClause).toString();
		params.putString("query", fqlQuery);

		String jsonResponse;
		try {
			jsonResponse = Util.openUrl(
					"https://api.facebook.com/restserver.php", "POST", params);

			JSONObjectDecode jsonArray = new JSONObjectDecode(jsonResponse);
			for (int i = 0; i < jsonArray.length(); i++)
				friendList.add(jsonArray.getFriend(i));

		} catch (MalformedURLException e) {

			throw new EasyFacebookError(e.toString(), "MalformedURLException");
		} catch (IOException e) {

			throw new EasyFacebookError(e.toString(), "IOException");
		} catch (JSONException e) {

			throw new EasyFacebookError(e.toString(), "JSONException");
		}

		return friendList;

	}

	public Friend getFriend(String uid) throws EasyFacebookError {
		Bundle params = new Bundle();
		params.putString("format", "json");
		params.putString("method", "fql.query");
		params.putString("access_token", facebook.getAccessToken());

		String fqlQuery = (new StringBuilder(
				"SELECT uid, name, pic, profile_update_time, timezone, birthday_date, status, online_presence, locale, profile_url, website, is_blocked FROM user WHERE uid="))
				.append(uid).toString();
		params.putString("query", fqlQuery);

		String jsonResponse;
		try {
			jsonResponse = Util.openUrl(
					"https://api.facebook.com/restserver.php", "POST", params);

			JSONObjectDecode jsonArray = new JSONObjectDecode(jsonResponse);
			return jsonArray.getFriend(0);

		} catch (MalformedURLException e) {

			throw new EasyFacebookError(e.toString(), "MalformedURLException");
		} catch (IOException e) {

			throw new EasyFacebookError(e.toString(), "IOException");
		} catch (JSONException e) {

			throw new EasyFacebookError(e.toString(), "JSONException");
		}

	}

	public String fqlQuery(String fqlQuery) throws EasyFacebookError {

		Bundle params = new Bundle();
		params.putString("method", "fql.query");
		params.putString("access_token", facebook.getAccessToken());

		params.putString("query", fqlQuery);

		try {
			return Util.openUrl("https://api.facebook.com/restserver.php",
					"POST", params);

		} catch (MalformedURLException e) {

			throw new EasyFacebookError(e.toString(), "MalformedURLException");
		} catch (IOException e) {

			throw new EasyFacebookError(e.toString(), "IOException");
		}
	}

}
