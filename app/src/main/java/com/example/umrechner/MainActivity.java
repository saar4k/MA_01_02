package com.example.umrechner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Button button1, button2;
    EditText et1, et2;
    TextView tx1, tx2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button Celsius
        button1 = (Button) findViewById(R.id.button1);
        //Button Fahrenheit
        button2 = (Button) findViewById(R.id.button2);
        //Text Celsius
        et1 = (EditText) findViewById(R.id.et1);
        //Text Fahrenheit
        et2 = (EditText) findViewById(R.id.et2);
        tx1 = (TextView) findViewById(R.id.textView11);
        tx2 = (TextView) findViewById(R.id.textView22);


        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et2.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Bitte Fahrenheit eingeben", Toast.LENGTH_SHORT).show();
                }else{
                    Double far = Double.parseDouble(String.valueOf(et2.getText()));
                    Double b = far - 32;
                    Double formel = b * 5/9;
                    DecimalFormat decimalFormat = new DecimalFormat("#.###");
                    String ergebnis = decimalFormat.format(formel);
                    tx2.setText(ergebnis + "°C");
                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et1.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Bitte Celsius eingeben", Toast.LENGTH_SHORT).show();
                } else{
                    Double cel = Double.parseDouble(String.valueOf(et1.getText()));
                    Double formel = cel * 9/5 + 32;
                    String ergebnis = String.valueOf(formel);
                    tx1.setText(ergebnis + "°F");
                }
            }
        });






    }
}