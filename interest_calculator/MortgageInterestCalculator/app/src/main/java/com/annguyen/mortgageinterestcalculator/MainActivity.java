package com.annguyen.mortgageinterestcalculator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    int intMonthly;
    int intYears;
    float decPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        final EditText monthly = (EditText)findViewById(R.id.txtMonthly); //years
        final EditText years = (EditText)findViewById(R.id.txtYears);   //loan
        final EditText principal = (EditText)findViewById(R.id.txtPrincipal);
        Button button = (Button)findViewById(R.id.btnInterest);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intMonthly = Integer.parseInt(monthly.getText().toString());
                intYears = Integer.parseInt(years.getText().toString());
                decPrincipal = Float.parseFloat(principal.getText().toString());

                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("key1", intMonthly);
                editor.putInt("key2", intYears);
                editor.putFloat("key3", decPrincipal);
                editor.commit();

                startActivity(new Intent(MainActivity.this, Payment.class));
            }
        });
    }
}
