package com.imtiaj.rush;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText editText;
    ArrayList<CustomItem> customList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextTextPersonName4);
        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, OtpverifyActivity.class));
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinner2);
/*// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, R.layout.mainactivity_spinner);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(R.layout.mainactivity_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);*/

       customList = getCustomList();
        MainactivityAdapter adapter = new MainactivityAdapter(this,customList);
        if (spinner!=null){
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);
        }


    }

    private ArrayList<CustomItem> getCustomList(){
        customList = new ArrayList<>();
        customList.add(new CustomItem("+961"));
        customList.add(new CustomItem("+962"));
        customList.add(new CustomItem("+963"));
        customList.add(new CustomItem("+964"));
        customList.add(new CustomItem("+965"));
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