package com.app.hometuition.activities.maths;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.hometuition.R;
import com.app.hometuition.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Math79Subtraction extends AppCompatActivity {

    TextView tv1;
    TextView textView1;
    TextView textView2;
    int count = 1;

    List<View> views;
    int showGr1 = 9;
    int showGr2 = 1;
    int showGr3 = 8;
    boolean isAnimating = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math79_subtraction);
        tv1 = findViewById(R.id.tv1);
        textView1 = findViewById(R.id.tv_text_1);
        textView2 = findViewById(R.id.tv_Text_2);

        views = new ArrayList<>();
        for (int i = 1; i <= 60; i++) {
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
        if (isAnimating)
            return;
        count--;
        if (count <= 0)
            count = 1;
        refresh();
    }

    private void refresh() {
        Utils.initSumGrids(this);
        isAnimating = true;
        new Handler().postDelayed(() -> isAnimating = false, 3000);

        if (count < 1)
            count = 1;

        if (count == 1) {
            showGr1 = 6;
            showGr2 = 6;
        }
        if (count == 2) {
            showGr1 = 7;
            showGr2 = 4;
        }
        if (count == 3) {
            showGr1 = 8;
            showGr2 = 8;
        }

        if (count == 4) {
            showGr1 = 9;
            showGr2 = 4;
        }
        if (count == 5) {
            showGr1 = 13;
            showGr2 = 1;
        }
        if (count == 6) {
            showGr1 = 12;
            showGr2 = 3;
        }
        if (count == 7) {
            showGr1 = 9;
            showGr2 = 6;
        }

        showGr3 = showGr1 - showGr2;
        int id = 0;
        Utils.speak(this, showGr1 + " minus");
        new Handler().postDelayed(() -> Utils.speak(this, showGr2 + " equals"), 1000);
        new Handler().postDelayed(() -> Utils.speak(this, String.valueOf(showGr3)), 2000);

        for (View view : views) {
            id++;
            if (id <= 15)
                if (id <= showGr1)
                    view.setVisibility(View.VISIBLE);
                else
                    view.setVisibility(View.GONE);

            else if (id <= 30)
                if (id <= showGr2 + 15)
                    view.setVisibility(View.VISIBLE);
                else
                    view.setVisibility(View.GONE);
            else if (id <= 60)
                if (id <= showGr3 + 30)
                    view.setVisibility(View.VISIBLE);
                else
                    view.setVisibility(View.GONE);
        }
        String words = showGr1 + " - " + showGr2 + " = " + showGr3;
        textView1.setText(String.valueOf(showGr1));
        textView2.setText(String.valueOf(showGr2));
        tv1.setText(words);
    }

    private void initNext() {
        if (isAnimating)
            return;
        count++;
        if (count > 7)
            count = 7;
        refresh();
    }
}