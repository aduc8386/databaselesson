package omt.aduc8386.databaselesson.data.api;

import com.google.gson.JsonObject;

import omt.aduc8386.databaselesson.model.UserResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("api/users")
    Call<UserResponse> getUsers();
}
