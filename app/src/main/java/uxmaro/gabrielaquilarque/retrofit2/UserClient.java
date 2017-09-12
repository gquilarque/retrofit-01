package uxmaro.gabrielaquilarque.retrofit2;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by gabrielaquilarque on 9/10/17.
 */

public interface UserClient {

    @POST("user")
    Call<User> createAccount(@Body User user);
}
