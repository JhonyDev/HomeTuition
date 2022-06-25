package com.app.hometuition.activities;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.app.hometuition.R;
import com.app.hometuition.singletons.VideoSingleton;
import com.app.hometuition.utils.Utils;

public class VideoPlayerActivity extends AppCompatActivity {
    VideoView videoView;
    int stopPosition;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        TextView textView = findViewById(R.id.textView2);
        textView.setText("");
        if (VideoSingleton.getInstance().getTitle().equals("Singular Plural")) {
            mp = Utils.initMediaPlayer(this, R.raw.singular_voice);
        }
        if (VideoSingleton.getInstance().getTitle().equals("The Article")) {
            mp = Utils.initMediaPlayer(this, R.raw.a_and_the);
        }
        if (VideoSingleton.getInstance().getTitle().equals("Compound Words")) {
            mp = Utils.initMediaPlayer(this, R.raw.compund_voice);
        }
        if (VideoSingleton.getInstance().getTitle().equals("Prefix Suffix")) {
            mp = Utils.initMediaPlayer(this, R.raw.pre_voice);
        }
        if (VideoSingleton.getInstance().getTitle().equals("Adjective")) {
            mp = Utils.initMediaPlayer(this, R.raw.adjective_voice);
        }
        if (VideoSingleton.getInstance().getTitle().equals("Adverb")) {
            mp = Utils.initMediaPlayer(this, R.raw.adverb_voice);
        }
        if (VideoSingleton.getInstance().getTitle().equals("Verb")) {
            mp = Utils.initMediaPlayer(this, R.raw.verb_voice);
        }
        if (VideoSingleton.getInstance().getTitle().equals("Pronoun")) {
            mp = Utils.initMediaPlayer(this, R.raw.pronoun_voice);
        }

        if (VideoSingleton.getInstance().getTitle().equals("Noun")) {
            mp = Utils.initMediaPlayer(this, R.raw.noun_voice);
        }

        if (VideoSingleton.getInstance().getTitle().equals("Vowels")) {
            mp = Utils.initMediaPlayer(this, R.raw.vowels_voice);
        }

        if (VideoSingleton.getInstance().getTitle().equals("Tables")) {
            mp = Utils.initMediaPlayer(this, R.raw.tables_voice);
        }

        if (VideoSingleton.getInstance().getTitle().equals("Time in hours")) {
            mp = Utils.initMediaPlayer(this, R.raw.time_voice);
        }

        if (VideoSingleton.getInstance().getTitle().equals("muza")) {
            mp = Utils.initMediaPlayer(this, R.raw.muzakar_monas);
        }

        if (VideoSingleton.getInstance().getTitle().equals(getString(R.string.wahid_jama))) {
            mp = Utils.initMediaPlayer(this, R.raw.wahid_jma_voice);
        }

        if (VideoSingleton.getInstance().getTitle().equals(getString(R.string.alfaz_mutazad))) {
            mp = Utils.initMediaPlayer(this, R.raw.alfaz_mutazad_mp3);
        }


        if (VideoSingleton.getInstance().getTitle().equals(getString(R.string.ism_fail))) {
            mp = Utils.initMediaPlayer(this, R.raw.ism_fail_voice);
        }

        if (VideoSingleton.getInstance().getTitle().equals("jumla")) {
            mp = Utils.initMediaPlayer(this, R.raw.jumla_sazi_voice);
        }

        if (VideoSingleton.getInstance().getTitle().equals("jor")) {
            mp = Utils.initMediaPlayer(this, R.raw.jor_tor_voice);
        }


        videoView = findViewById(R.id.video_view);
        if (VideoSingleton.getInstance().getResource() == -1) {
            Toast.makeText(this, "Video not set", Toast.LENGTH_SHORT).show();
            finish();
        }
        String path = "android.resource://" + getPackageName() + "/" + VideoSingleton.getInstance().getResource();
        videoView.setVideoURI(Uri.parse(path));
        videoView.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        VideoSingleton.setInstance(-1, "");
        videoView.stopPlayback();
        videoView.setVideoURI(null);
        if (mp != null)
            mp.pause();

    }

    public void back(View view) {
        finish();
    }

    public void playPause(View view) {
        if (videoView.isPlaying()) {
            stopPosition = videoView.getCurrentPosition();
            videoView.pause();
            if (mp != null)
                mp.pause();

        } else {
            videoView.seekTo(stopPosition);
            videoView.start();
            if (mp != null)
                mp.start();
        }
    }
}
