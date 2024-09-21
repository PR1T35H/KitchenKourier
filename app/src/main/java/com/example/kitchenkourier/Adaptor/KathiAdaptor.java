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
import com.example.kitchenkourier.Activity.ShowDetailActivity;
import com.example.kitchenkourier.Domain.FoodDomain;
import com.example.kitchenkourier.Domain.KathiDomain;
import com.example.kitchenkourier.R;

import java.util.ArrayList;


public class KathiAdaptor extends RecyclerView.Adapter<KathiAdaptor.ViewHolder> {
    ArrayList<KathiDomain> kathiFood;

    public KathiAdaptor(ArrayList<KathiDomain> kathiFood) {
        this.kathiFood=kathiFood;
    }

    @Override
    public KathiAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_kathi,parent,false);
        return new KathiAdaptor.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull KathiAdaptor.ViewHolder holder, int position) {
        holder.title.setText(kathiFood.get(position).getTitle());
        holder.feeEachItem.setText(String.valueOf(kathiFood.get(position).getFee()));


        int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(kathiFood.get(position).getPic(), "drawable",holder.itemView.getContext().getPackageName());

        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.pic);

        holder.cardView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.anim_one));



        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), MenuDetailActivity.class);
                intent.putExtra("object",kathiFood.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });


    }


    @Override
    public int getItemCount() {
        return kathiFood.size();
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
