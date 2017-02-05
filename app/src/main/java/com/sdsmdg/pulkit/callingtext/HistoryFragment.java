package com.sdsmdg.pulkit.callingtext;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class HistoryFragment extends Fragment {

    RecyclerView recList;
    DataBaseHandler dbh;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.activity_history, container, false);
        recList = (RecyclerView) view.findViewById(R.id.history_recycler);
        dbh = new DataBaseHandler(getContext());
        addToList();
        return view;
    }


    private List<CallerDetails> createList() {
        List<CallerDetails> result;
        result=dbh.getAllCallers();
        return result;
    }
    public void addToList(){
        recList.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recList.setLayoutManager(llm);
        CallListAdapter ca = new CallListAdapter(createList(),getActivity());
        recList.setAdapter(ca);
    }



}
