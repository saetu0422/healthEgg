package com.example.nonokang;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DeviceInfoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.device_info);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add(0,1,0,"돌아가기");
        ImageView img = findViewById(R.id.device_info_image);
        Glide.with(this).load(R.drawable.owl_egg).into(img);
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
