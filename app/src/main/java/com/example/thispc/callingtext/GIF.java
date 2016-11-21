package com.example.thispc.callingtext;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class GIF extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;

 /* private OnFragmentInteractionListener mListener;

    public GIF() {
    }
    public static GIF newInstance() {
        GIF fragment = new GIF();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
   // public void finish(View v)
    {
      //  Toast.makeText(getActivity(),"pulkit",Toast.LENGTH_LONG).show();
    }

   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
       Log.e("pil","in gif");
       return inflater.inflate(R.layout.fragment_gi, container, false);
    }
}
