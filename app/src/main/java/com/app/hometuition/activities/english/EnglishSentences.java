package com.app.hometuition.activities.english;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.app.hometuition.R;
import com.app.hometuition.utils.Utils;

public class EnglishSentences extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english_sentences);
        Utils.initLayouts(this, 5, "sentences_");
    }
}