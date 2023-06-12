package com.example.nonokang;

        import androidx.annotation.RequiresApi;
        import androidx.appcompat.app.AppCompatActivity;

        import android.app.AlarmManager;
        import android.app.PendingIntent;
        import android.content.Context;
        import android.content.Intent;
        import android.os.Build;
        import android.os.Bundle;
        import android.widget.Button;
        import android.widget.TextView;
        import android.widget.TimePicker;
        import android.widget.Toast;

        import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity {

    private Button save;
    private TimePicker timePicker;

    private TextView date_view;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_set);

        timePicker=(TimePicker)findViewById(R.id.time_picker);
        save=(Button)findViewById(R.id.save);
        date_view=findViewById(R.id.date_view);

        Intent intent = getIntent();
        Calendar calendar = (Calendar) intent.getSerializableExtra("OBJECT");

        date_view.setText((calendar.get(Calendar.MONTH) +1) +"월");


        save.setOnClickListener(v->{

//            Calendar calendar = Calendar.getInstance();
            //calendar.setTimeInMillis(System.currentTimeMillis());
            int hour=timePicker.getHour();
            int minute=timePicker.getMinute();
            calendar.set(Calendar.HOUR_OF_DAY,hour);
            calendar.set(Calendar.MINUTE,minute);

            if (calendar.before(Calendar.getInstance())) {
                calendar.add(Calendar.DATE, 1);
            }

            AlarmManager alarmManager=(AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
            if (alarmManager != null) {
                Intent intent2 = new Intent(this, AlarmReceiver.class);
                PendingIntent alarmIntent = PendingIntent.getBroadcast(this, 1, intent2, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(),
                        AlarmManager.INTERVAL_DAY, alarmIntent);

                Toast.makeText(AlarmActivity.this,"알람이 저장되었습니다.",Toast.LENGTH_LONG).show();
                date_view.setText((calendar.get(Calendar.MONTH) +1) +"월");
                Intent intent3=new Intent(getApplicationContext(), AlarmListActivity.class);
                intent3.putExtra("date", (calendar));
                startActivity(intent3);

            }
        });
    }
}