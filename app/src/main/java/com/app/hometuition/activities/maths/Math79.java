package com.app.hometuition.activities.maths;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.app.hometuition.R;
import com.app.hometuition.activities.VideoPlayerActivity;
import com.app.hometuition.singletons.VideoSingleton;

public class Math79 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math79);
    }

    public void back(View view) {
        finish();
    }

    public void add(View view) {
        startActivity(new Intent(this, Math79Addition.class));
    }

    public void tables(View view) {
        VideoSingleton.setInstance(R.raw.tables, "Tables");
        startActivity(new Intent(this, VideoPlayerActivity.class));
    }

    public void mul(View view) {
        startActivity(new Intent(this, Math7Mul.class));

    }

    public void sub(View view) {
        startActivity(new Intent(this, Math79Subtraction.class));

    }

    public void div(View view) {
        startActivity(new Intent(this, Math7Div.class));

    }

    public void threeDShapes(View view) {
        startActivity(new Intent(this, Math79Shapes.class));

    }

    public void ascending(View view) {
        startActivity(new Intent(this, AscendingActivity.class));

    }

    public void descending(View view) {
        startActivity(new Intent(this, DescendingActivity.class));

    }

    public void even_odd(View view) {
        startActivity(new Intent(this, EvenOddActivity.class));

    }
}