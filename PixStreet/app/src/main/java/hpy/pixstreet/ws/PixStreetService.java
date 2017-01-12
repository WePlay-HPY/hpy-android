package hpy.pixstreet.ws;

import java.util.List;

import hpy.pixstreet.models.Node;
import hpy.pixstreet.models.NodeResults;
import retrofit2.http.*;
import retrofit2.*;

/**
 * Created by benjamindebotte on 12/01/2017.
 */

public interface PixStreetService {
    @GET("api/location/")
    Call<NodeResults> getNodes();

    @GET("api/location/{lon}&{lat}&{distance}")
    Call<NodeResults> getNodesByCenter(@Path("lon") double lon, @Path("lat") double lat, @Path("distance") int distance);

    @GET("api/location/{id}")
    Call<Node> getNodesById(@Path("id") int id);
}
