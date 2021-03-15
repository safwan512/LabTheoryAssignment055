package com.example.task1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
public static int oncreate = 0;
public static int onstart;
public static int onresume;
public static int onrestart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView xcreate = findViewById(R.id.tvCreate);
        oncreate++;
        Log.d("LifeCycle","On Create Called "+oncreate);
        xcreate.setText("onCreate() calls: "+oncreate);
        Button btnStart = findViewById(R.id.btnActivity);


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent next = new Intent(MainActivity.this,Task2.class);
                startActivity(next);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        TextView xstart = findViewById(R.id.tvStart);
        Log.d("LifeCycle","On Create Called "+oncreate);
        onstart++;
        xstart.setText("onStart() calls: "+onstart);
    }

    @Override
    protected void onResume() {
        super.onResume();

        TextView xResume = findViewById(R.id.tvResume);

        onresume++;
        xResume.setText("onResume() calls: "+onresume);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        TextView xRestart = findViewById(R.id.tvRestart);
        onrestart++;
        xRestart.setText("onReStart() calls: "+onrestart);

    }








}