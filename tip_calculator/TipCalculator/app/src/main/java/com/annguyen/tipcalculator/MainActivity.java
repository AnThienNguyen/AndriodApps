package com.annguyen.tipcalculator;

import java.text.DecimalFormat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    double tipPercent;
    double billCost;
    int numOfGuest;
    double costPerGuest;
    String tip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //icon
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        //gets info from text and spinners
        final EditText bill = (EditText)findViewById(R.id.txtBill);
        final Spinner group = (Spinner)findViewById(R.id.txtGroup);
        final Spinner percent = (Spinner)findViewById(R.id.txtPercent);
        Button cost = (Button)findViewById(R.id.btnCost);

        cost.setOnClickListener(new View.OnClickListener() {
            final TextView result = ((TextView)findViewById(R.id.txtResults));
            @Override
            public void onClick(View v) {
                billCost = Double.parseDouble(bill.getText().toString());
                numOfGuest = Integer.parseInt(group.getSelectedItem().toString());

                //converts tip from spinner to string and ignores %
                tip = percent.getSelectedItem().toString();
                tip = tip.replace("%", "");

                //converts string to percent
                tipPercent = Double.parseDouble(tip.toString());
                tipPercent = tipPercent/100;
                costPerGuest = (billCost + (billCost * tipPercent))/ numOfGuest;

                //converts to currency format
                DecimalFormat currency = new DecimalFormat("$###,###.##");

                result.setText("Cost for each of the " + numOfGuest + " guest: " + currency.format(costPerGuest));
            }
        });
    }
}
