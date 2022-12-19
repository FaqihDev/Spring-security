package com.workshop.BuanaSecurity.Statval;

public interface IApplicationConstant {

    public interface ApplicationContext{
        public interface AUTHENTICATION {
            String AUTH = "/auth";

            String AUTHENTICATE = "/authtenticate";
            String API = "/api/v2";
        }
    }

    public interface API{
        String HELLO_WORLD = "/hello-world";
        String GOOD_BYE = "/good-bye";


    }


}
