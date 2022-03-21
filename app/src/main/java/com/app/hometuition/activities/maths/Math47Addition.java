package com.app.hometuition.activities.maths;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.hometuition.R;

import java.util.ArrayList;
import java.util.List;

public class Math47Addition extends AppCompatActivity {

    TextView tv1;
    int count = 1;

    List<View> views;
    int showGr1 = 9;
    int showGr2 = 1;
    int showGr3 = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math47_addition);
        tv1 = findViewById(R.id.tv1);
        views = new ArrayList<>();
        for (int i = 1; i <= 48; i++) {
            View view = findViewById(getResources()
                    .getIdentifier("anim" + i, "id", getPackageName()));
            try {
                views.add(view);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        findViewById(R.id.fl).setOnClickListener(view ->
                initNext());
        findViewById(R.id.next).setOnClickListener(view ->
                initNext());
        findViewById(R.id.prev).setOnClickListener(view ->
                initPrev());
        findViewById(R.id.textView2).setOnClickListener(view ->
                finish());
        refresh();
    }

    private void initPrev() {
        count--;
        if (count <= 0)
            count = 1;
        refresh();
    }

    private void refresh() {
        if (count < 1)
            count = 1;
        if (count == 1) {
            showGr1 = 9;
            showGr2 = 1;
        }
        if (count == 2) {
            showGr1 = 8;
            showGr2 = 2;
        }
        if (count == 3) {
            showGr1 = 2;
            showGr2 = 1;
        }

        if (count == 4) {
            showGr1 = 8;
            showGr2 = 4;
        }
        if (count == 5) {
            showGr1 = 3;
            showGr2 = 2;
        }
        showGr3 = showGr1 + showGr2;
        int id = 0;
        for (View view : views) {
            id++;
            if (id <= 12)
                if (id <= showGr1)
                    view.setVisibility(View.VISIBLE);
                else
                    view.setVisibility(View.GONE);
            else if (id <= 24)
                if (id <= showGr2 + 12)
                    view.setVisibility(View.VISIBLE);
                else
                    view.setVisibility(View.GONE);
            else if (id <= 48)
                if (id <= showGr3 + 24)
                    view.setVisibility(View.VISIBLE);
                else
                    view.setVisibility(View.GONE);
        }
        String words = showGr1 + " + " + showGr2 + " = " + showGr3;

        tv1.setText(words);
    }

    private void initNext() {
        count++;
        if (count > 5)
            count = 5;
        refresh();
    }
}