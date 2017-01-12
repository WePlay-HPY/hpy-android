package hpy.pixstreet.ws;

import android.util.Log;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hpy.pixstreet.models.Node;
import hpy.pixstreet.models.NodeResults;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by benjamindebotte on 12/01/2017.
 */

public class PixStreetClient {

    public PixStreetClient() {}

    public void getAllNodes() throws IOException {
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

        Call<NodeResults> call = PixStreetRequestClient.get().getNodesByCenter(options);
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

        Call<Node> call = PixStreetRequestClient.get().getNodeById(id);

        call.enqueue(new Callback<Node>() {
            @Override
            public void onFailure(Call<Node> call, Throwable t) {
                Log.d("PixStreet", "Error Occured: " + t.getMessage());
            }

            @Override
            public void onResponse(Call<Node> call, Response<Node> response) {
                Log.d("PixStreet", "Successfully response fetched");


                Node nodes = response.body();

                if (nodes != null) {
                    Log.d("PixStreet", "ITEM FETCHED o//");
                    // Item is nodes[0
                } else {
                    Log.d("PixStreet", "No item found");
                }
            }
        });
    }

    public void postScore(int score, String name, Long node_id) {
        Call<ResponseBody> call = PixStreetRequestClient.get().postScore(
                score,
                name,
                node_id);

        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    Log.d("PixStreet", "Response : " + response.body().string());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("PixStreet", "Error Occured: " + t.getMessage());
            }
        });

    }



}
