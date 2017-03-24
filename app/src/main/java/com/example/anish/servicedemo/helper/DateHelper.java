package com.example.anish.servicedemo.helper;

import android.app.AlarmManager;
import android.app.DatePickerDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TimePicker;

/**
 * Created by anish on 16-03-2017.
 */

public class DateHelper {
    public static String yyyyMMddHHmm="yyyyMMddHHmm";
    public static String yyddHHmm="yyddHHmm";//for id
    public static String ddMMyyyy_HHmm="dd-MM-yyyy:HH-mm";

    private static int mYear, mMonth, mDay, mHour, mMin;
    private AlarmManager alarmManager;

    public static void getDateFromDialog(Context mContext, final Button button) {
        final Calendar c = Calendar.getInstance();

        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(mContext, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                datePicker.setMinDate(System.currentTimeMillis() - 1000);
                button.setText(String.format("%s-%s-%s", dayOfMonth, monthOfYear + 1, year));
            }
        }, mYear, mMonth, mDay);

        datePickerDialog.show();
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
    }

    public static void getTimeFromDilog(Context mContext, final Button button) {
        final Calendar c = Calendar.getInstance();

        mHour = c.get(Calendar.HOUR_OF_DAY); //24 hour format
        mMin = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(mContext, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                button.setText(String.format("%s-%s", hourOfDay, minute));
            }
        }, mHour, mMin, false);
        timePickerDialog.show();
    }

    public static Date parseDate(String inputDate, String inputDateType) {
        SimpleDateFormat sdf = new SimpleDateFormat(inputDateType);
        Date date = null;
        try {
            date = sdf.parse(inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String formatDate(String inputDate, String inputPattern, String outputPattern) {

        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outPutFormat = new SimpleDateFormat(outputPattern);
        Date date=null;
        String formattedDate="";

        try {
            date=inputFormat.parse(inputDate);
            formattedDate=outPutFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return formattedDate;
    }



}
