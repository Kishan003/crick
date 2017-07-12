package com.example.kishan.crick;

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

    public class Matches{
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
    }

    @Override
    public String toString() {
        return "Data{" +
                "matches=" + matches +
                '}';
    }
}


