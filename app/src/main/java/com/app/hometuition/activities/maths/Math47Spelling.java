package com.app.hometuition.activities.maths;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.app.hometuition.R;
import com.app.hometuition.utils.Utils;

public class Math47Spelling extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math47_spelling);
        Utils.initLayouts(this, 27, "alphabet_");
    }
}