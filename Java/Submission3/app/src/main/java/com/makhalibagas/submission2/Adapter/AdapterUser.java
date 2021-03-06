package com.makhalibagas.submission2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.makhalibagas.submission2.Ui.DetailActivity;
import com.makhalibagas.submission2.Model.UserGithub;
import com.makhalibagas.submission2.R;

import java.util.List;

public class AdapterUser extends RecyclerView.Adapter<AdapterUser.UserViewHolder> {
    private Context c;
    private List<UserGithub> userGithubList ;

    public AdapterUser(Context c, List<UserGithub> userGithubList) {
        this.c = c;
        this.userGithubList = userGithubList;
    }

    @NonNull
    @Override
    public AdapterUser.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);

        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterUser.UserViewHolder holder, int position) {
        UserGithub userGithub = userGithubList.get(position);
        holder.tv_name.setText(userGithub.getLogin());
        holder.tv_url.setText(userGithub.getHtmlUrl());
        Glide.with(holder.itemView.getContext())
                .load(userGithub.getAvatarUrl())
                .into(holder.img);


    }

    @Override
    public int getItemCount() {
        return userGithubList.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img;
        TextView tv_url,tv_name;
        UserViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img_user);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_url = itemView.findViewById(R.id.tv_url);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            UserGithub userGithub = userGithubList.get(getAdapterPosition());
            Intent intent = new Intent(c, DetailActivity.class);
            intent.putExtra("DATA_USER",userGithub);
            v.getContext().startActivity(intent);
        }
    }
}
