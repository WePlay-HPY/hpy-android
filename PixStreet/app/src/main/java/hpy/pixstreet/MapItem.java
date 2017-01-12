package hpy.pixstreet;

/**
 * Created by Joey on 12/01/2017.
 */

public class MapItem {
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    private Long id;
    private double longitude;
    private double latitude;
    private String score;

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getScore() {
        return score;
    }

    public MapItem() {
        this.longitude = 0;
        this.latitude = 0;
        this.score = "0";
    }

    public MapItem(double longitude, double latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.score = "0";
    }

    public MapItem(Long id, double longitude, double latitude) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public MapItem(double longitude, double latitude, String score) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.score = score;
    }
}
