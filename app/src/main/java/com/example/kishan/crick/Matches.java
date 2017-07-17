package com.example.kishan.crick;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by kishan on 17/07/17.
 */

public class Matches implements Parcelable {
    protected Matches(Parcel in) {
        unique_id = in.readLong();
        date = in.readString();
        team1 = in.readString();
        team2 = in.readString();
        matchStarted = in.readByte() != 0;
        squad = in.readByte() != 0;
    }

    public static final Creator<Matches> CREATOR = new Creator<Matches>() {
        @Override
        public Matches createFromParcel(Parcel in) {
            return new Matches(in);
        }

        @Override
        public Matches[] newArray(int size) {
            return new Matches[size];
        }
    };

    public long getUnique_id() {
        return unique_id;
    }

    public void setUnique_id(long unique_id) {
        this.unique_id = unique_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public boolean isMatchStarted() {
        return matchStarted;
    }

    public void setMatchStarted(boolean matchStarted) {
        this.matchStarted = matchStarted;
    }

    public boolean isSquad() {
        return squad;
    }

    public void setSquad(boolean squad) {
        this.squad = squad;
    }

    public long unique_id;
    public String date;
    @SerializedName("team-1")
    String team1;
    @SerializedName("team-2")
    String team2;
    public boolean matchStarted;
    public boolean squad;

    @Override
    public String toString() {
        return "Matches{" +
                "unique_id=" + unique_id +
                ", date=" + date +
                ", team1='" + team1 + '\'' +
                ", team2='" + team2 + '\'' +
                ", matchStarted=" + matchStarted +
                ", squad=" + squad +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(unique_id);
        dest.writeString(date);
        dest.writeString(team1);
        dest.writeString(team2);
        dest.writeByte((byte) (matchStarted ? 1 : 0));
        dest.writeByte((byte) (squad ? 1 : 0));
    }
}

