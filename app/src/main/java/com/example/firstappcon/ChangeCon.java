package com.example.firstappcon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChangeCon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_con);
    }
    public void ClickconveyorHorisontal(View view) {
        Intent intent = new Intent(this, PowerHorisontalCon.class);
        startActivity(intent);

    }
    public void ClickConveyorAngle(View view) {
        Intent intent = new Intent(this, PowerAngleCon.class);
        startActivity(intent);
    }
    public void ClickConvetordouble(View view) {
        Intent intent = new Intent(this, PowerDoubleCon.class);
        startActivity(intent);
    }
}