package com.example.spinnerdemo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.spinnerdemo2.R;

public class MainActivity extends  AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText Opd1,Opd2;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Opd1 = (EditText) findViewById(R.id.txtOpd1);
        Opd1.setText("100");
        Opd2 = (EditText) findViewById(R.id.txtOpd2);
        Opd2.setText("50");
        Spinner sp = (Spinner) findViewById(R.id.spinner);
        sp.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        int v1, v2;
        double r = 0.0;
        v1 = Integer.parseInt(Opd1.getText().toString());
        v2 = Integer.parseInt(Opd2.getText().toString());
        try {
            switch (position) {
                case 0:
                    r = v1 + v2;
                    break;
                case 1:
                    r = v1 - v2;
                    break;
                case 2:
                    r = v1 * v2;
                    break;
                case 3:
                    r = (double) v1 / v2;
                    break;
            }
            output.setText("運算結果 =" + String.format("%.2f", r));

        } catch (NumberFormatException e) {
            output.setText("請輸入數字");
            return;
        } catch (ArithmeticException e) {
            output.setText("除數不可為0");
            return;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}