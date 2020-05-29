package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUp extends AppCompatActivity {
    private TextView getBoxer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        getBoxer = findViewById(R.id.getTextView);
        // Save the current Installation to Back4App
        ParseInstallation.getCurrentInstallation().saveInBackground();

        getBoxer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseQuery<ParseObject> query = ParseQuery.getQuery("Boxer");
                query.getInBackground("KleiLhaTou", new GetCallback<ParseObject>() {
                    public void done(ParseObject object, ParseException e) {
                        if (e == null) {
                            // object will be your game score
                            getBoxer.setText(object.get("punch_speed").toString());
                        } else {
                            // something went wrong
                            FancyToast.makeText(SignUp.this,"Something went wrong",FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                        }
                    }
                });
            }
        });

    }
    public void helloWordTapped(View v)
    {
        ParseObject boxer = new ParseObject("Boxer");
        boxer.put("punch_speed",200);
        boxer.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if(e==null)
                {
                    FancyToast.makeText(SignUp.this,"Boxer object saved",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
//                    Toast.makeText(SignUp.this, "Boxer object saved", Toast.LENGTH_SHORT).show();
                }
                else{
                    FancyToast.makeText(SignUp.this,"Something went wrong",FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                }
            }
        });
    }
}
