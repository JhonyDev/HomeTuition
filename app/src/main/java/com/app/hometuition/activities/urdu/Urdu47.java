package com.app.hometuition.activities.urdu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

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

    public void alphabets(View view) {
        startActivity(new Intent(this, UrduAlphabets.class));
    }

    public void basicColors(View view) {
        startActivity(new Intent(this, UrduBasicColors.class));
    }

    public void janwar(View view) {
        startActivity(new Intent(this, UrduJanwar.class));
    }

    public void parinday(View view) {
        startActivity(new Intent(this, UrduParinday.class));
    }

    public void phal(View view) {
        startActivity(new Intent(this, UrduPhal.class));

    }

    public void sabziya(View view) {
        startActivity(new Intent(this, UrduSabziyan.class));
    }

    public void ginti(View view) {
        startActivity(new Intent(this, UrduCountingActivity.class));

    }

    public void masootay(View view) {
        startActivity(new Intent(this, UrduMasootay.class));

    }
}