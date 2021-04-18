package com.example.doanchuyennganh.ui.dashboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.doanchuyennganh.Common.Common;
import com.example.doanchuyennganh.R;

public class MenuInfo extends Fragment {

    TextView tvname, tvapartment, tvblock, tvphone, tvmail, tvidcontract;

    public MenuInfo() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Log.d("fragmentB", "fragmentB: onCreate");
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.menu_info_fragment, container, false);


        tvname = root.findViewById(R.id.tvname);
        tvapartment = root.findViewById(R.id.tvapartment);
        tvblock = root.findViewById(R.id.tvblock);
        tvphone = root.findViewById(R.id.tvphone);
        tvmail = root.findViewById(R.id.tvmail);
        tvidcontract = root.findViewById(R.id.tvidcontract);

        tvname.setText(Common.currentUser.getOwner().toString());
        tvapartment.setText(Common.currentUser.getApartment().toString());
        tvblock.setText(Common.currentUser.getBlock().toString());
        tvphone.setText(Common.currentUser.getPhone().toString());
        tvmail.setText(Common.currentUser.getEmail().toString());
        tvidcontract.setText(Common.currentUser.getIdbusiness().toString());

        return root;

    }
}
