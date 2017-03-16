package com.example.anish.servicedemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnDatePicker,btnTimePicker;
    Context context=MainActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDatePicker=(Button)findViewById(R.id.btnDatePicker);
        btnTimePicker=(Button)findViewById(R.id.btnTimePicker);
    }

    public void clickPickDate(View view) {
        DateHelper.getDateFromDialog(context,btnDatePicker);
    }

    public void clickTimePick(View view) {
        DateHelper.getTimeFromDilog(context,btnTimePicker);
    }
}
