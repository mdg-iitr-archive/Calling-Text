package com.sdsmdg.pulkit.callingtext;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class CallDetailsFragment extends Fragment implements View.OnClickListener{


    OnCallerSelectionListener mCallback;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_call_details,container,false);
    }

    @Override
    public void onClick(View v) {

    }

    public interface OnCallerSelectionListener{
        public void onCallerSelected(String position);
    }
}
