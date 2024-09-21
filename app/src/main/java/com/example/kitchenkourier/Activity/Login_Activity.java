package com.example.kitchenkourier.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.kitchenkourier.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity {
    private TextInputLayout inputEmail,inputPassword;
    private TextView btnLogin,forgotPassword,createNewAccount;
    ProgressDialog mLoadingBar;
    FirebaseAuth mAuth;

    public static  final String SHARED_PREFS="sharedPrefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        inputEmail=findViewById(R.id.inputEmail1);
        inputPassword=findViewById(R.id.inputPassword);
        btnLogin=findViewById(R.id.btnLogin);
        createNewAccount=findViewById(R.id.createNewAccount);
        mLoadingBar=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();

        checkBox();


        createNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login_Activity.this,RegisterActivity.class);

                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AttemptLogin();
            }
        });

    }

    private void checkBox() {
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
        String check=sharedPreferences.getString("name","");
        if(check.equals("true")){
            Intent intent=new Intent(Login_Activity.this,MainActivity.class);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
            finish();
        }

    }

    private void AttemptLogin() {
        String email=inputEmail.getEditText().getText().toString();
        String password=inputPassword.getEditText().getText().toString();


        if(email.isEmpty() || !email.contains("@gmail")){
            showError(inputEmail,"E-mail is not Valid");
        }
        else if(password.isEmpty() || password.length()<5){
            showError(inputPassword,"Wrong Password");
        }

        else{
            mLoadingBar.setTitle("Logging in");
            mLoadingBar.setMessage("Please wait");
            mLoadingBar.setCanceledOnTouchOutside(false);
            mLoadingBar.show();
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){

                        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        CheckBox checkBoxBtn=findViewById(R.id.checkBox);
                        if(checkBoxBtn.isChecked()){
                            editor.putString("name","true");
                            editor.apply();
                        }
                        else{
                            editor.putString("name","");
                            editor.apply();
                        }

                        mLoadingBar.dismiss();
                        Intent intent=new Intent(Login_Activity.this,MainActivity.class);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                        finish();
                    }
                    else{
                        mLoadingBar.dismiss();
                        Toast.makeText(Login_Activity.this,"Login Failed, Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
    private void showError(TextInputLayout field, String text){
        field.setError(text);
        field.requestFocus();
    }

}