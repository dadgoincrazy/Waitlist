package com.trucs.waitlist;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Cody on 1/24/2018.
 */
@Dao
public interface EntryDao {
    @Query("SELECT * FROM entry")
    List<Entry> getAll();

    @Query("SELECT * FROM entry WHERE id IN (:entry_ids)")
    List<Entry> loadAllByIds(long[] entry_ids);

    @Query("SELECT * FROM entry WHERE guest_name LIKE :name LIMIT 1")
    Entry findByName(String name);

    @Query("SELECT * FROM entry WHERE id = :entry_id LIMIT 1")
    Entry get(long entry_id);

    @Insert
    long insert(Entry entry);

    @Update
    void update(Entry entry);

    @Delete
    void delete(Entry entry);
}
