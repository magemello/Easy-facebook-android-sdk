#Easy Facebook Android sdk
This library is not anymore supported from 2014. The web site http://www.easyfacebookandroidsdk.com/ will be dismissed soon.

The only information required to use the Easy facebook Android SDK are: 

1.Application ID
2.Permission (example : user_relationship_details,manage_friendlists,publish_stream,offline_access...)


#Builds
All the latest build are under the builds folder

#Demo Application
All the demo apps are under the demo folder

#How to integrate
1.Download easyfacebookandroidsdk library from build folder. 
2.Import the library into your android project. 
3.Copy class below in to your android application to use easyfacebookandroidsdk functionality: 

```
public class FacebookConnect extends Activity   implements LoginListener {

        private FBLoginManager fbManager;
        
        @Override
        public void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                shareFacebook();
        }

        
        public void shareFacebook() {
        
        //change the permissions according to the function you want to use 
                String permissions[] = { "read_stream", "user_relationship_details",
                                "user_religion_politics", "user_work_history",
                                "user_relationships", "user_interests", "user_likes",
                                "user_location", "user_hometown", "user_education_history",
                                "user_activities", "offline_access" };

                //change the parameters with those of your application
                fbManager = new FBLoginManager(this, R.layout.black,
                                "FacebookApplicationID", permissions);

                if (fbManager.existsSavedFacebook()) {
                        fbManager.loadFacebook();
                } else {

                        fbManager.login();
                }
        }
        
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                fbManager.loginSuccess(data);
        }

        public void loginFail() {
                fbManager.displayToast("Login failed!");

        }

        public void logoutSuccess() {
                fbManager.displayToast("Logout success!");
        }

        public void loginSuccess(Facebook facebook) {
                
                //library use example
                GraphApi graphApi = new GraphApi(facebook);

                User user = new User();
                try {
                        user = graphApi.getMyAccountInfo();
                } catch (EasyFacebookError e) {
                        e.toString();
                }

                
                

        }
}
```
When you call this class , in shareFacebook method the user can login and accept permissions, then if the login will be successful, in onLoginSuccess method you can use function of GraphApi,RestApi and FQL calss to interact with facebook.


#Permissions
Each facebook functionality needs some permissions, you must insert in this vector permits necessary for the functionality you want to use ,you can find list of all permits here: http://developers.facebook.com/docs/authentication/permissions/ 

#FacebookApplicationID
You can find the ID of your application on this page from http://www.facebook.com/developers/apps.php

#Key Hash
Before you begin use easy facebook android sdk , you will need to set key hash in the Mobile & Devices section of the Developer App for your app . At this link you can read a little guide for set up correctly this parameter : http://developers.facebook.com/docs/guides/mobile/#android

keytool -exportcert -alias androiddebugkey -keystore ~/.android/debug.keystore | openssl sha1 -binary | openssl base64 

 

If you have problems to get the debug key hash with keytool command , you can download the keyhash project from demo folder. Run it in eclipse to get yout key hash.
