package com.app.hometuition.activities.maths;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.hometuition.R;
import com.app.hometuition.utils.NumberToWords;

public class Math47Counting extends AppCompatActivity {

    TextView tv1;
    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math47_counting);
        tv1 = findViewById(R.id.tv1);
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
        if (count < 1)
            count = 1;
        refresh();
    }

    private void refresh() {
        for (int i = 1; i <= 100; i++) {
            View view = findViewById(getResources()
                    .getIdentifier("anim" + i, "id", getPackageName()));
            if (i <= count)
                view.animate().alpha(1).setDuration(200);
            else {
                view.setAlpha(0);
                view.setTranslationY(10);
            }

            if (i == count) {
                view.animate().translationYBy(-20).setDuration(200);
                new Handler().postDelayed(() ->
                        view.animate().translationYBy(20).setDuration(200), 200);
            }
        }

        String words = NumberToWords.convert(count) + " " + count;
        tv1.setText(words);
    }

    private void initNext() {
        count++;
        if (count > 100)
            count = 100;
        refresh();
    }
}