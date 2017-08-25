package com.hcm.jot;

import java.util.Date;
import java.util.UUID;

/**
 * Created by halil on 8/25/2017.
 */

public class Jot {
    private UUID mId;
    private String mTitle;
    private String mDescription;
    private Date mDate;
    private boolean mDone;

    public Jot() {
        mId = UUID.randomUUID();
        mDate = new Date();
    }

}
