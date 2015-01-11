package com.athlete.sports;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;
import com.parse.ui.ParseLoginBuilder;

/**
* Created by PSD on 1/10/15.
*/
public class IntroPage extends Activity {

    private Button bball, logout;
    private TextView name;
    private ParseUser currentUser;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_intro);

        logout = (Button) findViewById(R.id.logout_button);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentUser != null) {
                    ParseUser.logOut();
                    currentUser = null;
                } else {
                    //initializes login interface
                    ParseLoginBuilder loginBuilder = new ParseLoginBuilder(IntroPage.this);
                    loginBuilder
                            .setParseLoginEnabled(true)
                            .setParseSignupButtonText("Register")
                            .setParseLoginHelpText("Forgot password?")
                            .setParseLoginInvalidCredentialsToastText("You email and/or password is not correct");
                    startActivityForResult(loginBuilder.build(), 0);
                }
            }
        });

        bball = (Button) findViewById(R.id.bball);
        bball.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(IntroPage.this, BasketballView.class);
                startActivity(i);
            }
        });
        name = (TextView) findViewById(R.id.name);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Set up the profile page based on the current user.
        ParseUser user = ParseUser.getCurrentUser();
        showName(user);
    }

    private void showName(ParseUser user) {
        if (user != null) {
            String fullName = user.getString("name");
            if (fullName != null) {
                name.setText(fullName);
            }
        }
    }
}
