package com.app.hometuition.activities.activities_7_9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.app.hometuition.R;

public class English79 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english79);
    }

    public void back(View view) {
        finish();
    }

    public void sentences(View view) {
        startActivity(new Intent(this, EnglishSentences.class));
    }

    public void grammar(View view) {
        startActivity(new Intent(this, EnglishGrammar.class));
    }

    public void phonics(View view) {
        startActivity(new Intent(this, EnglishPhonics.class));
    }
}