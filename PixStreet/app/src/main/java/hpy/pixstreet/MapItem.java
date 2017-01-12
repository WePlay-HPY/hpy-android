package hpy.pixstreet;

/**
 * Created by Joey on 12/01/2017.
 */

public class MapItem {
    private double longitude;
    private double latitude;
    private int score;

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public int getScore() {
        return score;
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
    }

    public MapItem(double longitude, double latitude, int score) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.score = score;
    }
}
