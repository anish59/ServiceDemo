package com.example.anish.servicedemo.helper;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.anish.servicedemo.MainActivity;
import com.example.anish.servicedemo.R;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by anish on 17-03-2017.
 */

public class AlarmHelper extends BroadcastReceiver {

    private AlarmManager alarmManager;

    @Override
    public void onReceive(Context context, Intent intent) {
        showNotification(context, intent);
    }

    private void showNotification(Context context, Intent intent) {
        String title = intent.getExtras().getString(AppConstants.intentTitle);
        String message = intent.getExtras().getString(AppConstants.intentSubTitle);
        Intent intent1 = new Intent(context, MainActivity.class);
        int requestCode = 0;
        PendingIntent pendingIntent = PendingIntent.getActivity(context, requestCode, intent1, PendingIntent.FLAG_ONE_SHOT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(message)
                .setAutoCancel(true)
                .setContentIntent(pendingIntent)
                .setDefaults(NotificationCompat.DEFAULT_SOUND);


        Random random = new Random();
        int m = random.nextInt(9999 - 1000) + 1000;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(m, builder.build()); //0 = ID of notification
    }

    public void setReminder(Context context, Date date, int calId) {
        cancelAlarm(context, calId);
        if (date == null) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Log.e("calendar time",""+calendar);
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra(AppConstants.intentTitle, "Test Title");
        intent.putExtra(AppConstants.intentSubTitle, "Test subtitle");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, calId, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = getAlarmManager(context);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);


    }

    private AlarmManager getAlarmManager(Context context) {

        if (this.alarmManager == null) {
            alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        }
        return alarmManager;
    }

    public void cancelAlarm(Context context, long alarmID) {
        Intent intent = new Intent(context, AlarmHelper.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, (int) alarmID, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarmManager = getAlarmManager(context);
        alarmManager.cancel(pendingIntent);
    }
}
