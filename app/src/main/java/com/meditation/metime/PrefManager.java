package com.meditation.metime;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "metime_info";

    // Info screens file names
    private static final String APP_FIRST_TIME_LAUNCH = "AppFirstTimeLaunch";
    private static final String JOURNEY_FIRST_TIME_LAUNCH = "JourneyFirstTimeLaunch";
    private static final String MOOD_FIRST_TIME_LAUNCH = "MoodFirstTimeLaunch";
    private static final String BALANCING_FIRST_TIME_LAUNCH = "BalancingFirstTimeLaunch";
    private static final String PROGRESS_FIRST_TIME_LAUNCH = "ProgressFirstTimeLaunch";
    private static final String MUSIC_FIRST_TIME_LAUNCH = "MusicFirstTimeLaunch";

    // Progress file names
    private static final String TIME_START = "timeStart";

    private static final String TOTAL_DURATION = "totalDuration";
    private static final String TOTAL_SESSIONS = "totalSessions";
    private static final String STREAK_DATE = "streakDate";
    private static final String STREAK = "streak";

    int timeThreshold = 60; // Session data is only recorded if the session lasted at least one minute


    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    // Info screens
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

    // Progress
    public void sessionStart(){
        editor.putLong(TIME_START, System.currentTimeMillis());
        editor.commit();
    }

    public void addToTotalDuration(int duration){
        int prevDuration = pref.getInt(TOTAL_DURATION, 0);
        editor.putInt(TOTAL_DURATION, prevDuration+duration);
        editor.commit();
    }

    public void increaseTotalSessions(){
        int prevSessions = pref.getInt(TOTAL_SESSIONS, 0);
        editor.putInt(TOTAL_SESSIONS, prevSessions+1);
        editor.commit();
    }

    public void setStreak(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        String todayDate = dateFormat.format(cal.getTime());
        cal.add(Calendar.DATE, -1);
        String yesterdayDate = dateFormat.format(cal.getTime());

        String streakDate = pref.getString(STREAK_DATE, "");
        int streakBefore = pref.getInt(STREAK, 0);
        if(streakDate.equals(yesterdayDate)||streakDate.equals(todayDate)){
            editor.putString(STREAK_DATE, todayDate);
            editor.putInt(STREAK, streakBefore+1);
            editor.commit();
        } else {
            editor.putString(STREAK_DATE, todayDate);
            editor.putInt(STREAK, 1);
            editor.commit();
        }
    }

    public void sessionEnd(){
        // Calculate duration
        long startTime = pref.getLong(TIME_START, 0);
        long timeRunInSeconds;
        if(startTime!=0) timeRunInSeconds = (System.currentTimeMillis()-startTime)/1000;
        else timeRunInSeconds = 0;

        if(timeRunInSeconds>timeThreshold){
            long prevDuration = pref.getLong(TOTAL_DURATION, 0);
            editor.putLong(TOTAL_DURATION, prevDuration+timeRunInSeconds);
            editor.commit();

            // Increase total sessions
            int prevSessions = pref.getInt(TOTAL_SESSIONS, 0);
            editor.putInt(TOTAL_SESSIONS, prevSessions+1);
            editor.commit();

            // Set streak
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            String todayDate = dateFormat.format(cal.getTime());
            cal.add(Calendar.DATE, -1);
            String yesterdayDate = dateFormat.format(cal.getTime());

            String streakDate = pref.getString(STREAK_DATE, "");
            int streakBefore = pref.getInt(STREAK, 0);
            if(streakDate.equals(yesterdayDate)){
                editor.putString(STREAK_DATE, todayDate);
                editor.putInt(STREAK, streakBefore+1);
                editor.commit();
            } else if(streakDate.equals(todayDate)){
                // Do nothing
            }else {
                editor.putString(STREAK_DATE, todayDate);
                editor.putInt(STREAK, 1);
                editor.commit();
            }
        }
        editor.putLong(TIME_START,0);
    }

    public int getStreak(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        String todayDate = dateFormat.format(cal.getTime());
        cal.add(Calendar.DATE, -1);
        String yesterdayDate = dateFormat.format(cal.getTime());

        String streakDate = pref.getString(STREAK_DATE, "");
        int streakBefore = pref.getInt(STREAK, 0);
        if(streakDate.equals(yesterdayDate)||streakDate.equals(todayDate)){
            editor.putString(STREAK_DATE, todayDate);
            editor.commit();
            return streakBefore;
        } else {
            editor.putString(STREAK_DATE, null);
            editor.putInt(STREAK, 0);
            editor.commit();
            return 0;
        }
    }

    public int getTotalSessions(){
        int totalSessions = pref.getInt(TOTAL_SESSIONS, 0);
        return totalSessions;
    }

    public int getAvgDuration(){
        long totalDuration = pref.getLong(TOTAL_DURATION, 0);
        int totalSessions = pref.getInt(TOTAL_SESSIONS, 0);
        if (totalSessions!=0) return (int)(totalDuration/totalSessions)/60;
        else return 0;
    }

}