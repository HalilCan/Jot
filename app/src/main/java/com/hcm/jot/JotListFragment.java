package com.hcm.jot;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by halil on 8/25/2017.
 */

public class JotListFragment extends Fragment {

    private RecyclerView mJotRecyclerView;
    private JotAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jot_list, container, false);

        mJotRecyclerView = (RecyclerView) view.findViewById(R.id.jot_recycler_view);
        mJotRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();
        return view;
    }

    private void updateUI() {
        JotBook jotBook = JotBook.get(getActivity());
        List<Jot> jots = jotBook.getJots();

        mAdapter = new JotAdapter(jots);
        mJotRecyclerView.setAdapter(mAdapter);
    }

    private class JotHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mTitleTextView;
        private TextView mDateTextView;
        private Jot mJot;

        public JotHolder (LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_jot, parent, false));

            mTitleTextView = (TextView) itemView.findViewById(R.id.jot_title);
            mDateTextView = (TextView) itemView.findViewById(R.id.jot_date);
            itemView.setOnClickListener(this);
        }

        public void bind(Jot jot) {
            mJot = jot;
            mTitleTextView.setText(mJot.getTitle());
            mDateTextView.setText(mJot.getDate().toString());
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(getActivity(), mJot.getTitle() + " clicked!", Toast.LENGTH_SHORT).show();
        }
    }

    private class JotAdapter extends RecyclerView.Adapter<JotHolder> {
        private List<Jot> mJots;

        public JotAdapter(List<Jot> jots) {
            mJots = jots;
        }

        @Override
        public JotHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new JotHolder(layoutInflater, parent);
        }

        @Override
        //always keep this small and efficient
        public void onBindViewHolder(JotHolder holder, int position) {
            Jot jot = mJots.get(position);
            holder.bind(jot);
        }

        @Override
        public int getItemCount() {
            return mJots.size();
        }
    }

}
