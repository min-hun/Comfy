package com.example.doanchuyennganhadmin.ui.notifications;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.doanchuyennganhadmin.Common.Common;
import com.example.doanchuyennganhadmin.LoginActivity;
import com.example.doanchuyennganhadmin.R;
import com.google.firebase.auth.FirebaseAuth;

public class NotificationsFragment extends Fragment {
    TextView tvidinfo;
    NavController navController;

    RelativeLayout rlinfo, rlchucnang1, rlchucnang3, rlchucnang4, rllogout;


    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        tvidinfo = root.findViewById(R.id.tvidinfo);

        tvidinfo.setText(Common.currentAdmin.getAdminname().toString());

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);

        rlinfo = view.findViewById(R.id.rlinfo);
        rlchucnang1 = view.findViewById(R.id.rlchucnang1);
        rlchucnang3 = view.findViewById(R.id.rlchucnang3);
        rlchucnang4 = view.findViewById(R.id.rlchucnang4);
        rllogout = view.findViewById(R.id.rllogout);

        rlinfo.setOnClickListener(v -> navController.navigate(R.id.action_navigation_notifications_to_nav_profile_admin));
        rlchucnang1.setOnClickListener(v -> navController.navigate(R.id.action_navigation_notifications_to_nav_addnews));
        rlchucnang3.setOnClickListener(v -> navController.navigate(R.id.action_navigation_notifications_to_nav_quanlycudan));
        rlchucnang4.setOnClickListener(v -> navController.navigate(R.id.action_navigation_notifications_to_nav_infoapp));

        rllogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Logout();
            }
        });
    }

    private void Logout() {

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
                Common.currentAdmin = null;
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }
}