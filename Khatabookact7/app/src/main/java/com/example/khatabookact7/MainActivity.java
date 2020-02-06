package com.example.khatabookact7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    ListView lstView;
    ArrayList<String> arr_name;
    ArrayList<String> arr_amt;
    ArrayList<String> arr_trxnType;
    EditText inputSearch;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.item1:
                Intent i = new Intent(this,AddCustomer.class);
                startActivity(i);
                return true;
            case R.id.item2:
                Intent j = new Intent(this,Calculator.class);
                startActivity(j);
                return true;
            case R.id.item3:
                Intent k = new Intent(this,SettingsActivity.class);
                startActivity(k);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        if (isFirstRun) {
            //show sign up activity
            startActivity(new Intent(MainActivity.this, VerifyPhone.class));
            Toast.makeText(MainActivity.this, "Run only once", Toast.LENGTH_LONG)
                    .show();
        }


        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).commit();

        lstView=(ListView)findViewById(R.id.lstView);
        arr_name=new ArrayList<>();
        arr_amt=new ArrayList<>();
        arr_trxnType=new ArrayList<>();
        inputSearch=(EditText)findViewById(R.id.inputSearch);
        arr_name.add("A");
        arr_name.add("ANM");
        arr_name.add("B");
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




        CustomLayoutAdapter Custom=new CustomLayoutAdapter(this,arr_name,arr_amt,arr_trxnType);
        lstView.setAdapter(Custom);



        lstView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                final AlertDialog alertDialog=new AlertDialog.Builder(MainActivity.this).create();

                alertDialog.setMessage("Selected:"+arr_name.get(position)+"\nContact No:"+arr_amt.get(position)+"\nEmail:"+arr_trxnType.get(position));
                alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
            }
        });
//        inputSearch.addTextChangedListener(new TextWatcher() {
//
//            @Override
//            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
//                // When user changed the Text
//                MainActivity.this.adapter.getFilter().filter(cs);
//            }
//
//            @Override
//            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
//                                          int arg3) {
//                 //TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable arg0) {
//                // TODO Auto-generated method stub
//            }
//        });
    }


}
