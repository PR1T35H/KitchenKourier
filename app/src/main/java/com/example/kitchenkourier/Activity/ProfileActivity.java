package com.example.kitchenkourier.Activity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.kitchenkourier.Domain.ProfileDomain;
import com.example.kitchenkourier.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class ProfileActivity extends AppCompatActivity {
    EditText firstName,lastName,phoneNumber;
    TextView name,submitBtn;
    String fullname;
    String phone_Num;

    DatabaseReference databaseUser;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        bottomNavigation();

        firstName = (EditText) findViewById(R.id.issueTopic);
        lastName = (EditText) findViewById(R.id.changeLastName);
        phoneNumber = (EditText) findViewById(R.id.phoneNum);
        name = findViewById(R.id.name1);
        submitBtn = findViewById(R.id.submitBtn);

        databaseUser= FirebaseDatabase.getInstance("https://kitchenkourier-d9758-default-rtdb.asia-southeast1.firebasedatabase.app/").getReference("users");

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String first_Name = firstName.getText().toString();
                String sec_Name = lastName.getText().toString();
                phone_Num = phoneNumber.getText().toString();

                if (first_Name.isEmpty() || sec_Name.isEmpty()) {
                    Toast.makeText(ProfileActivity.this, "Kindly Enter your First and Last Name", Toast.LENGTH_SHORT).show();

                } else {
                    fullname = first_Name + " " + sec_Name;

                    ArrayList<String> greetingsList = new ArrayList<>();
                    greetingsList.add("Hello ");
                    greetingsList.add("Hi ");
                    greetingsList.add("Hey there ");
                    greetingsList.add("Greetings ");
                    greetingsList.add("Good to see you ");
                    greetingsList.add("Yo ");
                    greetingsList.add("Hiya ");
                    greetingsList.add("Howdy ");
                    greetingsList.add("Aloha ");

                    Random r = new Random();

                    int randomitem = r.nextInt(greetingsList.size());
                    String randomElement = greetingsList.get(randomitem);

                    String greet = randomElement + fullname + "!";
                    name.setText(greet);

                    addProfile();
                }
            }

        });


    }

    private void addProfile() {
        String Name=fullname;
        String number=phone_Num;

        String id=databaseUser.push().getKey();
        ProfileDomain profile=new ProfileDomain(id,Name,number);


        databaseUser.child(id).setValue(profile);

    }

    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.cartBtn);
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        ImageView backButton=findViewById(R.id.imageView28);
        LinearLayout settingsBtn=findViewById(R.id.settings);
        LinearLayout supportBtn=findViewById(R.id.support);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,CartListActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,MainActivity.class));
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
                startActivity(new Intent(ProfileActivity.this,SettingsActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
        supportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,SupportQueryActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });


    }
}