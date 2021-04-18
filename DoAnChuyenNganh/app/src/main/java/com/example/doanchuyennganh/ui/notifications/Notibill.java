package com.example.doanchuyennganh.ui.notifications;

import androidx.appcompat.app.AlertDialog;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.doanchuyennganh.R;
import com.example.doanchuyennganh.model.NotiModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Notibill extends Fragment {

    private NotibillViewModel notibillViewModel;

    NavController navController;
    int a = 0;
    Button btnpay;
    AlertDialog alertDialog;

    Unbinder unbinder;
    @BindView(R.id.tvLine3)
    TextView tvLine3;

    @BindView(R.id.tvYear)
    TextView tvYear;

    @BindView(R.id.tvLine4)
    TextView tvLine4;

    @BindView(R.id.tvLINE4b)
    TextView tvLINE4b;

    @BindView(R.id.tvLINE5)
    TextView tvLINE5;

    @BindView(R.id.tvLINE7)
    TextView tvLINE7;

    @BindView(R.id.tvLINE8)
    TextView tvLINE8;

    @BindView(R.id.tvLINE9)
    TextView tvLINE9;

    @BindView(R.id.tvLINE10)
    TextView tvLINE10;

    @BindView(R.id.tvLINE11)
    TextView tvLINE11;

    @BindView(R.id.tvLINE12)
    TextView tvLINE12;

    @BindView(R.id.tvLINE13)
    TextView tvLINE13;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        notibillViewModel =
                ViewModelProviders.of(this).get(NotibillViewModel.class);
        View root = inflater.inflate(R.layout.notibill_fragment, container, false);
        unbinder = ButterKnife.bind(this,root);
        notibillViewModel.getMutableLiveDataNoti().observe(this,notiModel -> {
            displayBill(notiModel);
        });
        return root;
    }

    private void displayBill(NotiModel notiModel) {
        tvLine3.setText(new StringBuilder(notiModel.getMonth().toString()));
        tvYear.setText(new StringBuilder(notiModel.getYear().toString()));
        tvLine4.setText(new StringBuilder(notiModel.getApartment()));
        tvLINE4b.setText(new StringBuilder(notiModel.getBlock()));
        tvLINE5.setText(new StringBuilder(notiModel.getOwner()));
        tvLINE7.setText(new StringBuilder(notiModel.getServiceBill().toString()));
        tvLINE8.setText(new StringBuilder(notiModel.getWaterBill().toString()));
        tvLINE9.setText(new StringBuilder(notiModel.getWaterOld().toString()));
        tvLINE10.setText(new StringBuilder(notiModel.getWaterNew().toString()));
        tvLINE11.setText(new StringBuilder(notiModel.getWaterUsed().toString()));
        tvLINE13.setText(new StringBuilder(notiModel.getTotalWord()));
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        btnpay = view.findViewById(R.id.btnpay);

        btnpay.setOnClickListener(v ->
                navController.navigate(R.id.action_nav_bill_info_to_pay_fragment));
    }
}
