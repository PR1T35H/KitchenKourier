package com.example.kitchenkourier.Activity;

import androidx.appcompat.app.AppCompatActivity;
import com.example.kitchenkourier.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SupportQueryActivity extends AppCompatActivity {
    TextView submitBtn;
    EditText email,topic,desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_query);

        bottomNavigation();


        email = (EditText) findViewById(R.id.enterEmail);
        topic = (EditText) findViewById(R.id.issueTopic);
        desc = (EditText) findViewById(R.id.issueDesc);



        submitBtn=findViewById(R.id.textView35);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String emailId=email.getText().toString();
                String issueTopic = topic.getText().toString();
                String issueDesc = desc.getText().toString();

                if(emailId.isEmpty()){
                    Toast.makeText(SupportQueryActivity.this, "Your Email is Empty", Toast.LENGTH_SHORT).show();
                }
                if(!emailId.contains("@gmail")){
                    Toast.makeText(SupportQueryActivity.this, "Your Email is Invalid", Toast.LENGTH_SHORT).show();
                }
                else if(issueTopic.isEmpty() || issueDesc.isEmpty()){
                    Toast.makeText(SupportQueryActivity.this, "Kindly fill-in rest of the Details", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(SupportQueryActivity.this, "Your Query has been Submitted", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.cartBtn);
        LinearLayout profileBtn=findViewById(R.id.profile);
        LinearLayout settingsBtn=findViewById(R.id.settings);
        LinearLayout supportBtn=findViewById(R.id.support);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);
        ImageView backButton = findViewById(R.id.imageView32);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SupportQueryActivity.this,CartListActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SupportQueryActivity.this, MainActivity.class));
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SupportQueryActivity.this,SettingsActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SupportQueryActivity.this,ProfileActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });



    }
}