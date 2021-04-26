package com.example.sarthi.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sarthi.R;
import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class RegisterFragment extends Fragment {

    private EditText etEmail, etPass, etName, etNumber, etPincode;
    private Spinner userType;
    private CheckBox logCheck;

    private MaterialButton registerBtn;

    private ViewGroup root;

    private LinearLayout locationMark;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        root = (ViewGroup) inflater.inflate(R.layout.fragment_register, container,false);
        initViews();

        userType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    locationMark.setVisibility(View.GONE);
                }else{
                    locationMark.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Objects.requireNonNull(getActivity()).getApplicationContext(), userType.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                if(userType.getSelectedItem().toString().equals("Seller")){
//                    Intent intent = new Intent(getActivity().getApplicationContext(),SellerHome.class);
//                    startActivity(intent);
                }else{
//                    Intent intent = new Intent(getActivity().getApplicationContext(),CustomerHome.class);
//                    startActivity(intent);
                }
            }
        });

        return root;
    }

    private void initViews() {
        etEmail=root.findViewById(R.id.et_email);
        etName=root.findViewById(R.id.et_name);
        etPass=root.findViewById(R.id.et_pass);
        etNumber=root.findViewById(R.id.et_phone);
        etPincode=root.findViewById(R.id.et_pincode);

        userType = root.findViewById(R.id.user_type);
        logCheck = root.findViewById(R.id.log_check);

        registerBtn = root.findViewById(R.id.register_btn);

        locationMark = root.findViewById(R.id.locationMarker);
    }
}