package com.example.sarthi.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sarthi.R;
import com.example.sarthi.adapter.DealsAdapter;
import com.example.sarthi.adapter.ProductsAdapter;
import com.example.sarthi.model.DealsModel;
import com.example.sarthi.model.ProductModel;
import com.google.android.material.slider.RangeSlider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListsFragment extends Fragment {

    View root;

    private RecyclerView productList;
    private RangeSlider priceRange;
    private CheckBox vegetable,fruit,groceries,nonVeg;

    private List<ProductModel> productModelList;

    private Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_lists, container, false);
        context = getActivity().getApplicationContext();

        initViews();



        return root;
    }

    private void initViews() {
        vegetable = root.findViewById(R.id.vegetable);
        fruit = root.findViewById(R.id.fruit);
        groceries = root.findViewById(R.id.groceries);
        nonVeg = root.findViewById(R.id.non_veg);
        priceRange = root.findViewById(R.id.feeRange);
        productList = root.findViewById(R.id.productList);
        initList();

        changeListener();


    }

    private void changeListener() {
//        vegetable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                initList(vegetable.isChecked(),fruit.isChecked(),groceries.isChecked(),nonVeg.isChecked());
//            }
//        });
//        fruit.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                initList(vegetable.isChecked(),fruit.isChecked(),groceries.isChecked(),nonVeg.isChecked());
//            }
//        });
//        nonVeg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                initList(vegetable.isChecked(),fruit.isChecked(),groceries.isChecked(),nonVeg.isChecked());
//            }
//        });
//        groceries.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                initList(vegetable.isChecked(),fruit.isChecked(),groceries.isChecked(),nonVeg.isChecked());
//            }
//        });

    }

    private void initList() {
        productModelList = new ArrayList<>();
        String apikey = "https://sarthiapi.herokuapp.com/api/get/all/products";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, apikey, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONObject obj = response;
                try {
                    JSONArray jsonArray = obj.getJSONArray("product");
                    String name, type,url,sellerId;
                    int price;
                    for(int i=0;i<3;i++){
                        JSONObject object = jsonArray.getJSONObject(i);
                        name = object.getString("name");
                        type = object.getString("category");
                        url = object.getString("image");
                        price = object.getInt("price");
                        sellerId = object.getString("seller");
                        productModelList.add(new ProductModel(name,type,url,sellerId,price));
                    }
                    productList.setAdapter(new ProductsAdapter(productModelList,getActivity().getApplicationContext()));
                } catch (JSONException e) {
                    e.printStackTrace();
//                    Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity().getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());

        requestQueue.add(jsonObjectRequest);
    }
}