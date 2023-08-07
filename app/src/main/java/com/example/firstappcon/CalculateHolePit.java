package com.example.firstappcon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculateHolePit extends AppCompatActivity {
    public EditText textviewB;
    public EditText textviewK;
    public EditText textviewT;
    public EditText textviewH;
    public TextView textViewBK, textViewTH1, textViewTH2, textViewHB1, textViewHB2;
    double H;
    double B;
    double K;
    double T;
    double i;
    double j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_hole_pit);
        textviewB=findViewById(R.id.textViewB);
        textviewK=findViewById(R.id.textViewK);
        textviewT=findViewById(R.id.textViewT);
        textviewH=findViewById(R.id.textViewH);
        textViewBK=findViewById(R.id.textViewBK);
        textViewTH1=findViewById(R.id.textViewTH1);
        textViewTH2=findViewById(R.id.textViewTH2);
        textViewHB1=findViewById(R.id.textViewHB1);
        textViewHB2=findViewById(R.id.textViewHB2);
    }

    public void Clickresultcalcpt(View view) {
        String Bval = textviewB.getText().toString();
        String Hval = textviewH.getText().toString();
        String Kval = textviewK.getText().toString();
        String Tval = textviewT.getText().toString();
        if (Bval.isEmpty() || Hval.isEmpty() || Kval.isEmpty() || Tval.isEmpty()) {
            Toast.makeText(this, R.string.nulledition, Toast.LENGTH_SHORT).show();
        } else {
            B = Double.parseDouble(Bval);
            H = Double.parseDouble(Hval);
            K = Double.parseDouble(Kval);
            T = Double.parseDouble(Tval);
            if (B > K) {
                textViewBK.setText("Выполнено");
            } else {
                textViewBK.setText("Увеличь B");
            }
            if (T / H < 0.9) {
                textViewTH1.setText("Увеличь T");
            } else if (T / H > 1.4) {
                textViewTH1.setText("Увеличь H");
            } else {
                textViewTH1.setText("Выполнено");
            }
            if (H / B < 0.75) {
                textViewHB1.setText("Увеличь H");
            } else if (H / B > 0.85) {
                textViewHB1.setText("Увеличь B");
            } else {
                textViewHB1.setText("Выполнено");
            }
            i = T / H;
            j = H / B;
            String res1 = String.format("%.2f",i);
            String res2 = String.format("%.2f",j);
            textViewTH2.setText(res1.toString());
            textViewHB2.setText(res2.toString());
        }
    }
    public void ClickClearPit(View view) {
        textviewB.setText(null);
        textviewK.setText(null);
        textviewT.setText(null);
        textviewH.setText(null);
        textViewBK.setText(null);
        textViewTH1.setText(null);
        textViewTH2.setText(null);
        textViewHB1.setText(null);
        textViewHB2.setText(null);
    }
}