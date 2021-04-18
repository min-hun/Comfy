package com.example.doanchuyennganh.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.doanchuyennganh.Common.Common;
import com.example.doanchuyennganh.Callback.CallBackNews;
import com.example.doanchuyennganh.model.NewsModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel implements CallBackNews {

    private MutableLiveData<List<NewsModel>> mutableLiveData;
    private CallBackNews callBackNews;
    private MutableLiveData<String> messageError;


    public HomeViewModel() {
        callBackNews = this;
    }

    public MutableLiveData<List<NewsModel>> getMutableLiveData() {
        if (mutableLiveData == null) {
            mutableLiveData = new MutableLiveData<>();
            messageError = new MutableLiveData<>();
            loadNewsData();
        }
        return mutableLiveData;
    }

    private void loadNewsData() {
        List<NewsModel> tempList = new ArrayList<>();
        DatabaseReference newsRef = FirebaseDatabase.getInstance().getReference(Common.NEWS_REFERENCE);
        newsRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot daySnapshort : dataSnapshot.getChildren()) {
                    for (DataSnapshot timeSnapshot : daySnapshort.getChildren()) {
                        NewsModel model = timeSnapshot.getValue(NewsModel.class);
                        tempList.add(model);
                    }
                }
                callBackNews.onNewsLoadSuccess(tempList);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                callBackNews.onNewsLoadFailed(databaseError.getMessage());
            }
        });
    }

    public CallBackNews getCallBackNews() {
        return callBackNews;
    }

    @Override
    public void onNewsLoadSuccess(List<NewsModel> newsModel) {
        mutableLiveData.setValue(newsModel);
    }

    @Override
    public void onNewsLoadFailed(String message) {
        messageError.setValue(message);
    }
}