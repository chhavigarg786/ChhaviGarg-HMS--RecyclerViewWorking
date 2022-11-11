package com.example.howsMyStylist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.howsMyStylist.RecyclerViewAdapter.HairStylistModel;
import com.example.howsMyStylist.RecyclerViewAdapter.HairStylistRecyclerViewInterface;
import com.example.howsMyStylist.RecyclerViewAdapter.PopularHairStylistAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.core.Tag;

import java.util.ArrayList;


public class HomePage extends AppCompatActivity implements PopularHairStylistAdapter.HairInterface {

    private static final String TAG = "MyActivity";
    ArrayList<HairStylistModel> hairStylistModels = new ArrayList<>();

    int[] popularHairStylistImages = {R.drawable.female_hairdresser1,R.drawable.female_hairdresser1,
            R.drawable.female_hairdresser1,R.drawable.female_hairdresser1,R.drawable.female_hairdresser1
    };

     BottomNavigationView bottomNavigationView;


     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


         RecyclerView recyclerView = findViewById(R.id.popularHairStylistRecyclerView);
         setUpHairStylistsName();

         PopularHairStylistAdapter adapter = new PopularHairStylistAdapter(this ,
                 hairStylistModels ,this);

         recyclerView.setAdapter(adapter);
         recyclerView.setHasFixedSize(true);

         recyclerView.setLayoutManager(new LinearLayoutManager(this ,
                 LinearLayoutManager.HORIZONTAL , false));




         bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {



                switch (item.getItemId())
                {
                    case R.id.userProfile:
                        startActivity(new Intent(getApplicationContext(), UserProfile.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.home:
                        return true;

                    case R.id.comments:
                        startActivity(new Intent(getApplicationContext(), HairStylist.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }


    private void setUpHairStylistsName() {

        String [] hairStylistsName = getResources().getStringArray(R.array.PopularhairStylistName);
        String [] hairStylistsRatings = getResources().getStringArray(R.array.PopularhairStylistRatings);
        for(int i = 0; i<hairStylistsName.length; i++)
        {
            hairStylistModels.add(new HairStylistModel(hairStylistsName[i] , hairStylistsRatings[i],
                    popularHairStylistImages[i] ));
        }
    }



    @Override
    public void onClickHair(int position1) {
        Log.d( TAG, "OnNoteClick :  Clicked" +position1);
                Intent intent = new Intent(HomePage.this, HairStylistProfile.class);
        Log.d( TAG, "OnNoteClick :  Clicked");

        intent.putExtra("NAME", hairStylistModels.get(position1).getHairStylistName());
        Log.d( TAG, "OnNoteClick :  Clicked");
        intent.putExtra("RATING", hairStylistModels.get(position1).getHairStylistRatings());
        intent.putExtra("IMAGE", hairStylistModels.get(position1).getImage());
        startActivity(intent);
        Log.d( TAG, "OnNoteClick :  Clicked");


    }
}
