package com.app.hometuition.activities.maths;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.app.hometuition.R;

import java.util.ArrayList;
import java.util.List;

public class Math47Subtration extends AppCompatActivity {

    TextView tv1;
    int count = 1;

    List<View> views;
    int showGr1 = 1;
    int showGr2 = 1;
    int showGr3 = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math47_subtration);

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

        refresh();
    }

    private void refresh() {
        if (count < 1)
            count = 1;
        if (count == 1) {
            showGr1 = 1;
            showGr2 = 1;
        }
        if (count == 2) {
            showGr1 = 6;
            showGr2 = 2;
        }
        if (count == 3) {
            showGr1 = 12;
            showGr2 = 2;
        }

        if (count == 4) {
            showGr1 = 10;
            showGr2 = 10;
        }
        if (count == 5) {
            showGr1 = 12;
            showGr2 = 12;
        }
        showGr3 = showGr1 - showGr2;
        int id = 0;
        for (View view : views) {
            id++;
            if (id <= 12) {
                if (id <= showGr1)
                    view.setVisibility(View.VISIBLE);
                else
                    view.setVisibility(View.GONE);

            } else if (id <= 24) {
                if (id <= showGr2 + 12)
                    view.setVisibility(View.VISIBLE);
                else
                    view.setVisibility(View.GONE);
            } else if (id <= 48) {
                if (id <= showGr3 + 24)
                    view.setVisibility(View.VISIBLE);
                else
                    view.setVisibility(View.GONE);
            }
        }
        String words = showGr1 + " - " + showGr2 + " = " + showGr3;
        tv1.setText(words);
    }

    private void initNext() {
        count++;
        if (count > 5)
            count = 5;
        refresh();
    }
}