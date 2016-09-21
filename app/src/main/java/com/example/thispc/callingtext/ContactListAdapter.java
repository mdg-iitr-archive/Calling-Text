package com.example.thispc.callingtext;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by this pc on 21-09-2016.
 */
public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ListViewHolder> {
    public static List<String>  contactList=new ArrayList<>();
    Activity parentAct;

    public ContactListAdapter(List<String> contactList, Activity activity){
        this.contactList = contactList;
        parentAct = activity;
        Log.e("pulkit","in constructor");
    }

    @Override
    public ContactListAdapter.ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.
                from(parent.getContext()).
                inflate(R.layout.contact_card, parent, false);

        return new ListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder (ContactListAdapter.ListViewHolder holder, final int position) {
        Log.e("pulkit","in bind ");
        holder.name.setText(contactList.get(position));

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected TextView name;
        public ListViewHolder(View vi) {
            super(vi);
            name = (TextView) vi.findViewById(R.id.textView6);
            vi.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
    public List<String> getContactList() {
        return contactList;
    }

}
