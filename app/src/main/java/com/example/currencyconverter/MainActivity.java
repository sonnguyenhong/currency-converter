package com.example.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner fromSpinner;
    private Spinner toSpinner;
    private EditText fromInput;
    private TextView output;
    private Button convertBtn;

    private String[] fromItems = {"USD", "EUR", "VND"};
    private String[] toItems = {"USD", "EUR", "VND"};
    private double fromRateBaseVND[] = {23000, 30000, 1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fromSpinner = (Spinner) findViewById(R.id.fromSpinner);
        toSpinner = (Spinner) findViewById(R.id.toSpinner);
        fromInput = (EditText) findViewById(R.id.fromInput);
        output = (TextView) findViewById(R.id.output);
        convertBtn = (Button) findViewById(R.id.convertBtn);

        ArrayAdapter<String> fromAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, fromItems);
        ArrayAdapter<String> toAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, toItems);
        fromSpinner.setAdapter(fromAdapter);
        toSpinner.setAdapter(toAdapter);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fromCurrency = fromSpinner.getSelectedItem().toString();
                String toCurrency = toSpinner.getSelectedItem().toString();
                Double fromAmount = Double.parseDouble(fromInput.getText().toString());

                int fromIndex = indexOf(fromItems, fromCurrency);
                int toIndex = indexOf(toItems, toCurrency);

                Double result = fromAmount * fromRateBaseVND[fromIndex] / fromRateBaseVND[toIndex];
                System.out.println(fromIndex);
                System.out.println(toIndex);
                System.out.println(fromCurrency);
                System.out.println(toCurrency);
                System.out.println(fromRateBaseVND[fromIndex]);
                System.out.println(fromRateBaseVND[toIndex]);
                System.out.println(result);
                output.setText(result.toString());
            }
        });

    }

    private int indexOf(String[] arr, String key) {
        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}