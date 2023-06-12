package com.example.HealthEgg;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.myapplication.R;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_schedul:
                btnSchedul();
                break;
            case R.id.btn_info:
                btnInfo();
                break;

        }
    }
    private void btnSchedul() {
        Intent intent = new Intent(getActivity(), AlarmFragment.class);
        startActivity(intent);
    }
    private void btnInfo() {
        Intent intent = new Intent(getActivity(), InfoFragment.class);
        startActivity(intent);
    }
}