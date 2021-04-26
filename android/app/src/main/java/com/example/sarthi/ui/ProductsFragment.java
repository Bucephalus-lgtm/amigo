package com.example.sarthi.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sarthi.R;
import com.example.sarthi.adapter.CategoryAdapter;
import com.example.sarthi.model.CategoryModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductsFragment extends Fragment {


    View root;

    private String name;
    private RecyclerView category;
    private Context mContext;

    List<CategoryModel> categories;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_products, container, false);
        mContext = getActivity().getApplicationContext();
        initView();

        return root;
    }

    private void initView() {
        category = root.findViewById(R.id.categories);
        category.setLayoutManager(new LinearLayoutManager(mContext,RecyclerView.HORIZONTAL,false));
        category.setHasFixedSize(true);
        initCategories();
    }

    private void initCategories() {
        categories = new ArrayList<>();
        String[] strArr = root.getResources().getStringArray(R.array.categories);
        String[] urlArr = root.getResources().getStringArray(R.array.cat_img);
        for(int i=0;i<4;i++){
            categories.add(new CategoryModel(strArr[i],urlArr[i]));
        }
        category.setAdapter(new CategoryAdapter(categories,mContext));
    }
}