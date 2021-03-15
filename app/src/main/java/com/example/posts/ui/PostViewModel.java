package com.example.posts.ui;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.posts.API.APIManager;
import com.example.posts.Model.PostModel;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PostViewModel extends ViewModel {
    MutableLiveData<List<PostModel>> postsMutableLiveData = new MutableLiveData<>();
    MutableLiveData<String> posts = new MutableLiveData<>();
    private static final String TAG = "PostViewModel";

    public void getPosts() {
        Observable observable = APIManager.getINSTANCE().getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        Observer<List<PostModel>> observer = new Observer<List<PostModel>>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(List<PostModel> value) {
                postsMutableLiveData.setValue(value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e);
            }

            @Override
            public void onComplete() {

            }
        };
        observable.subscribe(observer);

    }
}
