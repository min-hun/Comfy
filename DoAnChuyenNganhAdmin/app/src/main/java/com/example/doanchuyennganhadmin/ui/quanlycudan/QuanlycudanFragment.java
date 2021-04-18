package com.example.doanchuyennganhadmin.ui.quanlycudan;

import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProviders;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.doanchuyennganhadmin.R;
import com.example.doanchuyennganhadmin.adapter.ResidentAdapter;
import com.example.doanchuyennganhadmin.model.ResidentModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public class QuanlycudanFragment extends Fragment {

    private QuanlycudanViewModel quanlycudanViewModel;

    List<ResidentModel> residentModel;

    ResidentAdapter adapter;

    NavController navController;
    ImageView imgthemcudan;

    Unbinder unbinder;

    private RecyclerView recycler_resident;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        quanlycudanViewModel = ViewModelProviders.of(this).get(QuanlycudanViewModel.class);
        View root = inflater.inflate(R.layout.quanlycudan_fragment, container, false);
        recycler_resident = (RecyclerView)root.findViewById(R.id.recycler_resident);
        init();
        unbinder = ButterKnife.bind(this, root);
        quanlycudanViewModel.getResidentModelList().observe(this, residentModelList -> {
            residentModel = residentModelList;
            adapter = new ResidentAdapter(getContext(), residentModel);
            ResidentAdapter residentAdapter = new ResidentAdapter(getContext(), residentModelList);
            recycler_resident.setAdapter(residentAdapter);
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

        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                return false;
            }
        });
        return root;
    }

    private void startSearchNews(String query) {
        List<ResidentModel> resultResident = new ArrayList<>();
        List<ResidentModel> currentResident = quanlycudanViewModel.getResidentModelList().getValue();

        for (ResidentModel residentModel : currentResident){
            if (residentModel.getApartment().toLowerCase().contains(query.toLowerCase())){
                resultResident.add(residentModel);
            }
            quanlycudanViewModel.getResidentModelList().setValue(resultResident);
        }
    }

    private void init() {
        recycler_resident.setHasFixedSize(true);
        recycler_resident.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
    }

    @Override
    public void onViewCreated(@NonNull View root, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(root, savedInstanceState);
        navController = Navigation.findNavController(root);

        imgthemcudan = root.findViewById(R.id.imgthemcudan);
        imgthemcudan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_nav_quanlycudan_to_nav_themcudan);
            }
        });


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}