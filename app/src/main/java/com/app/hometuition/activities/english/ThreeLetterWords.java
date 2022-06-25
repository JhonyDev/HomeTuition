package com.app.hometuition.activities.english;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.app.hometuition.R;
import com.app.hometuition.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ThreeLetterWords extends AppCompatActivity {
    private static int selectedLayout = 0;
    private static List<LinearLayout> llList;
    private static int count = 8;
    private static List<Integer> mediaPlayersIds;
    private static MediaPlayer mp;
    private static Activity context;

    public static void initLayouts(Activity context, int playerCount, String id) {
        selectedLayout = 0;
        speak();

        mediaPlayersIds = new ArrayList<>();
        for (int i = 1; i <= playerCount; i++)
            mediaPlayersIds.add(context.getResources()
                    .getIdentifier(id + i, "raw", context.getPackageName()));

        try {
            initMediaPlayer(context, mediaPlayersIds.get(0));
            mp.setOnCompletionListener(mediaPlayer -> initMediaPlayer(context, mediaPlayersIds.get(1)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            initListeners(context);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (llList != null)
            llList.clear();

        llList = new ArrayList<>();
        boolean isFirst = true;
        for (int i = 1; i < 60; i++) {
            LinearLayout view = context.findViewById(context.getResources()
                    .getIdentifier("ll_" + i, "id", context.getPackageName()));

            if (view == null)
                continue;
            if (isFirst) {
                view.setAlpha(1);
                isFirst = false;
            } else
                view.setAlpha(0);
            llList.add(view);
        }

        count = llList.size();
        initAnimations(context);
    }

    private static void initListeners(Activity context) {
        context.findViewById(R.id.lotie2).setOnClickListener(view ->
                initAudio());

        context.findViewById(R.id.fl).setOnClickListener(view ->
                initNext());
        context.findViewById(R.id.next).setOnClickListener(view ->
                initNext());
        context.findViewById(R.id.prev).setOnClickListener(view ->
                initPrev());
        context.findViewById(R.id.textView2).setOnClickListener(view ->
                context.finish());
        context.findViewById(R.id.cl).setOnClickListener(view ->
                initNext());

    }


    private static void initAudio() {
        initMediaPlayer(context, mediaPlayersIds.get(selectedLayout + 1));
    }

    private static void initAnimations(Activity context) {
        for (int i = 1; i < 1000; i++) {
            View view = context.findViewById(context.getResources()
                    .getIdentifier("anim" + i, "id", context.getPackageName()));
            if (view == null)
                continue;
            new Handler().postDelayed(() -> initAnim(view), i * 500L);
        }
    }

    private static void animateVisibility(float visibility, LinearLayout ll) {
        if (visibility == 1)
            new Handler().postDelayed(() ->
                    ll.animate().alpha(visibility).setDuration(250), 250);
        else
            ll.animate().alpha(visibility).setDuration(250);
    }

    private static void initVisible(LinearLayout ll1) {
        for (LinearLayout ll : llList)
            if (ll == ll1)
                animateVisibility(1, ll);
            else
                animateVisibility(0, ll);
    }

    private static void initAnim(View view) {
        view.animate().rotationBy(5).translationYBy(20).setDuration(10);
        new Handler().postDelayed(() -> view
                .animate().translationYBy(-40).rotationBy(-10).setDuration(1000), 10);
        new Handler().postDelayed(() -> view
                .animate().translationYBy(40).rotationBy(-10).setDuration(1000), 1010);
        new Handler().postDelayed(() -> view
                .animate().translationYBy(-40).rotationBy(10).setDuration(1000), 2010);
        new Handler().postDelayed(() -> view
                .animate().translationYBy(40).rotationBy(10).setDuration(1000), 3010);
        new Handler().postDelayed(() -> initAnim(view), 4010);
    }

    private static void initNext() {
        selectedLayout += 1;
        if (selectedLayout > (count - 1))
            selectedLayout = 0;
        try {
            initMediaPlayer(context, mediaPlayersIds.get(selectedLayout + 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        speak();

        initVisible(llList.get(selectedLayout));
    }

    private static void initMediaPlayer(Context context, int id) {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
        try {
            mp = MediaPlayer.create(context, id);
            mp.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initPrev() {
        selectedLayout -= 1;
        if (selectedLayout <= 0)
            selectedLayout = 0;

        try {
            initMediaPlayer(context, mediaPlayersIds.get(selectedLayout + 1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        speak();
        initVisible(llList.get(selectedLayout));
    }

    public static void speak() {
        switch (selectedLayout + 1) {
            case 1:
                Utils.speak(context, "cat");
                break;
            case 2:
                Utils.speak(context, "dog");
                break;
            case 3:
                Utils.speak(context, "egg");
                break;
            case 4:
                Utils.speak(context, "hat");
                break;
            case 5:
                Utils.speak(context, "jug");
                break;
            case 6:
                Utils.speak(context, "net");
                break;
            case 7:
                Utils.speak(context, "sun");
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_letter_words);
        context = this;
        initLayouts(this, 0, "");
    }
}