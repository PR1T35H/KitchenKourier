package com.example.kitchenkourier.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.kitchenkourier.Domain.ApplicationClass;
import com.example.kitchenkourier.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class OrderPlacedActivity extends AppCompatActivity {
    private TextView timetxt,otpTxt;
    Integer time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_placed);

        timetxt=findViewById(R.id.textView56);
        otpTxt=findViewById(R.id.textView55);


        if(ContextCompat.checkSelfPermission(OrderPlacedActivity.this, Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED){
            sendSMS();
        }

        else{
            ActivityCompat.requestPermissions(OrderPlacedActivity.this, new String[]{Manifest.permission.SEND_SMS},100);

        }

        String totaltxt=ApplicationClass.myAppsBundle.getString("total");

        Double total=Double.valueOf(totaltxt);

        if(total<100.0){
            time=7;
        }
        else if(total>=100.0 && total<200.0){
            time=10;
        }
        else if(total>=200.0 && total<300.0){
            time=13;
        }
        else if(total>=300.0 && total<400.0){
            time=15;
        }
        else if(total>=400.0 && total<500.0){
            time=17;
        }
        else{
            time=25;
        }
        timetxt.setText(time+" Minutes");
        String otp=ApplicationClass.myAppsBundle.getString("otp");
        otpTxt.setText(otp);

        bottomNavigation();

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==100){
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                sendSMS();
            }
            else{
                Toast.makeText(this, "death", Toast.LENGTH_SHORT).show();
            }
        }


    }
    private void sendSMS() {

        String totalTxt=ApplicationClass.myAppsBundle.getString("total");
        String otpTxt=ApplicationClass.myAppsBundle.getString("otp");
        String SMS="Thank you for Ordering from KitchenKourier. Your Order has been placed for Rs. "+totalTxt+". Use OTP: "+otpTxt+" at the time of collecting your Order.";

        String userPhoneNum= ApplicationClass.myAppsBundle.getString("otpNumber");

        if(userPhoneNum==null){
            Toast.makeText(this, "No Number", Toast.LENGTH_SHORT).show();
        }
        else{
            try{
                SmsManager smsManager=SmsManager.getDefault();

                smsManager.sendTextMessage(userPhoneNum,null, SMS,null,null);
            }catch (Exception e){
                e.printStackTrace();
                Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show();
            }
        }

    }
    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.cartBtn);
        LinearLayout homeBtn=findViewById(R.id.homeBtn);

        LinearLayout profileBtn=findViewById(R.id.profile);
        LinearLayout settingsBtn=findViewById(R.id.settings);
        LinearLayout supportBtn=findViewById(R.id.support);

        TextView feedBackBtn=findViewById(R.id.feedbackBtn);

        feedBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrderPlacedActivity.this,SupportFeedbackActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrderPlacedActivity.this,CartListActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrderPlacedActivity.this,MainActivity.class));
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });

        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrderPlacedActivity.this,SettingsActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrderPlacedActivity.this,ProfileActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
        supportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(OrderPlacedActivity.this,SupportQueryActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
    }
}