package com.example.firstappcon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PowerDoubleCon extends AppCompatActivity {
    public EditText textViewL1;
    public EditText textViewL2;
    public EditText textViewBangle;
    public EditText textViewQp;
    public EditText textViewkH;
    public EditText textViewkB;
    public EditText textViewkr;
    public EditText textViewv;
    public EditText textViewKPD;

    public Spinner spinnerB;

    public Spinner spinnerbar;
    public Spinner spinnerAngleBar;
    public EditText textViewB;

    public TextView textViewPowerres;
    public TextView textViewPowerres1;
    public Spinner spinnerNumber;

    double g = 9.81;
    double Lg;
    double H;
    double kd;
    double w;
    double u;
    double e;
    double Ssb;
    double S1;
    double S2;
    double S3;
    double S4;
    double S5;
    double S6;
    double S7;
    double S8;
    double Wsb;
    double Wgr;
    double P;
    double nb;

    double J;
    double Nb;
    double Nelec;
    double Gp;
    double Gp1;
    double Gp2;
    double Wsbk;
    double Wgrk;
    double Wsbgor;
    double Wgrgor;

    String Nelecres;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_power_double_con);
        textViewL1=findViewById(R.id.textViewL1);
        textViewL2=findViewById(R.id.textViewL2);
        textViewBangle=findViewById(R.id.textViewBangle);
        textViewQp=findViewById(R.id.textViewQp);
        textViewkH=findViewById(R.id.textViewkH);
        textViewkB=findViewById(R.id.textViewkB);
        textViewkr=findViewById(R.id.textViewkr);
        textViewv=findViewById(R.id.textViewv);
        textViewKPD =findViewById(R.id.textViewKPD);
        spinnerB = findViewById(R.id.spinnerB);
        spinnerbar = findViewById(R.id.spinnerbar);
        spinnerAngleBar = findViewById(R.id.spinnerAngleBar);
        spinnerNumber = findViewById(R.id.spinnerNumber);
        textViewPowerres = findViewById(R.id.textViewPowerres);
        textViewPowerres1 = findViewById(R.id.textViewPowerres1);
    }

    public void resdouble(View view) {
        String Pull = String.valueOf(spinnerbar.getSelectedItemPosition());
        int pull1 = Integer.parseInt(Pull);

        String conditions1 = String.valueOf(spinnerNumber.getSelectedItemPosition());
        int conditions = Integer.parseInt(conditions1);

        String pullgrad1 = String.valueOf(spinnerAngleBar.getSelectedItemPosition());
        int pullgrad = Integer.parseInt(pullgrad1);

        String width1 = String.valueOf(spinnerB.getSelectedItemPosition());
        int B = Integer.parseInt(width1);

        String Q1 = textViewQp.getText().toString();
        String kH1 = textViewkH.getText().toString();
        String kv1 = textViewkB.getText().toString();
        String kr1 = textViewkr.getText().toString();
        String v1 = textViewv.getText().toString();
        String L = textViewL1.getText().toString();
        String a1 = textViewBangle.getText().toString();
        String KPD1 = textViewKPD.getText().toString();
        String L21 = textViewL2.getText().toString();
        if (Q1.isEmpty() || kH1.isEmpty() || kv1.isEmpty() || kr1.isEmpty() || L.isEmpty() || v1.isEmpty() || a1.isEmpty() || KPD1.isEmpty() || L21.isEmpty()) {
            Toast.makeText(this, R.string.nulledition, Toast.LENGTH_SHORT).show();
        } else {
            double KPD = Double.parseDouble(KPD1);
            double a = Double.parseDouble(a1);
            double L1 = Double.parseDouble(L);
            double Q = Double.parseDouble(Q1);
            double kH = Double.parseDouble(kH1);
            double kV = Double.parseDouble(kv1);
            double kr = Double.parseDouble(kr1);
            double v = Double.parseDouble(v1);
            double L2 = Double.parseDouble(L21);

            if (B == 1) {
                Gp = 7;
                Gp1 = 11.5;
                Gp2 = 7.5;
            } else if (B == 2) {
                Gp = 9.1;
                Gp1 = 12.5;
                Gp2 = 10.5;
            } else if (B == 3) {
                Gp = 11.2;
                Gp1 = 17.9;
                Gp2 = 19;
            } else if (B == 4) {
                Gp = 14;
                Gp1 = 43;
                Gp2 = 28;
            } else if (B == 5) {
                Gp = 16.8;
                Gp1 = 50;
                Gp2 = 31;
            } else if (B == 6) {
                Gp = 19.6;
                Gp1 = 86.5;
                Gp2 = 60;
            } else if (B == 7) {
                Gp = 22.4;
                Gp1 = 92.8;
                Gp2 = 65.8;
            }
            double Qras = (Q * kH) / (kV * kr);
            double qr = (Qras * g) / (36 * v);
            double ql = 0.1 * g * Gp;
            double qp = (Gp1 * g) / 10;
            double qp2 = (Gp2 * g) / (10 * 3);

            Lg = L2 * Math.cos(Math.toRadians(a));
            H = L2 * Math.sin(Math.toRadians(a));


            if (L1 <= 20) {
                kd = 4;
            } else if (L1 > 20 && L1 <= 50) {
                kd = 2.5;
            } else if (L1 > 50 && L1 <= 70) {
                kd = 2.1;
            } else if (L1 > 70 && L1 <= 100) {
                kd = 1.9;
            } else {
                kd = 1.1;
            }

            if (conditions == 1) {
                w = 0.02;
            } else if (conditions == 2) {
                w = 0.025;
            } else if (conditions == 3) {
                w = 0.045;
            } else if (conditions == 4) {
                w = 0.055;
            }

            double Pokr = kd * Lg * w * (qr + qp + qp2 + 2 * ql) + qr * H;

            if (pull1 == 1 && conditions == 1) {
                u = 0.35;
            } else if (pull1 == 1 && conditions == 2) {
                u = 0.3;
            } else if (pull1 == 1 && conditions == 3) {
                u = 0.2;
            } else if (pull1 == 1 && conditions == 4) {
                u = 0.1;
            } else if (pull1 == 2 && conditions == 1) {
                u = 0.5;
            } else if (pull1 == 2 && conditions == 2) {
                u = 0.4;
            } else if (pull1 == 2 && conditions == 3) {
                u = 0.25;
            } else if (pull1 == 2 && conditions == 4) {
                u = 0.15;
            } else if (pull1 == 3 && conditions == 1) {
                u = 0.45;
            } else if (pull1 == 3 && conditions == 2) {
                u = 0.35;
            } else if (pull1 == 3 && conditions == 3) {
                u = 0.25;
            } else if (pull1 == 3 && conditions == 4) {
                u = 0.1;
            }

            if (pullgrad == 1) {
                e = Math.toRadians(180);
            } else if (pullgrad == 2) {
                e = Math.toRadians(210);
            } else if (pullgrad == 3) {
                e = Math.toRadians(270);
            }

            double ue = u * e;
            double snb1 = Math.pow(2.72, ue);
            double Snb = (snb1 / (snb1 - 1)) * Pokr;
            double Ssb = Snb - Pokr;

            Wsbk = (ql + qp2) * 3 * w - ql * 1;
            Wgrk = (qr + ql + qp) * 3 * w + (qr + ql) * 1;
            Wsbgor = (ql + qp2) * L1 * w;
            Wgrgor = (qr + ql + qp) * L1 * w;
            Wgr = (qr + ql + qp) * Lg * w + (qr + ql) * H;
            Wsb = (ql + qp2) * Lg * w - ql * H;

            S1 = (S1 + Wsb + Wsbk+Wsbgor + 0.04 * (S1 + Wsb + Wsbk+Wsbgor)) + Wgrgor +Wsbk+Wgr / snb1;
            S2 = S1 + Wsb;
            S3 = S1 + Wsb + Wsbk;
            S4 = S1 + Wsb + Wsbk+Wsbgor;
            S5 = S1 + Wsb + Wsbk+Wsbgor + 0.04 * (S1 - Wsb + Wsbk+Wsbgor);
            S6 = (S1 + Wsb + Wsbk+Wsbgor + 0.04 * (S1 - Wsb + Wsbk+Wsbgor)) + Wgrgor;
            S7 = (S1 + Wsb + Wsbk+Wsbgor + 0.04 * (S1 - Wsb + Wsbk+Wsbgor)) + Wgrgor +Wsbk;
            S8 = (S1 + Wsb + Wsbk+Wsbgor + 0.04 * (S1 - Wsb + Wsbk+Wsbgor)) + Wgrgor +Wsbk+Wgr;

            J = snb1 / (snb1 - 1);
            nb = 1 / (1 + 0.06 * (2 * J - 1));

            P = (S8 - S1) / nb;

            Nb = P * v / 100;
            Nelec = Nb * 1.2 / KPD;


            if (Nelec <= 3) {
                Nelecres = "3.0";
            } else if (Nelec > 3 && Nelec <= 4) {
                Nelecres = "4.0";
            } else if (Nelec > 4 && Nelec <= 5.5) {
                Nelecres = "5.5";
            } else if (Nelec > 5.5 && Nelec <= 7.5) {
                Nelecres = "7.5";
            } else if (Nelec > 7.5 && Nelec <= 11) {
                Nelecres = "11";
            } else if (Nelec > 11 && Nelec <= 15) {
                Nelecres = "15";
            } else if (Nelec > 15 && Nelec <= 18.5) {
                Nelecres = "18.5";
            } else if (Nelec > 18.5 && Nelec <= 22) {
                Nelecres = "22";
            } else if (Nelec > 22 && Nelec <= 30) {
                Nelecres = "30";
            } else if (Nelec > 30 && Nelec <= 37) {
                Nelecres = "37";
            } else if (Nelec > 37 && Nelec <= 44) {
                Nelecres = "44";
            } else if (Nelec > 44 && Nelec <= 60) {
                Nelecres = "60";
            } else if (Nelec > 60 && Nelec <= 74) {
                Nelecres = "74";
            } else if (Nelec > 74 && Nelec <= 90) {
                Nelecres = "90";
            } else if (Nelec > 90 && Nelec <= 110) {
                Nelecres = "110";
            } else {
                Nelecres = "150";
            }
            String result1 = String.format("%.1f", Nelec);
            textViewPowerres.setText(result1.toString());
            textViewPowerres1.setText(Nelecres);
        }
    }
    public void ClickCleardoble(View view) {
        textViewL1.setText(null);
        textViewL2.setText(null);
        textViewBangle.setText(null);
        textViewQp.setText(null);
        textViewkH.setText(null);
        textViewkB.setText(null);
        textViewkr.setText(null);
        textViewv.setText(null);
        textViewL1.setText(null);
        textViewKPD.setText(null);
        textViewPowerres.setText(null);
        textViewPowerres1.setText(null);
    }
}