package com.example.doanchuyennganhadmin.ui.quanlycudan;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.doanchuyennganhadmin.Common.Common;
import com.example.doanchuyennganhadmin.model.ResidentModel;

public class ThongtincudanViewModel extends ViewModel {
    private MutableLiveData<ResidentModel> residentModelMutableLiveData;

    public ThongtincudanViewModel() {
    }

    public MutableLiveData<ResidentModel> getResidentModelMutableLiveData(){
        if (residentModelMutableLiveData == null){
            residentModelMutableLiveData = new MutableLiveData<>();
        }
        residentModelMutableLiveData.setValue(Common.ResidentClick);
        return residentModelMutableLiveData;
    }

}
