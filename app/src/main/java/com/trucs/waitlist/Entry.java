package com.trucs.waitlist;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Cody on 1/24/2018.
 */
@Entity(tableName = "entry")
public class Entry {

    @PrimaryKey(autoGenerate = true)
    public Long id;

    @ColumnInfo(name = "guest_name")
    public String guestName;

    @ColumnInfo(name = "guest_num")
    public int guestNum;

    public Entry(String guestName, int guestNum) {
        this.guestName = guestName;
        this.guestNum = guestNum;
    }

    public Long getId() {
        return id;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public int getGuestNum() {
        return guestNum;
    }

    public void setGuestNum(int guestNum) {
        this.guestNum = guestNum;
    }
}
