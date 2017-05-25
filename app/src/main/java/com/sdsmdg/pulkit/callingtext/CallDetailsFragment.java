package com.sdsmdg.pulkit.callingtext;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class CallDetailsFragment extends Fragment implements View.OnClickListener{


   // OnCallerSelectionListener mCallback;
    TextView tv_name;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_call_details,container,false);
        tv_name= (TextView) v.findViewById(R.id.callerName);
        tv_name.setText(BaseActivity.getMname());
        return v;
    }

    @Override
    public void onClick(View v) {

    }

//    public interface OnCallerSelectionListener{
//        public void onCallerSelected(String position);
//    }
}
