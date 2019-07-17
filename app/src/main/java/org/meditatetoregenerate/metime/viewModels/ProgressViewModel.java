package org.meditatetoregenerate.metime.viewModels;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;

import org.meditatetoregenerate.metime.MeTimeApp;
import org.meditatetoregenerate.metime.db.AppDatabase;
import org.meditatetoregenerate.metime.db.AppRepository;
import org.meditatetoregenerate.metime.db.ProgressStat;

import java.util.List;

public class ProgressViewModel extends AndroidViewModel {

    private String TAG = getClass().getSimpleName();
    private final AppRepository mRepository;

    private final MediatorLiveData<List<ProgressStat>> mObservableStats;

    // private Application app;
    public ProgressViewModel(@NonNull Application application) {
        //in viewmodels it is ok to have reference to application context
        super(application);
        mObservableStats = new MediatorLiveData<>();

        // set by default null, until we get data from the database.
        mObservableStats.setValue(null);

        mRepository = ((MeTimeApp) application).getRepository();

        LiveData<List<ProgressStat>> stats = mRepository.getStats();
        // observe the changes of the products from the database and forward them
        mObservableStats.addSource(stats, mObservableStats::setValue);

        //Log.i(TAG, "ctor");
    }

    public LiveData<List<ProgressStat>> getProgressStats() {

        return mObservableStats;
    }
}