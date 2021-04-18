package com.example.doanchuyennganh.ui.home;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doanchuyennganh.R;
import com.example.doanchuyennganh.adapter.NewsAdapter;
import com.example.doanchuyennganh.model.NewsModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    Unbinder unbinder;
    @BindView(R.id.recycler_news)
    RecyclerView recycler_news;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, root);
        init();
        homeViewModel.getMutableLiveData().observe(this,newsModels -> {
            NewsAdapter newsAdapter = new NewsAdapter(getContext(),newsModels);
            recycler_news.setAdapter(newsAdapter);
        });

        SearchManager searchManager = (SearchManager) getActivity().getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) root.findViewById(R.id.sv_news);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                startSearchNews(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        return root;

    }

    private void startSearchNews(String query) {
        List<NewsModel> resultNews = new ArrayList<>();
        List<NewsModel> currentNews = homeViewModel.getMutableLiveData().getValue();

        for (NewsModel newsModel : currentNews){
            if (newsModel.getNewscontent().toLowerCase().contains(query.toLowerCase())){
                resultNews.add(newsModel);
            }
            homeViewModel.getMutableLiveData().setValue(resultNews);
        }
    }


    private void init() {
        recycler_news.setHasFixedSize(true);
        recycler_news.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
    }
}
