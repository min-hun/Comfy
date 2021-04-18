package com.example.doanchuyennganh;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.OverScroller;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.doanchuyennganh.event.InfoClick;
import com.example.doanchuyennganh.event.NotiClick;
import com.example.doanchuyennganh.ui.message.MessageViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {

    private NavController navController;
    private DrawerLayout drawer;
    private ActionBar toolbar;
    FragmentManager fragmentManager;
    @BindView(R.id.rlinfo)
    RelativeLayout rlinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications,R.id.navigation_message,R.id.nav_bill_info,R.id.menu_profile_fragment)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }
    @Subscribe(sticky = true,threadMode = ThreadMode.MAIN)
    public void onNotiSelect (NotiClick event){
        if(event.isSuccess())
        {
            Toast.makeText(this, "Click to: "+event.getNotiModel().getNotiDay(), Toast.LENGTH_SHORT).show();
            navController.navigate(R.id.nav_bill_info);
        }
    }

}
