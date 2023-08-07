package com.example.firstappcon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalcHole extends AppCompatActivity {

    public EditText textViewAmax;
    public EditText textViewAmin;
    public EditText textViewA;
    public EditText textViewB;
    public EditText textViewy;
    public EditText textViewangle;
    public TextView textViewres;
    double ai;
    double r;
    double c;
    double g = 9.81;
    double v;
    double k;
    double Q;
    double i=0.4;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_hole);
        textViewAmax = findViewById(R.id.textViewAmax);
        textViewAmin = findViewById(R.id.textViewAmin);
        textViewA = findViewById(R.id.textViewA);
        textViewB = findViewById(R.id.textViewB);
        textViewy = findViewById(R.id.textViewy);
        textViewangle = findViewById(R.id.textViewangle);
        textViewres = findViewById(R.id.textViewres);
    }
    public void res(View view) {
        String Amax = textViewAmax.getText().toString();
        String Amin = textViewAmin.getText().toString();
        String A1 = textViewA.getText().toString();
        String B1 = textViewB.getText().toString();
        String Acon1 = textViewangle.getText().toString();
        String t1 = textViewy.getText().toString();
        if (Amax.isEmpty() || Amin.isEmpty() || A1.isEmpty() || B1.isEmpty()|| Acon1.isEmpty()|| t1.isEmpty()) {
            Toast.makeText(this, R.string.nulledition, Toast.LENGTH_SHORT).show();
        } else {
            double Acon = Double.parseDouble(Acon1);
            double amax1 = Double.parseDouble(Amax);
            double amin1 = Double.parseDouble(Amin);
            double A2 = Double.parseDouble(A1);
            double B2 = Double.parseDouble(B1);
            double t = Double.parseDouble(t1);
            double alfa = Math.sin(Math.toRadians(Acon));
            double amax = amax1 / 1000;
            double amin = amin1 / 1000;
            double A = A2 / 1000;
            double B = B2 / 1000;
            if (amax / amin <= 2.5) {
                ai = (amin + amax) / 2;
            } else {
                ai = amax;
            }
            r = ((A - ai) * (B - ai)) / (2 * (A + B - 2 * ai));
            if (amin < 0.005) {
                c = 0.2;
            } else {
                c = 0.4;// тау = 15 беру из статьи  потом можно сделать апгрейд и сделать выбор и книги про бункера стр24
            }
            k = Math.sqrt(2 * g * (2.1 * r - ((3.4 * 15) / (t * 1000))));
            v = alfa * c * k;
            Q = 3600 * v * A * B * t * i;
            String res = String.format("%.2f", Q);
            textViewres.setText(res.toString());
        }
    }
    public void ClickClearHoleCalc(View view) {
        textViewAmax.setText(null);
        textViewAmin.setText(null);
        textViewA.setText(null);
        textViewB.setText(null);
        textViewy.setText(null);
        textViewangle.setText(null);
        textViewres.setText(null);
    }
}