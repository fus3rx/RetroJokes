package com.imaginers.tonmo.retrojokes.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.imaginers.tonmo.retrojokes.Interface.ApiInterface;
import com.imaginers.tonmo.retrojokes.Model.ServerResponse;
import com.imaginers.tonmo.retrojokes.Model.User;
import com.imaginers.tonmo.retrojokes.R;
import com.imaginers.tonmo.retrojokes.Retrofit.RetrofitApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ApiInterface apiInterface;
    private static final String TAG = MainActivity.class.getSimpleName();
    private EditText userIdEditText;
    private EditText passwordEditText;
    private EditText jokeUserIdEditText;
    private TextView jokeTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiInterface = RetrofitApiClient.getClient().create(ApiInterface.class);

        //Initialize the view like EditText, TextView
        viewInitialization();


    }

    private void viewInitialization() {
        userIdEditText = (EditText) findViewById(R.id.login_id);
        passwordEditText = (EditText) findViewById(R.id.login_password);
        jokeUserIdEditText = (EditText) findViewById(R.id.user_id_for_joke);
        jokeTextView = (TextView) findViewById(R.id.jokeTextView);
    }


    private void checkUserValidity(User userCredential){

        Call<ServerResponse> call = apiInterface.getUserValidity(userCredential);

        call.enqueue(new Callback<ServerResponse>() {

            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {

                ServerResponse validity = response.body();
                Toast.makeText(getApplicationContext(), validity.getMessage(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    private void getJokeFromServer(String userId) {

        Call<ServerResponse> call = apiInterface.getJoke(userId);

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                ServerResponse validity = response.body();
                jokeTextView.setText(validity.getMessage());
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }

    public void buttonClickEvent(View view){

        if(view.getId()==R.id.login_button){
            String userId;
            String password;
            User user = new User();

            userId = userIdEditText.getText().toString();
            password = passwordEditText.getText().toString();

            user.setUserId(userId);
            user.setPassword(password);

            checkUserValidity(user);
        }
        else {
            String userId;

            userId = jokeUserIdEditText.getText().toString();

            getJokeFromServer(userId);
        }

    }
}
