package com.example.drivescores.data;

public class DriverScore {
    private String date;
    private int score;
    private String tripDuration;
    private String distance;

    public DriverScore(String date, int score, String tripDuration, String distance) {
        this.date = date;
        this.score = score;
        this.tripDuration = tripDuration;
        this.distance = distance;
    }

    public String getDate() {
        return date;
    }

    public int getScore() {
        return score;
    }

    public String getTripDuration() {
        return tripDuration;
    }

    public String getDistance() {
        return distance;
    }
}
