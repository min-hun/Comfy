package com.example.doanchuyennganhadmin.adapter;

import android.content.Context;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.doanchuyennganhadmin.Common.Common;
import com.example.doanchuyennganhadmin.R;
import com.example.doanchuyennganhadmin.callback.CallBackClickNews;
import com.example.doanchuyennganhadmin.model.NewsModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {


    Context context;
    List<NewsModel> newsModelList;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference newsRef = database.getReference("news");
    public NewsAdapter(Context context, List<NewsModel> newsModelList) {
        this.context = context;
        this.newsModelList = newsModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.newsitemlayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(context).load(newsModelList.get(position).getNewsavt()).apply(RequestOptions.circleCropTransform()).into(holder.imgavt);
        Glide.with(context).load(newsModelList.get(position).getNewsimg()).into(holder.imgnews);
        holder.tvDaynews.setText(newsModelList.get(position).getNewsday());
        holder.tvTimenews.setText(newsModelList.get(position).getNewstime());
        holder.tvnews.setText(newsModelList.get(position).getNewscontent());

        holder.setCallBackClickNews(((view, pos) -> {
            Common.NewsClick = newsModelList.get(pos);
            holder.btnxoa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    newsRef.child(Common.NewsClick.getNewsday()).child(Common.NewsClick.getNewstime()).removeValue();
                    Toast.makeText(context, "Đã xóa tin "+Common.NewsClick.getNewsday(), Toast.LENGTH_SHORT).show();
                }
            });

        }));
    }

    @Override
    public int getItemCount() {
        return newsModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
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

        @BindView(R.id.btnxoa)
        Button btnxoa;

        CallBackClickNews callBackClickNews;

        public void setCallBackClickNews (CallBackClickNews callBackClickNews){
            this.callBackClickNews = callBackClickNews;
        }

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            callBackClickNews.OnNewsClickListener(view, getAdapterPosition());
        }

    }
}
