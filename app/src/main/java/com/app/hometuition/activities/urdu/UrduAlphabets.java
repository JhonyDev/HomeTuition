package com.app.hometuition.activities.urdu;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.app.hometuition.R;
import com.app.hometuition.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class UrduAlphabets extends AppCompatActivity {
    private static int selectedLayout = 0;
    private static List<LinearLayout> llList;
    private static int count = 8;
    private static List<Integer> mediaPlayersIds;
    private static MediaPlayer mp;
    private static Activity context;

    public static void initLayouts(Activity context, int playerCount, String id) {
        selectedLayout = 0;
        try {
            int res_id = context.getResources()
                    .getIdentifier("u_" + (selectedLayout + 1), "string", context.getPackageName());
            Log.i("TAG", "initNext: " + selectedLayout);
            Log.i("TAG", "initNext: " + context.getResources().getString(res_id));
            Utils.speakUrdu(context, context.getResources().getString(res_id));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        try {
            if (selectedLayout + 1 == 17) {
                try {
                    initMediaPlayer(context, R.raw.jay);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (selectedLayout + 1 == 22) {
                try {
                    initMediaPlayer(context, R.raw.tuae);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (selectedLayout + 1 == 23) {
                try {
                    initMediaPlayer(context, R.raw.zuae);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                int res_id = context.getResources()
                        .getIdentifier("u_" + (selectedLayout + 1), "string", context.getPackageName());
                Utils.speakUrdu(context, context.getResources().getString(res_id));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        if (selectedLayout + 1 == 22) {
            try {
                initMediaPlayer(context, R.raw.tuae);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (selectedLayout + 1 == 23) {
            try {
                initMediaPlayer(context, R.raw.zuae);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            int res_id = context.getResources()
                    .getIdentifier("u_" + (selectedLayout + 1), "string", context.getPackageName());
            Utils.speakUrdu(context, context.getResources().getString(res_id));
        }
        initVisible(llList.get(selectedLayout));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urdu_alphabets);
        context = this;
        initLayouts(this, 0, "");
    }

    public void back(View view) {
        finish();
    }
}