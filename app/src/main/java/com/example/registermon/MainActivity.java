package com.example.registermon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    Button login, reg;
    public static final String Success = "200";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        reg = findViewById(R.id.register);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MainActivity.this, RegisterActivity.class));
            }
        });

        ///for login pressed
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String Email = email.getText().toString();
                String Password = password.getText().toString();

                LoginPost loginPost = new LoginPost(Email, Password);//here we are passing data to initialise constroctor of LoginPost();
                Call<LoginPojo> pojoCall = BaseUrl.getClient().create(ApiInetrface.class).loginUser(loginPost);
                //here we are implementing api to save data in database
                if (email.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "enter email", Toast.LENGTH_SHORT).show();
                } else if (!isEmailValid()) {
                    Toast.makeText(MainActivity.this, "enter valid email", Toast.LENGTH_SHORT).show();

                } else if (password.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "please enter password", Toast.LENGTH_SHORT).show();
                } else {
                    pojoCall.enqueue(new Callback<LoginPojo>() {
                        @Override
                        public void onResponse(Call<LoginPojo> call, Response<LoginPojo> response) {
                            if (response.body() == null) {
                                Toast.makeText(MainActivity.this, response.raw().message(), Toast.LENGTH_SHORT).show();
                            } else {
                                String code = response.body().getCode();
                                if (code.equals(String.valueOf(200))) {
                                    Toast.makeText(MainActivity.this, "Successfully connected" + response.body().getMessage(), Toast.LENGTH_SHORT).show();

                                } else {
                                    Toast.makeText(MainActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();

                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<LoginPojo> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_SHORT).show();

                        }

                    });


                }

            }

            private boolean isEmailValid() {
                return android.util.Patterns.EMAIL_ADDRESS.matcher(
                        email.getText().toString()).matches();
            }
        });

    }
}
