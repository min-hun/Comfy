package com.example.doanchuyennganhadmin.ui.quanlycudan;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.doanchuyennganhadmin.R;
import com.example.doanchuyennganhadmin.model.ResidentModel;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class ThongtincudanFragment extends Fragment {

    ThongtincudanViewModel thongtincudanViewModel;

    Unbinder unbinder;

    @BindView(R.id.tv_owner)
    TextView tv_owner;

    @BindView(R.id.tv_residentid)
    TextView tv_residentid;

    @BindView(R.id.tv_phone)
    TextView tv_phone;

    @BindView(R.id.tv_email)
    TextView tv_email;

    @BindView(R.id.tv_block)
    TextView tv_block;

    @BindView(R.id.tv_apartment)
    TextView tv_apartment;

    @BindView(R.id.tv_account)
    TextView tv_account;

    @BindView(R.id.tv_password)
    TextView tv_password;

    @BindView(R.id.tv_idbusiness)
    TextView tv_idbusiness;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        thongtincudanViewModel =
                ViewModelProviders.of(this).get(ThongtincudanViewModel.class);
        View root = inflater.inflate(R.layout.thongtincudan_fragment, container, false);
        unbinder = ButterKnife.bind(this, root);

        thongtincudanViewModel.getResidentModelMutableLiveData().observe(this,residentModel -> {
            displayInfor(residentModel);
        });
        return root;

    }

    private void displayInfor(ResidentModel residentModel) {
        tv_owner.setText(new StringBuilder(residentModel.getOwner()));
        tv_residentid.setText(new StringBuilder(residentModel.getCmnd()));
        tv_phone.setText(new StringBuilder(residentModel.getPhone()));
        tv_email.setText(new StringBuilder(residentModel.getEmail()));
        tv_block.setText(new StringBuilder(residentModel.getBlock()));
        tv_apartment.setText(new StringBuilder(residentModel.getApartment()));
        tv_account.setText(new StringBuilder(residentModel.getAccount()));
        tv_password.setText(new StringBuilder(residentModel.getPassword()));
        tv_idbusiness.setText(new StringBuilder(residentModel.getIdbusiness()));

    }
}