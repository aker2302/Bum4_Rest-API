package com.bum4.bum4;

public class Competition {
    public int id;
    public Area area;

    public class Area {
        public int id;
        public String name;
    }
    public String name;
    public String code;
    public String emblemUrl;
    public String plan;

    public Season currentSeason;
    public class Season {
        public int id;
        public String startDate;
        public String endDate;
        public int currentMatchday;
        public Object winner;
    }
    public int numberOfAvailableSeasons;
    public String lastUpdated;

    @Override
    public String toString() {
        return "Competition{" +
                "id=" + id +
                ", area=" + area +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", emblemUrl='" + emblemUrl + '\'' +
                ", plan='" + plan + '\'' +
                ", currentSeason=" + currentSeason +
                ", numberOfAvailableSeasons=" + numberOfAvailableSeasons +
                ", lastUpdated='" + lastUpdated + '\'' +
                '}';
    }
}

