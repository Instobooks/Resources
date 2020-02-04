package com.example.khatabookact7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddCustomer extends AppCompatActivity {
    EditText EtxtPhone;
    EditText EtxtName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_add);
        EtxtPhone=(EditText)findViewById(R.id.EtxtPhone);
        EtxtName=(EditText)findViewById(R.id.EtxtName);
    }
    public void addBtn(View v){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        i.putExtra("Name",EtxtName.getText());

    }
}
