package com.example.doanchuyennganh.adapter;

import android.content.Context;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanchuyennganh.Common.Common;
import com.example.doanchuyennganh.R;
import com.example.doanchuyennganh.Callback.CallBackClickNoti;
import com.example.doanchuyennganh.event.NotiClick;
import com.example.doanchuyennganh.model.NotiModel;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class NotiAdapter extends RecyclerView.Adapter<NotiAdapter.MyViewHolder> {
    Context context;
    List<NotiModel> notiModels;

    public NotiAdapter(Context context, List<NotiModel> notiModels) {
        this.context = context;
        this.notiModels = notiModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.noti_item_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvnoticontent.setText(notiModels.get(position).getNotiContent());
        holder.tvnotiday.setText(notiModels.get(position).getNotiDay());

        holder.setCallBackClickNoti((view, pos) -> {
            Common.NotiClick = notiModels.get(pos);
            EventBus.getDefault().postSticky(new NotiClick(true, notiModels.get(pos)));
        });
    }

    @Override
    public int getItemCount() {
        return notiModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Unbinder unbinder;
        @BindView(R.id.tvnoticontent)
        TextView tvnoticontent;
        @BindView(R.id.tvnotiday)
        TextView tvnotiday;

        CallBackClickNoti callBackClickNoti;

        public void setCallBackClickNoti(CallBackClickNoti callBackClickNoti) {
            this.callBackClickNoti = callBackClickNoti;
        }

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            callBackClickNoti.OnItemClickListener(view,getAdapterPosition());
        }
    }
}
