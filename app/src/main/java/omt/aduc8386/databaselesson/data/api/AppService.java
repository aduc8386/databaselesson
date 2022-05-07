package omt.aduc8386.databaselesson.data.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppService {

    private static ApiService apiService;

    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static ApiService init() {
        if (apiService != null) {
            return apiService;
        }
        apiService = retrofit.create(ApiService.class);
        return apiService;
    }
}
