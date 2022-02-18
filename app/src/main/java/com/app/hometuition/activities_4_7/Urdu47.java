package com.app.hometuition.activities_4_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.app.hometuition.R;

public class Urdu47 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urdu_4_7);
    }

    public void back(View view) {
        finish();
    }
}