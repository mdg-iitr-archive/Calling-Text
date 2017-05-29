package com.sdsmdg.pulkit.callingtext;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pulkit on 19/5/17.
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ListViewHolder> {

    private HistoryAdapter.ListViewHolder hold;
    private List<CallerDetails> historyList;
    private Activity parentActivity;
    private final HistoryAdapter.OnItemLongClickListener listener;

    public HistoryAdapter(List<CallerDetails> historyList, Activity parentActivity, OnItemLongClickListener listener) {
        this.historyList = historyList;
        this.parentActivity = parentActivity;
        this.listener = listener;
    }

    public interface OnItemLongClickListener {
        void onItemLongClick();

    }

    @Override
    public HistoryAdapter.ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.history_card,parent,false);

        return new ListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final HistoryAdapter.ListViewHolder holder, int position) {

        hold=holder;
        holder.number.setText(historyList.get(position).getCaller_number());
        holder.message.setText(historyList.get(position).getCaller_msg());
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                listener.onItemLongClick();
                BaseActivity.setMmessage(holder.message.getText().toString());
                BaseActivity.setMnumber(holder.number.getText().toString());
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnLongClickListener {

        protected TextView message;
        protected TextView number;


        public ListViewHolder(final View itemView) {
            super(itemView);

            message=(TextView)itemView.findViewById(R.id.message);
            number=(TextView)itemView.findViewById(R.id.number);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public boolean onLongClick(View v) {
            Animation animation = AnimationUtils.loadAnimation(parentActivity, R.anim.swipe);
            v.startAnimation(animation);
            return false;
        }
    }
}
