package com.app.hometuition.activities.maths;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.app.hometuition.R;
import com.app.hometuition.activities.VideoPlayerActivity;
import com.app.hometuition.singletons.VideoSingleton;

public class Math47 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math47);
    }

    public void back(View view) {
        finish();
    }

    public void counting(View view) {
        startActivity(new Intent(this, Math47Counting.class));
    }

    public void spelling(View view) {
        startActivity(new Intent(this, Math47Spelling.class));
    }

    public void addition(View view) {
        startActivity(new Intent(this, Math47Addition.class));
    }

    public void sub(View view) {
        startActivity(new Intent(this, Math47Subtration.class));
    }

    public void ordinal(View view) {
        startActivity(new Intent(this, Math47OrdinalNumbers.class));
    }

    public void shapes(View view) {
        startActivity(new Intent(this, Math47Shapes.class));
    }

    public void time_in_hours(View view) {
        VideoSingleton.setInstance(R.raw.time_hours, "Time in hours");
        startActivity(new Intent(this, VideoPlayerActivity.class));
    }
}