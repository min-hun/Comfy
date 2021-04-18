package com.example.doanchuyennganh.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.doanchuyennganh.R;
import com.example.doanchuyennganh.model.NewsModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    Context context;
    List<NewsModel> newsModelList;

    public NewsAdapter(Context context, List<NewsModel> newsModelList) {
        this.context = context;
        this.newsModelList = newsModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.news_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(newsModelList.get(position).getNewsavt()).apply(RequestOptions.circleCropTransform()).into(holder.imgavt);
        Glide.with(context).load(newsModelList.get(position).getNewsimg()).into(holder.imgnews);
        holder.tvDaynews.setText(newsModelList.get(position).getNewsday());
        holder.tvTimenews.setText(newsModelList.get(position).getNewstime());
        holder.tvnews.setText(newsModelList.get(position).getNewscontent());

    }

    @Override
    public int getItemCount() {
        return newsModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        Unbinder unbinder;
        @BindView(R.id.imgavt)
        ImageView imgavt;

        @BindView(R.id.tvTimenews)
        TextView tvTimenews;

        @BindView(R.id.imgnews)
        ImageView imgnews;

        @BindView(R.id.tvnews)
        TextView tvnews;

        @BindView(R.id.tvDaynews)
        TextView tvDaynews;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
        }
    }
}

