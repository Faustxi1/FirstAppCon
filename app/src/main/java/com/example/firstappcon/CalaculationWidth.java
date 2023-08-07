package com.example.firstappcon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CalaculationWidth extends AppCompatActivity {
    public EditText textViewQ;
    public EditText textViewy;
    public EditText textViewv;
    public EditText textViewAmax;
    public EditText textViewAmin;
    public EditText textViewkH;
    public EditText textViewkB;
    double ai;
    public TextView textViewkr;
    public TextView textViewB;
    public TextView textViewBras;
    public TextView textViewBgost;
    public TextView textViewriad;
    public RadioButton radioButton10, radioButton20, radioButton30, radioButton201, radioButton301;
    public Spinner spinnerAngleCon;
    double Br;
    double i;
    double j;
    double kb;
    double kn;
    double ressqrt;
    double Bres;
    double Bbol;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calaculation_width);
        textViewQ = findViewById(R.id.textViewQ);
        textViewy = findViewById(R.id.textViewy);
        textViewv = findViewById(R.id.textViewv);
        textViewAmax = findViewById(R.id.textViewAmax);
        textViewAmin = findViewById(R.id.textViewAmin);
        textViewkH = findViewById(R.id.textViewkH);
        textViewkB = findViewById(R.id.textViewkB);
        textViewkr = findViewById(R.id.textViewkr);
        textViewB = findViewById(R.id.textViewB);
        spinnerAngleCon = findViewById(R.id.spinnerAngleCon);
        textViewBras = findViewById(R.id.textViewBras);
        textViewBgost = findViewById(R.id.textViewBgost);
        radioButton10 =findViewById(R.id.radioButton10);
        radioButton20 =findViewById(R.id.radioButton20);
        radioButton30 =findViewById(R.id.radioButton30);
        radioButton201 =findViewById(R.id.radioButton201);
        radioButton301 = findViewById(R.id.radioButton301);
        textViewriad = findViewById(R.id.textViewriad);
    }
    public void ClickRes(View view) {
        String Q1 = textViewQ.getText().toString();
        String kH1 = textViewkH.getText().toString();
        String kv1 = textViewkB.getText().toString();
        String kr1 = textViewkr.getText().toString();
        String a1 = textViewAmax.getText().toString();
        String b1 = textViewAmin.getText().toString();
        String v1 = textViewv.getText().toString();
        String p1 = textViewy.getText().toString();
        if (Q1.isEmpty() || kH1.isEmpty()|| kv1.isEmpty() || kr1.isEmpty() || a1.isEmpty() || b1.isEmpty()|| v1.isEmpty() || p1.isEmpty()) {
            Toast.makeText(this, R.string.nulledition, Toast.LENGTH_SHORT).show();
        } else {
            double v = Double.parseDouble(v1);
            double p = Double.parseDouble(p1);
            double Q = Double.parseDouble(Q1);
            double kH = Double.parseDouble(kH1);
            double kV = Double.parseDouble(kv1);
            double kr = Double.parseDouble(kr1);
            double a = Double.parseDouble(a1);
            double b = Double.parseDouble(b1);
            double Qras = (Q * kH) / (kV * kr);
            if (a / b <= 2.5) {
                Br = a * 2 + 200;
                textViewriad.setText("Рядовой");
                String res = String.format("%.2f", Br);
                textViewBras.setText(res.toString());
            } else {
                Br = a * 3.3 + 200;
                textViewriad.setText("Сортированный");
                String res = String.format("%.0f", Br);
                textViewBras.setText(res.toString());
            }
            if (radioButton10.isChecked()) {
                i = 10;
            } else if (radioButton20.isChecked()) {
                i = 20;
            } else if (radioButton30.isChecked()) {
                i = 30;
            }
            if (radioButton201.isChecked()) {
                j = 20;
            } else if (radioButton301.isChecked()) {
                j = 30;
            }
            int position = (int) spinnerAngleCon.getSelectedItemPosition();
            String pos1 = getDescriptionByPosition(position);
            if (pos1 == "1-5 градусов") {
                kb = 1;
            } else if (pos1 == "6-10 градусов") {
                kb = 0.97;
            } else if (pos1 == "11-15 градусов") {
                kb = 0.95;
            } else
                kb = 0.9;
            if (i == 10 && j == 20) {
                kn = 470;
            } else if (i == 20 && j == 20) {
                kn = 550;
            } else if (i == 30 && j == 20) {
                kn = 640;
            } else if (i == 10 && j == 30) {
                kn = 550;
            } else if (i == 20 && j == 30) {
                kn = 625;
            } else if (i == 30 && j == 30) {
                kn = 700;
            }
            ressqrt = Math.sqrt(Qras / (kn * kb * v * p));
            Bres = (1.1 * (ressqrt + 0.05)) * 1000;
            String resultB = String.format("%.0f", Bres);
            textViewB.setText(resultB.toString());
            if (Br > Bres) {
                Bbol = Br;
            } else if (Bres >= Br) {
                Bbol = Bres;
            }
            if (Bbol <= 500) {
                textViewBgost.setText("500");
            } else if (Bbol <= 650 && Bbol > 500) {
                textViewBgost.setText("650");
            } else if (Bbol <= 800 && Bbol > 650) {
                textViewBgost.setText("800");
            } else if (Bbol <= 1000 && Bbol > 800) {
                textViewBgost.setText("1000");
            } else if (Bbol <= 1200 && Bbol > 1000) {
                textViewBgost.setText("1200");
            } else if (Bbol <= 1400 && Bbol > 1200) {
                textViewBgost.setText("1400");
            } else if (Bbol <= 1600 && Bbol > 1400) {
                textViewBgost.setText("1600");
            } else {
                textViewBgost.setText("B>1600");
            }
        }
    }

    private String getDescriptionByPosition(int position) {
        String[] description = getResources().getStringArray(R.array.con);
        return description[position];

    }
    public void Clickclear(View view) {
        textViewQ.setText(null);
        textViewy.setText(null);
        textViewv.setText(null);
        textViewAmax.setText(null);
        textViewAmin.setText(null);
        textViewkH.setText(null);
        textViewkB.setText(null);
        textViewkr.setText(null);
        textViewB.setText(null);
        textViewBras.setText(null);
        textViewBgost.setText(null);
        textViewriad.setText(null);
    }
}