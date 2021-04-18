package com.example.doanchuyennganhadmin.ui.dashboard;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.doanchuyennganhadmin.Common.Common;
import com.example.doanchuyennganhadmin.R;

public class profileadmin extends Fragment {
    TextView tvname, tvnamsinh, tvcontact,tvemail,tvdiachi;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_profileadmin, container, false);
        tvname = root.findViewById(R.id.tvname);
        tvnamsinh = root.findViewById(R.id.tvnamsinh);
        tvcontact = root.findViewById(R.id.tvcontact);
        tvemail = root.findViewById(R.id.tvemail);
        tvdiachi = root.findViewById(R.id.tvdiachi);

        tvname.setText(Common.currentAdmin.getAdminname());
        tvnamsinh.setText(Common.currentAdmin.getNamsinh());
        tvcontact.setText(Common.currentAdmin.getContact());
        tvemail.setText(Common.currentAdmin.getEmail());
        tvdiachi.setText(Common.currentAdmin.getDiachi());

        return root;
    }
}