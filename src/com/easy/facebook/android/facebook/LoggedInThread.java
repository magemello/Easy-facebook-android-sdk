package com.easy.facebook.android.facebook;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;

public class LoggedInThread implements Runnable {

	private FBLoginManager fbManager;
	private LoginListener callback;
	private Activity activity;
	private ProgressDialog dialog;
	private boolean validSession;
	private Facebook facebook;

	public LoggedInThread(FBLoginManager fbManager, int returnWindow,
			LoginListener callback, Activity activity) {
		this.fbManager = fbManager;
		this.callback = callback;
		this.activity = activity;
	}

	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {

			if (dialog != null && dialog.isShowing())
				dialog.cancel();

			if (validSession) {
				((LoginListener) callback).loginSuccess(facebook);
			} else {
				fbManager.login();
			}

		}
	};

	public void LoggedIn() {
		dialog = new ProgressDialog(activity);
		dialog.setCancelable(true);
		dialog.setMessage("Connect to Facebook...");
		dialog.show();

		Thread thread = new Thread(this);
		thread.start();
	}

	public void run() {

		SharedPreferences preferences = activity.getSharedPreferences(
				fbManager.getAppID(), 0);
		String accessToken = preferences.getString("accessToken", "");
		facebook = new Facebook(fbManager, fbManager.getAppID(), accessToken);

		if (facebook.sessionIsValid()) {

			validSession = true;

			handler.sendEmptyMessage(0);

		} else {
			validSession = false;

			handler.sendEmptyMessage(0);

		}

	}

}
