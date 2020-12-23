package com.imtiaj.rush;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ResendOtpActivity extends AppCompatActivity {

    private ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repeat_verification);
        constraintLayout = findViewById(R.id.verify_Repeat_wrapper);
        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResendOtpActivity.this, DriverRegisterActivity.class));
            }
        });
    }
}