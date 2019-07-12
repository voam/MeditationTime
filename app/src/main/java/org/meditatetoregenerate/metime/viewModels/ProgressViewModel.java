package org.meditatetoregenerate.metime.viewModels;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import org.meditatetoregenerate.metime.db.AppDatabase;
import org.meditatetoregenerate.metime.db.ProgressStat;

import java.util.List;

public class ProgressViewModel extends AndroidViewModel {

    private String TAG = getClass().getSimpleName();
    private MutableLiveData<List<ProgressStat>> progressStats;

    private Application app;
    public ProgressViewModel(@NonNull Application application) {
        //in viewmodels it is ok to have reference to application context
        super(application);
        app = application;
        Log.i(TAG, "ctor");
    }

    public LiveData<List<ProgressStat>> getProgressStats() {
        if (progressStats == null) {
            progressStats = new MutableLiveData<List<ProgressStat>>();
            loadProgressStats();
        }
        return progressStats;
    }

    private void loadProgressStats() {
        // Do an asynchronous operation to fetch stats.
        new AsyncTask<Void, Void, List<ProgressStat>>() {
            @Override
            protected  List<ProgressStat> doInBackground(Void...voids) {
                Log.i(TAG, "loadProgressStats.doInBackground");
                AppDatabase db = AppDatabase.getAppDatabase( app );
                return db
                        .statsDao()
                        .loadAllStats();
            }

            @Override
            protected void onPostExecute(List<ProgressStat> data) {

                Log.i(TAG, "loadProgressStats.onPostExecute");
             //   Log.i(TAG, data.toString());

                progressStats.setValue(data);

            }
        }.executeOnExecutor(  AsyncTask.THREAD_POOL_EXECUTOR);

    }
}
//public class MyViewModel extends ViewModel {
//    private MutableLiveData<List<User>> users;
//    public LiveData<List<User>> getUsers() {
//        if (users == null) {
//            users = new MutableLiveData<List<User>>();
//            loadUsers();
//        }
//        return users;
//    }
//
//    private void loadUsers() {
//        // Do an asynchronous operation to fetch users.
//    }
//}