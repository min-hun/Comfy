package com.example.doanchuyennganh.ui.notifications;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.doanchuyennganh.Common.Common;
import com.example.doanchuyennganh.model.NotiModel;

public class NotibillViewModel extends ViewModel {

    private MutableLiveData <NotiModel> mutableLiveDataNoti;
    public NotibillViewModel(){
    }

    public MutableLiveData<NotiModel> getMutableLiveDataNoti(){
        if (mutableLiveDataNoti == null){
            mutableLiveDataNoti = new MutableLiveData<>();
        }
        mutableLiveDataNoti.setValue(Common.NotiClick);
        return mutableLiveDataNoti;
    }
}
