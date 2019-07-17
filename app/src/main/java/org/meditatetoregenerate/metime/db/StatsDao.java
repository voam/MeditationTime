package org.meditatetoregenerate.metime.db;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface StatsDao {

    @Insert
    public long insertProgressStat(ProgressStat progress);

    @Query("SELECT * FROM progress_stats ORDER BY DateTime")
    public LiveData< List<ProgressStat>> loadAllStats();

    @Query("DELETE FROM progress_stats")
    public void clearStats();

}
