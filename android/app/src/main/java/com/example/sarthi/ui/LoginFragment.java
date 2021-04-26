package com.example.sarthi.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.ServerError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.sarthi.R;
import com.google.android.material.button.MaterialButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class LoginFragment extends Fragment {

    private EditText etEmail, etPass;
    private Spinner userType;
    private CheckBox logCheck;
    private MaterialButton loginBtn;

    private String EMAIL, PASSWORD, TYPE;

    private ViewGroup root;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = (ViewGroup) inflater.inflate(R.layout.fragment_login  , container,false);
        initViews();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userType.getSelectedItem().toString().equals("Seller")){
                    TYPE="seller";
                }else{
                    TYPE="customer";
                }
                EMAIL=etEmail.getText().toString();
                PASSWORD=etPass.getText().toString();
                if(validate(v)){
                    loginUser();
                }
            }
        });
        return root;
    }

    private void loginUser() {
       final HashMap<String,String> params = new HashMap<>();
       params.put("email",EMAIL);
       params.put("password",PASSWORD);
       params.put("type",TYPE);

       String apikey = "https://sarthiapi.herokuapp.com/api/signin";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, apikey, new JSONObject(params), new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
//                        String token = response.getString("token");
                        JSONObject obj;
                        if(TYPE=="seller"){
                            obj = response.getJSONObject("seller");
                        }else{
                            obj = response.getJSONObject("customer");
                        }
                        String _id = obj.getString("_id");
//                        sharedPreferenceClass.setValue_string("token", token);
                        Toast.makeText(getActivity().getApplicationContext(),_id, Toast.LENGTH_SHORT).show();

                    Intent intent;
                    if(TYPE=="customer"){
                        intent = new Intent(getActivity().getApplicationContext(), CustomerHome.class);
                    }else{
                        intent = new Intent(getActivity().getApplicationContext(), SellerHome.class);
                    }
                    intent.putExtra("_id",_id);
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getActivity().getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                NetworkResponse response = error.networkResponse;
                if(error instanceof ServerError && response != null) {
                    try {
                        String res = new String(response.data, HttpHeaderParser.parseCharset(response.headers,  "utf-8"));
                        JSONObject obj = new JSONObject(res);
                        Toast.makeText(getActivity().getApplicationContext(), obj.getString("msg"), Toast.LENGTH_SHORT).show();
                    } catch (JSONException | UnsupportedEncodingException je) {
                        je.printStackTrace();
                    }
                }
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<>();
                headers.put("Content-Type", "application/json");
                return params;
            }
        };

        int socketTime = 3000;
        RetryPolicy policy = new DefaultRetryPolicy(socketTime,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        jsonObjectRequest.setRetryPolicy(policy);

        // request add
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity().getApplicationContext());
        requestQueue.add(jsonObjectRequest);
    }

    private boolean validate(View v) {
        boolean isValid;
        if(!TextUtils.isEmpty(EMAIL)){
            if(!TextUtils.isEmpty(PASSWORD)){
                isValid=true;
            }else{
                Toast.makeText(getActivity().getApplicationContext(), "Password is required", Toast.LENGTH_SHORT).show();
                isValid=false;
            }
        }else{
            Toast.makeText(getActivity().getApplicationContext(), "Email is required", Toast.LENGTH_SHORT).show();
            isValid=false;
        }
        return isValid;
    }

    private void initViews() {
        etEmail = root.findViewById(R.id.et_email);
        etPass = root.findViewById(R.id.et_pass);
        userType = root.findViewById(R.id.user_type);
        logCheck = root.findViewById(R.id.log_check);
        loginBtn = root.findViewById(R.id.login_btn);

    }

}