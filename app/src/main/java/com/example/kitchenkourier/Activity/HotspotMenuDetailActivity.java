package com.example.kitchenkourier.Activity;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.kitchenkourier.Domain.HotspotDomain;
import com.example.kitchenkourier.Domain.QuenchDomain;
import com.example.kitchenkourier.Helper.ManagementCart;
import com.example.kitchenkourier.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class HotspotMenuDetailActivity extends AppCompatActivity {
    private TextView addToCartBtn;
    private TextView titleTxt,feeTxt,numberOrderTxt;
    private ImageView plusBtn,minusBtn,picFood;
    private HotspotDomain object;
    int numberOrder=1;
    private ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotspot_menu_detail);

        managementCart=new ManagementCart(this);
        initView();
        getBundle();
    }
    private void getBundle() {
        object=(HotspotDomain) getIntent().getSerializableExtra("object");
        int drawableResourceId=this.getResources().getIdentifier(object.getPic(),"drawable",this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(picFood);

        /*ArrayList<String> picUrl=new ArrayList<>();
        picUrl.add("pic1");
        picUrl.add("pic2");
        picUrl.add("pic3");
        picUrl.add("pic4");
        picUrl.add("pic5");
        picUrl.add("pic6");
        picUrl.add("pic7");
        picUrl.add("pic8");
        picUrl.add("pic9");
        picUrl.add("pic10");

        Random r=new Random();

        int randomitem=r.nextInt(picUrl.size());
        String randomElement=picUrl.get(randomitem);

        ImageView image=findViewById(R.id.imageView16);
        int drawableResourceId1=this.getResources().getIdentifier(randomElement,"drawable",this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId1)
                .into(image);*/

        titleTxt.setText(object.getTitle());
        feeTxt.setText("Rs "+object.getFee());
        numberOrderTxt.setText(String.valueOf(numberOrder));
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOrder=numberOrder+1;
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });
        ImageView backButton=findViewById(R.id.imageView19);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });



        minusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberOrder>1){
                    numberOrder=numberOrder-1;
                }
                numberOrderTxt.setText(String.valueOf(numberOrder));
            }
        });
        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                object.setNumberInCar(numberOrder);
                managementCart.insertFood(object);
            }
        });
    }

    private  void initView(){
        addToCartBtn=findViewById(R.id.addToCartBtn);
        titleTxt=findViewById(R.id.titleTxt);
        feeTxt=findViewById(R.id.priceTxt);
        numberOrderTxt=findViewById(R.id.numberOrderTxt);
        plusBtn=findViewById(R.id.plusBtn);
        minusBtn=findViewById(R.id.minusBtn);
        picFood=findViewById(R.id.picfood);
    }
}