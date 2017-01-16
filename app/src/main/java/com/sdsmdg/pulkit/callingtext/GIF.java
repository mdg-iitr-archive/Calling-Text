package com.sdsmdg.pulkit.callingtext;

import android.app.Activity;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;


public class GIF extends DialogFragment implements View.OnClickListener {
    ImageButton img1;
    ImageButton img2;
    ImageButton img3;
    ImageButton img4;
    ImageButton img5;
    ImageButton img6;
    ImageButton img7;
    ImageButton img8;
    ImageButton img9;
    ImageButton img10;
    onImageselectionListener mCallback;
public interface onImageselectionListener{
    public void onImageSelection(String position);
}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_gi, container, false);
       img1=(ImageButton)view.findViewById(R.id.imageButton);
       img2=(ImageButton)view.findViewById(R.id.imageButton2);
       img3=(ImageButton)view.findViewById(R.id.imageButton3);
       img4=(ImageButton)view.findViewById(R.id.imageButton4);
       img5=(ImageButton)view.findViewById(R.id.imageButton5);
       img6=(ImageButton)view.findViewById(R.id.imageButton6);
       img7=(ImageButton)view.findViewById(R.id.imageButton7);
       img8=(ImageButton)view.findViewById(R.id.imageButton8);
       img9=(ImageButton)view.findViewById(R.id.imageButton9);
       img10=(ImageButton)view.findViewById(R.id.imageButton10);
       img1.setOnClickListener(this);
       img2.setOnClickListener(this);
       img3.setOnClickListener(this);
       img4.setOnClickListener(this);
       img5.setOnClickListener(this);
       img6.setOnClickListener(this);
       img7.setOnClickListener(this);
       img8.setOnClickListener(this);
       img9.setOnClickListener(this);
       img10.setOnClickListener(this);

       return view;
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (onImageselectionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton:
              mCallback.onImageSelection("1");
                getActivity().onBackPressed();
                break;
            case R.id.imageButton2:
                mCallback.onImageSelection("2");
                getActivity().onBackPressed();
                break;
            case R.id.imageButton3:
                mCallback.onImageSelection("3");
                getActivity().onBackPressed();
                break;
            case R.id.imageButton4:
                mCallback.onImageSelection("4");
                getActivity().onBackPressed();
                break;
            case R.id.imageButton5:
                mCallback.onImageSelection("5");
                getActivity().onBackPressed();
                break;
            case R.id.imageButton6:
                mCallback.onImageSelection("6");
                getActivity().onBackPressed();
                break;
            case R.id.imageButton7:
                mCallback.onImageSelection("7");
                getActivity().onBackPressed();
                break;
            case R.id.imageButton8:
                mCallback.onImageSelection("8");
                getActivity().onBackPressed();
                break;
            case R.id.imageButton9:
                mCallback.onImageSelection("9");
                getActivity().onBackPressed();
                break;
            case R.id.imageButton10:
                mCallback.onImageSelection("10");
                getActivity().onBackPressed();
                break;
            case R.id.imageButton11:
                mCallback.onImageSelection("11");
                getActivity().onBackPressed();
                break;
            case R.id.imageButton12:
                mCallback.onImageSelection("12");
                getActivity().onBackPressed();
                break;
            case R.id.imageButton13:
                mCallback.onImageSelection("13");
                getActivity().onBackPressed();
                break;
            case R.id.imageButton14:
                mCallback.onImageSelection("14");
                getActivity().onBackPressed();
                break;
            case R.id.imageButton15:
                mCallback.onImageSelection("15");
                getActivity().onBackPressed();
                break;
            case R.id.imageButton16:
                mCallback.onImageSelection("16");
                getActivity().onBackPressed();
                break;
            case R.id.imageButton17:
                mCallback.onImageSelection("17");
                getActivity().onBackPressed();
                break;
            case R.id.imageButton18:
                mCallback.onImageSelection("18");
                getActivity().onBackPressed();
                break;
            case R.id.imageButton19:
                mCallback.onImageSelection("19");
                getActivity().onBackPressed();
                break;
            case R.id.imageButton20:
                mCallback.onImageSelection("20");
                getActivity().onBackPressed();
                break;
        }
    }
}
