package com.example.sarthi.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sarthi.R;

import org.json.JSONException;
import org.json.JSONObject;

public class ProductPage extends AppCompatActivity {

    private String ID;
    RecyclerView sellerItems;
    TextView sellerName, sellerNo,sellerPin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);
        ID = getIntent().getStringExtra("_id");

        initView();
    }

    private void initView() {
        sellerName = findViewById(R.id.sellerName);
        sellerNo = findViewById(R.id.sellerNo);
        sellerPin = findViewById(R.id.sellerpin);

        setSellerData();
    }

    private void setSellerData() {
        String apikey = "https://sarthiapi.herokuapp.com/api/seller/"+ID;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, apikey, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONObject obj = null;
                String NAME, PHONE, PIN;
                try {
                    obj = response.getJSONObject("seller");
                    NAME = obj.getString("name");
                    PHONE =obj.getString("phone");
                    PIN=String.valueOf(obj.getInt("pin"));
                    if(NAME!=null)sellerName.setText(NAME);
                    if(PIN!=null)sellerPin.setText(PIN);
                    if(PHONE!=null)sellerNo.setText(PHONE);

//                    sellerName.setText(obj.getString("name"));
//                    sellerNo.setText(obj.getString("phone"));
//                    sellerPin.setText(obj.getString("pin"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(ProductPage.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }
}