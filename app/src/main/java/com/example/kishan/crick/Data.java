package com.example.kishan.crick;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by kishan on 11/07/17.
 */

public class Data {



public List<Matches> matches;


    public List<Matches> getMatches() {
        return matches;
    }

    public void setMatches(List<Matches> matches) {
        this.matches = matches;
    }



    @Override
    public String toString() {
        return "Data{" +
                "matches=" + matches +
                '}';
    }
}


