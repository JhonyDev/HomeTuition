package com.app.hometuition.activities.english;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.app.hometuition.R;
import com.app.hometuition.activities.VideoPlayerActivity;
import com.app.hometuition.singletons.VideoSingleton;

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

    public void abcUpper(View view) {
        startActivity(new Intent(this, UpperCaseActivity.class));
    }

    public void abcLower(View view) {
        startActivity(new Intent(this, LowerCaseActivity.class));
    }

    public void vowels(View view) {
        VideoSingleton.setInstance(R.raw.vowels, "Vowels");
        startActivity(new Intent(this, VideoPlayerActivity.class));
    }

    public void three(View view) {
        startActivity(new Intent(this, ThreeLetterWords.class));

    }

    public void aAndAn(View view) {
        startActivity(new Intent(this, AAndAnActivity.class));
    }

    public void rhyme(View view) {
        startActivity(new Intent(this, EnglishRhyme.class));
    }

}
