//Created and Updated by Jaisal Shah on 06/02/2020
package com.example.khatabookact7;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;



public class CustomLayoutAdapter extends ArrayAdapter<String> {
    Activity ac;
    ArrayList<String> name;
    ArrayList<Integer> amount;
    ArrayList<String> trxnType;
//    Defining CustomLayuotAdapter method
    public CustomLayoutAdapter(Activity activity, ArrayList<String> arr_name,ArrayList<Integer> arr_amt,ArrayList <String> arr_trxntype){
        super(activity,R.layout.customlayout,arr_name);
        this.ac=activity;
        this.name=arr_name;
        this.amount=arr_amt;
        this.trxnType=arr_trxntype;
    }

//    Getting View details
    @Override
    public View getView(int position,View v,ViewGroup vg){
        LayoutInflater inflater=ac.getLayoutInflater();
        v=inflater.inflate(R.layout.customlayout,null);
        TextView txtName=v.findViewById(R.id.txtName);
        TextView txtAmt=v.findViewById(R.id.txtAmt);
        TextView txttrxnType=v.findViewById(R.id.txtAmt);
        txtName.setText(name.get(position));
        txtAmt.setText(amount.get(position).toString());
        txttrxnType.setText(trxnType.get(position));
        return v;
    }
}

