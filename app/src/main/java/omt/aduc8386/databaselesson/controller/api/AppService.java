package omt.aduc8386.databaselesson.controller.api;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppService {

    private static ApiService apiService;
    private static final HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY);

    static OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://reqres.in/")
            .client(client)
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
