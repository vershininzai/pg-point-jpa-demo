package com.example.pgpointjpademo.custom_type;

import java.io.Serializable;

public class Point implements Serializable {
    private final float lon;
    private final float lat;

    public Point(float lon, float lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public float getLat() {
        return lat;
    }

    @Override
    public String toString() {
        return "Point{" +
                "lon=" + lon +
                ", lat=" + lat +
                '}';
    }
}
