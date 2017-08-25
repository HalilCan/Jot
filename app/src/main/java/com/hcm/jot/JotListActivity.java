package com.hcm.jot;

import android.support.v4.app.Fragment;

/**
 * Created by halil on 8/25/2017.
 */

public class JotListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new JotListFragment();
    }
}
