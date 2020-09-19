package com.practica.practica3gencurprfc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class DespliegaIdentificadores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_despliega_identificadores);

        Intent intent= getIntent();
        String rfc = intent.getStringExtra(MainActivity.EXTRA_RFC);
        System.out.println("DEspl "+rfc);
        TextView textView = findViewById(R.id.codRFC);
        textView.setText(rfc);

        Intent intent1 = getIntent();
        String curp = intent1.getStringExtra(MainActivity.EXTRA_CURP);
        System.out.println("DEspl "+curp);
        TextView textView1 = findViewById(R.id.codCURP);
        textView1.setText(curp);

        Intent intent2 = getIntent();
        String edad = intent2.getStringExtra(MainActivity.EXTRA_EDAD);
        System.out.println("DEspl "+edad);
        TextView textView2 = findViewById(R.id.txtEdadDesp);
        textView2.setText(edad);
    }
}