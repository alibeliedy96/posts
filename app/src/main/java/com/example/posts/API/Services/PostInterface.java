package com.example.posts.API.Services;



import com.example.posts.Model.PostModel;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
    public Observable<List<PostModel>> getPosts();
}
