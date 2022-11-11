package com.example.howsMyStylist.RecyclerViewAdapter;

import java.util.ArrayList;

public class HairStylistModel {

    String hairStylistName;
    String hairStylistRatings;
    int image;


    public HairStylistModel(String hairStylistName, String hairStylistRatings, int image) {
        this.hairStylistName = hairStylistName;
        this.hairStylistRatings = hairStylistRatings;
        this.image = image;
    }

    public String getHairStylistName() {
        return hairStylistName;
    }

    public void setHairStylistName(String hairStylistName) {
        this.hairStylistName = hairStylistName;
    }

    public String getHairStylistRatings() {
        return hairStylistRatings;
    }

    public void setHairStylistRatings(String hairStylistRatings) {
        this.hairStylistRatings = hairStylistRatings;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
