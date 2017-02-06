package com.sdsmdg.pulkit.callingtext;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.telephony.TelephonyManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by pulkit on 4/2/17.
 */

public class CallListAdapter extends RecyclerView.Adapter<CallListAdapter.ListViewHolder> {

    List<CallerDetails> callerList;
    Activity parentAct;

    public CallListAdapter(List<CallerDetails> historyList, Activity activity) {
        this.callerList = historyList;
        parentAct = activity;
    }

    @Override
    public CallListAdapter.ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.history_card, parent, false);

        return new ListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CallListAdapter.ListViewHolder holder, int position) {
        CallerDetails hd = callerList.get(position);
        holder.vName.setText(hd.getCaller_name());
        holder.vNumber.setText(hd.getCaller_name());
        holder.vMsg.setText(hd.getCaller_msg());
        holder.time.setText(hd.getCall_time());
        if (hd.getCall_type().equals("outgoing")) {
            holder.type.setImageResource(R.drawable.call_made);
        } else if (hd.getCall_type().equals("incoming")) {
            holder.type.setImageResource(R.drawable.call_received);
        }

    }

    @Override
    public int getItemCount() {
        return callerList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        protected TextView vName;
        protected TextView vNumber;
        protected TextView vMsg;
        protected ImageView type;
        protected TextView time;
        protected ImageView call;

        public ListViewHolder(View vi) {
            super(vi);
            vName = (TextView) vi.findViewById(R.id.name);
            vNumber = (TextView) vi.findViewById(R.id.number);
            vMsg = (TextView) vi.findViewById(R.id.message);
            type = (ImageView) vi.findViewById(R.id.call_type);
            time = (TextView) vi.findViewById(R.id.time);
            call = (ImageView) vi.findViewById(R.id.call);
            vi.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }

}
