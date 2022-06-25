package com.app.hometuition.activities.urdu;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.hometuition.R;
import com.app.hometuition.utils.NumberToWords;
import com.app.hometuition.utils.Utils;

public class UrduCountingActivity extends AppCompatActivity {

    TextView tv1;
    int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urdu_counting);
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
        for (int i = 1; i <= 200; i++) {
            View view = findViewById(getResources()
                    .getIdentifier("anim" + i, "id", getPackageName()));

            if (view == null)
                continue;

            if (i <= count) {
                view.animate().alpha(1).setDuration(200);
                view.setVisibility(View.VISIBLE);
            } else {
                view.setAlpha(0);
                view.setTranslationY(10);
                view.setVisibility(View.GONE);
            }

            if (i == count) {
                view.animate().translationYBy(-20).setDuration(200);
                new Handler().postDelayed(() ->
                        view.animate().translationYBy(20).setDuration(200), 200);
            }
        }
        int res_id = getResources()
                .getIdentifier(NumberToWords.convert(count), "string", getPackageName());
        Utils.speakUrdu(this, getResources().getString(res_id));
        String words = getResources().getString(res_id) + " " + count;
        tv1.setText(words);
    }

    private void initNext() {
        count++;
        if (count > 20)
            count = 20;
        refresh();
    }
}