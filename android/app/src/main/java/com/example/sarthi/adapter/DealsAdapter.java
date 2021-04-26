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
import com.example.sarthi.model.DealsModel;

import java.util.List;

public class DealsAdapter extends RecyclerView.Adapter<DealsAdapter.ViewHolder> {

    private List<DealsModel> itemList;
    private Context mContext;
    public DealsAdapter(List<DealsModel> deals, Context mContext) {
        this.itemList=deals;
        this.mContext=mContext;
    }

    @NonNull
    @Override
    public DealsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.deal_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DealsAdapter.ViewHolder holder, int position) {
        holder.name.setText(itemList.get(position).getName());
        holder.category.setText(itemList.get(position).getCategory());
        holder.price.setText("Rs. "+String.valueOf(itemList.get(position).getPrice()));
        Glide.with(mContext).load(itemList.get(position).getImg_url())
                .into(holder.img);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name,category,price;
        ImageView img;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.deal_name);
            category = itemView.findViewById(R.id.deal_type);
            img = itemView.findViewById(R.id.deal_img);
            price = itemView.findViewById(R.id.deals_price);
        }
    }
}
