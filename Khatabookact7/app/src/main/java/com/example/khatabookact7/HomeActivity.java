package com.example.khatabookact7;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {


    ListView lstView;
    ArrayList<String> arr_name;
    ArrayList<String> arr_amt;
    ArrayList<String> arr_trxnType;
    EditText inputSearch;
    ArrayAdapter<String> adapterReplica;
    CustomLayoutAdapter Custom;
    int unique = 1;//fro unique notifications

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
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent i = new Intent(HomeActivity.this, AddCustomer.class);
                startActivity(i);
            }
        });

        String name, amt, trxnType;

//        Getting Intent Data from previous activity
        Intent i = getIntent();
        name = i.getStringExtra("name");
        amt = i.getStringExtra("amount");
        trxnType = i.getStringExtra("trxnType");
        Toast.makeText(this, name + amt + trxnType, Toast.LENGTH_SHORT).show();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            name = extras.getString("Name");
            amt = extras.getString("Amount");
            trxnType = extras.getString("trxnType");
            Toast.makeText(this, name + "\n" + amt + "\n" + trxnType, Toast.LENGTH_SHORT).show();
            arr_name.add(0, name);
            arr_amt.add(0, amt);
            arr_trxnType.add(0, trxnType);
        }

        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            //show sign up activity
            startActivity(new Intent(HomeActivity.this, VerifyPhone.class));
            Toast.makeText(HomeActivity.this, "Run only once", Toast.LENGTH_LONG)
                    .show();
        }

        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).commit();


        lstView = (ListView) findViewById(R.id.lstView);
        arr_name = new ArrayList<>();
        arr_amt = new ArrayList<>();
        arr_trxnType = new ArrayList<>();
        inputSearch = (EditText) findViewById(R.id.inputSearch);

//        Array for name of customer

        arr_name.add("Afcgvb");
        arr_name.add("ANMtdc");
        arr_name.add("Bzx nh");
        arr_name.add("qwertyu");
        arr_name.add("asdfgh");
        arr_name.add("zxcvbn");
        arr_name.add("uiop");
        arr_name.add("rtyu");
        arr_name.add("vbnmkl");
        arr_name.add("zxcvbnmdeg");
        arr_name.add("yuifghd");
        arr_name.add("jkls");
        arr_name.add("tyuixnm");
        arr_name.add("vbnmwyui");
        arr_name.add("hjkladdsd");
        arr_name.add("sdfgvbnm");
        arr_name.add("lkjhg");
        arr_name.add("zxcvmn");
        arr_name.add("mvnbv");
        arr_name.add("poiuy");

//        Array for balance of customer
        arr_amt.add("List 1");
        arr_amt.add("List 2");
        arr_amt.add("List 3");
        arr_amt.add("List 4");
        arr_amt.add("List 5");
        arr_amt.add("List 6");
        arr_amt.add("List 7");
        arr_amt.add("List 8");
        arr_amt.add("List 9");
        arr_amt.add("List 10");
        arr_amt.add("List 1");
        arr_amt.add("List 2");
        arr_amt.add("List 3");
        arr_amt.add("List 4");
        arr_amt.add("List 5");
        arr_amt.add("List 6");
        arr_amt.add("List 7");
        arr_amt.add("List 8");
        arr_amt.add("List 9");
        arr_amt.add("List 10");

//        Array for Transaction type of customer;
        arr_trxnType.add("List 1");
        arr_trxnType.add("List 2");
        arr_trxnType.add("List 3");
        arr_trxnType.add("List 4");
        arr_trxnType.add("List 5");
        arr_trxnType.add("List 6");
        arr_trxnType.add("List 7");
        arr_trxnType.add("List 8");
        arr_trxnType.add("List 9");
        arr_trxnType.add("List 10");
        arr_trxnType.add("List 1");
        arr_trxnType.add("List 2");
        arr_trxnType.add("List 3");
        arr_trxnType.add("List 4");
        arr_trxnType.add("List 5");
        arr_trxnType.add("List 6");
        arr_trxnType.add("List 7");
        arr_trxnType.add("List 8");
        arr_trxnType.add("List 9");
        arr_trxnType.add("List 10");

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                final AlertDialog alertDialog = new AlertDialog.Builder(HomeActivity.this).create();

                alertDialog.setMessage("Selected:" + arr_name.get(position) + "\nContact No:" + arr_amt.get(position) + "\nEmail:" + arr_trxnType.get(position));
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();

//                Implementation of push notification
                NotificationCompat.Builder builder = new NotificationCompat.Builder(HomeActivity.this);

                builder.setContentTitle("Selected:" + arr_name.get(position) + "\nContact No:" + arr_amt.get(position) + "\nEmail:" + arr_trxnType.get(position))
                        .setContentText("OTP").setSmallIcon(R.drawable.ic_access_black_24dp)

                        .build();
                NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = builder.build();

                notification.flags |= Notification.FLAG_AUTO_CANCEL;
                unique++;
                notificationManager.notify(unique, notification);
            }
        });


//Custom Layout fro ListView containing above arrays

        Custom = new CustomLayoutAdapter(this, arr_name, arr_amt, arr_trxnType);
        lstView.setAdapter(Custom);
//Changed from here


        String products[] = {"Afcgvb", "ANMtdc", "Bzx nh", "qwertyu", "asdfgh",
                "zxcvbn", "uiop",
                "rtyu", "vbnmkl", "zxcvbnmdeg", "yuifghd" , "jkls" , "tyuixnm" , "vbnmwyui" , "hjkladdsd" , "sdfgvbnm" , "zxcvmn" , "mvnbv"};
        adapterReplica = new ArrayAdapter<String>(this, R.layout.replicalist, R.id.product_name, products);

        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text
                lstView.setAdapter(adapterReplica);
                HomeActivity.this.adapterReplica.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub
                lstView.setAdapter(Custom);
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
//                lstView.setAdapter(Custom);
            }
        });
    }

}
