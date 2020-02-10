package com.example.khatabookact7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.mbms.StreamingServiceInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class AddCustomer extends AppCompatActivity {
    EditText EtxtPhone;
    EditText EtxtName;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu1, menu);
        return true;
    }

    // options menu Events
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Intent i = new Intent(this, AddCustomer.class);
                startActivity(i);
                return true;
            case R.id.item2:
                Intent j = new Intent(this, Calculator.class);
                startActivity(j);
                return true;
            case R.id.item3:
                Intent k = new Intent(this, SettingsActivity.class);
                startActivity(k);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_add);
        EtxtPhone=(EditText)findViewById(R.id.EtxtPhone);
        EtxtName=(EditText)findViewById(R.id.EtxtName);
    }
    public void addBtn(View v){
        String EtxtName = EtxtPhone.getText().toString();
        Intent i = new Intent(this,HomeActivity.class);
        startActivity(i);
        i.putExtra("Name",EtxtName);
        i.putExtra("Amount","1234");
        i.putExtra("trxnType","credit");

    }
}
