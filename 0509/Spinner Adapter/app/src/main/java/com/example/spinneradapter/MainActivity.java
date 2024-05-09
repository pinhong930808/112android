package com.example.spinneradapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private String[] courses,deserts;
    private Spinner spCourses,spDesserts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        courses = getResources().getStringArray(R.array.courses);
        deserts=getResources().getStringArray(R.array.dessert);


        spCourses = (Spinner) findViewById(R.id.spinner);
        spDesserts = (Spinner) findViewById(R.id.spinner2);

        ArrayAdapter<String> adpCourses  = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, courses);
        ArrayAdapter<String> adpDeserts  = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, deserts);

        spCourses.setAdapter(adpCourses);
        spDesserts.setAdapter(adpDeserts);
        Button btnConfirm = (Button) findViewById(R.id.button);
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String course = spCourses.getSelectedItem().toString();
                String dessert= spDesserts.getSelectedItem().toString();
                TextView output = (TextView) findViewById(R.id.lblOutput);
                output.setText("主餐:"+course+"\n甜點"+dessert);
            }
        });

    }
}