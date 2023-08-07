package com.example.firstappcon;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CalcVolume extends AppCompatActivity {
    public Spinner spinnerScrolMat;
    public EditText textViewAngleA;
    public EditText textViewAngleB;
    public EditText textViewfi;
    public EditText textViewL;
    private EditText textViewy;
    public TextView textViewV, textViewh, textViewr;
    double L;
    double Bangel;
    double b;
    double a;
    double Aangle;
    double Cangle;
    double h;
    double r;

    double pi=3.14;
    double Vk;
    double kef=0.33333;
    double Locr;
    double AngleK;
    double Vokr;
    double T;
    double Vresult;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_volume);
        spinnerScrolMat = findViewById(R.id.spinnerScrolMat);
        textViewAngleB = findViewById(R.id.textViewAngleB);
        textViewfi = findViewById(R.id.textViewfi);
        textViewL=findViewById(R.id.textViewL);
        textViewV=findViewById(R.id.textViewV);
        textViewr=findViewById(R.id.textViewr);
        textViewh=findViewById(R.id.textViewh);
        textViewAngleA = findViewById(R.id.textViewAngleA);
        textViewy =findViewById(R.id.textViewy);

        ArrayAdapter<?> adapter = ArrayAdapter.createFromResource(this, R.array.goods, android.R.layout.simple_spinner_item );
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        // Применяем адаптер к элементу spinner
        spinnerScrolMat.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                // Получаем выбранный объект
                // String item = (String) parent.getItemAtPosition(position);
                int pos1 = spinnerScrolMat.getSelectedItemPosition();
                int pos2= spinnerScrolMat.getSelectedItemPosition();
                int pos3= spinnerScrolMat.getSelectedItemPosition();
                String goods1 =GetPos1(pos1);
                String good2 = GetPos2(pos2);
                String good3 = GetPos2(pos3);
                textViewAngleB.setText(goods1);
                textViewfi.setText(good2);
                textViewy.setText(good3);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinnerScrolMat.setOnItemSelectedListener(itemSelectedListener);
    }

    private String GetPos1(int pos1){
        String[] desc = getResources().getStringArray(R.array.conveyor_array);
        return desc[pos1];
    }
    private String GetPos2(int pos2){
        String[] desc = getResources().getStringArray(R.array.slope);
        return desc[pos2];
    }
    private String GetPos3(int pos3) {
        String[] desc = getResources().getStringArray(R.array.Destiny);
        return desc[pos3];
    }
    public void ClickresultVolume(View view) {
        String length = textViewL.getText().toString();
        String AngleB = textViewAngleB.getText().toString();
        String AngleK = textViewAngleA.getText().toString();
        if (length.isEmpty() || AngleB.isEmpty() || AngleK.isEmpty()) {
            Toast.makeText(this, R.string.nulledition, Toast.LENGTH_SHORT).show();
        } else {
            L = Double.parseDouble(length);
            b = Double.parseDouble(AngleB);
            T = Double.parseDouble(AngleK);
            Bangel = Math.sin(Math.toRadians(b));
            Cangle = Math.cos(Math.toRadians(b));
            h = L * Bangel - 0.2;

            String AngleA = textViewfi.getText().toString();
            a = Double.parseDouble(AngleA);
            Aangle = Math.sin(Math.toRadians(a));
            r = (h * Aangle) / 2;
            Vk = kef * pi * r * r * h;
            Locr = (pi * L * Cangle * T) / 180;
            Vokr = Locr * h * r;
            Vresult = Vk + Vokr;
            String result1 = String.format("%.1f", h);
            String result2 = String.format("%.1f", r);
            String result3 = String.format("%.1f", Vresult);
            textViewh.setText(result1.toString());
            textViewr.setText(result2.toString());
            textViewV.setText(result3.toString());
        }
    }
    public void ClickClearVolume(View view) {
        textViewL.setText(null);
        textViewAngleA.setText(null);
        textViewV.setText(null);
        textViewh.setText(null);
        textViewr.setText(null);
        textViewfi.setText(null);
        textViewy.setText(null);
        textViewAngleB.setText(null);
    }
}