package com.sdsmdg.pulkit.callingtext;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class CallDetailsFragment extends Fragment implements View.OnClickListener{


    OnCallerSelectionListener mCallback;
    @Override
    public void onClick(View v) {

    }

    public interface OnCallerSelectionListener{
        public void onCallerSelected(String position);
    }
}
