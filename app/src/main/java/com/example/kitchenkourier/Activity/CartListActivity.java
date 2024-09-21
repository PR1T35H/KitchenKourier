package com.example.kitchenkourier.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kitchenkourier.Adaptor.CartListAdapter;
import com.example.kitchenkourier.Helper.ManagementCart;
import com.example.kitchenkourier.Interface.ChangeNumberItemsListener;
import com.example.kitchenkourier.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class CartListActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter;
private  RecyclerView recyclerViewlist;
private ManagementCart managementCart;
TextView totalFeeTxt,taxTxt,deliveryTxt,totalTxt,emptyTxt;
private double tax;
private ScrollView scrollView;

private TextView checkoutBtn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        managementCart=new ManagementCart(this);


        checkoutBtn=findViewById(R.id.textView14);

        checkoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartListActivity.this,OrderActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });

        initView();
        intiList();
        CalculateCart();
        bottomNavigation();


    }
    private void bottomNavigation(){
        FloatingActionButton floatingActionButton=findViewById(R.id.cartBtn);
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout profileBtn=findViewById(R.id.profile);
        LinearLayout settingsBtn=findViewById(R.id.settings);
        LinearLayout supportBtn=findViewById(R.id.support);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartListActivity.this,CartListActivity.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartListActivity.this,MainActivity.class));
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartListActivity.this,SettingsActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartListActivity.this,ProfileActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
        supportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartListActivity.this,SupportActivity.class) );
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

            }
        });
    }

    private void initView(){
        recyclerViewlist=findViewById(R.id.recyclerView2);
        totalFeeTxt=findViewById(R.id.totalFeeTxt);
        taxTxt=findViewById(R.id.taxTxt);
        deliveryTxt=findViewById(R.id.deliverytxt);
        totalTxt=findViewById(R.id.totalTxt);
        emptyTxt=findViewById(R.id.emptyTxt);
        scrollView=findViewById(R.id.scrollView3);
        recyclerViewlist=findViewById(R.id.cartView);
    }

    private  void intiList(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        recyclerViewlist.setLayoutManager(linearLayoutManager);
        adapter=new CartListAdapter(managementCart.getListCart(),this, new ChangeNumberItemsListener() {
            @Override
            public void changed() {
                CalculateCart();
                int temp5=0;
                CalculateCart(temp5);
            }
        });

        recyclerViewlist.setAdapter(adapter);
        if(managementCart.getListCart().isEmpty()){
            emptyTxt.setVisibility(View.VISIBLE);
            scrollView.setVisibility(View.GONE);
        }
        else{
            emptyTxt.setVisibility(View.GONE);
            scrollView.setVisibility(View.VISIBLE);
        }

    }
    private void CalculateCart(){
        double percentTax=0.04;
        double delivery=30;
        tax=Math.round((managementCart.getTotalFee()*percentTax)*100)/100;
        double total=Math.round((managementCart.getTotalFee()+tax+delivery)*100)/100;
        double itemTotal=Math.round(managementCart.getTotalFee()*100)/100;

        totalFeeTxt.setText("Rs "+itemTotal);
        taxTxt.setText("Rs "+tax);
        deliveryTxt.setText("Rs "+delivery);
        totalTxt.setText("Rs "+total);
    }
    private void CalculateCart(int z){
        int temp=0;
        double percentTax=0.04;
        double delivery=30;
        tax=Math.round((managementCart.getTotalFee(temp)*percentTax)*100)/100;
        double total=Math.round((managementCart.getTotalFee(temp)+tax+delivery)*100)/100;
        double itemTotal=Math.round(managementCart.getTotalFee(temp)*100)/100;

        totalFeeTxt.setText("Rs "+itemTotal);
        taxTxt.setText("Rs "+tax);
        deliveryTxt.setText("Rs "+delivery);
        totalTxt.setText("Rs "+total);
    }
}