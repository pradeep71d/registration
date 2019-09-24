package com.example.registermon;

public class Response {

        private String user_dob;

        private String user_states;

        private String user_email;

        private String user_password;

        private String user_country;

        private String updated_at;

        private String user_fname;

        private String user_id;

        private String api_token;

        private String user_phone;

        private String created_at;

        private String user_gender;

        public String getUser_dob ()
        {
            return user_dob;
        }

        public void setUser_dob (String user_dob)
        {
            this.user_dob = user_dob;
        }

        public String getUser_states ()
        {
            return user_states;
        }

        public void setUser_states (String user_states)
        {
            this.user_states = user_states;
        }

        public String getUser_email ()
        {
            return user_email;
        }

        public void setUser_email (String user_email)
        {
            this.user_email = user_email;
        }

        public String getUser_password ()
        {
            return user_password;
        }

        public void setUser_password (String user_password)
        {
            this.user_password = user_password;
        }

        public String getUser_country ()
        {
            return user_country;
        }

        public void setUser_country (String user_country)
        {
            this.user_country = user_country;
        }

        public String getUpdated_at ()
        {
            return updated_at;
        }

        public void setUpdated_at (String updated_at)
        {
            this.updated_at = updated_at;
        }

        public String getUser_fname ()
        {
            return user_fname;
        }

        public void setUser_fname (String user_fname)
        {
            this.user_fname = user_fname;
        }

        public String getUser_id ()
        {
            return user_id;
        }

        public void setUser_id (String user_id)
        {
            this.user_id = user_id;
        }

        public String getApi_token ()
        {
            return api_token;
        }

        public void setApi_token (String api_token)
        {
            this.api_token = api_token;
        }

        public String getUser_phone ()
        {
            return user_phone;
        }

        public void setUser_phone (String user_phone)
        {
            this.user_phone = user_phone;
        }

        public String getCreated_at ()
        {
            return created_at;
        }

        public void setCreated_at (String created_at)
        {
            this.created_at = created_at;
        }

        public String getUser_gender ()
        {
            return user_gender;
        }

        public void setUser_gender (String user_gender)
        {
            this.user_gender = user_gender;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [user_dob = "+user_dob+", user_states = "+user_states+", user_email = "+user_email+", user_password = "+user_password+", user_country = "+user_country+", updated_at = "+updated_at+", user_fname = "+user_fname+", user_id = "+user_id+", api_token = "+api_token+", user_phone = "+user_phone+", created_at = "+created_at+", user_gender = "+user_gender+"]";
        }
    }

