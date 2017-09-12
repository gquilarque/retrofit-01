package uxmaro.gabrielaquilarque.retrofit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "RETROFIT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText name = (EditText) findViewById(R.id.input_name);
        final EditText email = (EditText) findViewById(R.id.input_email);
        final EditText age = (EditText) findViewById(R.id.input_age);
        final EditText topics = (EditText) findViewById(R.id.input_topics);

        Button createAccountButton = (Button) findViewById(R.id.btn_signup);

        createAccountButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                User user = new User(
                        name.getText().toString(),
                        email.getText().toString(),
                        Integer.parseInt(age.getText().toString()),
                        topics.getText().toString().split(","));
                sendNetworkRequest(user);
            }
        });

    }

    public void sendNetworkRequest(User user){
        //Create Retrofit Instance

        Log.v(TAG, "USER Name=" + user.getName());

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:3000/api/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        //get client and call object for the request
        UserClient client = retrofit.create(UserClient.class);
        Call<User> call = client.createAccount(user);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(MainActivity.this,"Yeah! User-ID:" + response.body().getId(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Toast.makeText(MainActivity.this,"something went wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
