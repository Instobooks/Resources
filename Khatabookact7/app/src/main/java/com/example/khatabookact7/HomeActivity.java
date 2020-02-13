package com.example.khatabookact7;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
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
    ArrayList<Integer> arr_amt;
    ArrayList<String> arr_trxnType;
    EditText inputSearch;
    ArrayAdapter<String> adapterReplica;
    CustomLayoutAdapter Custom;
    String products[];
    Cursor cursor ;
    SQLController myDb;
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

//        String name, amt, trxnType;

//        Getting Intent Data from previous activity
//        Intent i = getIntent();
//        name = i.getStringExtra("name");
//        amt = i.getStringExtra("amount");
//        trxnType = i.getStringExtra("trxnType");
//        Toast.makeText(this, name + amt + trxnType, Toast.LENGTH_SHORT).show();
//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            name = extras.getString("Name");
//            amt = extras.getString("Amount");
//            trxnType = extras.getString("trxnType");
//            Toast.makeText(this, name + "\n" + amt + "\n" + trxnType, Toast.LENGTH_SHORT).show();
//            arr_name.add(0, name);
//            arr_amt.add(0, amt);
//            arr_trxnType.add(0, trxnType);
//        }


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
        myDb = new SQLController(this);
        getData();
//Extracting DB to listview
//        cursor = myDb.getAllData();
//        if (cursor.moveToFirst()) {
//            do{
//                arr_name.add(cursor.getString(0));
//                arr_amt.add(cursor.getString(1));
//                int type = cursor.getInt(2);
//                if (type == 0){
//                    arr_trxnType.add("You will give");
//                }else{
//                    arr_trxnType.add("You will get");
//                }
//            }
//            while(cursor.moveToNext());
//        }

//        Custom = new CustomLayoutAdapter(this, arr_name, arr_amt, arr_trxnType);
//        lstView.setAdapter(Custom);

        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
//                final AlertDialog alertDialog = new AlertDialog.Builder(HomeActivity.this).create();
//
//                alertDialog.setMessage("Selected:" + arr_name.get(position) + "\nContact No:" + arr_amt.get(position) + "\nEmail:" + arr_trxnType.get(position));
//                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        alertDialog.dismiss();
//                    }
//                });
//                alertDialog.show();
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(HomeActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_layout, null);
                final EditText etAmt = (EditText) mView.findViewById(R.id.etAmt);
                Button btnGave = (Button) mView.findViewById(R.id.btnGave);
                Button btnReceived = (Button) mView.findViewById(R.id.btnReceived);
                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                mBuilder.setView(mView);
                btnGave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(!etAmt.getText().toString().isEmpty() ){
                            Toast.makeText(HomeActivity.this, "You gave "+etAmt.getText().toString(),Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }else{
                            Toast.makeText(HomeActivity.this, "Enter amount that you gave",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                btnGave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(!etAmt.getText().toString().isEmpty() ){
                            Toast.makeText(HomeActivity.this, "You received "+etAmt.getText().toString(),Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }else{
                            Toast.makeText(HomeActivity.this, "Enter amount that you gave" ,Toast.LENGTH_SHORT).show();
                        }
                    }
                });
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
        arr_name.add("jaisal");
        arr_amt.add(455);
        arr_trxnType.add(("You will get"));
//Custom Layout fro ListView containing above arrays
        Custom = new CustomLayoutAdapter(this, arr_name, arr_amt, arr_trxnType);
        lstView.setAdapter(Custom);
//Changed from here

        String products[] = {};
//        String products[] = {"A", "B", "C", "D", "E",
//                "F", "G",
//                "H", "I", "J", "K" , "L" , "M" , "N" , "O" , "P" , "Q" , "R"};

        adapterReplica = new ArrayAdapter<String>(this, R.layout.replicalist, R.id.product_name, products);

        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                // When user changed the Text

                lstView.setAdapter(adapterReplica);
                HomeActivity.this.adapterReplica.getFilter().filter(cs);
//                try 1
//                while(cs.toString()==""){
//                    lstView.setAdapter(Custom);
//                }
//                try 2
//                if(cs.toString() == ""){
//                    lstView.setAdapter(Custom);
//                }else{
//                    lstView.setAdapter(adapterReplica);
//                }
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub
                //lstView.setAdapter(adapterReplica);
            }

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                //lstView.setAdapter(adapterReplica);
            }
        });
        lstView.setAdapter(Custom);
    }
    public void getData(){
        cursor = myDb.getAllData();
        if (cursor.moveToFirst()) {
            do{
                arr_name.add(cursor.getString(1));
                arr_amt.add(cursor.getInt(4));
                int type = cursor.getInt(5);
                if (type == 0){                                                                                 //if new user
                    arr_trxnType.add("You will get");
                }else if(type == 1){                                                                            //if total is -ve
                    arr_trxnType.add("You will give");
                } else {                                                                                        //if total is +ve
                    arr_trxnType.add("");
                }
            }
            while(cursor.moveToNext());
            Custom = new CustomLayoutAdapter(this, arr_name, arr_amt, arr_trxnType);
            lstView.setAdapter(Custom);
        }
    }
}





