package com.example.sarthi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sarthi.R;
import com.example.sarthi.model.MyProductModel;
import com.example.sarthi.model.SellerItemsModel;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class MyProductAdapter extends RecyclerView.Adapter<MyProductAdapter.ViewHolder> {
    List<MyProductModel> itemlist;
    Context mContext;

    public MyProductAdapter(List<MyProductModel> itemlist, Context applicationContext) {
        this.itemlist=itemlist;
        this.mContext=applicationContext;

    }

    @NonNull
    @Override
    public MyProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_product_item,parent,false);
        return new MyProductAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyProductAdapter.ViewHolder holder, int position) {
        holder.productId.setText(itemlist.get(position).getProduct_id());
        holder.name.setText(itemlist.get(position).getName());
        holder.price.setText(itemlist.get(position).getPrice());
        holder.type.setText(itemlist.get(position).getType());
        Glide.with(mContext).load(itemlist.get(position).getImg_url()).into(holder.image);


    }

    @Override
    public int getItemCount() {
        return itemlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,price,type,productId;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.myProductName);
            price = itemView.findViewById(R.id.myProductprice);
            type = itemView.findViewById(R.id.myProductType);
            productId = itemView.findViewById(R.id.myProduct_id);

            image = itemView.findViewById(R.id.my_product_img);
        }
    }
}
