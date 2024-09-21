package com.example.kitchenkourier.Activity;

import androidx.appcompat.app.AppCompatActivity;
import com.example.kitchenkourier.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class SupportFeedbackActivity extends AppCompatActivity {
    TextView submitBtn;
    EditText feedbackText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_support_feedback);

        bottomNavigation();

        feedbackText = (EditText) findViewById(R.id.feedback);
        submitBtn=findViewById(R.id.textView46);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String feedText=feedbackText.getText().toString();

                if(feedText.isEmpty()){
                    Toast.makeText(SupportFeedbackActivity.this, "Kindly fill-in the Feedback", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(SupportFeedbackActivity.this, "Your Feedback was much Appreciated!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.cartBtn);
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        ImageView backButton=findViewById(R.id.imageView45);
        LinearLayout profileBtn=findViewById(R.id.profile);
        LinearLayout settingsBtn=findViewById(R.id.settings);
        LinearLayout supportBtn=findViewById(R.id.support);


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SupportFeedbackActivity.this,CartListActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SupportFeedbackActivity.this,MainActivity.class));
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
                startActivity(new Intent(SupportFeedbackActivity.this,SettingsActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SupportFeedbackActivity.this,ProfileActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
        supportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SupportFeedbackActivity.this,SupportQueryActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
    }
}