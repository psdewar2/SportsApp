package com.athlete.sports;

import android.app.Application;
import com.parse.Parse;


public class MainActivity extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(this, getString(R.string.parse_app_id), getString(R.string.parse_client_key));
    }
}
