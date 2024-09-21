package com.example.kitchenkourier.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.kitchenkourier.Adaptor.KathiAdaptor;
import com.example.kitchenkourier.Adaptor.QuenchAdaptor;
import com.example.kitchenkourier.Domain.QuenchDomain;
import com.example.kitchenkourier.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class QuenchActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerViewMenu;
    private RecyclerView.Adapter adapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quench);

        recyclerViewMenu();
        bottomNavigation();
    }
    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.cartBtn);
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        ImageView backButton=findViewById(R.id.imageView17);
        LinearLayout profileBtn=findViewById(R.id.profile);
        LinearLayout settingsBtn=findViewById(R.id.settings);
        LinearLayout supportBtn=findViewById(R.id.support);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuenchActivity.this,CartListActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuenchActivity.this,MainActivity.class));
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
                startActivity(new Intent(QuenchActivity.this,SettingsActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuenchActivity.this,ProfileActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
        supportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(QuenchActivity.this,SupportQueryActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });

    }
    private void recyclerViewMenu(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerViewMenu=findViewById(R.id.recyclerViewId);
        recyclerViewMenu.setLayoutManager(linearLayoutManager);

        ArrayList<QuenchDomain> quenchlist=new ArrayList<>();
        quenchlist.add(new QuenchDomain("Bechara Aloo Burger","aloob",50.00));
        quenchlist.add(new QuenchDomain("Spicy Chilli Lava Burger","spicyb",60.00));
        quenchlist.add(new QuenchDomain("Achari Burger","acharib",60.00));
        quenchlist.add(new QuenchDomain("Schezwan Burger","schezb",60.00));
        quenchlist.add(new QuenchDomain("Simply Veggie Burger","simpleb",60.00));
        quenchlist.add(new QuenchDomain("Tandoori Crispy Burger","tandoorib",65.00));
        quenchlist.add(new QuenchDomain("Crunchy Paneer Burger","paneerb",80.00));
        quenchlist.add(new QuenchDomain("Cheesy Maharaja Burger","pop_2",110.00));
        quenchlist.add(new QuenchDomain("Classic with Ketchup","classic1",110.00));
        quenchlist.add(new QuenchDomain("Classic with Mayo","classic2",50.00));
        quenchlist.add(new QuenchDomain("Peri-Peri with Ketchup","peri1",55.00));
        quenchlist.add(new QuenchDomain("Peri-Peri with Mayo","peri2",60.00));
        quenchlist.add(new QuenchDomain("Thousand Island","thousand",65.00));
        quenchlist.add(new QuenchDomain("Cheese n Chilli","cheese",65.00));
        quenchlist.add(new QuenchDomain("Jalapeno n Cheese","jala",70.00));
        quenchlist.add(new QuenchDomain("Say Cheese","say",70.00));
        quenchlist.add(new QuenchDomain("Fire-n-Cheese","fire",75.00));
        quenchlist.add(new QuenchDomain("Mexican Salsa","mexican",80.00));
        quenchlist.add(new QuenchDomain("Veg Delight","veg",90.00));
        quenchlist.add(new QuenchDomain("Corn-N-Peas","corn",90.00));
        quenchlist.add(new QuenchDomain("Hara-Bara Kebab","hara",110.00));
        quenchlist.add(new QuenchDomain("Paneer Tikka","paneer",110.00));
        quenchlist.add(new QuenchDomain("Arriabiata Pasta","arra",90.00));
        quenchlist.add(new QuenchDomain("Alfredo Pasta","alfredo",90.00));
        quenchlist.add(new QuenchDomain("Pink-Sauce Pasta","pink",90.00));
        quenchlist.add(new QuenchDomain("Aloo-Tikki Wrap","aloo",70.00));
        quenchlist.add(new QuenchDomain("Veggie Wrap","veggie",80.00));
        quenchlist.add(new QuenchDomain("Paneer Wrap","pan",90.00));
        quenchlist.add(new QuenchDomain("Mexican Salsa Wrap","mexican1",90.00));
        quenchlist.add(new QuenchDomain("Choco Waffle","choco",70.00));
        quenchlist.add(new QuenchDomain("Caramel Waffle","caramel",70.00));
        quenchlist.add(new QuenchDomain("Strawberry Waffle","straw",70.00));
        quenchlist.add(new QuenchDomain("Maple Waffle","maple",80.00));
        quenchlist.add(new QuenchDomain("Choco Oreo Waffle","oreo",90.00));
        quenchlist.add(new QuenchDomain("Nutella Waffle","nutella",95.00));
        quenchlist.add(new QuenchDomain("Banana Shake","banana",50.00));
        quenchlist.add(new QuenchDomain("Mango Shake","mango",60.00));
        quenchlist.add(new QuenchDomain("Chocolate Shake","chocos",60.00));
        quenchlist.add(new QuenchDomain("Cold Cofee Shake","cold",65.00));
        quenchlist.add(new QuenchDomain("Bubble-Gum Shake","gum",65.00));
        quenchlist.add(new QuenchDomain("Choc-Oreo Shake","oreos",75.00));
        quenchlist.add(new QuenchDomain("Kitkat Shake","kitkat",75.00));
        quenchlist.add(new QuenchDomain("Spicy Mango","spicy",65.00));
        quenchlist.add(new QuenchDomain("Mint Mojito","mint",65.00));
        quenchlist.add(new QuenchDomain("Green Apple Mojito","green",65.00));
        quenchlist.add(new QuenchDomain("Bloody Orange","orange",65.00));
        quenchlist.add(new QuenchDomain("Paan Mojito","paan",65.00));
        quenchlist.add(new QuenchDomain("Blue Curacko","blue",65.00));
        quenchlist.add(new QuenchDomain("Watermelon Juice","watermelon",50.00));
        quenchlist.add(new QuenchDomain("Pineapple Juice","pine",70.00));
        quenchlist.add(new QuenchDomain("Orange/Mosambi Juice","mosambi",65.00));
        quenchlist.add(new QuenchDomain("Apple Juice","apple",80.00));
        quenchlist.add(new QuenchDomain("Pomergranate Juice","pom",90.00));




        adapter3=new QuenchAdaptor(quenchlist);
        recyclerViewMenu.setAdapter(adapter3);
    }
}