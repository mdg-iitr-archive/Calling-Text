package com.example.thispc.callingtext;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.ListViewHolder> {
    private List<ArrayList> contactList;
    private Activity parentAct;
    private ContactListAdapter.ListViewHolder h1;
    private int lastPosition = -1;
    ContactListAdapter(List<ArrayList> contactList1, Activity activity){
        Log.e("pil","in adapter");
        contactList = contactList1;
        parentAct=activity;
    }

    @Override
    public ContactListAdapter.ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.e("pil","in adapter");
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_card, parent, false);
        return new ListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder (ContactListAdapter.ListViewHolder holder, final int position) {
        Log.e("pil","in adapter");
        h1=holder;
        holder.name.setText((String) contactList.get(position).get(0));
        holder.phoneNumber.setText((String) contactList.get(position).get(1));
        holder.textsmsLogo.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                h1.textsmsLogo.startAnimation(
                        AnimationUtils.loadAnimation(parentAct, R.anim.rotation) );
                Intent intent = new Intent(parentAct, MainActivity.class);
                intent.putExtra("number",(String)contactList.get(position).get(1));
                parentAct.startActivity(intent);
            }
        });
        for (int i = 0; i < getItemCount(); i++) {

            //animate(itemView, i);

        }
    }
    private void animate(final View view, final int position){

        view.animate();
        view.setTranslationY(100);
        view.setAlpha(0);
        view.animate().alpha(1.0f).translationY(0).setDuration(300).setStartDelay(position * 100);

    }

    @Override
    public int getItemCount() {
        Log.d("itemCount",contactList.size()+"");
        return contactList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected TextView name;
        protected TextView phoneNumber;
        protected ImageButton textsmsLogo;
        public ListViewHolder(View vi) {
            super(vi);
            Log.e("pil","in adapter");
            name = (TextView) vi.findViewById(R.id.textView6);
            phoneNumber=(TextView) vi.findViewById(R.id.textView7);
            textsmsLogo=(ImageButton) vi.findViewById(R.id.imageButton21);
            vi.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Animation animation = AnimationUtils.loadAnimation(parentAct, R.anim.swipe);
            v.startAnimation(animation);
        }
    }
    public List<ArrayList> getContactList() {
        return contactList;
    }

}
