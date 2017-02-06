package com.sdsmdg.pulkit.callingtext;


import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.CallLog;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;

import java.util.List;

import jp.co.recruit_lifestyle.android.widget.WaveSwipeRefreshLayout;
import jp.wasabeef.recyclerview.animators.adapters.ScaleInAnimationAdapter;

public class HistoryFragment extends Fragment {

    RecyclerView recList;
    DataBaseHandler dbh;
    View view;
    WaveSwipeRefreshLayout mWaveSwipeRefreshLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.activity_history, container, false);
        recList = (RecyclerView) view.findViewById(R.id.history_recycler);
        dbh = DataBaseHandler.getInstance(getContext());
        dbh.clear();
        CallerDetails cd =new CallerDetails("name","number","message","outgoing","time");
        dbh.addCaller(cd);
        CallerDetails cd1 =new CallerDetails("name","number","message","incoming","time");
        dbh.addCaller(cd1);
        CallerDetails cd2 =new CallerDetails("name","number","message","outgoing","time");
        dbh.addCaller(cd2);
        CallerDetails cd3 =new CallerDetails("name","number","message","outgoing","time");
        dbh.addCaller(cd3);
        CallerDetails cd4 =new CallerDetails("name","number","message","outgoing","time");
        dbh.addCaller(cd4);
        CallerDetails cd5 =new CallerDetails("name","number","message","outgoing","time");
        dbh.addCaller(cd5);
        CallerDetails cd6 =new CallerDetails("name","number","message","outgoing","time");
        dbh.addCaller(cd6);
        CallerDetails cd7 =new CallerDetails("name","number","message","outgoing","time");
        dbh.addCaller(cd7);
        CallerDetails cd8 =new CallerDetails("name","number","message","outgoing","time");
        dbh.addCaller(cd8);
        CallerDetails cd9 =new CallerDetails("name","number","message","outgoing","time");
        dbh.addCaller(cd9);
        CallerDetails cd10 =new CallerDetails("name","number","message","outgoing","time");
        dbh.addCaller(cd10);
        CallerDetails cd11 =new CallerDetails("name","number","message","outgoing","time");
        dbh.addCaller(cd11);
        addToList();
        mWaveSwipeRefreshLayout = (WaveSwipeRefreshLayout) view.findViewById(R.id.main_swipe);
        mWaveSwipeRefreshLayout.setOnRefreshListener(new WaveSwipeRefreshLayout.OnRefreshListener() {
            @Override public void onRefresh() {
                // Do work to refresh the list here.
                new HistoryFragment.Task().execute();
            }
        });
        return view;
    }
    private class Task extends AsyncTask<Void, Void, String[]> {

        @Override
        protected String[] doInBackground(Void... params) {
            return new String[0];
        }

        @Override protected void onPostExecute(String[] result) {
            // Call setRefreshing(false) when the list has been refreshed.
            mWaveSwipeRefreshLayout.setRefreshing(false);
            super.onPostExecute(result);
        }
    }

    private List<CallerDetails> createList() {
        List<CallerDetails> result;
        result=dbh.getAllCallers();
        Log.e("result",result+"");
        return result;
    }
    public void addToList(){

        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        CallListAdapter ca = new CallListAdapter(createList(),getActivity());
        ScaleInAnimationAdapter alphaAdapter = new ScaleInAnimationAdapter(ca);
        alphaAdapter.setInterpolator(new OvershootInterpolator());
        alphaAdapter.setDuration(1000);
        alphaAdapter.setFirstOnly(false);
        recList.setAdapter(alphaAdapter);
    }



}
