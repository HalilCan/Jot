package com.hcm.jot;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

/**
 * Created by halil on 8/25/2017.
 */

public class JotFragment extends android.support.v4.app.Fragment {

    private Jot mJot;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mDoneCheckbox;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mJot = new Jot();

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_jot, container, false);

        mTitleField = (EditText) v.findViewById(R.id.jot_title);
        mDateButton = (Button) v.findViewById(R.id.jot_date);
        mDoneCheckbox = (CheckBox) v.findViewById(R.id.jot_done);

        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                mJot.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        mDateButton.setText(mJot.getDate().toString());
        mDateButton.setEnabled(false);

        mDoneCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                mJot.setDone(isChecked);
            }
        });

        return v;
    }


}
