package com.annguyen.currencyconverter;

import java.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    double euroRate = 0.94;
    double pesoRate = 20.34;
    double cRate = 1.31;
    double entered;
    double convertDola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        //connecting widgets to code by ids
        final EditText currency = (EditText) findViewById(R.id.txtAmount);
        final RadioButton toEuro = (RadioButton) findViewById(R.id.radToEuro);
        final RadioButton toPeso = (RadioButton) findViewById(R.id.radToPeso);
        final RadioButton toCanadian = (RadioButton) findViewById(R.id.radToCanadian);
        final TextView result = (TextView) findViewById(R.id.txtResult);

        //connects button
        Button convert = (Button) findViewById(R.id.btnConvert);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                entered = Double.parseDouble(currency.getText().toString());
                DecimalFormat tenth = new DecimalFormat("#.#");

                //toast
                if (entered > 100000 || entered < 0)
                {
                    Toast.makeText(MainActivity.this, "US Dollars must be <= 100,000 and >0", Toast.LENGTH_LONG).show();
                }

                else {
                    //convert to euro
                    if (toEuro.isChecked()) {
                        convertDola = entered * euroRate;
                        result.setText("€" + tenth.format(convertDola) + " Euros");
                    }
                    //convert to peso
                    if (toPeso.isChecked()) {
                        convertDola = entered * pesoRate;
                        result.setText("$" + tenth.format(convertDola) + " Pesos");
                    }
                    //convert to canadian dollar
                    if (toCanadian.isChecked()) {
                        convertDola = entered * cRate;
                        result.setText("$" + tenth.format(convertDola) + " Canadian Dollars");
                    }
                }
            }
        });
    }
}
