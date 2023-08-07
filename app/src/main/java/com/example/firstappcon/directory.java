package com.example.firstappcon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

public class directory extends AppCompatActivity {

    private Spinner spinnerMat;
    private TextView textViewy;
    private TextView textViewfi;
    private TextView textViewBangle;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_directory);
        spinnerMat = findViewById(R.id.spinnerMat);
        textViewy = findViewById(R.id.textViewy);
        textViewfi = findViewById(R.id.textViewfi);
        textViewBangle = findViewById(R.id.textViewBangle);
    }

    public void showGoods(View view) {
        int position = spinnerMat.getSelectedItemPosition();
        int position1 = spinnerMat.getSelectedItemPosition();
        int position2 = spinnerMat.getSelectedItemPosition();
        String goods = getDescriptionByPosition(position);
        String goods1 = getDescriptionByPosition1(position1);
        String goods2 = getDescriptionByPosition2(position2);
        textViewy.setText(goods);
        textViewfi.setText(goods1);
        textViewBangle.setText(goods2);

    }
    private String getDescriptionByPosition(int position){
        String[] description = getResources().getStringArray(R.array.Destiny_array);
        return description[position];
    }
    private String getDescriptionByPosition1(int position1) {
        String[] description = getResources().getStringArray(R.array.slope_array);
        return description[position1];
    }
    private String getDescriptionByPosition2(int position2) {
        String[] description = getResources().getStringArray(R.array.conveyor_array);
        return description[position2];
    }
}