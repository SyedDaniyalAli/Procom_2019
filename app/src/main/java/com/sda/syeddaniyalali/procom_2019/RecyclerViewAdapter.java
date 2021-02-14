package com.sda.syeddaniyalali.procom_2019;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{


    private ArrayList<SocialData> mproducts;
    Context mcontext;

    RecyclerViewAdapter(Context context, ArrayList<SocialData> products)
    {
        mproducts=products;
        mcontext=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View view= LayoutInflater.from(mcontext).inflate(R.layout.custom_card, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int i) {

        viewHolder.imgImageView.setImageResource(mproducts.get(i).img);
        viewHolder.name.setText(mproducts.get(i).Name);
        viewHolder.user.setText(mproducts.get(i).UserName);
        viewHolder.desc.setText(mproducts.get(i).desc);

    }

    @Override
    public int getItemCount() {
        return mproducts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgImageView;
        TextView name, user, desc;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgImageView=itemView.findViewById(R.id.img);
            name=itemView.findViewById(R.id.tv_name);
            user=itemView.findViewById(R.id.tv_user);
            desc=itemView.findViewById(R.id.tv_details);
        }
    }
}