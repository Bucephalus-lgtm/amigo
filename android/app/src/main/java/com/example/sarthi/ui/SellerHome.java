package com.example.sarthi.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.sarthi.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SellerHome extends AppCompatActivity {

    private ChipNavigationBar cnbSeller;
    private String _id,POSTNAME,POSTPRICE,POSTTYPE;
    private FloatingActionButton upload;

    private ImageView postImage;

    private MaterialButton btn_submit;
    private EditText postName, postPrice;

    private Window window;
    public static final int CAMERA_PERM_CODE = 101;
    public static final int CAMERA_REQUEST_CODE = 102;
    public static final int GALLERY_REQUEST_CODE = 105;
    Uri contentUri;
    String encodedImageStr;

    Bitmap bitmap;

    Spinner postType;

    String uploadApi = "https://sarthiapi.herokuapp.com/api/upload";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_home);

        _id = getIntent().getStringExtra("_id");
        cnbSeller = findViewById(R.id.cnb_seller);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_seller,new MyProductsFragment()).commit();
        cnbSeller.setItemSelected(R.id.bottom_nav_home,true);
        bottomMenu();

        upload = findViewById(R.id.upload);


        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadPost();
            }
        });

    }

    private void uploadPost() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_post);
        postImage = (ImageView)dialog.findViewById(R.id.uploadProductImage);
        dialog.setCancelable(true);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(dialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        btn_submit = dialog.findViewById(R.id.bt_upload);

        postName = (EditText) dialog.findViewById(R.id.post_name);
        postPrice = dialog.findViewById(R.id.post_price);
        postType = dialog.findViewById(R.id.postType);



        btn_submit.setOnClickListener(v -> {
//            Toast.makeText(getApplicationContext(),"Button Pressed",Toast.LENGTH_SHORT).show();
            uploadToDb();
            dialog.dismiss();
//            Toast.makeText(getApplicationContext(), "Post Submitted", Toast.LENGTH_SHORT).show();
        });

        dialog.findViewById(R.id.bt_photo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                askCameraPermissions();
            }
        });

        dialog.findViewById(R.id.bt_link).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(gallery, GALLERY_REQUEST_CODE);
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(lp);


    }

    private void uploadToDb() {
        if(validate()){
            POSTNAME = postName.getText().toString();
            POSTPRICE = postPrice.getText().toString();
            if(postType.getSelectedItem().toString().equals("Vegetables")) POSTTYPE = "vegetable";
            if(postType.getSelectedItem().toString().equals("Fruits")) POSTTYPE = "fruit";
            if(postType.getSelectedItem().toString().equals("Groceries")) POSTTYPE = "packet-food";
            if(postType.getSelectedItem().toString().equals("Non Veg")) POSTTYPE = "non-veg";
            Log.d("-------------------",encodedImageStr);
            StringRequest stringRequest = new StringRequest(Request.Method.POST, uploadApi, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Toast.makeText(SellerHome.this, response, Toast.LENGTH_SHORT).show();

                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(SellerHome.this, error.getMessage(), Toast.LENGTH_SHORT).show();

                }
            }){
                @Override
                protected Map<String,String> getParams() throws AuthFailureError{
                    Map<String,String> map = new HashMap<>();
                    map.put("name",POSTNAME);
                    map.put("seller",_id);
                    map.put("price",POSTPRICE);
                    map.put("category",POSTTYPE);
                    map.put("image",encodedImageStr);
                    return map;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);

        }


    }

    private boolean validate() {
        boolean isValid;
        if(!postName.getText().toString().equals(null)){
            if(!postPrice.getText().toString().equals(null)){
                isValid = true;
            }else{
                isValid=false;
                Toast.makeText(this, "Enter Price", Toast.LENGTH_SHORT).show();
            }
        }else{
            isValid = false;
            Toast.makeText(this, "Enter Name", Toast.LENGTH_SHORT).show();
        }
        return isValid;
    }

    private void askCameraPermissions() {
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.CAMERA}, CAMERA_PERM_CODE);
        }else {
//            dispatchTakePictureIntent();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == CAMERA_PERM_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                dispatchTakePictureIntent();
            }else {
                Toast.makeText(this, "Camera Permission is Required to Use camera.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
//                Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
//                contentUri = Uri.fromFile(f);
//                mediaScanIntent.setData(contentUri);
//                this.sendBroadcast(mediaScanIntent);
            }
        }
        if (requestCode == GALLERY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                contentUri = data.getData();
                try {
                    InputStream inputStream = getContentResolver().openInputStream(contentUri);
                    bitmap = BitmapFactory.decodeStream(inputStream);
                    postImage.setImageBitmap(bitmap);
                    encodeBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
//                String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//                imageFileName = "JPEG_" + timeStamp + "." + getFileExt(contentUri);
//                Log.d("tag", "onActivityResult: Gallery Image Uri: " + imageFileName);
//                postImage.setImageURI(contentUri);
            }
        }
    }

    private void encodeBitmap(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);

        byte[] bytes = byteArrayOutputStream.toByteArray();
        encodedImageStr = android.util.Base64.encodeToString(bytes,Base64.DEFAULT);
    }




    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    private void bottomMenu() {
        cnbSeller.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            Fragment fragment=null;
            @Override
            public void onItemSelected(int i) {
                switch (i){
                    case R.id.bottom_nav_home:
                        fragment = new MyProductsFragment();
                        break;
                    case R.id.bottom_nav_lists:
                        fragment = new MyOrdersFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_seller,fragment).commit();
            }
        });
    }
}