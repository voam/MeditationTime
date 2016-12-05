package com.meditation.metime;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "metime_info";

    private static final String APP_FIRST_TIME_LAUNCH = "AppFirstTimeLaunch";
    private static final String JOURNEY_FIRST_TIME_LAUNCH = "JourneyFirstTimeLaunch";
    private static final String MOOD_FIRST_TIME_LAUNCH = "MoodFirstTimeLaunch";
    private static final String BALANCING_FIRST_TIME_LAUNCH = "BalancingFirstTimeLaunch";
    private static final String PROGRESS_FIRST_TIME_LAUNCH = "ProgressFirstTimeLaunch";
    private static final String MUSIC_FIRST_TIME_LAUNCH = "MusicFirstTimeLaunch";


    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(String activity, boolean isFirstTime) {
        if(activity.equalsIgnoreCase("App")) editor.putBoolean(APP_FIRST_TIME_LAUNCH, isFirstTime);
        else if(activity.equalsIgnoreCase("Journey")) editor.putBoolean(JOURNEY_FIRST_TIME_LAUNCH, isFirstTime);
        else if(activity.equalsIgnoreCase("Mood")) editor.putBoolean(MOOD_FIRST_TIME_LAUNCH, isFirstTime);
        else if(activity.equalsIgnoreCase("Balancing")) editor.putBoolean(BALANCING_FIRST_TIME_LAUNCH, isFirstTime);
        else if(activity.equalsIgnoreCase("Progress")) editor.putBoolean(PROGRESS_FIRST_TIME_LAUNCH, isFirstTime);
        else if(activity.equalsIgnoreCase("Music")) editor.putBoolean(MUSIC_FIRST_TIME_LAUNCH, isFirstTime);
        else return;
        editor.commit();
    }

    public boolean isFirstTimeLaunch(String activity) {
        boolean isFirstTime = false;
        if(activity.equalsIgnoreCase("App")) isFirstTime = pref.getBoolean(APP_FIRST_TIME_LAUNCH, true);
        else if(activity.equalsIgnoreCase("Journey")) isFirstTime = pref.getBoolean(JOURNEY_FIRST_TIME_LAUNCH, true);
        else if(activity.equalsIgnoreCase("Mood")) isFirstTime = pref.getBoolean(MOOD_FIRST_TIME_LAUNCH, true);
        else if(activity.equalsIgnoreCase("Balancing")) isFirstTime = pref.getBoolean(BALANCING_FIRST_TIME_LAUNCH, true);
        else if(activity.equalsIgnoreCase("Progress")) isFirstTime = pref.getBoolean(PROGRESS_FIRST_TIME_LAUNCH, true);
        else if(activity.equalsIgnoreCase("Music")) isFirstTime = pref.getBoolean(MUSIC_FIRST_TIME_LAUNCH, true);
        return isFirstTime;
    }

}