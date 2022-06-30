package com.app.hometuition.utils;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.app.hometuition.R;
import com.app.hometuition.TTSSingleton;
import com.app.hometuition.info.Info;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils implements Info {
    private static int selectedLayout = 0;
    private static List<LinearLayout> llList;
    private static int count = 8;
    private static List<Integer> mediaPlayersIds;
    private static MediaPlayer mp;
    private static Activity context;

    public static void initLayouts(Activity context, int playerCount, String id) {
        selectedLayout = 0;
        Utils.context = context;
        mediaPlayersIds = new ArrayList<>();
        for (int i = 1; i <= playerCount; i++)
            mediaPlayersIds.add(context.getResources()
                    .getIdentifier(id + i, "raw", context.getPackageName()));

        try {
            initMediaPlayer(context, mediaPlayersIds.get(0));
            try {
                mp.setOnCompletionListener(mediaPlayer -> initMediaPlayer(context, mediaPlayersIds.get(1)));
            } catch (Exception e) {
                e.printStackTrace();
            }
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
        Log.i(TAG, "initListeners: ");
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
        Log.i(TAG, "initAudio: ");
        initMediaPlayer(context, mediaPlayersIds.get(selectedLayout + 1));
    }

    public static void speak(Context context, String str) {
        TTSSingleton.getInstance(context).speak(str, TextToSpeech.QUEUE_FLUSH, null);
    }

    public static void speakUrdu(Context context, String str) {
        new Handler().postDelayed(() -> TTSSingleton.getUrduInstance(context).speak(str, TextToSpeech.QUEUE_FLUSH, null), 500);
    }

    public static void speakHindi(Context context, String str) {
        new Handler().postDelayed(() -> TTSSingleton.getHindiInstance(context).speak(str, TextToSpeech.QUEUE_FLUSH, null), 500);
    }

    public static void initQuiz(Activity context) {
        List<View> llList = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            LinearLayout view = context.findViewById(context.getResources()
                    .getIdentifier("ll_" + i, "id", context.getPackageName()));

            if (view == null)
                continue;
            llList.add(view);
        }
        Random random = new Random();
        int randomNumber = random.nextInt(5);
        for (int i = 0; i < llList.size(); i++)
            if (randomNumber == i)
                llList.get(i).setVisibility(View.VISIBLE);
            else
                llList.get(i).setVisibility(View.GONE);
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

        initVisible(llList.get(selectedLayout));
    }

    public static MediaPlayer initMediaPlayer(Context context, int id) {
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
        return mp;
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

        initVisible(llList.get(selectedLayout));
    }

    public static void initSumGrids(Activity math47Addition) {
        GridLayout grid1 = math47Addition.findViewById(R.id.grid_1);
        GridLayout grid2 = math47Addition.findViewById(R.id.grid_2);
        GridLayout grid3 = math47Addition.findViewById(R.id.grid_3);

        grid1.setAlpha(0);
        grid2.setAlpha(0);
        grid3.setAlpha(0);

        grid1.animate().alpha(1).setDuration(1000);
        new Handler().postDelayed(() -> grid2.animate().alpha(1).setDuration(1000), 1000);
        new Handler().postDelayed(() -> grid3.animate().alpha(1).setDuration(1000), 2000);

    }

    public static String ordinal(int i) {
        String[] suffixes = new String[]{"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th"};
        switch (i % 100) {
            case 11:
            case 12:
            case 13:
                return i + "th";
            default:
                return i + suffixes[i % 10];
        }
    }
}