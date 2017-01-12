package hpy.pixstreet.ws;

import java.util.List;
import java.util.Map;

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


    // Will need to contain lon, lat & distance
    @GET("api/location/")
    Call<NodeResults> getNodesByCenter(@QueryMap Map<String, String> options);

    @GET("api/location/{id}")
    Call<NodeResults> getNodeById(@Path("id") Long id);
    // Forced to use array even if one is returned.
}
