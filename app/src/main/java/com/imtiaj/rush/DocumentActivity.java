package com.imtiaj.rush;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class DocumentActivity extends AppCompatActivity {

    private TextInputEditText uploadImageEdit, uploadDocumentEdit, motoPermitEdit, personIdEdit;
    private ConstraintLayout constraintLayout;
    private String TAG = "Document";
    Context ctx;
    boolean invalidInput = false;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);
        ctx = getApplicationContext();

        uploadImageEdit =  findViewById(R.id.uploadImageInput);
        uploadDocumentEdit = findViewById(R.id.uploadDocumentInput);
        motoPermitEdit = findViewById(R.id.driverPermitInput);
        personIdEdit = findViewById(R.id.driverIdInput);

        /*Image.setTextSize(18);
        Document.setTextSize(18);
        Moto_permit.setTextSize(18);
        Person_id.setTextSize(18);*/


        constraintLayout = findViewById(R.id.verifyTextWrapper);

        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(invalidInput == false){
                    Log.d(TAG, "Got Error for Input box 3");
//                    for(int i=2;i<=3;i++){
                        setErrorAlertIcon(3);
//                    }
                   gotoMYProfile();

                }
                else {
                    Log.d(TAG, "No error proceeding...!!! ");
                }
            }
        });
    }

    private void gotoMYProfile() {
        if (doubleBackToExitPressedOnce) {
           startActivity(new Intent(DocumentActivity.this,MyProfileActivity.class));
        }
        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click Button again to MyProfile", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);

    }


    private void setErrorAlertIcon(int position) {
        Log.d(TAG, "Inside setErrorAlertIcon ");
        Drawable[] compoundDrawables;
        Drawable drawableresource;
        compoundDrawables=motoPermitEdit.getCompoundDrawables();
        switch (position) {
            case 1 :
                Log.d(TAG, "Selected item 1 ");
                break;
            case 2:
                Log.d(TAG, "Selected item 2 ");
//                compoundDrawables=Document.getCompoundDrawables();
                uploadDocumentEdit.setHintTextColor(getResources().getColor(R.color.Highlight));
                //Document.setTextColor(getResources().getColor(R.color.Highlight));
                uploadDocumentEdit.setBackground(ContextCompat.getDrawable(DocumentActivity.this, R.drawable.alert_color));
                drawableresource=compoundDrawables[1].mutate();
                drawableresource.setColorFilter(new PorterDuffColorFilter(getResources().getColor(R.color.Highlight), PorterDuff.Mode.SRC_IN));
                break;
            case 3:
                Log.d(TAG, "Selected item 3 ");
//                compoundDrawables=Moto_permit.getCompoundDrawables();
                motoPermitEdit.setHintTextColor(getResources().getColor(R.color.Highlight));
                //Moto_permit.setTextColor(getResources().getColor(R.color.Highlight));
                motoPermitEdit.setBackground(ContextCompat.getDrawable(DocumentActivity.this, R.drawable.alert_color));
                drawableresource=compoundDrawables[2].mutate();
                drawableresource.setColorFilter(new PorterDuffColorFilter(getResources().getColor(R.color.Highlight), PorterDuff.Mode.SRC_IN));
                break;
            case 4:
                Log.d(TAG, "Selected item 4 ");
                break;
        }
    }
}