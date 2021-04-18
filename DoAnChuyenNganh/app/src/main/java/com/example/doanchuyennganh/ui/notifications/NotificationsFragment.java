package com.example.doanchuyennganh.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.GlideContext;
import com.example.doanchuyennganh.R;
import com.example.doanchuyennganh.adapter.NotiAdapter;
import com.example.doanchuyennganh.model.NotiModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class NotificationsFragment extends Fragment {

    Unbinder unbinder;
    @BindView(R.id.recycler_noti)
    RecyclerView recycler_noti;

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        unbinder = ButterKnife.bind(this, root);
        init();
        notificationsViewModel.getListMutableLiveData().observe(this,notiModels -> {
            NotiAdapter notiAdapter= new NotiAdapter(getContext(),notiModels);
            recycler_noti.setAdapter(notiAdapter);
        });
        return root;
    }

    private void init() {
        recycler_noti.setHasFixedSize(true);
        recycler_noti.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
    }
}
