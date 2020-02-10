package com.example.sqliteapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName,editSurname,editMarks;
    Button addData,showData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new DatabaseHelper(this);

        editName = (EditText)findViewById(R.id.editText_name);
        editSurname = (EditText)findViewById(R.id.editText_surname);
        editMarks = (EditText)findViewById(R.id.editText_Marks);
        addData = (Button)findViewById(R.id.button_add);
        showData = (Button)findViewById(R.id.button_show);

        addData();
        showData();
    }

    public void addData(){
        addData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        boolean isInserted = myDb.insert(editName.getText().toString(),editSurname.getText().toString(),editMarks.getText().toString());
                        if(isInserted){
                            Toast.makeText(MainActivity.this,"Inserted",Toast.LENGTH_SHORT).show();;
                        }else{
                            Toast.makeText(MainActivity.this,"Not Inserted",Toast.LENGTH_SHORT).show();;

                        }
                    }
                }
        );
    }
    public void showData(){
        showData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0){
                            showMessage("DAta","Data not found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext()){
                            buffer.append("Id"+res.getString(0)+"\n");
                            buffer.append("Name"+res.getString(1)+"\n");
                            buffer.append("Surname"+res.getString(2)+"\n");
                            buffer.append("Marks"+res.getString(3)+"\n\n");

                        }
                        showMessage("DAta",buffer.toString());

                    }
                }
        );
    }
    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title).setMessage(Message).show();
    }
}
