package com.sdsmdg.pulkit.callingtext;

import android.content.Context;
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
import android.widget.TextView;

import java.util.List;


public class CallDetails extends Fragment implements HistoryFragment.onCardselectionListener{

    String cname;
    String cnumber;
    String position;
    View view;
    TextView tcall,  tmsg;


    DataBaseHandler dbh;

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCname() {
        return cname;
    }

    public void setCnumber(String cnumber) {
        this.cnumber = cnumber;
    }

    public String getCnumber() {
        return cnumber;
    }

    @Override
    public void onCardSelection(String cPosition) {
        setData(cPosition);
        position=cPosition;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        tcall=(TextView)view.findViewById(R.id.cname);
        tmsg=(TextView)view.findViewById(R.id.msg_text);
        tmsg.setText("Message "+getCname());
        tcall.setText("Call "+getCname());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_call_details, container, false);
        dbh = DataBaseHandler.getInstance(getContext());
        return view;
    }
    private List<CallerDetails> createList() {
        List<CallerDetails> result;
        result=dbh.getAllCallers();
        Log.e("result",result+"");
        return result;
    }

    public void setData(String position){

        setCname(createList().get(Integer.parseInt(position)).getCaller_name());
        setCnumber(createList().get(Integer.parseInt(position)).getCaller_number());

    }
    public void letscall(){

    }
    public void letsmsg(){

    }
    public void letdelete(){

    }
    public void letsview(){

    }

}
