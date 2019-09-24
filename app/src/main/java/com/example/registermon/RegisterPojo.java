package com.example.registermon;

public class RegisterPojo {

        private String code;

        private Response response;

        private String message;

        private String status;

        public String getCode ()
        {
            return code;
        }

        public void setCode (String code)
        {
            this.code = code;
        }

        public Response getResponse ()
        {
            return response;
        }

        public void setResponse (Response response)
        {
            this.response = response;
        }

        public String getMessage ()
        {
            return message;
        }

        public void setMessage (String message)
        {
            this.message = message;
        }

        public String getStatus ()
        {
            return status;
        }

        public void setStatus (String status)
        {
            this.status = status;
        }

        @Override
        public String toString()
        {
            return "ClassPojo [code = "+code+", response = "+response+", message = "+message+", status = "+status+"]";
        }
    }


