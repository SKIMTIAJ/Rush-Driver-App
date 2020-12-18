package com.imtiaj.rush;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Document extends AppCompatActivity {

    private EditText Image, Document, Moto_permit, Person_id;
    private ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document);

        Image = (EditText)findViewById(R.id.upload_image);
        Document = findViewById(R.id.upload_document);
        Moto_permit = findViewById(R.id.driver_permit);
        Person_id = findViewById(R.id.driver_id);

        constraintLayout = findViewById(R.id.verify_text_wrapper);

        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Moto_permit.setHintTextColor(getResources().getColor(R.color.Highlight));
                Moto_permit.setBackground(ContextCompat.getDrawable(Document.this, R.drawable.alert_color));
                //Moto_permit.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable, 0);
                setTextViewDrawableColor(Moto_permit,R.color.Highlight);
            }
        });
    }

    private void setTextViewDrawableColor(EditText textView, int color) {
        for (Drawable drawable : textView.getCompoundDrawables()) {
            if (drawable != null) {
                drawable.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(textView.getContext(), color), PorterDuff.Mode.SRC_IN));
            }
        }
    }

}