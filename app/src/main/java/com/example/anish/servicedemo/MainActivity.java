package com.example.anish.servicedemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.anish.servicedemo.helper.AlarmHelper;
import com.example.anish.servicedemo.helper.AppConstants;
import com.example.anish.servicedemo.helper.DateHelper;

import java.util.Date;

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
        DateHelper.getTimeFromDilog(context, btnTimePicker);// resulting format: HH-mm
    }

    public void clickSetBroadCast(View view) {
        callReminder(AppConstants.IntentBroadCast);
    }


    public void clickSetService(View view) {
        callReminder(AppConstants.IntentService);
    }

    private void callReminder(int receiverOption) {
        if (getResources().getString(R.string.date).toLowerCase().equals(btnDatePicker.getText().toString().toLowerCase())
                || getResources().getString(R.string.time).toLowerCase().equals(btnTimePicker.getText().toString().toLowerCase())) {
            Toast.makeText(context, "Please Select Date and Time", Toast.LENGTH_SHORT).show();
            return;
        }

        String remindDateNTime = String.format("%s:%s", btnDatePicker.getText().toString(), btnTimePicker.getText().toString());
        Date date = DateHelper.parseDate(remindDateNTime, DateHelper.ddMMyyyy_HHmm);
        int calId = Integer.parseInt(DateHelper.formatDate(remindDateNTime, DateHelper.ddMMyyyy_HHmm, DateHelper.yyddHHmm));
        Log.e("remindDateNTime:-> ", remindDateNTime);
        Log.e("date:-> ", date + "");
        Log.e("calId:-> ", calId + "");
        AlarmHelper alarmHelper = new AlarmHelper();
        alarmHelper.setReminder(context, date, calId, receiverOption);
    }

}
