package com.example.kitchenkourier.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kitchenkourier.Adaptor.CartListAdapter;
import com.example.kitchenkourier.Adaptor.KathiAdaptor;
import com.example.kitchenkourier.Domain.KathiDomain;
import com.example.kitchenkourier.Interface.ChangeNumberItemsListener;
import com.example.kitchenkourier.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class KathiHouseActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewMenu;
    private RecyclerView.Adapter adapter3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kathi_house);

        recyclerViewMenu();
        bottomNavigation();



    }
    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.cartBtn);
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        ImageView backButton=findViewById(R.id.imageView13);
        LinearLayout profileBtn=findViewById(R.id.profile);
        LinearLayout settingsBtn=findViewById(R.id.settings);
        LinearLayout supportBtn=findViewById(R.id.support);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KathiHouseActivity.this,CartListActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KathiHouseActivity.this,MainActivity.class));
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KathiHouseActivity.this,SettingsActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KathiHouseActivity.this,ProfileActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
        supportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(KathiHouseActivity.this,SupportQueryActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
    }

    private void recyclerViewMenu(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewMenu=findViewById(R.id.recyclerViewId);
        recyclerViewMenu.setLayoutManager(linearLayoutManager);

        ArrayList<KathiDomain> kathiList=new ArrayList<>();
        kathiList.add(new KathiDomain("Aloo Paratha","aloop",45.00));
        kathiList.add(new KathiDomain("Aloo-Pyaz Paratha","pyazp",55.00));
        kathiList.add(new KathiDomain("Egg Paratha","eggp",55.00));
        kathiList.add(new KathiDomain("Veg-Noodles","vegn",120.00));
        kathiList.add(new KathiDomain("Egg-Noodles","eggn",140.00));
        kathiList.add(new KathiDomain("Veg-Fried Rice","vegfr",120.00));
        kathiList.add(new KathiDomain("Egg-Fried Rice","eggfr",140.00));
        kathiList.add(new KathiDomain("Chole Bhature","choleb",75.00));
        kathiList.add(new KathiDomain("Chole Kulcha","cholek",65.00));
        kathiList.add(new KathiDomain("Pav Bhaji","pavb",65.00));
        kathiList.add(new KathiDomain("Bread Omelette","breado",60.00));
        kathiList.add(new KathiDomain("Plain Omelette","plaino",40.00));
        kathiList.add(new KathiDomain("Massala Omelette","massalao",50.00));
        kathiList.add(new KathiDomain("Chilli Potato","chillp",140.00));
        kathiList.add(new KathiDomain("Honey-Chilli Potato","honeyp",150.00));
        kathiList.add(new KathiDomain("Chilli Paneer","chillipan",160.00));
        kathiList.add(new KathiDomain("Poori Sabji","pooris",45.00));
        kathiList.add(new KathiDomain("White-Suace Pasta","whitepas",80.00));
        kathiList.add(new KathiDomain("Red-Suace Pasta","redpas",99.00));



        adapter3=new KathiAdaptor(kathiList);

        recyclerViewMenu.setAdapter(adapter3);
    }

}