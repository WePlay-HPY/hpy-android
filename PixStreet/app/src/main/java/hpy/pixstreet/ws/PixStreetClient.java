package hpy.pixstreet.ws;

import java.io.IOException;
import java.util.List;

import hpy.pixstreet.models.Node;
import hpy.pixstreet.models.NodeResults;
import retrofit2.Call;

/**
 * Created by benjamindebotte on 12/01/2017.
 */

public class PixStreetClient {

    public PixStreetClient() {}

    public List<Node> getAllNodes() throws IOException {
        Call<NodeResults> call = RequestClient.get().getNodes();
        NodeResults nodesResult = call.execute().body();
        return nodesResult.nodes;
    }

    public List<Node> getAllNodesFromCenter(double lon, double lat, int rangeInMeters) throws IOException {
        Call<NodeResults> call = RequestClient.get().getNodesByCenter(lon, lat, rangeInMeters);
        NodeResults nodesResult = call.execute().body();
        return nodesResult.nodes;
    }

    public Node getNode(int id) throws IOException {
        Call<Node> call = RequestClient.get().getNodesById(id);
        Node node = call.execute().body();
        return node;
    }


}
