package com.example.doanchuyennganh.ui.dashboard;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.doanchuyennganh.Common.Common;
import com.example.doanchuyennganh.Login;
import com.example.doanchuyennganh.R;
import com.google.firebase.auth.FirebaseAuth;

public class DashboardFragment extends Fragment{

    private DashboardViewModel dashboardViewModel;
    NavController navController;
    int a = 0;
    RelativeLayout rlutility, rlinfoapp, rlsetting,rlinfo,rllogout;
    AlertDialog alertDialog;
    TextView tvidinfo;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        Log.d("fragmentA", "fragmentA: onCreateView với biến a = " + a);
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        tvidinfo = view.findViewById(R.id.tvidinfo);
        tvidinfo.setText(Common.currentUser.getOwner().toString());

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        rlinfo = view.findViewById(R.id.rlinfo);
        rlutility = view.findViewById(R.id.rlutility);
        rlinfoapp = view.findViewById(R.id.rlinfoapp);
        rlsetting = view.findViewById(R.id.rlsetting);
        rllogout = view.findViewById(R.id.rllogout);

        rlinfo.setOnClickListener(v ->
                navController.navigate(R.id.action_navigation_dashboard_to_menu_profile_fragment));

        rlutility.setOnClickListener(v -> {
            navController.navigate(R.id.action_navigation_dashboard_to_utility_fragment);
        });
        rlinfoapp.setOnClickListener(v -> {
            navController.navigate(R.id.action_navigation_dashboard_to_info_app_fragment);
        });
        rlsetting.setOnClickListener(v ->
                navController.navigate(R.id.action_navigation_dashboard_to_setting_fragment));
        rllogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signOut();
            }
        });
    }

    @Override
    public void onStart() {
        Log.d("Fragment Dashboard", "FragmentDashboard: onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d("Fragment Dashboard", "FragmentDashboard: onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d("Fragment Dashboard", "Fragment Dashboard: onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d("Fragment Dashboard", "Fragment Dashboard: onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d("Fragment Dashboard", "Fragment Dashboard: onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d("Fragment Dashboard", "Fragment Dashboard: onDestroy");
        super.onDestroy();
    }
    private void signOut() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Đăng Xuất")
                .setMessage("Bạn có thực sự muốn đăng xuất ?")
                .setNegativeButton("HỦY", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).setPositiveButton("ĐỒNG Ý", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Common.currentUser = null;
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(), Login.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

}
