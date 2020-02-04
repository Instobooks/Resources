package com.example.khatabookact7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    ListView lstView;
    ArrayList<String> arr_name;
    ArrayList<String> arr_amt;
    ArrayList<String> arr_trxnType;
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
                Toast.makeText(this,"Item 2 clicked",Toast.LENGTH_SHORT ).show();
                return true;
            case R.id.item3:
                Toast.makeText(this,"Item 3 clicked",Toast.LENGTH_SHORT ).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lstView=(ListView)findViewById(R.id.lstView);
        arr_name=new ArrayList<>();
        arr_amt=new ArrayList<>();
        arr_trxnType=new ArrayList<>();

        arr_name.add("List 1");
        arr_name.add("List 2");
        arr_name.add("List 3");
        arr_name.add("List 4");
        arr_name.add("List 5");
        arr_name.add("List 6");
        arr_name.add("List 7");
        arr_name.add("List 8");
        arr_name.add("List 9");
        arr_name.add("List 10");
        arr_name.add("List 1");
        arr_name.add("List 2");
        arr_name.add("List 3");
        arr_name.add("List 4");
        arr_name.add("List 5");
        arr_name.add("List 6");
        arr_name.add("List 7");
        arr_name.add("List 8");
        arr_name.add("List 9");
        arr_name.add("List 10");

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
    }


}
