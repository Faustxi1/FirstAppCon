package com.example.firstappcon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CalcCapacity extends AppCompatActivity {

    public Spinner spinnerB;
    public EditText textViewy;
    public EditText textViewv;
    public EditText textViewl;
    public TextView textViewQ;
    public TextView textViewF;
    public RadioGroup radioGroupMat;
    public RadioGroup radioGroupRol;
    private RadioButton radioButtonDegreesMaterial1, radioButtonDegreesMaterial2, radioButtonDegreesMaterial3;
    private RadioButton radioButtonDegreesRol1, radioButtonDegreesRol2, radioButtonDegreesRol3, radioButtonDegreesRol4;
    double l;
    double Ares;
    double Bres;
    double Cres;
    static Double F;
    static Double Q;
    static Double b;
    double b1;
    double i;
    double j;


    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_capacity);
        spinnerB = findViewById(R.id.spinnerB);
        textViewy = findViewById(R.id.textViewy);
        textViewv = findViewById(R.id.textViewv);
        textViewl = findViewById(R.id.textViewl);
        textViewQ = findViewById(R.id.textViewQ);
        textViewF = findViewById(R.id.textViewF);
        radioGroupMat = findViewById(R.id.radioGroupMat);
        radioGroupRol = findViewById(R.id.radioGroupRol);
        radioButtonDegreesMaterial1 = findViewById(R.id.radioButtonDegreesMaterial1);
        radioButtonDegreesMaterial2 = findViewById(R.id.radioButtonDegreesMaterial2);
        radioButtonDegreesMaterial3 = findViewById(R.id.radioButtonDegreesMaterial3);
        radioButtonDegreesRol1 = findViewById(R.id.radioButtonDegreesRol1);
        radioButtonDegreesRol2 = findViewById(R.id.radioButtonDegreesRol2);
        radioButtonDegreesRol3 = findViewById(R.id.radioButtonDegreesRol3);
        radioButtonDegreesRol4 = findViewById(R.id.radioButtonDegreesRol4);

    }
    public void ClickresultCap(View view) {

        String B = String.valueOf(spinnerB.getSelectedItemPosition());
        String lenght = textViewl.getText().toString();
        String speed = textViewv.getText().toString();
        String Dens = textViewy.getText().toString();
        if (B.isEmpty() || lenght.isEmpty() || speed.isEmpty() || Dens.isEmpty()) {
            Toast.makeText(this, R.string.nulledition, Toast.LENGTH_SHORT).show();
        } else {
            int BB = Integer.parseInt(B);
            l = Double.parseDouble(lenght);
            double S = Double.parseDouble(speed);
            double D = Double.parseDouble(Dens);
            if (BB == 1) {
                b1 = 500;
            } else if (BB == 2) {
                b1 = 650;
            } else if (BB == 3) {
                b1 = 820;
            } else if (BB == 4) {
                b1 = 1000;
            } else if (BB == 5) {
                b1 = 1200;
            } else if (BB == 6) {
                b1 = 1400;
            } else if (BB == 7) {
                b1 = 1600;
            }
            b = (0.9 * b1 - 50) * 0.001;


            if (radioButtonDegreesRol1.isChecked()) {
                i = 10;
            } else if (radioButtonDegreesRol2.isChecked()) {
                i = 20;
            } else if (radioButtonDegreesRol3.isChecked()) {
                i = 30;
            } else if (radioButtonDegreesRol4.isChecked()) {
                i = 40;
            }
            if (radioButtonDegreesMaterial1.isChecked()) {
                j = 10;
            } else if (radioButtonDegreesMaterial2.isChecked()) {
                j = 20;
            } else if (radioButtonDegreesMaterial3.isChecked()) {
                j = 30;
            }

            Ares = Math.cos(Math.toRadians(i));
            Bres = Math.sin(Math.toRadians(i));
            Cres = Math.tan(Math.toRadians(j));
            F = ((l + ((b - 1) / 2) * Ares) * ((b - 1) / 2) * Bres + ((l + (b - 1) * Ares) / 2) * ((l + (b - 1) * Ares) / 2) * Cres) / 1000000;


            Q = 3600 * F * S * D;
            String result1 = String.format("%.4f", F);
            String result2 = String.format("%.2f", Q);
            textViewQ.setText(result2.toString());
            textViewF.setText(result1.toString());
        }
    }
    public void ClickClearCap(View view) {
        textViewy.setText(null);
        textViewv.setText(null);
        textViewl.setText(null);
        textViewQ.setText(null);
        textViewF.setText(null);
    }
}