package com.imtiaj.rush;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MyProfileActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    ArrayList<CustomItem> customList;

    private TextView crossBtn,editBtn,crossBtnEditPage,saveBtn, floatEditPic,floatSavePic;
    private TextInputEditText name,phoneNo,emailAddress, nameEditPage,phoneNoEditPage,emailAddressEditPage;
    private Spinner spinnerEditPage;
    private Button submitDocBtn, submitDocBtnEditPage;

    private ConstraintLayout myProfilePage, editProfilePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        crossBtn = findViewById(R.id.floatCrossBtn);
        editBtn = findViewById(R.id.floatingEditBtn);
        crossBtnEditPage = findViewById(R.id.floaCrossBtn_EditPage);
        saveBtn = findViewById(R.id.floatingSaveBtn_EditPage);

        name = findViewById(R.id.profileNameInput);
        phoneNo = findViewById(R.id.profilePhoneNo);
        emailAddress = findViewById(R.id.profileEmail);

        //name.setEnabled(false);
        name.setFocusable(false);
        phoneNo.setFocusable(false);
        //phoneNo.setEnabled(false);
        //emailAddress.setEnabled(false);
        emailAddress.setFocusable(false);


        myProfilePage = (ConstraintLayout)findViewById(R.id.myProfilePage);
        editProfilePage = (ConstraintLayout)findViewById(R.id.editProfilePage);

        spinnerEditPage = (Spinner)findViewById(R.id.phoneCode_EditPage);



        customList = getCustomList();
        EditProfileAdapter adapter = new EditProfileAdapter(this,customList);
        if (spinnerEditPage!=null){
            spinnerEditPage.setAdapter(adapter);
            spinnerEditPage.setOnItemSelectedListener(MyProfileActivity.this);
        }

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myProfilePage.setVisibility(View.GONE);
                editProfilePage.setVisibility(View.VISIBLE);
            }
        });
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myProfilePage.setVisibility(View.VISIBLE);
                editProfilePage.setVisibility(View.GONE);
            }
        });


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

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}