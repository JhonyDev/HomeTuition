package com.app.hometuition.activities.activities_4_7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.app.hometuition.R;

public class English47 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english47);
    }

    public void back(View view) {
        finish();
    }

    public void alphabets(View view) {
        startActivity(new Intent(this, EnglishAlphabets.class));
    }

    public void colorIdentification(View view) {
        startActivity(new Intent(this, EnglishColors.class));
    }

    public void spellings(View view) {
        startActivity(new Intent(this, EnglishSpellings.class));
    }

    public void formalization(View view) {
        startActivity(new Intent(this, EnglishObjects.class));
    }

    public void days(View view) {
        startActivity(new Intent(this, EnglishDays.class));

    }

    public void months(View view) {
        startActivity(new Intent(this, EnglishMonths.class));
    }
}
