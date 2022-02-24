package com.app.hometuition.activities.activities_4_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.app.hometuition.R;
import com.app.hometuition.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class EnglishMonths extends AppCompatActivity {
    int selectedLayout = 0;
    List<LinearLayout> llList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_months);
        initLayouts();
        refreshLayouts();
    }

    private void initLayouts() {
        llList = new ArrayList<>();
        for (int i = 1; i <= 12; i++)
            llList.add(findViewById(getResources()
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
        Utils.initVisible(llList.get(selectedLayout), llList);
    }

    public void next(View view) {
        selectedLayout += 1;
        if (selectedLayout > 11)
            selectedLayout = 0;
        refreshLayouts();
    }
}