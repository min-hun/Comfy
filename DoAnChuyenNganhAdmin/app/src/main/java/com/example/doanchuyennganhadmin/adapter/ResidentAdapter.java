package com.example.doanchuyennganhadmin.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanchuyennganhadmin.Common.Common;
import com.example.doanchuyennganhadmin.R;
import com.example.doanchuyennganhadmin.callback.RecyclerClickListener;
import com.example.doanchuyennganhadmin.event.ResidentClick;
import com.example.doanchuyennganhadmin.model.ResidentModel;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ResidentAdapter extends RecyclerView.Adapter<ResidentAdapter.MyViewHolder> {

    Context context;
    List<ResidentModel> residentModelList;
    NavController navController;

    DatabaseReference residentRef = FirebaseDatabase.getInstance().getReference(Common.RESIDENT_REF);

    public ResidentAdapter(Context context, List<ResidentModel> residentModelList) {
        this.context = context;
        this.residentModelList = residentModelList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context)
                .inflate(R.layout.item_cudan, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ResidentAdapter.MyViewHolder holder, int position) {

        holder.tv_block.setText(residentModelList.get(position).getBlock());
        holder.tv_apartment.setText(residentModelList.get(position).getApartment());
        holder.tv_owner.setText(residentModelList.get(position).getOwner());
        holder.tv_phone.setText(residentModelList.get(position).getPhone());

        holder.setClickListener((view, pos) -> {
            Common.ResidentClick = residentModelList.get(pos);
            holder.btn_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    residentRef.child(Common.ResidentClick.getBlock()).child(Common.ResidentClick.getAccount()).removeValue();
                    Toast.makeText(context, "Đã xóa " + Common.ResidentClick.getBlock() + Common.ResidentClick.getApartment(), Toast.LENGTH_SHORT).show();
                }
            });
            holder.btn_edit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    EventBus.getDefault().postSticky(new ResidentClick(true, Common.ResidentClick));
                    // Toast.makeText(context, "Click Edit " + Common.ResidentClick.getBlock() + Common.ResidentClick.getApartment(), Toast.LENGTH_SHORT).show();
                }
            });
        });
    }

    @Override
    public int getItemCount() {
        return residentModelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Unbinder unbinder;

        @BindView(R.id.tv_block)
        TextView tv_block;

        @BindView(R.id.tv_apartment)
        TextView tv_apartment;

        @BindView(R.id.tv_owner)
        TextView tv_owner;

        @BindView(R.id.tv_phone)
        TextView tv_phone;

        @BindView(R.id.btn_edit)
        Button btn_edit;

        @BindView(R.id.btn_delete)
        Button btn_delete;

        RecyclerClickListener clickListener;

        public void setClickListener(RecyclerClickListener clickListener) {
            this.clickListener = clickListener;
        }

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            unbinder = ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            clickListener.OnItemClickListener(view, getAdapterPosition());
        }
    }
}
