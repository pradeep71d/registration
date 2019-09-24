package com.example.registermon;

import com.google.gson.annotations.SerializedName;

public class RegisterPost {
    @SerializedName("user_fname")
    String user_fname;

    public RegisterPost(String user_fname, String user_email, String user_password, String user_gender, String user_dob, String user_mobile, String user_state, String user_country) {
        this.user_fname = user_fname;
        this.user_email = user_email;
        this.user_password = user_password;
        this.user_gender = user_gender;
        this.user_dob = user_dob;
        this.user_mobile = user_mobile;
        this.user_state = user_state;
        this.user_country = user_country;
    }

    @SerializedName("user_email")
    String user_email;

    @SerializedName("user_password")
    String user_password;

    @SerializedName("user_gender")
    String user_gender;

    @SerializedName("user_dob")
    String user_dob;

    @SerializedName("user_mobile")
    String user_mobile;

    @SerializedName("user_states")
    String user_state;

    @SerializedName("user_country")
    String user_country;


}

