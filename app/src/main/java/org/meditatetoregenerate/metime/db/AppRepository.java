package org.meditatetoregenerate.metime.db;

import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;

import java.util.List;

public class AppRepository {

    private String TAG = getClass().getSimpleName();
    private static AppRepository sInstance;
    private final AppDatabase mDatabase;
    private MediatorLiveData<List<ProgressStat>> mObservableStats;

    private AppRepository(final AppDatabase database) {
        mDatabase = database;
        mObservableStats = new MediatorLiveData<>();

        mObservableStats.addSource(mDatabase.statsDao().loadAllStats(),
                statEntities -> {

                //    if (mDatabase.getDatabaseCreated().getValue() != null) {
                        mObservableStats.postValue(statEntities);
                  //  }
                });

    }

    public static AppRepository getInstance(final AppDatabase database) {
        if (sInstance == null) {
            synchronized (AppRepository.class) {
                if (sInstance == null) {
                    sInstance = new AppRepository(database);
                }
            }
        }
        return sInstance;
    }

    public LiveData<List<ProgressStat>> getStats() {
        return mObservableStats;
    }
    public void insert (ProgressStat stat) {
      //  Log.i(TAG, "performing insert");
        new SaveStatsTask().execute(stat);
    }

    private class SaveStatsTask extends AsyncTask<ProgressStat, Void, Long> {

        @Override
        protected Long doInBackground(ProgressStat... p) {

//            Log.i(TAG, "doInBackground");
//            Log.i(TAG, p.toString());
            p[0].setDateTime(System.currentTimeMillis() / 1000L);

            //  AppDatabase db = AppDatabase.getInstance( Progress.this.getApplicationContext() );

          //  stat.setDateTime(System.currentTimeMillis() / 1000L);
            Long result = 0L;
            try {
                result = mDatabase.statsDao().insertProgressStat(p[0]);
            }
            catch(Exception ex) {
             //   Log.e(TAG, ex.getMessage());
                ex.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(Long result) {
            //  super.onPostExecute(result);
          //  Log.i(TAG, "onPostExecute " + result);
        }
    }
}
