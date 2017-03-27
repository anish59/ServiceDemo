package com.example.anish.servicedemo.helper;

import android.content.res.Resources;

/**
 * Created by anish on 17-03-2017.
 */

public class AppConstants {

    //All Intent Names should specify here
    public static String INTENT_TITLE = "title";
    public static String INTENT_SUBTITLE = "title";
    public static String INTENT_NOTIFY = "notify";

    //other constants
    public static int _BROADCAST = 0;
    public static int _SERVICE = 1;
    public static int _NOTIFY = 2;

    public static String APP_DESCRIPTION =
            "(A) Here I have given you a demo of opening up an activity through :\n" +
             "      1. Service \n" +
              "     2. Broadcast \n" +
             "(B) setting a notification using BroadCast \n\n" +
              "Note: \n" +
               "    I haven't used BroadCast and Service together because that is not the way, you have to use only one of them.\n" +
               "if at all you want to use both tell me, I will teach you. \n" +
               "Thank you!!!";
}
