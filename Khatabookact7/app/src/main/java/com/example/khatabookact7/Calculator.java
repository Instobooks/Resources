//Created and Updated by Jaisal Shah on 06/02/2020
package com.example.khatabookact7;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculator extends AppCompatActivity {

    TextView textView;

    Button clear, btnSave;

    Button one, two, three, four, five, six, seven, eight, nine, point, zero ;

    EditText EtxtNotes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //code for hide title bar.
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_calculator);

        textView = (TextView)findViewById(R.id.textView1);




        one = (Button)findViewById(R.id.button1);
        two = (Button)findViewById(R.id.button2);
        three = (Button)findViewById(R.id.button3);
        four = (Button)findViewById(R.id.button4);
        five = (Button)findViewById(R.id.button5);
        six = (Button)findViewById(R.id.button6);
        seven = (Button)findViewById(R.id.button7);
        eight = (Button)findViewById(R.id.button8);
        nine = (Button)findViewById(R.id.button9);
        point = (Button)findViewById(R.id.buttonPoint);
        zero = (Button)findViewById(R.id.buttonZero);
        btnSave = (Button)findViewById(R.id.btnSave);
        clear = (Button)findViewById(R.id.buttonClear);
        EtxtNotes=(EditText)findViewById(R.id.EtxtNotes);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView.setText(null);
            }
        });





//        Button Events
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView.setText(textView.getText() + "1");
                EtxtNotes.setVisibility(View.VISIBLE);

            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView.setText(textView.getText() + "2");
                EtxtNotes.setVisibility(View.VISIBLE);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView.setText(textView.getText() + "3");
                EtxtNotes.setVisibility(View.VISIBLE);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView.setText(textView.getText() + "4");

            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView.setText(textView.getText() + "5");
                EtxtNotes.setVisibility(View.VISIBLE);
            }
        });


        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView.setText(textView.getText() + "6");
                EtxtNotes.setVisibility(View.VISIBLE);
            }
        });


        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView.setText(textView.getText() + "7");
                EtxtNotes.setVisibility(View.VISIBLE);
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView.setText(textView.getText() + "8");

            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView.setText(textView.getText() + "9");
                EtxtNotes.setVisibility(View.VISIBLE);
            }
        });

        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView.setText(textView.getText() + ".");
                EtxtNotes.setVisibility(View.VISIBLE);
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textView.setText(textView.getText() + "0");
                EtxtNotes.setVisibility(View.VISIBLE);
            }
        });

    }

}