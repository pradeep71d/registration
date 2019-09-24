package com.example.registermon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    EditText name, gender, dob, mob, state, country;

    Button signup;
    public static final String Success = "200";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        name = findViewById(R.id.firstname);
        gender = findViewById(R.id.user_gender);
        dob = findViewById(R.id.user_dob);
        mob = findViewById(R.id.user_mob);
        state = findViewById(R.id.user_state);
        country = findViewById(R.id.user_country);

        signup = findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                String Name = name.getText().toString();
                String Country = country.getText().toString();
                String State = state.getText().toString();
                String Mob = mob.getText().toString();
                String Dob = dob.getText().toString();
                String Gender = gender.getText().toString();
                RegisterPost registerPost = new RegisterPost(Name, Email, Password, Gender, Dob, Mob, State, Country);
                Call<RegisterPojo> pojoCall = BaseUrl.getClient().create(ApiInetrface.class).registerUser(registerPost);
                if (name.getText().toString().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "please enter name", Toast.LENGTH_SHORT).show();
                } else if (email.getText().toString().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "please entre email", Toast.LENGTH_SHORT).show();
                } else if (!isEmailValid()) {
                    Toast.makeText(RegisterActivity.this, "enter valid email id", Toast.LENGTH_SHORT).show();
                } else if (password.getText().toString().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "please entre password", Toast.LENGTH_SHORT).show();
                } else if (gender.getText().toString().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "please entre gender", Toast.LENGTH_SHORT).show();
                } else if (dob.getText().toString().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "please entre dob", Toast.LENGTH_SHORT).show();
                } else if (mob.getText().toString().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "please entre mobile number", Toast.LENGTH_SHORT).show();
                } else if (state.getText().toString().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "please entre state", Toast.LENGTH_SHORT).show();
                } else if (country.getText().toString().isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "please entre country", Toast.LENGTH_SHORT).show();
                } else {
                    pojoCall.enqueue(new Callback<RegisterPojo>() {
                        @Override
                        public void onResponse(Call<RegisterPojo> call, Response<RegisterPojo> response) {
                            if (response.body() == null) {
                                Toast.makeText(RegisterActivity.this, response.raw().message(), Toast.LENGTH_SHORT).show();
                            } else {
                                String code = response.body().getCode();
                                if (code.equals(String.valueOf(200))) {
                                    Toast.makeText(RegisterActivity.this, "Successfully connected" + response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                    email.setText("");
                                    password.setText("");
                                    name.setText("");
                                    country.setText("");
                                    state.setText("");
                                    mob.setText("");
                                    dob.setText("");
                                    gender.setText("");

                                } else {
                                    Toast.makeText(RegisterActivity.this, "" + response.body().getMessage(), Toast.LENGTH_SHORT).show();

                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<RegisterPojo> call, Throwable t) {
                            Toast.makeText(RegisterActivity.this, "Register failed", Toast.LENGTH_SHORT).show();
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
