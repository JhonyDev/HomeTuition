package com.app.hometuition.activities.english;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.app.hometuition.R;
import com.app.hometuition.utils.Utils;

public class UpperCaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upper__case);
        Utils.initLayouts(this, 0, "");

    }
}