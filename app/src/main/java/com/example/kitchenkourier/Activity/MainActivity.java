package com.example.kitchenkourier.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.example.kitchenkourier.Adaptor.PoplurarAdaptor;
import com.example.kitchenkourier.Domain.DetailsDomain;
import com.example.kitchenkourier.Domain.FoodDomain;
import com.example.kitchenkourier.Domain.KathiDomain;
import com.example.kitchenkourier.Domain.QuenchDomain;
import com.example.kitchenkourier.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView  recyclerViewPopularList;
    private DetailsDomain object;
    private TextView greeting,offersBtn;
    private  ImageView profileIcon;
    private LottieAnimationView lottie,lottie1;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lottie=findViewById(R.id.lottie1);
        lottie.setRepeatCount(LottieDrawable.INFINITE);
        lottie.playAnimation();


        greeting=findViewById(R.id.textView2);

        Intent receiverIntent=getIntent();
        String receivedValue=receiverIntent.getStringExtra("KEY_SENDER");

        if(receivedValue==null){
            greeting.setText("Hungry?");
        }
        else{
            greeting.setText("Hey "+receivedValue);
        }

        RecyclerViewPopular();
        bottomNavigation();
        Menu();

        profileIcon=findViewById(R.id.imageView10);

        profileIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ProfileActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });


    }

    private void Menu(){
        ImageView kathiButton;
        kathiButton=findViewById(R.id.categoryPic1);

        kathiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,KathiHouseActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
        ImageView quenchButton=findViewById(R.id.categoryPic2);
        quenchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,QuenchActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
        ImageView hotspotButton=findViewById(R.id.categoryPic3);
        hotspotButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,HotspotActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
        ImageView kitchenButton=findViewById(R.id.categoryPic4);
        kitchenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,NonVegKitchenActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });

    }
    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.cartBtn);
        LinearLayout profileBtn=findViewById(R.id.profile);
        LinearLayout settingsBtn=findViewById(R.id.settings);
        LinearLayout supportBtn=findViewById(R.id.support);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,CartListActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });

        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SettingsActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,ProfileActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
        supportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,SupportQueryActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });


    }

    private  void RecyclerViewPopular(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewPopularList= findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodList=new ArrayList<>();
        foodList.add(new FoodDomain("Aloo Paratha","aloop","Get ready for a flavor-packed adventure with every bite of the ultimate comfort food: Aloo Paratha!",45.00));
        foodList.add(new FoodDomain("Veg-Noodles","vegn","Noodles: The versatile and delicious strands that always satisfy your cravings, no matter how you slurp them!",120.00));
        foodList.add(new FoodDomain("Chole Bhature","choleb","Indulge in the ultimate North Indian comfort food: fluffy fried bread paired with spicy chickpea curry - the unbeatable Chole Bhature!",75.00));
        foodList.add(new FoodDomain("Chilli Potato","chillp","Crispy potatoes tossed in a fiery chilli sauce, delivering a spicy and savory explosion in every bite - that's chilli potato for you!",140.00));
        foodList.add(new FoodDomain("Cheesy Maharaja Burger","pop_2","Indulge in royalty with every bite of our Cheesy Maharaja Burger - a deliciously cheesy and flavorful experience fit for a king!",110.00));
        foodList.add(new FoodDomain("Peri-Peri with Mayo","peri2","Get ready for a flavor explosion with our peri-peri fries dipped in smooth and zesty mayo!",60.00));
        foodList.add(new FoodDomain("Paneer Wrap","pan","Indulge in a flavorful adventure with our Paneer Wrap - a mouthwatering blend of tender paneer, fresh veggies, and zesty sauces, all wrapped up in a warm, soft tortilla.",90.00));
        foodList.add(new FoodDomain("Paneer Tikka Sub","paneer","Indulge in the sizzling sensation of spicy marinated paneer, grilled to perfection and served in a soft, warm sub - a taste explosion in every bite with Paneer Tikka Sub!",110.00));
        foodList.add(new FoodDomain("Choc-Oreo Shake","oreos","Satisfy your sweet cravings with our sinfully delicious Choco Oreo shake, blending rich chocolate and crunchy Oreos into one heavenly sip.",75.00));
        foodList.add(new FoodDomain("Double Maggie","doublem","Spice up your life with Double Masala Maggie, the ultimate noodle experience for those who like it spicy!",45.00));
        foodList.add(new FoodDomain("Peri-Peri Maggie","peri","Get ready to unleash your taste buds with Peri Peri Maggie, the perfect blend of tangy and hot that will leave you craving for more!",55.00));
        foodList.add(new FoodDomain("Hot Chocolate","hotc","Wrap your hands around a warm mug of hot chocolate and let the velvety sweetness melt away your worries.",45.00));
        foodList.add(new FoodDomain("Café Mocha","cafem","Start your day with a little indulgence - sip on a rich and decadent cafe mocha, the perfect marriage of espresso and chocolate.",45.00));


        adapter2=new PoplurarAdaptor(foodList);
        recyclerViewPopularList.setAdapter(adapter2);
    }
}