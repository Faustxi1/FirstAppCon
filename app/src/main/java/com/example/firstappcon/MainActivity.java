package com.example.firstappcon;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ClickWidth(View view) {
        Intent intent = new Intent(this, CalaculationWidth.class);
        startActivity(intent);
    }
    public void ClickPower(View view) {
        Intent intent = new Intent(this, ChangeCon.class);
        startActivity(intent);
    }
    public void ClickCalcHole(View view) {
        Intent intent = new Intent(this, CalcHole.class);
        startActivity(intent);
    }
    public void ClickDirectory(View view) {
        Intent intent = new Intent(this, directory.class);
        startActivity(intent);
    }
    public void ClickCalcCapacity(View view) {
        Intent intent = new Intent(this, CalcCapacity.class);
        startActivity(intent);
    }
    public void ClickCalcVolume(View view) {
        Intent intent = new Intent(this, CalcVolume.class);
        startActivity(intent);
    }
    public void ClickCalcPit(View view) {
        Intent intent = new Intent(this, CalculateHolePit.class);
        startActivity(intent);
    }
}