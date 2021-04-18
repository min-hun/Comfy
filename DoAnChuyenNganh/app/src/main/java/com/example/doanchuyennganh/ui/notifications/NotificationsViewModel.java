package com.example.doanchuyennganh.ui.notifications;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.doanchuyennganh.Common.Common;
import com.example.doanchuyennganh.Callback.CallBackNoti;
import com.example.doanchuyennganh.model.NotiModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.callback.Callback;

public class NotificationsViewModel extends ViewModel implements CallBackNoti {

    private MutableLiveData<List<NotiModel>> listMutableLiveData;
    private MutableLiveData<String > messageError;
    private CallBackNoti callBackNoti;

    public MutableLiveData<List<NotiModel>> getListMutableLiveData(){
        if(listMutableLiveData == null){
            listMutableLiveData = new MutableLiveData<>();
            messageError = new MutableLiveData<>();
            loadNotiData();
        }
        return listMutableLiveData;
    }

    private void loadNotiData() {
        List<NotiModel> tempNoti = new ArrayList<>();
        DatabaseReference notiRef = FirebaseDatabase.getInstance().getReference(Common.NOTI_REFERENCE);
        notiRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot itemSnapshot : dataSnapshot.getChildren()){
                    NotiModel model = itemSnapshot.getValue(NotiModel.class);
                    tempNoti.add(model);
                }
                callBackNoti.onNotiLoadSuccess(tempNoti);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                callBackNoti.onNotiLoadFailed(databaseError.getMessage());
            }
        });
    }

    public CallBackNoti getCallBackNoti() {
        return callBackNoti;
    }

    public NotificationsViewModel() {
        callBackNoti = this;
    }

    @Override
    public void onNotiLoadSuccess(List<NotiModel> notiModel) {
        listMutableLiveData.setValue(notiModel);
    }

    @Override
    public void onNotiLoadFailed(String message) {
        messageError.setValue(message);
    }
}