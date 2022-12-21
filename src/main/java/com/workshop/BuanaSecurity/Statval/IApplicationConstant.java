package com.workshop.BuanaSecurity.Statval;

public interface IApplicationConstant {
    public interface ApplicationContext{
        public interface AUTHENTICATION {
            String AUTH = "/auth";

        }

        public interface API{
            String API_V2 = "/api/v2";
        }

    }
    public interface ENDPOINT {
        String AUTHENTICATE = "/authenticate";
        String HELLO_WORLD = "/hello-world";
        String GOOD_BYE = "/good-bye";

    }


}
