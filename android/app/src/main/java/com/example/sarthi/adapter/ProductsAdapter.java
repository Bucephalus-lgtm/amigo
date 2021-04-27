package com.example.sarthi.adapter;

import android.content.Context;
import android.content.Intent;
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
import com.example.sarthi.model.ProductModel;
import com.example.sarthi.ui.ProductPage;
import com.google.android.material.card.MaterialCardView;

import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    private List<ProductModel> itemlist;
    private Context mContext;

    public ProductsAdapter(List<ProductModel> productModelList, Context context) {
        this.itemlist=productModelList;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ProductsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsAdapter.ViewHolder holder, int position) {
        holder.name.setText(itemlist.get(position).getName());
        holder._id.setText(itemlist.get(position).getSellerId());
        holder.price.setText("Rs. "+String.valueOf(itemlist.get(position).getPrice()));
        holder.type.setText(itemlist.get(position).getCategory());

        Glide.with(mContext).load(itemlist.get(position).getImg_url()).into(holder.img);

        holder.productCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ProductPage.class);
                intent.putExtra("_id",itemlist.get(position).getSellerId());
//                Toast.makeText(mContext, itemlist.get(position).getSellerId(), Toast.LENGTH_SHORT).show();
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return itemlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        MaterialCardView productCard;
        TextView name,price,type,_id;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.ProductName);
            price = itemView.findViewById(R.id.Productprice);
            type = itemView.findViewById(R.id.ProductType);
            _id= itemView.findViewById(R.id.Seller_id);
            img = itemView.findViewById(R.id.product_img);

            productCard = itemView.findViewById(R.id.productcard);
        }
    }
}
