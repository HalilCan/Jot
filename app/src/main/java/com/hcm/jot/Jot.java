package com.hcm.jot;

import java.util.Date;
import java.util.UUID;

/**
 * Created by halil on 8/25/2017.
 */

public class Jot {
    private UUID mId;
    private String mTitle;
    private String mNotes;
    private Date mDate;
    private boolean mUrgent;
    private boolean mDone;

    public Jot() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

    public UUID getId() {
        return mId;
    }

    public void setId(UUID mId) {
        this.mId = mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmNotes() {
        return mNotes;
    }

    public void setmNotes(String mNotes) {
        this.mNotes = mNotes;
    }

    public Date getDate() {
        return mDate;
    }

    public void setDate(Date mDate) {
        this.mDate = mDate;
    }

    public boolean isDone() {
        return mDone;
    }

    public void setDone(boolean mDone) {
        this.mDone = mDone;
    }

    public boolean isUrgent() {
        return mUrgent;
    }

    public void setUrgent(boolean mUrgent) {
        this.mUrgent = mUrgent;
    }
}
