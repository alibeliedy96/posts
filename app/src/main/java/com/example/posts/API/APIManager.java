package com.example.posts.API;

import android.util.Log;

import com.example.posts.API.Services.PostInterface;
import com.example.posts.Model.PostModel;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIManager {
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private PostInterface postInterface;
    private static APIManager INSTANCE;

    public APIManager() {
        HttpLoggingInterceptor loggingInterceptor =new HttpLoggingInterceptor(
                new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        Log.e("api",message);
                    }
                });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
        postInterface = retrofit.create(PostInterface.class);
    }

    public static APIManager getINSTANCE() {
        if (null == INSTANCE){
            INSTANCE = new APIManager();
        }
        return INSTANCE;
    }

    public Observable<List<PostModel>> getPosts(){

        return postInterface.getPosts();
    }
}
