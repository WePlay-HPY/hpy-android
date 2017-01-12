package hpy.pixstreet;

import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.osmdroid.api.IMapController;
import org.osmdroid.google.wrapper.MyLocationOverlay;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.config.Configuration;
import org.osmdroid.views.overlay.ItemizedIconOverlay;
import org.osmdroid.views.overlay.ItemizedOverlay;
import org.osmdroid.views.overlay.OverlayItem;
import org.osmdroid.views.overlay.compass.CompassOverlay;
import org.osmdroid.views.overlay.compass.InternalCompassOrientationProvider;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.io.IOException;
import java.util.ArrayList;

import hpy.pixstreet.ws.PixStreetClient;

public class OpenStreetMap extends AppCompatActivity {

    private MapView map;
    private MyLocationNewOverlay mLocationOverlay;
    private CompassOverlay mCompassOverlay;
    private ItemizedOverlay mMyLocationOverlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_street_map);

        map = (MapView) findViewById(R.id.mapview);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);
        IMapController mapController = map.getController();
        mapController.setZoom(16);
        GeoPoint startPoint = new GeoPoint(49.1833, -0.35);
        mapController.setCenter(startPoint);

        mLocationOverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(this.getApplicationContext()),map);
        mLocationOverlay.enableMyLocation();
        map.getOverlays().add(mLocationOverlay);

        putPoints(new GeoPoint(49.1833, -0.35));


        // Code pour intégration
        testRESTAPI();

    }

    private void testRESTAPI() {
        // Code pour intégration

        PixStreetClient client = new PixStreetClient();
        try {
            client.getAllNodes();
            client.getAllNodesFromCenter(-0.3446069, 49.1675276, 1000);
            client.getNode(3655298618L);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onResume(){
        super.onResume();
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().save(this, prefs);
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
    }


    public void putPoints(GeoPoint geo){
        geo = new GeoPoint(49.1833, -0.35);
        ArrayList<OverlayItem> items = new ArrayList<OverlayItem>();
        items.add(new OverlayItem("Here", "SampleDescription", geo));

        mMyLocationOverlay = new ItemizedIconOverlay<OverlayItem>(items,
                new ItemizedIconOverlay.OnItemGestureListener<OverlayItem>() {
                    @Override
                    public boolean onItemSingleTapUp(final int index,
                                                     final OverlayItem item) {
                        Toast.makeText(
                                OpenStreetMap.this,
                                "Launch Game", Toast.LENGTH_LONG).show();
                        return true;
                    }
                    @Override
                    public boolean onItemLongPress(final int index,
                                                   final OverlayItem item) {
                        Toast.makeText(
                                OpenStreetMap.this,
                                "Long", Toast.LENGTH_LONG).show();
                        return false;
                    }
                }, this.getApplicationContext());
        map.getOverlays().add(this.mMyLocationOverlay);
        map.invalidate();
    }
}
