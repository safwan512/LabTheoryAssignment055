package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Task2 extends AppCompatActivity {

    private Spinner spin;
    private ArrayList<String> sign = new ArrayList<>();
    private EditText etNumOne,etNumTwo;
    private TextView tvresult;
    private Button btnCalc,btnresult;

    public double numOne,numTwo,result;

    division div = new division();
    Addition add = new Addition();
    Subtraction sub = new Subtraction();
    Multiply multi = new Multiply();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);

        etNumOne = findViewById(R.id.etNumOne);
        etNumTwo = findViewById(R.id.etNumTwo);
        tvresult = findViewById(R.id.tvResult);
        btnCalc = findViewById(R.id.btnCalc);


        spin = (Spinner) findViewById(R.id.dropOp);
        sign.add("Choose Operator");
        sign.add("Addition");
        sign.add("Subtraction");
        sign.add("Multiplication");
        sign.add("Division");

        ArrayAdapter<String> addData = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,sign);
        addData.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(addData);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                numOne = Double.parseDouble(etNumOne.getText().toString());
                numTwo = Double.parseDouble(etNumTwo.getText().toString());
                String select = spin.getSelectedItem().toString();

                switch(select){
                    case "Addition":
                        result = add.add(numOne,numTwo);
                        tvresult.setText("Answer of Addition is "+result);
                        break;
                    case "Subtraction":
                        result = sub.sub(numOne,numTwo);
                        tvresult.setText("Answer of Subtraction is "+result);
                        break;
                    case "Multiplication":
                        result = multi.multi(numOne,numTwo);
                        tvresult.setText("Answer of Multiplication is "+result);
                        break;
                    case "Division":
                        result = div.div(numOne,numTwo);
                        double check = Double.parseDouble(String.valueOf(result));
                        if(check == 0){
                            Toast.makeText(Task2.this, "Dividend Cannot be zero", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            tvresult.setText("Answer of Division is "+result);
                        }

                        break;
                    default:
                        break;
                }

            }
        });



    }
}