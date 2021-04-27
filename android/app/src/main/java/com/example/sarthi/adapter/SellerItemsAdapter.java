package com.example.sarthi.adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sarthi.R;
import com.example.sarthi.model.SellerItemsModel;
import com.google.android.material.button.MaterialButton;

import java.util.List;

public class SellerItemsAdapter extends RecyclerView.Adapter<SellerItemsAdapter.ViewHolder> {

    List<SellerItemsModel> itemlist;
    Context mContext;

    public SellerItemsAdapter(List<SellerItemsModel> itemlist, Context applicationContext) {
        this.itemlist=itemlist;
        this.mContext=applicationContext;

    }

    @NonNull
    @Override
    public SellerItemsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seller_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SellerItemsAdapter.ViewHolder holder, int position) {
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
        MaterialButton add;
        TextView name,price,type,productId;
        ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            add = itemView.findViewById(R.id.add_to_cart);
            name = itemView.findViewById(R.id.itemName);
            price = itemView.findViewById(R.id.pg_price);
            type = itemView.findViewById(R.id.itemType);
            productId = itemView.findViewById(R.id.sellerProduct_id);

            image = itemView.findViewById(R.id.pg_img);
        }
    }
}
