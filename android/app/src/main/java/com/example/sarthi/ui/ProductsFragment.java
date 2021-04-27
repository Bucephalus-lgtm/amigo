package com.example.sarthi.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.security.identity.AccessControlProfileId;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sarthi.R;
import com.example.sarthi.adapter.CategoryAdapter;
import com.example.sarthi.adapter.DealsAdapter;
import com.example.sarthi.model.CategoryModel;
import com.example.sarthi.model.DealsModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductsFragment extends Fragment {


    View root;

    private String name;
    private RecyclerView category, popDeals;
    private Context mContext;

    List<CategoryModel> categories;
    List<DealsModel> deals;
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

        popDeals = root.findViewById(R.id.pop_deals);
        popDeals.setLayoutManager(new LinearLayoutManager(mContext,RecyclerView.VERTICAL,false));
        popDeals.setHasFixedSize(true);
        initDeals();
    }

    private void initDeals() {
        deals = new ArrayList<>();
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
                        deals.add(new DealsModel(name,url,type,price,sellerId));
                    }
                    popDeals.setAdapter(new DealsAdapter(deals,mContext));
                } catch (JSONException e) {
                    e.printStackTrace();
//                    Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mContext,error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });


//        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, apikey, null, new Response.Listener<JSONArray>() {
//            @Override
//            public void onResponse(JSONArray response) {
//                JSONObject object = new JSONObject(response.getJSONObject(0));
//                JSONArray jsonArray = response;
////                Toast.makeText(mContext, jsonArray.toString(), Toast.LENGTH_SHORT).show();
//                String name, type,url;
//                int price;
//                try {
//                    for(int i=0;i<3;i++)
//                    {
//                        JSONObject jsonObject = jsonArray.getJSONObject(i);
//                        name = jsonObject.getString("name");
//                        type = jsonObject.getString("category");
//                        url = jsonObject.getString("image");
//                        price = jsonObject.getInt("price");
//                        deals.add(new DealsModel(name,url,type,price));
//                    }
//                    popDeals.setAdapter(new DealsAdapter(deals,mContext));
//                }
//                catch (Exception w){
////                    Toast.makeText(mContext,w.getMessage(),Toast.LENGTH_LONG).show();
//                }
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Log.d("Error",error.getMessage()+"--------------------------------------------------");
////                Toast.makeText(mContext,error.getMessage(),Toast.LENGTH_LONG).show();
//            }
//        });
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        requestQueue.add(jsonObjectRequest);
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