package com.example.kitchenkourier.Activity;

import androidx.appcompat.app.AppCompatActivity;
import com.example.kitchenkourier.R;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SecondIntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_intro);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SecondIntroActivity.this,Login_Activity.class));
                finish();
            }
        },3000);
    }
}