package com.annguyen.mortgageinterestcalculator;

import android.content.SharedPreferences;
import android.icu.text.DecimalFormat;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        TextView interest = (TextView)findViewById(R.id.txtInterest);
        ImageView image = (ImageView)findViewById(R.id.imgYears);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        int intMonthly = sharedPref.getInt("key1", 0);
        int intYears = sharedPref.getInt("key2", 0);
        float decPrincipal = sharedPref.getFloat("key3", 0);
        float decInterest;

        decInterest = (intMonthly * (12 * intYears) - decPrincipal);
        DecimalFormat currency = new DecimalFormat("$###,###.##");
        interest.setText("Interest Paid: " + currency.format(decInterest));

        if (intYears == 30)
        {
            image.setImageResource(R.drawable.thirty);
        }
        else if (intYears == 20)
        {
            image.setImageResource(R.drawable.twenty);
        }
        else if (intYears == 10)
        {
            image.setImageResource(R.drawable.ten);
        }
        else
        {
            interest.setText("Enter 10, 20, or 30 years");
        }
    }
}
