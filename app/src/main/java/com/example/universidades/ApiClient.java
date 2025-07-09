package com.example.universidades;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    /**private static final String BASE_URL = "http://192.168.1.11:5000/";**/

    private static final String BASE_URL = "http://10.0.2.2:5000/";


    private static Retrofit retrofit;

    private ApiClient() {

    }

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
