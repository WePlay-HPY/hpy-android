package hpy.pixstreet;

/**
 * Created by Joey on 12/01/2017.
 */

public class MapItem {
    private double longitude;
    private double latitude;
    private Integer score;


    private String name;

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public Integer getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public MapItem() {
        this.longitude = 0;
        this.latitude = 0;
        this.score = 0;
    }

    public MapItem(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.score = 0;
        this.name  = "";
    }


    public MapItem(double longitude, double latitude, String name, Integer score) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.score = score;
        this.name  = name;
    }

    public String getHighScore() {
        String user = "";
        if (name.equals("")) {
            user = "nobody";
        } else {
            user = name;
        }
        return score.toString() + " (" + user + ")";
    }
}
