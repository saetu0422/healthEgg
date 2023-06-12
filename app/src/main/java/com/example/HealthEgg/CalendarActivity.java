package com.example.nonokang;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.TextView;

import java.util.Calendar;

public class CalendarActivity extends AppCompatActivity {

    CalendarView cal;
    TextView date_text, alarm_text;
    Button nextBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);






        cal = findViewById(R.id.cal);
        date_text = findViewById(R.id.date_text);
        nextBtn = findViewById(R.id.nextBtn);
        alarm_text = findViewById(R.id.alarm_text);

        Calendar calendar = Calendar.getInstance();


        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int date) {
                date_text.setText(year + "/" + (month+1) + "/" + date);


                calendar.set(year, month, date);
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), AlarmActivity.class);
                Log.d(TAG, "onClick: "+ CalendarActivity.this);
                intent.putExtra("OBJECT", calendar);
                startActivity(intent);

            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.mymenu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull android.view.MenuItem item){
        switch (item.getItemId()){
            case R.id.deviceInfo:
                Intent intent=new Intent(getApplicationContext(), DeviceInfoActivity.class);
                startActivity(intent);
                break;
            case R.id.alarmList:
                Intent intent2=new Intent(getApplicationContext(), AlarmListActivity.class);
                startActivity(intent2);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}