package com.example.anish.servicedemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.anish.servicedemo.helper.AlarmHelper;
import com.example.anish.servicedemo.helper.DateHelper;

public class MainActivity extends AppCompatActivity {
    Button btnDatePicker, btnTimePicker;
    Context context = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDatePicker = (Button) findViewById(R.id.btnDatePicker);
        btnTimePicker = (Button) findViewById(R.id.btnTimePicker);
    }

    public void clickPickDate(View view) {
        DateHelper.getDateFromDialog(context, btnDatePicker);// resulting format: dd-MM-yyyy
    }

    public void clickTimePick(View view) {
        DateHelper.getTimeFromDilog(context, btnTimePicker);// resulting format: Hh-MM-yyyy
    }

    public void clickSetReminder(View view) {
        if (!getResources().getString(R.string.date).toLowerCase().equals("time")
                || !getResources().getString(R.string.time).toLowerCase().equals("time")){
            Toast.makeText(context, "Please Select Date and Time", Toast.LENGTH_SHORT).show();
            return;
        }

        String remindDateNTime=String.format("%s:%s",btnDatePicker.getText().toString(),btnTimePicker.getText().toString());

        AlarmHelper alarmHelper=new AlarmHelper();
//        alarmHelper.setReminder(context,remindDateNTime,);
    }
}
