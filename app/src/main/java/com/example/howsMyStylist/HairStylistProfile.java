package com.example.howsMyStylist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class HairStylistProfile extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hair_stylist_profile);
//        getSupportActionBar().hide();

        Log.d( TAG, "OnNoteClick :  NOTClicked");
        TextView nameTextView = findViewById(R.id.hairStylistName3);
        Log.d( TAG, "OnNoteClick :  NOTClicked");
        TextView ratingTextView = findViewById(R.id.hairStylistRating);
        Log.d( TAG, "OnNoteClick :  NOTClicked");
        ImageView hairStylistImage = findViewById(R.id.hairStylistImageView);


        Log.d( TAG, "OnNoteClick :  NOTClicked");
        String name = getIntent().getStringExtra("NAME");
        Log.d( TAG, "OnNoteClick :  NOTClicked" + name);
        String ratings = getIntent().getStringExtra("RATING");
        int image = getIntent().getExtras().getInt("IMAGE");


        Log.d( TAG, "OnNoteClick :  NOTClicked");
        nameTextView.setText(name);
        ratingTextView.setText(ratings);
        hairStylistImage.setImageResource(image);



    }
}