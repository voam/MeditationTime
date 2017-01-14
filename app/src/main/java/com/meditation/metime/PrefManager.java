/**
 *  MeDitationTime
 *
 *  PrefManager.class: Saves data on the phone and retrieves saved data
 *
 *  com.bal.wheel: by Marcus from www.github.com/bla
 *
 *  @version    1.0
 *  @author     Meditate to Regenerate (meditatetoregenerate.org)
 */

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

    // Locking file names
    private static final String LOCKED_INTRO = "lockedIntro";
    private static final String LOCKED_JOURNEY_2 = "lockedJourney2";
    private static final String LOCKED_JOURNEY_3 = "lockedJourney3";
    private static final String LOCKED_JOURNEY_4 = "lockedJourney4";
    private static final String LOCKED_JOURNEY_5 = "lockedJourney5";
    private static final String LOCKED_JOURNEY_6 = "lockedJourney6";
    private static final String LOCKED_JOURNEY_7 = "lockedJourney7";

    // Progress file names
    private static final String TIME_START = "timeStart";
    private static final String TOTAL_DURATION = "totalDuration";
    private static final String TOTAL_SESSIONS = "totalSessions";
    private static final String STREAK_DATE = "streakDate";
    private static final String STREAK = "streak";

    int timeThreshold = 60; // Session data is only recorded if the session lasted at least one minute


    /**
     * Creates a prefManager object.
     *
     * @param context   The current context
     */
    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }


    // ----------------
    // Info screens
    // ----------------

    /**
     * Sets the boolean flag, indicating if the user has already entered a certain section of the app.
     *
     * @param activity      The activity for which a flag should be set.
     * @param isFirstTime   <code>true</code> if the user hasn't entered the section yet.
     *                      <code>false</code> if the user has entered the section before.
     */
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

    /**
     * Checks if the user has already entered a certain section of the app or not.
     *
     * @param activity  The activity that shall be checked.
     * @return          Returns <code>true</code> if the user hasn't entered the section yet.
     *                          <code>false</code> if the user has entered the section before.
     */
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


    // ----------------
    // Locking
    // ----------------

    /**
     * Sets the boolean flag to unlock a certain stage of the journey.
     *
     * @param stage The section that shall be unlocked.
     */
    public void setUnlocked(int stage){

        // Check the stage id and set the respective boolean value
        switch(stage){
            case 1: editor.putBoolean(LOCKED_INTRO, false);
                    break;
            case 2: editor.putBoolean(LOCKED_JOURNEY_2, false);
                    break;
            case 3: editor.putBoolean(LOCKED_JOURNEY_3, false);
                    break;
            case 4: editor.putBoolean(LOCKED_JOURNEY_4, false);
                    break;
            case 5: editor.putBoolean(LOCKED_JOURNEY_5, false);
                    break;
            case 6: editor.putBoolean(LOCKED_JOURNEY_6, false);
                    break;
            case 7: editor.putBoolean(LOCKED_JOURNEY_7, false);
                    break;
        }
        editor.commit();
    }

    /**
     * Checks if a certain stage of the journey is still locked.
     *
     * @param stage The section that shall be checked.
     * @return      Returns <code>true</code> if the section is still locked.
     *                      <code>false</code> if the section is unlocked.
     */
    public boolean isLocked(int stage){
        boolean isLocked = false;

        // Check the stage id and return the respective boolean value
        switch(stage){
            case 1: isLocked = pref.getBoolean(LOCKED_INTRO, true);
                    break;
            case 2: isLocked = pref.getBoolean(LOCKED_JOURNEY_2, true);
                    break;
            case 3: isLocked = pref.getBoolean(LOCKED_JOURNEY_3, true);
                    break;
            case 4: isLocked = pref.getBoolean(LOCKED_JOURNEY_4, true);
                    break;
            case 5: isLocked = pref.getBoolean(LOCKED_JOURNEY_5, true);
                    break;
            case 6: isLocked = pref.getBoolean(LOCKED_JOURNEY_6, true);
                    break;
            case 7: isLocked = pref.getBoolean(LOCKED_JOURNEY_7, true);
                    break;
        }
        return isLocked;
    }


    // ----------------
    // Progress
    // ----------------

    /**
     * Saves a timestamp to calculate the duration of a meditation session
     */
    public void sessionStart(){
        editor.putLong(TIME_START, System.currentTimeMillis());
        editor.commit();
    }

    /**
     * Calculates the duration of a meditation session. If the session was longer than one minute:
     * 1) The calculated duration will be added to the total duration.
     * 2) The total number of sessions will be increased by one.
     * 3) If it is the first session of the day, the streak will be increased by one.
     */
    public void sessionEnd(){
        // Calculate session duration
        long startTime = pref.getLong(TIME_START, 0);
        long timeRunInSeconds;
        if(startTime!=0) timeRunInSeconds = (System.currentTimeMillis()-startTime)/1000;
        else timeRunInSeconds = 0;

        // Check if the session duration is longer than the set threshold
        if(timeRunInSeconds>timeThreshold){
            // Add the session duration to the total duration
            long prevDuration = pref.getLong(TOTAL_DURATION, 0);
            editor.putLong(TOTAL_DURATION, prevDuration+timeRunInSeconds);
            editor.commit();

            // Increase total sessions
            int prevSessions = pref.getInt(TOTAL_SESSIONS, 0);
            editor.putInt(TOTAL_SESSIONS, prevSessions+1);
            editor.commit();

            // Set streak
            // Get today's and yesterday's date
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            String todayDate = dateFormat.format(cal.getTime());
            cal.add(Calendar.DATE, -1);
            String yesterdayDate = dateFormat.format(cal.getTime());

            // Get the date stamp associated with the last streak update as well as the respective streak set
            String streakDate = pref.getString(STREAK_DATE, "");
            int streakBefore = pref.getInt(STREAK, 0);
            // Check if the date stamp of the last streak update equals yesterday's date
            // If yes, increase streak by one
            if(streakDate.equals(yesterdayDate)){
                editor.putString(STREAK_DATE, todayDate);
                editor.putInt(STREAK, streakBefore+1);
                editor.commit();
            } else if(streakDate.equals(todayDate)){
                // If the streak was last set today, do nothing
            }else {
                // If the streak was last set before yesterday, set the current streak to one
                editor.putString(STREAK_DATE, todayDate);
                editor.putInt(STREAK, 1);
                editor.commit();
            }
        }

        // Reset the timestamp for the next session
        editor.putLong(TIME_START,0);
    }

    /**
     * Calculates the current streak.
     *
     * @return  Returns the current streak as an integer.
     */
    public int getStreak(){
        // Get today's and yesterday's date
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        String todayDate = dateFormat.format(cal.getTime());
        cal.add(Calendar.DATE, -1);
        String yesterdayDate = dateFormat.format(cal.getTime());

        // Get the date stamp associated with the last streak update as well as the respective  streak set
        String streakDate = pref.getString(STREAK_DATE, "");
        int streakBefore = pref.getInt(STREAK, 0);
        // Check if the date stamp of the last streak update equals today's or yesterday's date
        // If yes, return the current streak
        if(streakDate.equals(yesterdayDate)||streakDate.equals(todayDate)){
            editor.putString(STREAK_DATE, todayDate);
            editor.commit();
            return streakBefore;
        } else {
            // If not, reset the current streak to zero
            editor.putString(STREAK_DATE, null);
            editor.putInt(STREAK, 0);
            editor.commit();
            return 0;
        }
    }

    /**
     * @return Returns the total number of sessions as an integer.
     */
    public int getTotalSessions(){
        int totalSessions = pref.getInt(TOTAL_SESSIONS, 0);
        return totalSessions;
    }

    /**
     * @return  Returns the average duration of all meditation sessions as an integer.
     */
    public int getAvgDuration(){
        long totalDuration = pref.getLong(TOTAL_DURATION, 0);
        int totalSessions = pref.getInt(TOTAL_SESSIONS, 0);
        if (totalSessions!=0) return (int)(totalDuration/totalSessions)/60;
        else return 0;
    }

}