package com.app.hometuition.activities.english;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.app.hometuition.R;
import com.app.hometuition.activities.VideoPlayerActivity;
import com.app.hometuition.singletons.VideoSingleton;

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

    public void phonics(View view) {
        startActivity(new Intent(this, EnglishPhonics.class));
    }


    public void four(View view) {
        startActivity(new Intent(this, FourLetterActivity.class));
    }

    public void singular(View view) {
        VideoSingleton.setInstance(R.raw.singular_plural, "Singular Plural");
        startActivity(new Intent(this, VideoPlayerActivity.class));
    }

    public void opposite(View view) {
        startActivity(new Intent(this, OppositeActivity.class));

    }

    public void transport(View view) {
        startActivity(new Intent(this, TransportationActivity.class));

    }

    public void noun(View view) {
        VideoSingleton.setInstance(R.raw.noun, "Noun");
        startActivity(new Intent(this, VideoPlayerActivity.class));
    }

    public void pronoun(View view) {
        VideoSingleton.setInstance(R.raw.pronoun, "Pronoun");
        startActivity(new Intent(this, VideoPlayerActivity.class));
    }

    public void verb(View view) {
        VideoSingleton.setInstance(R.raw.verb, "Verb");
        startActivity(new Intent(this, VideoPlayerActivity.class));
    }

    public void adverb(View view) {
        VideoSingleton.setInstance(R.raw.adverb, "Adverb");
        startActivity(new Intent(this, VideoPlayerActivity.class));
    }

    public void adjective(View view) {
        VideoSingleton.setInstance(R.raw.adjective, "Adjective");
        startActivity(new Intent(this, VideoPlayerActivity.class));
    }

    public void prefix(View view) {
        VideoSingleton.setInstance(R.raw.prefix_suffix, "Prefix Suffix");
        startActivity(new Intent(this, VideoPlayerActivity.class));
    }

    public void compound(View view) {
        VideoSingleton.setInstance(R.raw.compound, "Compound Words");
        startActivity(new Intent(this, VideoPlayerActivity.class));
    }

    public void the(View view) {
        VideoSingleton.setInstance(R.raw.the_art, "The Article");
        startActivity(new Intent(this, VideoPlayerActivity.class));
    }
}