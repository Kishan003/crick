package com.example.kishan.crick;

import java.util.ArrayList;

/**
 * Created by kishan on 14/07/17.
 */

public class SquadData {
    private ArrayList<Players> squad;


    public ArrayList<Players> getPlayerslist() {
        return squad;
    }

    public void setPlayerslist(ArrayList<Players> playerslist) {
        this.squad = playerslist;
    }

    public class Players{
        private String name;
        private ArrayList<Player> players;
    }


    public class Player {

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPid() {
            return pid;
        }

        public void setPid(int pid) {
            this.pid = pid;
        }

        private String name;
        private int pid;

    }



    }

