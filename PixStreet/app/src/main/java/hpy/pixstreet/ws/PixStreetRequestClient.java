package hpy.pixstreet.ws;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;

import java.util.List;


/**
 * Created by Joan on 16/11/2015.
 */
public class PixStreetRequestClient {
    private static PixStreetService REST_CLIENT;
    private static final String API_URL = "https://pixstreet-backend.herokuapp.com/"; //Change according to your API path.

    static {
        setupRestClient();
    }

    private PixStreetRequestClient() {}

    public static PixStreetService get() {
        return REST_CLIENT;
    }

    private static void setupRestClient() {

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        //Uncomment these lines below to start logging each request.


        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();


        REST_CLIENT = retrofit.create(PixStreetService.class);
    }

}

