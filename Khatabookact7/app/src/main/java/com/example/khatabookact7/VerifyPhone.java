package com.example.khatabookact7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

public class VerifyPhone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phone);
    }
    public void sendOtpBtn(View v){
        Intent i = new Intent(this,OTP.class);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                show();
            }
        },3000);
        startActivity(i);
    }
    public void show(){
        Toast.makeText(this,"OTP Sent Succcessfully",Toast.LENGTH_SHORT).show();
    }
}
