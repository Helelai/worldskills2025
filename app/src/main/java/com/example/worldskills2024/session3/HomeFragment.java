package com.example.worldskills2024.session3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.worldskills2024.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView recyclerView;
    private ArrayList<Category> categories = new ArrayList<Category>();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        initializeCategoryRecyclerView();

        recyclerView = view.findViewById(R.id.CategoryRW); //recyclerView

        CategoryAdapter categoryAdapter = new CategoryAdapter(view.getContext(), categories);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(categoryAdapter);
        return view;
    }

    public void initializeCategoryRecyclerView() {
        categories.add(new Category("Все"));
        categories.add(new Category("Outdoor"));
        categories.add(new Category("Tennis"));
        categories.add(new Category("Running"));
    }
}
