package hpy.pixstreet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Joey on 12/01/2017.
 */
public class MapDatas {
    private static MapDatas ourInstance = new MapDatas();
    private List<MapItem> _datas = new ArrayList<>();

    public static MapDatas getInstance() {
        return ourInstance;
    }

    // à supprimer
    private class Node{
        private double longitude;
        private double latitude;

        public Node(double longitude, double latitude) {
            this.longitude = longitude;
            this.latitude = latitude;
        }

        public double getLongitude(){return longitude;};
        public double getLatitude(){return latitude;};


    }
    // supp

    private MapDatas() {
        List<Node> nodes = new ArrayList<>();
        // à supprimer
        nodes.add(new Node( -0.35,49.183));
        nodes.add(new Node( -0.349,49.182));
        nodes.add(new Node( -0.364,49.185));
        nodes.add(new Node( -0.352,49.179));
        // supp

        for(Iterator<Node> i = nodes.iterator(); i.hasNext(); ) {
            Node node = i.next();
            _datas.add(new MapItem(node.getLongitude(), node.getLatitude()));
        }
    }

    private MapDatas(List<Node> nodes){

        // à supprimer
        nodes.add(new Node( -0.35,49.183));
        nodes.add(new Node( -0.349,49.182));
        nodes.add(new Node( -0.364,49.185));
        nodes.add(new Node( -0.352,49.179));
        // supp

        for(Iterator<Node> i = nodes.iterator(); i.hasNext(); ) {
            Node node = i.next();
            _datas.add(new MapItem(node.getLongitude(), node.getLatitude()));
        }
    }

    public List<MapItem> getDatasMap(){return _datas;}
}
