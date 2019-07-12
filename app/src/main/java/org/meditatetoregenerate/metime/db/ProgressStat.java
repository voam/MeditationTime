package org.meditatetoregenerate.metime.db;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "progress_stats")
public class ProgressStat {

    @PrimaryKey (autoGenerate = true)
    private int id;
    private int Thoughtless;
    private int Balanced;
    private int Peaceful;
    private long DateTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getThoughtless() {
        return Thoughtless;
    }

    public void setThoughtless(int thoughtless) {
        Thoughtless = thoughtless;
    }

    public int getBalanced() {
        return Balanced;
    }

    public void setBalanced(int balanced) {
        Balanced = balanced;
    }

    public int getPeaceful() {
        return Peaceful;
    }

    public void setPeaceful(int peaceful) {
        Peaceful = peaceful;
    }

    public long getDateTime() {
        return DateTime;
    }

    public void setDateTime(long dateTime) {
        DateTime = dateTime;
    }
}
