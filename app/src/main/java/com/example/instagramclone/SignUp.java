package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.parse.ParseInstallation;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        // Save the current Installation to Back4App
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
