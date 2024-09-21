package com.example.kitchenkourier.Adaptor;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.kitchenkourier.Activity.MenuDetailActivity;
import com.example.kitchenkourier.Activity.NonVegKitchenMenuDetailActivity;
import com.example.kitchenkourier.Domain.NonVegKitchenDomain;
import com.example.kitchenkourier.R;

import java.util.ArrayList;


public class NonVegKitchenAdaptor extends RecyclerView.Adapter<NonVegKitchenAdaptor.ViewHolder> {
    ArrayList<NonVegKitchenDomain> kitchenfood;

    public NonVegKitchenAdaptor(ArrayList<NonVegKitchenDomain> kitchenfood) {
        this.kitchenfood =kitchenfood;
    }

    @Override
    public NonVegKitchenAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_nonvegkitchen,parent,false);
        return new NonVegKitchenAdaptor.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull NonVegKitchenAdaptor.ViewHolder holder, int position) {
        holder.title.setText(kitchenfood.get(position).getTitle());
        holder.feeEachItem.setText(String.valueOf(kitchenfood.get(position).getFee()));

        int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(kitchenfood.get(position).getPic(), "drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.anim_one));

        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), NonVegKitchenMenuDetailActivity.class);
                intent.putExtra("object", kitchenfood.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return kitchenfood.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, feeEachItem,addBtn;
        ImageView pic;
        ConstraintLayout cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.titleTxt);
            feeEachItem=itemView.findViewById(R.id.feeEachItem);
            pic=itemView.findViewById(R.id.picCart);
            addBtn=itemView.findViewById(R.id.addBtn3);
            cardView=itemView.findViewById(R.id.cardView);
        }
    }
}
