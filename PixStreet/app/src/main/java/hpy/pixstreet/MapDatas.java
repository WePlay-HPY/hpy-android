package hpy.pixstreet;

import android.util.Log;
import android.util.Pair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import hpy.pixstreet.models.MyNode;
import hpy.pixstreet.models.Node;
import hpy.pixstreet.models.NodeResults;
import hpy.pixstreet.models.Score;
import hpy.pixstreet.ws.PixStreetClient;
import hpy.pixstreet.ws.PixStreetRequestClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Joey on 12/01/2017.
 */
public class MapDatas {
    private static MapDatas ourInstance = new MapDatas();
    private List<MapItem> _datas = new ArrayList<>();
    private HashMap<String,Integer> scoreTable;

    public static MapDatas getInstance() {
        return ourInstance;
    }


    private MapDatas() {
        Call<List<Node>> call = PixStreetRequestClient.get().getNodes();
        call.enqueue(new Callback<List<Node>>() {
            @Override
            public void onFailure(Call<List<Node>> call, Throwable t) {
                Log.d("PixStreet", "Error Occured: " + t.getMessage());
            }

            @Override
            public void onResponse(Call<List<Node>> call, Response<List<Node>> response) {
                Log.d("PixStreet", "Successfully response fetched" );

                List<Node> nodes=response.body();
                if(nodes.size() > 0) {
                    Log.d("PixStreet", "ITEM FETCHED o//");

                    for(Iterator<Node> i = nodes.iterator(); i.hasNext(); ) {
                        Node node = i.next();
                        List<Double> loc = node.getLoc();
                        double longitude = loc.get(0);
                        double latitude  = loc.get(1);
                        _datas.add(new MapItem(longitude, latitude));
                    }

                }else{
                    Log.d("PixStreet", "No item found");
                }
            }
        });
    }



    // à supprimer
    private MapDatas(int k){
        List<MyNode> nodes = null;
        nodes.add(new MyNode( -0.35,49.183));
        nodes.add(new MyNode( -0.349,49.182));
        nodes.add(new MyNode( -0.364,49.185));
        nodes.add(new MyNode( -0.352,49.179));

        for(Iterator<MyNode> i = nodes.iterator(); i.hasNext(); ) {
            MyNode node = i.next();
            double longitude = node.getLongitude();
            double latitude = node.getLatitude();
            _datas.add(new MapItem(node.getId(),longitude, latitude));
            scoreTable.put(node.getId().toString(),node.getScore());
        }
    }
    // suppr

    public List<MapItem> getDatasMap(){return _datas;}

    public Integer getScore(String id){
        return scoreTable.get(id);
    }
}
