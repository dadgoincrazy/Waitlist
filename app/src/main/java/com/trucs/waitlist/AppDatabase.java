package com.trucs.waitlist;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Cody on 1/24/2018.
 */
@Database(entities = {Entry.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract EntryDao entryDao();
}
