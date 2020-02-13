package com.example.khatabookact7;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddCustomer extends AppCompatActivity {
    SQLController myDb;
    EditText EtxtPhone;
    Button addbtn;
    EditText EtxtName;
    String date = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

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
        myDb = new SQLController(this);
        EtxtPhone = findViewById(R.id.EtxtPhone);
        EtxtName = findViewById(R.id.EtxtName);
        addbtn = findViewById(R.id.addbtn);
        addbtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = myDb.insert(EtxtName.getText().toString(), EtxtPhone.getText().toString(), 0, 0, date);
                        if (isInserted) {
                            Toast.makeText(AddCustomer.this, "Inserted", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(AddCustomer.this, "Not Inserted", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}
//    public void addData() {
        /*addbtn.setOnClickListener(
                new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                boolean isInserted = myDb.insert(EtxtName.getText().toString(), EtxtPhone.getText().toString(), 0, 0, date);
                                if (isInserted) {
                                    Toast.makeText(AddCustomer.this, "Inserted", Toast.LENGTH_SHORT).show();
                                } else {
                                    Toast.makeText(AddCustomer.this, "Not Inserted", Toast.LENGTH_SHORT).show();
                                }


                            }
                }); */
    //}

