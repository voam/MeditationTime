package org.meditatetoregenerate.metime;

import android.app.Application;

import org.meditatetoregenerate.metime.db.AppDatabase;
import org.meditatetoregenerate.metime.db.AppRepository;

/**
 * Android Application class. Used for accessing singletons.
 */
public class MeTimeApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }
    public AppDatabase getDatabase() {
        return AppDatabase.getInstance(this);
    }

    public AppRepository getRepository() {
        return AppRepository.getInstance(getDatabase());
    }

}
