package com.example.kitchenkourier.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitchenkourier.Adaptor.HotspotAdaptor;
import com.example.kitchenkourier.Adaptor.KathiAdaptor;
import com.example.kitchenkourier.Domain.HotspotDomain;
import com.example.kitchenkourier.Domain.KathiDomain;
import com.example.kitchenkourier.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class HotspotActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewMenu;
    private RecyclerView.Adapter adapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotspot);

        recyclerViewMenu();
        bottomNavigation();
    }
    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.cartBtn);
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        ImageView backButton=findViewById(R.id.imageView9);
        LinearLayout profileBtn=findViewById(R.id.profile);
        LinearLayout settingsBtn=findViewById(R.id.settings);
        LinearLayout supportBtn=findViewById(R.id.support);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HotspotActivity.this,CartListActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HotspotActivity.this,MainActivity.class));
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
                startActivity(new Intent(HotspotActivity.this,SettingsActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HotspotActivity.this,ProfileActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
        supportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HotspotActivity.this,SupportQueryActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
    }

    private void recyclerViewMenu(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewMenu=findViewById(R.id.recyclerViewId);
        recyclerViewMenu.setLayoutManager(linearLayoutManager);

        ArrayList<HotspotDomain> hotspotlist=new ArrayList<>();
        hotspotlist.add(new HotspotDomain("Original Maggie","original",40.00));
        hotspotlist.add(new HotspotDomain("Double Maggie","doublem",45.00));
        hotspotlist.add(new HotspotDomain("Butter Maggie","butter",50.00));
        hotspotlist.add(new HotspotDomain("Oregano Maggie","oreganom",50.00));
        hotspotlist.add(new HotspotDomain("Atta-Masala Maggie","atta",55.00));
        hotspotlist.add(new HotspotDomain("Onion-Capsicum Maggie","onion",55.00));
        hotspotlist.add(new HotspotDomain("Peri-Peri Maggie","peri",55.00));
        hotspotlist.add(new HotspotDomain("Oats-Masala Maggie","oats",55.00));
        hotspotlist.add(new HotspotDomain("Butter Double Maggie","butterdouble",60.00));
        hotspotlist.add(new HotspotDomain("Cheese Maggie","cheesema",60.00));
        hotspotlist.add(new HotspotDomain("Butter-Garlic Maggie","buttergarlic",60.00));
        hotspotlist.add(new HotspotDomain("Schezwan Maggie","schezwan",60.00));
        hotspotlist.add(new HotspotDomain("Chilli-Garlic Maggie","chilligarlic",60.00));
        hotspotlist.add(new HotspotDomain("Manchurian Maggie","manch",60.00));
        hotspotlist.add(new HotspotDomain("Biryani Maggie","biryani",60.00));
        hotspotlist.add(new HotspotDomain("Tomato Pazzta","pasta",60.00));
        hotspotlist.add(new HotspotDomain("Cheese Macroni","macr",60.00));
        hotspotlist.add(new HotspotDomain("Onion-Cap.Butter Maggie","onioncap",70.00));
        hotspotlist.add(new HotspotDomain("Corn and Cheese Maggie","corncheese",70.00));
        hotspotlist.add(new HotspotDomain("Chilli-Gar.Cheese Maggie","chillcheese",70.00));
        hotspotlist.add(new HotspotDomain("Biryani-Masala Sweet Corn","biryanicorn",45.00));
        hotspotlist.add(new HotspotDomain("Chilli-Garlic Sweet Corn","chillcorn",45.00));
        hotspotlist.add(new HotspotDomain("Classic Chinese Sweet Corn","china",45.00));
        hotspotlist.add(new HotspotDomain("Espresso","espresso",45.00));
        hotspotlist.add(new HotspotDomain("Cardamom Tea","cardtea",45.00));
        hotspotlist.add(new HotspotDomain("Milk","milk",45.00));
        hotspotlist.add(new HotspotDomain("Masala Tea","masalatea",45.00));
        hotspotlist.add(new HotspotDomain("Cappuccino","cap",45.00));
        hotspotlist.add(new HotspotDomain("Café Latte","cafel",45.00));
        hotspotlist.add(new HotspotDomain("Ginger and Honey Tea","gingertea",45.00));
        hotspotlist.add(new HotspotDomain("Assam Tea","assamtea",45.00));
        hotspotlist.add(new HotspotDomain("Darjeeling Tea","dartea",45.00));
        hotspotlist.add(new HotspotDomain("Café Mocha","cafem",45.00));
        hotspotlist.add(new HotspotDomain("Hot Chocolate","hotc",45.00));
        hotspotlist.add(new HotspotDomain("Irish Cappuccino","irishc",45.00));
        hotspotlist.add(new HotspotDomain("Caramel Cappuccino","caramelc",45.00));
        hotspotlist.add(new HotspotDomain("Hazelnut Cappuccino","hazec",45.00));
        hotspotlist.add(new HotspotDomain("Tomato Soup","tsoup",45.00));
        hotspotlist.add(new HotspotDomain("Manchow Soup","msoup",45.00));
        hotspotlist.add(new HotspotDomain("Lemon-Iced Tea","lemonice",45.00));
        hotspotlist.add(new HotspotDomain("Masala Lemon-Iced Tea","lemonicem",45.00));
        hotspotlist.add(new HotspotDomain("Frappe","frappe",45.00));
        hotspotlist.add(new HotspotDomain("Cold Chocolate","coldc",45.00));
        hotspotlist.add(new HotspotDomain("Irish Frappe","irishf",45.00));
        hotspotlist.add(new HotspotDomain("Caramel Frappe","caramelf",45.00));
        hotspotlist.add(new HotspotDomain("Honey Frappe","honeyf",45.00));
        hotspotlist.add(new HotspotDomain("Chocolate Frappe","chocof",45.00));
        hotspotlist.add(new HotspotDomain("Hazelnut Frappe","hazlef",45.00));
        hotspotlist.add(new HotspotDomain("Cookie Frappe","cookief",45.00));
        hotspotlist.add(new HotspotDomain("Kit-Kat Frappe","kitkatf",45.00));

        adapter3=new HotspotAdaptor(hotspotlist);

        recyclerViewMenu.setAdapter(adapter3);
    }
}