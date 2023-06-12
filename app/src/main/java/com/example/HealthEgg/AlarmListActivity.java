package com.example.nonokang;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AlarmListActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.alarm_list);

            TextView alarm_list = findViewById(R.id.alarm_list);

            Intent intent = getIntent();
            Calendar calendar = (Calendar) intent.getSerializableExtra("date");

            if (calendar != null) {
                alarm_list.setText((calendar.get(Calendar.MONTH)+1)+" 월 "+calendar.get(Calendar.DATE)+" 일 "+      calendar.get(Calendar.HOUR_OF_DAY) + " 시 " + calendar.get(Calendar.MINUTE) + " 분");
            }


        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0,1,0,"알람설정");
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull android.view.MenuItem item){
        switch (item.getItemId()){
            case Menu.FIRST:
                Intent intent=new Intent(getApplicationContext(), CalendarActivity.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
