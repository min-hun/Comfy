package com.example.doanchuyennganhadmin.ui.quanlycudan;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.doanchuyennganhadmin.Common.Common;
import com.example.doanchuyennganhadmin.callback.CallBackListResident;
import com.example.doanchuyennganhadmin.model.ResidentModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.nio.channels.MulticastChannel;
import java.util.ArrayList;
import java.util.List;

public class QuanlycudanViewModel extends ViewModel implements CallBackListResident {

    private MutableLiveData<List<ResidentModel>> residentModelList;
    private MutableLiveData<String> errorMessage;
    private CallBackListResident callBackListResident;

    public QuanlycudanViewModel() {
        callBackListResident = this;
    }

    public MutableLiveData<List<ResidentModel>> getResidentModelList() {
        if (residentModelList == null) {
            residentModelList = new MutableLiveData<>();
            errorMessage = new MutableLiveData<>();
            loadResidentList();
        }
        return residentModelList;
    }

    private void loadResidentList() {
        List<ResidentModel> templist = new ArrayList<>();
        DatabaseReference residentRef = FirebaseDatabase.getInstance().getReference(Common.RESIDENT_REF);
        residentRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot blockSnapshot : dataSnapshot.getChildren()) {
                    for (DataSnapshot apartmentSnapshot : blockSnapshot.getChildren()) {
                        ResidentModel model = apartmentSnapshot.getValue(ResidentModel.class);
                        templist.add(model);
                    }
                }
                callBackListResident.onResidentLoadSuccess(templist);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                callBackListResident.onResidentLoadFailed(databaseError.getMessage());
            }
        });
    }

    public MutableLiveData<String> getErrorMessage() {
        return getErrorMessage();
    }

    @Override
    public void onResidentLoadSuccess(List<ResidentModel> residentModel) {
        residentModelList.setValue(residentModel);
    }

    @Override
    public void onResidentLoadFailed(String message) {
        errorMessage.setValue(message);

    }
}