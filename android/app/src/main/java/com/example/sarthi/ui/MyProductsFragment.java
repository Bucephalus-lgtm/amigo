package com.example.sarthi.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sarthi.R;
import com.example.sarthi.adapter.MyProductAdapter;
import com.example.sarthi.adapter.SellerItemsAdapter;
import com.example.sarthi.model.MyProductModel;
import com.example.sarthi.model.SellerItemsModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class MyProductsFragment extends Fragment {

    View root;

    private RecyclerView myProducts;
    List<MyProductModel> itemlist;
    Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_my_products, container, false);
        myProducts = root.findViewById(R.id.myProducts);
        GridLayoutManager manager = new GridLayoutManager(getActivity().getApplicationContext(), 2, GridLayoutManager.VERTICAL, false);
        myProducts.setLayoutManager(manager);
        myProducts.setHasFixedSize(true);
        setMyProducts();



        return root;
    }

    private void setMyProducts() {
        String apikey = "https://sarthiapi.herokuapp.com/api/get/all/products";
        itemlist = new ArrayList<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, apikey, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONObject obj = response;
                try{
                    JSONArray jsonArray = obj.getJSONArray("product");
                    String name, type,price,pin,img_url,seller_id,product_id;
                    for(int i=0;i<jsonArray.length();i++){
                        JSONObject object = jsonArray.getJSONObject(i);
                        name = object.getString("name");
                        type=object.getString("category");
                        img_url = object.getString("image");
                        price = String.valueOf(object.getInt("price"));
                        product_id = object.getString("_id");
                        itemlist.add(new MyProductModel(name,type,price,img_url,product_id));
                    }
                    myProducts.setAdapter(new MyProductAdapter(itemlist,getActivity().getApplicationContext()));
                }catch (JSONException e){

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity().getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        requestQueue.add(jsonObjectRequest);

    }
}