package com.hcm.jot;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by halil on 8/25/2017.
 */

public class JotBook {
    private static JotBook sJotBook;
    private List<Jot> mJots;

    public static JotBook get(Context context) {
        if (sJotBook == null) {
            sJotBook = new JotBook(context);
        }
        return sJotBook;
    }

    private JotBook(Context context) {
        mJots = new ArrayList<>();
        for (int i = 0; i < 100; i ++) {
            Jot jot = new Jot();
            jot.setTitle("Jot #" + i);
            jot.setDone(i%2 == 0);
            mJots.add(jot);
        }
    }

    public List<Jot> getJots() {
        return mJots;
    }

    public Jot getJot(UUID id) {
        for (Jot jot : mJots) {
            if (jot.getId().equals(id)) {
                return jot;
            }
        }
        return null;
    }

}
