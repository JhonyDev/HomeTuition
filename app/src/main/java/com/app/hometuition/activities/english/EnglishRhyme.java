package com.app.hometuition.activities.english;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.app.hometuition.R;
import com.app.hometuition.utils.Utils;

public class EnglishRhyme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_rhyme);
        Utils.initLayouts(this, 7, "rhymes_");

    }
}