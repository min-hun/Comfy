package com.example.doanchuyennganh.ui.message;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doanchuyennganh.R;

public class Message extends Fragment {

    private MessageViewModel mViewModel;

    public static Message newInstance() {
        return new Message();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        mViewModel =
                ViewModelProviders.of(this).get(MessageViewModel.class);
        View root = inflater.inflate(R.layout.message_fragment, container, false);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MessageViewModel.class);
        // TODO: Use the ViewModel
    }

}