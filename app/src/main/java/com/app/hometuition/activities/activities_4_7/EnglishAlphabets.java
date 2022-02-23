package com.app.hometuition.activities.activities_4_7;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.app.hometuition.R;

import java.util.ArrayList;
import java.util.List;

public class EnglishAlphabets extends AppCompatActivity {
    int selectedLayout = 0;
    List<LinearLayout> llList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_alphabets);
        initLayouts();
        refreshLayouts();
    }

    private void initLayouts() {
        llList = new ArrayList<>();
        for (int i = 1; i <= 26; i++)
            llList.add((LinearLayout) findViewById(getResources()
                    .getIdentifier("ll_" + i, "id", getPackageName())));
    }

    public void back(View view) {
        finish();
    }

    public void prev(View view) {
        selectedLayout -= 1;
        if (selectedLayout <= 0)
            selectedLayout = 0;
        refreshLayouts();
    }

    private void refreshLayouts() {
        initVisible(llList.get(selectedLayout));
    }

    public void next(View view) {
        selectedLayout += 1;
        if (selectedLayout >= 25)
            selectedLayout = 25;
        refreshLayouts();
    }

    private void initVisible(LinearLayout ll1) {
        for (LinearLayout ll : llList)
            if (ll == ll1)
                animateVisibility(1, ll);
            else
                animateVisibility(0, ll);
    }

    private void animateVisibility(float visibility, LinearLayout ll) {
        ll.animate().alpha(visibility).setDuration(300);
        if (visibility == 1)
            ll.setVisibility(View.VISIBLE);
        else
            ll.setVisibility(View.GONE);
    }
}