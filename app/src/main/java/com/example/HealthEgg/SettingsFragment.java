package com.example.HealthEgg;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {


    public SettingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String version;
        version = "0.0.1";

        // LayoutInflater 사용해 Resource Layout을 View로 변환해준 후 findViewById() 호출
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        // ListView 아이템에 표시될 사용자 테이터 정의
        String[] menuItems = {"시스템 버전 : "+ version, "number two"};

        ListView listView = (ListView) view.findViewById(R.id.mainMenu);

        // 데이터 입력받을 Adapter 생성
        // fragment에서는 'this' 사용이 불가하므로, Activity의 참조 획득이 가능한 getActivity()함수 사용
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, menuItems);

        listView.setAdapter(listViewAdapter);

        return view;
    }
}