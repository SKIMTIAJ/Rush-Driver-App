package com.imtiaj.rush;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class Document extends AppCompatActivity {

    private EditText Image, Document, Moto_permit, Person_id;
    private ConstraintLayout constraintLayout;
    private String TAG = "Document";
    Context ctx;
    boolean invalidInput = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);
        ctx = getApplicationContext();

        Image =  findViewById(R.id.upload_image);
        Document = findViewById(R.id.upload_document);
        Moto_permit = findViewById(R.id.driver_permit);
        Person_id = findViewById(R.id.driver_id);

        /*Image.setTextSize(18);
        Document.setTextSize(18);
        Moto_permit.setTextSize(18);
        Person_id.setTextSize(18);*/


        constraintLayout = findViewById(R.id.verify_text_wrapper);

        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(invalidInput == false){
                    Log.d(TAG, "Got Error for Input box 3");
//                    for(int i=2;i<=3;i++){
                        setErrorAlertIcon(3);
//                    }

                }
                else {
                    Log.d(TAG, "No error proceeding...!!! ");
                }
            }
        });
    }


    private void setErrorAlertIcon(int position) {
        Log.d(TAG, "Inside setErrorAlertIcon ");
        Drawable[] compoundDrawables;
        Drawable drawableresource;
        compoundDrawables=Moto_permit.getCompoundDrawables();
        switch (position) {
            case 1 :
                Log.d(TAG, "Selected item 1 ");
                break;
            case 2:
                Log.d(TAG, "Selected item 2 ");
//                compoundDrawables=Document.getCompoundDrawables();
                Document.setHintTextColor(getResources().getColor(R.color.Highlight));
                //Document.setTextColor(getResources().getColor(R.color.Highlight));
                Document.setBackground(ContextCompat.getDrawable(Document.this, R.drawable.alert_color));
                drawableresource=compoundDrawables[1].mutate();
                drawableresource.setColorFilter(new PorterDuffColorFilter(getResources().getColor(R.color.Highlight), PorterDuff.Mode.SRC_IN));
                break;
            case 3:
                Log.d(TAG, "Selected item 3 ");
//                compoundDrawables=Moto_permit.getCompoundDrawables();
                Moto_permit.setHintTextColor(getResources().getColor(R.color.Highlight));
                //Moto_permit.setTextColor(getResources().getColor(R.color.Highlight));
                Moto_permit.setBackground(ContextCompat.getDrawable(Document.this, R.drawable.alert_color));
                drawableresource=compoundDrawables[2].mutate();
                drawableresource.setColorFilter(new PorterDuffColorFilter(getResources().getColor(R.color.Highlight), PorterDuff.Mode.SRC_IN));
                break;
            case 4:
                Log.d(TAG, "Selected item 4 ");
                break;
        }
    }
}