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
//@Dao
//public interface MyDao {
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    public void insertUsers(User... users);
//
//    @Insert
//    public void insertBothUsers(User user1, User user2);
//
//    @Insert
//    public void insertUsersAndFriends(User user, List<User> friends);

//    @Query("SELECT first_name, last_name FROM user WHERE region IN (:regions)")
//    public LiveData<List<User>> loadUsersFromRegionsSync(List<String> regions);
//}