package com.example.kitchenkourier.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.example.kitchenkourier.Domain.ApplicationClass;
import com.example.kitchenkourier.Domain.ProfileDomain;
import com.example.kitchenkourier.Helper.ManagementCart;
import com.example.kitchenkourier.R;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class TakeAwayActivity extends AppCompatActivity {
    private LottieAnimationView lottie;
    private ManagementCart managementCart;
    private TextView totaltxt,name,phNum,submitBtn;
    private double tax;

    DatabaseReference databaseUser;
    String userName;
    String userPhoneNum;

    @Override
    protected void onStart() {
        super.onStart();

        name=findViewById(R.id.textView50);
        phNum=findViewById(R.id.textView51);;

        databaseUser= FirebaseDatabase.getInstance("https://kitchenkourier-d9758-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("users");

        Query lastQuery=databaseUser.limitToLast(1);

        lastQuery.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot childSnapshot: snapshot.getChildren()){
                    userName=childSnapshot.child("userName").getValue(String.class);
                    userPhoneNum=childSnapshot.child("userNumnber").getValue(String.class);
                }
                if(userName==null || userPhoneNum==null){
                    name.setText("Name: ");
                    phNum.setText("Phone: ");
                }
                else{
                    name.setText("Name: "+userName);
                    phNum.setText("Phone: "+userPhoneNum);
                }
                ApplicationClass.myAppsBundle.putString("otpNumber",userPhoneNum);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(TakeAwayActivity.this, "Sorry", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_away);
        databaseUser= FirebaseDatabase.getInstance("https://kitchenkourier-d9758-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("users");

        managementCart=new ManagementCart(this);
        totaltxt=findViewById(R.id.textView52);

        int temp=0;
        double percentTax=0.04;
        double delivery=30;
        tax=Math.round((managementCart.getTotalFee(temp)*percentTax)*100)/100;
        double total=Math.round((managementCart.getTotalFee(temp)+tax+delivery)*100)/100;

        total=total-30;

        totaltxt.setText("Total: Rs "+total);
        String totalTxt=String.valueOf(total);
        ApplicationClass.myAppsBundle.putString("total",totalTxt);

        Random rand = new Random();
        int min = 1000;
        int max = 9999;
        int randomNum = rand.nextInt((max - min) + 1) + min;
        String otp=String.valueOf(randomNum);
        ApplicationClass.myAppsBundle.putString("otp",otp);


        bottomNavigation();

        submitBtn=findViewById(R.id.submitBtn3);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TakeAwayActivity.this,OrderPlacedActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });

    }

    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.cartBtn);
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        ImageView backButton=findViewById(R.id.imageView41);
        LinearLayout profileBtn=findViewById(R.id.profile);
        LinearLayout settingsBtn=findViewById(R.id.settings);
        LinearLayout supportBtn=findViewById(R.id.support);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TakeAwayActivity.this,CartListActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TakeAwayActivity.this,MainActivity.class));
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
                startActivity(new Intent(TakeAwayActivity.this,SettingsActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TakeAwayActivity.this,ProfileActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
        supportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TakeAwayActivity.this,SupportQueryActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
    }
}