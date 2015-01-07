package com.athlete.sports;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.parse.ui.ParseLoginBuilder;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Parse.initialize(this, getString(R.string.parse_app_id), getString(R.string.parse_client_key));

        //test user
        ParseUser user = new ParseUser();
        user.setUsername("psd");
        user.setPassword("1234567");
        user.setEmail("email@example.com");
        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    // Hooray! Let them use the app now.
                } else {
                    // Sign up didn't succeed. Look at the ParseException
                    // to figure out what went wrong
                }
            }
        });
        //initializes login interface
        ParseLoginBuilder loginBuilder = new ParseLoginBuilder(MainActivity.this);
        startActivityForResult(loginBuilder.build(), 0);

    }
}
