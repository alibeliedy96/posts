package com.example.posts.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.posts.Apapters.PostsAdapter;
import com.example.posts.Model.PostModel;
import com.example.posts.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {
   PostViewModel postViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        postViewModel= new ViewModelProvider(this).get(PostViewModel.class);
        postViewModel.getPosts();
        RecyclerView recyclerView = findViewById(R.id.recycler);
        final PostsAdapter adapter = new PostsAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        postViewModel.postsMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                adapter.setList(postModels);
            }
        });
    }
}