package com.app.hometuition.activities.urdu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.app.hometuition.R;
import com.app.hometuition.activities.VideoPlayerActivity;
import com.app.hometuition.singletons.VideoSingleton;

public class Urdu79 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urdu79);
    }

    public void back(View view) {
        finish();
    }

    public void alfazMutazad(View view) {
        VideoSingleton.setInstance(R.raw.alfaz_mutazad, getString(R.string.alfaz_mutazad));
        startActivity(new Intent(this, VideoPlayerActivity.class));
    }

    public void humQafiya(View view) {
        VideoSingleton.setInstance(R.raw.jumla_sazi, "jumla");
        startActivity(new Intent(this, VideoPlayerActivity.class));
    }

    public void muzakar(View view) {
        VideoSingleton.setInstance(R.raw.muzakar, "muza");
        startActivity(new Intent(this, VideoPlayerActivity.class));
    }

    public void wahidJama(View view) {
        VideoSingleton.setInstance(R.raw.wahid_jama, getString(R.string.wahid_jama));
        startActivity(new Intent(this, VideoPlayerActivity.class));
    }

    public void ismFail(View view) {
        VideoSingleton.setInstance(R.raw.ism_fail, getString(R.string.ism_fail));
        startActivity(new Intent(this, VideoPlayerActivity.class));
    }

    public void jorTor(View view) {
        VideoSingleton.setInstance(R.raw.jor_tor, "jor");
        startActivity(new Intent(this, VideoPlayerActivity.class));
    }

    public void mosam(View view) {
        startActivity(new Intent(this, MosamActivity.class));

    }
}