package com.sdsmdg.pulkit.callingtext;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import static com.sdsmdg.pulkit.callingtext.R.id.msgcard;


public class CallDetails extends Fragment{

    String callerName;
    String callerNumber;
    String position;
    View view;
    TextView tCall,  tMsg;
    LinearLayout callCard,deleCard,msgCard,viewCard;

    DataBaseHandler dbh;

    public void setCallerName(String callerName) {
        this.callerName = callerName;
    }

    public String getCallerName() {
        return callerName;
    }

    public void setCallerNumber(String callerNumber) {
        this.callerNumber = callerNumber;
    }

    public String getCallerNumber() {
        return callerNumber;
    }

//    @Override
//    public void onCardSelection(String cPosition) {
//        setData(cPosition);
//        position=cPosition;
//    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        tCall=(TextView)view.findViewById(R.id.cname);
        tMsg=(TextView)view.findViewById(R.id.msg_text);
        tMsg.setText("Message "+getCallerName());
        tCall.setText("Call "+getCallerName());
        callCard=(LinearLayout)view.findViewById(R.id.callcard);
        callCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                letsCall();
            }
        });
        msgCard=(LinearLayout)view.findViewById(msgcard);
        msgCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                letsMsg();
            }
        });
        deleCard= (LinearLayout) view.findViewById(R.id.delcard);
        deleCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                letsDelete();
            }
        });
        viewCard=(LinearLayout)view.findViewById(R.id.concard);
        viewCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                letsView();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_call_details, container, false);
        dbh = DataBaseHandler.getInstance(getContext());
        return view;
    }
//    private List<CallerDetails> createList() {
//        List<CallerDetails> result;
//        result=dbh.getAllCallers();
//        Log.e("result",result+"");
//        return result;
//    }

//    public void setData(String position){
//
//        //setCallerName(createList().get(Integer.parseInt(position)).getCaller_name());
//        //setCallerNumber(createList().get(Integer.parseInt(position)).getCaller_number());
//
//    }
    public void letsCall(){
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" +getCallerNumber()));
        startActivity(intent);

    }
    public void letsMsg(){
        Intent sendIntent = new Intent(Intent.ACTION_VIEW);
        sendIntent.setData(Uri.parse("sms:"+getCallerNumber()));
        startActivity(sendIntent);

    }
    public void letsDelete(){
       // dbh.clear();
    }
    public void letsView(){
        //insert code here

    }

}
