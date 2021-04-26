package com.example.sarthi.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.sarthi.R;
import com.google.android.material.button.MaterialButton;

public class LoginFragment extends Fragment {

    private EditText etEmail, etPass;
    private Spinner userType;
    private CheckBox logCheck;
    private MaterialButton loginBtn;

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
        etEmail = root.findViewById(R.id.et_email);
        etPass = root.findViewById(R.id.et_pass);
        userType = root.findViewById(R.id.user_type);
        logCheck = root.findViewById(R.id.log_check);
        loginBtn = root.findViewById(R.id.login_btn);

    }

}