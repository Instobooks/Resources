//Created and updated by Jaisal Shah on 06/02/2020
package com.example.khatabookact7;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import java.util.Random;

public class VerifyPhone extends AppCompatActivity {
    EditText EtxtPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phone);
        EtxtPhone=(EditText)findViewById(R.id.EtxtPhone);
        VerifyPhone ver=new VerifyPhone();
    }

//    Button Events
    public void sendOtpBtn(View v) {
        if (verify()) {
//            Random otp Generation
            Random rand = new Random();
            int randomInt = rand.nextInt(10000);
//            Implementation of Push notification for OTP message
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this);

            builder.setContentText("OTP").setSmallIcon(R.drawable.ic_access_black_24dp)
                    .setStyle(new NotificationCompat.BigTextStyle()
                            .bigText("Dear Customer,Welcome to Instobooks your OTP for registration is "+randomInt+".Don't share youtr OTP ith anyone. "))
                    .build();
            NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            Notification notification = builder.build();

            notification.flags |= Notification.FLAG_AUTO_CANCEL;

            notificationManager.notify(0, notification);


            Intent i = new Intent(this, OTP.class);
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    show();
                }
            }, 3000);
            startActivity(i);
        }else{
            Toast.makeText(this,"Invalid Input",Toast.LENGTH_SHORT).show();
        }
    }
//    Implementation for verification
    public boolean verify() {
        if (EtxtPhone.getText().length() == 10) {
            return true;
        }
        return false;
    }
    public void show(){
        Toast.makeText(this,"OTP Sent Succcessfully",Toast.LENGTH_SHORT).show();
    }
}
