package com.example.thispc.callingtext;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ListViewHolder> {
    public static List<ArrayList>  contactList=new ArrayList<>();
    Activity parentAct;
    ImageButton b1;
    public ContactListAdapter(List<ArrayList> contactList, Activity activity){
        this.contactList = contactList;
        parentAct=activity;
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
        holder.name.setText((String) contactList.get(position).get(0));
        holder.phoneNumber.setText((String) contactList.get(position).get(1));
        holder.textsmsLogo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
               /*ContactList.button1.startAnimation(
                        AnimationUtils.loadAnimation(parentAct, R.anim.rotation) );*/
                Intent intent = new Intent(parentAct, MainActivity.class);
                intent.putExtra("number",(String)contactList.get(position).get(1));
                parentAct.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected TextView name;
        protected TextView phoneNumber;
        protected ImageButton textsmsLogo;
        public ListViewHolder(View vi) {
            super(vi);
            name = (TextView) vi.findViewById(R.id.textView6);
            phoneNumber=(TextView) vi.findViewById(R.id.textView7);
            textsmsLogo=(ImageButton) vi.findViewById(R.id.imageButton21);
            vi.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

        }
    }
    public List<ArrayList> getContactList() {
        return contactList;
    }

}
