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

public class Task2 extends AppCompatActivity {

    public String op;
    public float calculation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task2);

        EditText numOne = findViewById(R.id.etNumOne);
        EditText numTwo = findViewById(R.id.etNumTwo);
        TextView result = findViewById(R.id.tvResult);
        Button calc = findViewById(R.id.btnCalc);

        Spinner mySpin = (Spinner) findViewById(R.id.dropOp);
        ArrayAdapter<String> myAdap = new ArrayAdapter<String>(Task2.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.operation));
        myAdap.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpin.setAdapter(myAdap);


        mySpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch(position){
                    case 0:
                        op = "+";
                        break;
                    case 1:
                        op = "-";
                        break;
                    case 2:
                        op = "*";
                        break;
                    case 3:
                        op = "/";
                        break;
                    default:
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



calc.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String Val = numOne.getText().toString();
        float num1 = Float.parseFloat(Val);
        String Val2 = numTwo.getText().toString();
        float num2 = Float.parseFloat(Val2);

        switch(op){
            case "+":
                calculation = num1+num2;
                break;
            case "-":
                calculation = num1-num2;
                break;
            case "*":
                calculation = num1*num2;
                break;
            case "/":
                calculation = num1/num2;
                break;
            default:
                break;
        }

        result.setText("Result is: "+calculation);
    }
});


        Button btnR = findViewById(R.id.btnReturn);
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ret = new Intent(Task2.this,MainActivity.class);
                startActivity(ret);
            }
        });
    }
}