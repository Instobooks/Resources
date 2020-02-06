package com.example.khatabookact7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class VerifyPhone extends AppCompatActivity {
    EditText EtxtPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_phone);
        EtxtPhone=(EditText)findViewById(R.id.EtxtPhone);
        VerifyPhone ver=new VerifyPhone();
    }
    public void sendOtpBtn(View v) {
        if (verify()) {
            NotificationManager notif=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
            Notification notify=new Notification.Builder
                    (getApplicationContext()).setContentTitle("title").setContentText("body").
                    setContentTitle("sub").setSmallIcon(R.drawable.ic_access_black_24dp).build();

            notify.flags |= Notification.FLAG_AUTO_CANCEL;
            notif.notify(0, notify);
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
