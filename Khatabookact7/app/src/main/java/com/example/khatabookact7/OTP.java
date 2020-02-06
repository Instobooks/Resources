package com.example.khatabookact7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class OTP extends AppCompatActivity {
    EditText EtxtOtp;
    String otp="abc";
    public String Etxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        EtxtOtp = (EditText)findViewById(R.id.EtxtOtp);
        String Etxt=EtxtOtp.getText().toString();
    }
    public void verOtp(View v){

            Intent i= new Intent(this,MainActivity.class);
            startActivity(i);


    }
    public boolean checkOtp(){
        if(Etxt==otp){
            return true;
        }
        return false;
    }
}

