package com.example.doanchuyennganh.ui.dashboard;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.doanchuyennganh.R;


public class Utility extends Fragment {

    RelativeLayout rllogout,rllogout2,rllogout3;
    NavController navController;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_utility, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        rllogout = view.findViewById(R.id.rldatxe);
        rllogout2 = view.findViewById(R.id.rllogout2);
        rllogout3 = view.findViewById(R.id.rllogout3);
        rllogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_utility_fragment_to_fragment_datxe);
            }
        });
        rllogout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_utility_fragment_to_fragment_phonggym);
            }
        });
        rllogout3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_utility_fragment_to_fragment_yte);
            }
        });
    }
}