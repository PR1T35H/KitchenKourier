package com.example.kitchenkourier.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitchenkourier.Adaptor.KathiAdaptor;
import com.example.kitchenkourier.Adaptor.NonVegKitchenAdaptor;
import com.example.kitchenkourier.Domain.KathiDomain;
import com.example.kitchenkourier.Domain.NonVegKitchenDomain;
import com.example.kitchenkourier.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class NonVegKitchenActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewMenu;
    private RecyclerView.Adapter adapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_veg_kitchen);

        recyclerViewMenu();
        bottomNavigation();
    }
    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.cartBtn);
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        ImageView backButton=findViewById(R.id.imageView14);
        LinearLayout profileBtn=findViewById(R.id.profile);
        LinearLayout settingsBtn=findViewById(R.id.settings);
        LinearLayout supportBtn=findViewById(R.id.support);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NonVegKitchenActivity.this,CartListActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NonVegKitchenActivity.this,MainActivity.class));
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
                startActivity(new Intent(NonVegKitchenActivity.this,SettingsActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NonVegKitchenActivity.this,ProfileActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
        supportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NonVegKitchenActivity.this,SupportQueryActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });

    }
    private void recyclerViewMenu(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewMenu=findViewById(R.id.recyclerViewId);
        recyclerViewMenu.setLayoutManager(linearLayoutManager);

        ArrayList<NonVegKitchenDomain> kitchenlist=new ArrayList<>();
        kitchenlist.add(new NonVegKitchenDomain("Tandoori Chicken","tandoori",341.00));
        kitchenlist.add(new NonVegKitchenDomain("Afgani Chicken","afgani",341.00));
        kitchenlist.add(new NonVegKitchenDomain("Chicken Tikka","tikkac",341.00));
        kitchenlist.add(new NonVegKitchenDomain("Chicken Malai Tikka","tikkam",341.00));
        kitchenlist.add(new NonVegKitchenDomain("Chicken Seekh Kebab","seekhc",341.00));
        kitchenlist.add(new NonVegKitchenDomain("Mutton Seekh Kebab","seekhm",341.00));
        kitchenlist.add(new NonVegKitchenDomain("Paneer Tikka","tikkap",358.00));
        kitchenlist.add(new NonVegKitchenDomain("Malai Chaap","chaapm",266.00));
        kitchenlist.add(new NonVegKitchenDomain("Tandoori Chaap","chaapt",266.00));
        kitchenlist.add(new NonVegKitchenDomain("Mutton Seekh Masala","mseekhm",358.00));
        kitchenlist.add(new NonVegKitchenDomain("Mutton Curry","currym",323.00));
        kitchenlist.add(new NonVegKitchenDomain("Mutton Rara","raram",300.00));
        kitchenlist.add(new NonVegKitchenDomain("Fish Tikka","fisht",474.00));
        kitchenlist.add(new NonVegKitchenDomain("Fish Fry","fishf",474.00));
        kitchenlist.add(new NonVegKitchenDomain("Chicken Tikka Masala","tikkacm",341.00));
        kitchenlist.add(new NonVegKitchenDomain("Chicken Curry","curryc",341.00));
        kitchenlist.add(new NonVegKitchenDomain("Chicken Rara Punjabi","rarac",341.00));
        kitchenlist.add(new NonVegKitchenDomain("Chicken Lababdar","labc",341.00));
        kitchenlist.add(new NonVegKitchenDomain("Butter Chicken","chickenb",341.00));
        kitchenlist.add(new NonVegKitchenDomain("Kadhai Chicken","chickenk",341.00));
        kitchenlist.add(new NonVegKitchenDomain("Chicken Korma","chickenkor",341.00));
        kitchenlist.add(new NonVegKitchenDomain("Chicken Seekh Masala","cseekhm",341.00));
        kitchenlist.add(new NonVegKitchenDomain("Dal Makhani","dalm",243.00));
        kitchenlist.add(new NonVegKitchenDomain("Paneer Butter Masala","paneerbm",277.00));
        kitchenlist.add(new NonVegKitchenDomain("Paneer Lababdar","paneerl",277.00));
        kitchenlist.add(new NonVegKitchenDomain("Paneer Dhania Adraki","paneerd",277.00));
        kitchenlist.add(new NonVegKitchenDomain("Tawa Chaap","tawac",277.00));
        kitchenlist.add(new NonVegKitchenDomain("Rara Chaap","rarach",277.00));
        kitchenlist.add(new NonVegKitchenDomain("Chicken Soup","soupc",127.00));
        kitchenlist.add(new NonVegKitchenDomain("Chicken Wings","wingsc",323.00));
        kitchenlist.add(new NonVegKitchenDomain("Chicken Steam Momo","momoc",150.00));
        kitchenlist.add(new NonVegKitchenDomain("Tandoori Chicken Momo","momoct",173.00));
        kitchenlist.add(new NonVegKitchenDomain("Kurkure Chicken Momo","momock",173.00));
        kitchenlist.add(new NonVegKitchenDomain("Chicken Lollypop","lolly",323.00));
        kitchenlist.add(new NonVegKitchenDomain("Chicken Fried Rice","friedrc",254.00));
        kitchenlist.add(new NonVegKitchenDomain("Chicken Noodles","noodlec",266.00));
        kitchenlist.add(new NonVegKitchenDomain("Veg Fried Rice ","friedveg",231.00));
        kitchenlist.add(new NonVegKitchenDomain("Veg Noodles","noodleveg",231.00));
        kitchenlist.add(new NonVegKitchenDomain("Chilli Chicken Dry","ccdry",300.00));
        kitchenlist.add(new NonVegKitchenDomain("Chilli Chicken Gravy","ccgravy",300.00));
        kitchenlist.add(new NonVegKitchenDomain("Lemon Chicken Dry","lemond",300.00));
        kitchenlist.add(new NonVegKitchenDomain("Lemon Chicken Gravy","lemong",300.00));
        kitchenlist.add(new NonVegKitchenDomain("Chilli Paneer Dry","cpdry",254.00));
        kitchenlist.add(new NonVegKitchenDomain("Chilli Paneer Gravy","cpgravy",254.00));
        kitchenlist.add(new NonVegKitchenDomain("Chilli Chaap Dry","chaapdry",254.00));
        kitchenlist.add(new NonVegKitchenDomain("Chilli Chaap Gravy","chaapgravy",254.00));



        adapter3=new NonVegKitchenAdaptor(kitchenlist);

        recyclerViewMenu.setAdapter(adapter3);
    }
}