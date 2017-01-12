package hpy.pixstreet.models;

import java.util.Collections;
import java.util.List;

/**
 * Created by Joey on 12/01/2017.
 */

public class MyNode{
    private double longitude;
    private double latitude;
    private Long id;
    private List<Score> scores = null;
    private static Long _id = 1l;

    public MyNode(double longitude, double latitude) {
        this.id = _id + 1;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public Long getId() {
        return id;
    }

    public int getScore() {
        return Collections.max(scores).getScore();
    }
}
