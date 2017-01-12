package hpy.pixstreet.ws;

import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hpy.pixstreet.models.Node;
import hpy.pixstreet.models.NodeResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by benjamindebotte on 12/01/2017.
 */

public class PixStreetClient {

    public PixStreetClient() {}

    public void getAllNodes() throws IOException {
        Call<NodeResults> call = PixStreetLocationRequestClient.get().getNodes();

        call.enqueue(new Callback<NodeResults>() {
            @Override
            public void onFailure(Call<NodeResults> call, Throwable t) {
                Log.d("PixStreet", "Error Occured: " + t.getMessage());
            }

            @Override
            public void onResponse(Call<NodeResults> call, Response<NodeResults> response) {
                Log.d("PixStreet", "Successfully response fetched" );


                List<Node> nodes=response.body().nodes;

                if(nodes.size() > 0) {
                    Log.d("PixStreet", "ITEM FETCHED o//");
                }else{
                    Log.d("PixStreet", "No item found");
                }
            }
        });

    }

    public void getAllNodesFromCenter(double lon, double lat, int rangeInMeters) throws IOException {
        Map<String, String> options = new HashMap<>();
        options.put("lon", String.valueOf(lon));
        options.put("lat", String.valueOf(lat));
        options.put("distance", String.valueOf(rangeInMeters));

        Call<NodeResults> call = PixStreetLocationRequestClient.get().getNodesByCenter(options);
        call.enqueue(new Callback<NodeResults>() {
            @Override
            public void onFailure(Call<NodeResults> call, Throwable t) {
                Log.d("PixStreet", "Error Occured: " + t.getMessage());
            }

            @Override
            public void onResponse(Call<NodeResults> call, Response<NodeResults> response) {
                Log.d("PixStreet", "Successfully response fetched" );


                List<Node> nodes=response.body().nodes;

                if(nodes.size() > 0) {
                    Log.d("PixStreet", "ITEM FETCHED o//");
                }else{
                    Log.d("PixStreet", "No item found");
                }
            }
        });
    }

    public void getNode(Long id) throws IOException {

        Call<NodeResults> call = PixStreetLocationRequestClient.get().getNodeById(id);

        call.enqueue(new Callback<NodeResults>() {
            @Override
            public void onFailure(Call<NodeResults> call, Throwable t) {
                Log.d("PixStreet", "Error Occured: " + t.getMessage());
            }

            @Override
            public void onResponse(Call<NodeResults> call, Response<NodeResults> response) {
                Log.d("PixStreet", "Successfully response fetched" );



                List<Node> nodes=response.body().nodes;

                if(nodes != null) {
                    Log.d("PixStreet", "ITEM FETCHED o//");
                    // Item is nodes[0
                }else{
                    Log.d("PixStreet", "No item found");
                }
            }
        });
    }


}
