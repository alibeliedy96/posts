package com.example.posts.Apapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.posts.Model.PostModel;
import com.example.posts.R;

import java.util.ArrayList;
import java.util.List;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.PostViewHolder> {
    private List<PostModel> posts = new ArrayList<>();

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.titleTV.setText(posts.get(position).getTitle());
        holder.userTV.setText(posts.get(position).getUserId()+"");
        holder.bodyTV.setText(posts.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void setList(List<PostModel> moviesList) {
        this.posts = moviesList;
        notifyDataSetChanged();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView titleTV, userTV, bodyTV;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTV = itemView.findViewById(R.id.titleTV);
            userTV = itemView.findViewById(R.id.userIDTV);
            bodyTV = itemView.findViewById(R.id.bodyTV);
        }
    }
}
