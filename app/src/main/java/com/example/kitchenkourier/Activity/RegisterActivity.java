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
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout inputName,inputEmail,inputPassword,inputConfirmPassword;
    TextView btnRegister,alreadyhaveAccount;
    FirebaseAuth mAuth;
    ProgressDialog mLoadingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        inputName=findViewById(R.id.inputname);
        inputEmail=findViewById(R.id.inputEmail1);
        inputPassword=findViewById(R.id.inputPassword);
        inputConfirmPassword=findViewById(R.id.inputConfirmPassword);
        btnRegister=findViewById(R.id.btnRegister);
        alreadyhaveAccount=findViewById(R.id.textView31);
        mAuth=FirebaseAuth.getInstance();
        mLoadingBar=new ProgressDialog(this);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AttempRegistration();
            }
        });

        alreadyhaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegisterActivity.this,Login_Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
            }
        });

    }

    private void AttempRegistration() {
        String name=inputName.getEditText().getText().toString();
        String email=inputEmail.getEditText().getText().toString();
        String password=inputPassword.getEditText().getText().toString();
        String confirmPassword=inputConfirmPassword.getEditText().getText().toString();



        if(name.isEmpty()){
            showError(inputName,"Enter your name");
        }
        else if(email.isEmpty() || !email.contains("@gmail")){
            showError(inputEmail,"E-mail is not Valid");
        }
        else if(password.isEmpty() || password.length()<5){
            showError(inputPassword,"Password must be greater than 5 characters");
        }
        else if(!confirmPassword.equals(password)){
            showError(inputPassword,"Password did not Match!");
        }
        else{
            mLoadingBar.setTitle("Registration");
            mLoadingBar.setMessage("Please wait");
            mLoadingBar.setCanceledOnTouchOutside(false);
            mLoadingBar.show();
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){

                        mLoadingBar.dismiss();
                        Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                        intent.putExtra("KEY_SENDER",name);

                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
                        startActivity(intent);
                        finish();
                    }
                    else{
                        mLoadingBar.dismiss();
                        Toast.makeText(RegisterActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
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