package com.imtiaj.rush;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class Driver_register extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    ArrayList<CustomItem> customList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_register);


        spinner = findViewById(R.id.driver_Zone_spinner);
        customList = getCustomList();
        CustomAdapter adapter = new CustomAdapter(this,customList);
       if (spinner!=null){
           spinner.setAdapter(adapter);
           spinner.setOnItemSelectedListener(this);
       }
    }

    private ArrayList<CustomItem> getCustomList(){
        customList = new ArrayList<>();
        customList.add(new CustomItem("Zone"));
        customList.add(new CustomItem("Kolkata"));
        customList.add(new CustomItem("Delhi"));
        customList.add(new CustomItem("Mumbai"));
        customList.add(new CustomItem("Chennai"));
        return customList;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        CustomItem item = (CustomItem) adapterView.getSelectedItem();
        Toast.makeText(this,item.getDropdownzone(),Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}