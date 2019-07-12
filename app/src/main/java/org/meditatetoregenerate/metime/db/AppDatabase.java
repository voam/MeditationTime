package org.meditatetoregenerate.metime.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {ProgressStat.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME  = "metime-db";

    private static AppDatabase INSTANCE;

    public abstract StatsDao statsDao();

    public static AppDatabase getAppDatabase(Context context) {

        if (INSTANCE == null) {

            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class, DB_NAME)
                    .fallbackToDestructiveMigration() //todo: change this when schema settled
                .build();
        }
        return INSTANCE;
    }
}