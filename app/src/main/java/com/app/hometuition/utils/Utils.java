package com.app.hometuition.utils;

import android.app.Activity;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

import com.app.hometuition.R;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    private static int selectedLayout = 0;
    private static List<LinearLayout> llList;
    private static int count = 8;

    public static void initLayouts(Activity context) {
        selectedLayout = 0;
        initListeners(context);

        if (llList != null)
            llList.clear();

        llList = new ArrayList<>();

        for (int i = 1; ; i++) {
            LinearLayout view = context.findViewById(context.getResources()
                    .getIdentifier("ll_" + i, "id", context.getPackageName()));
            if (view == null) {
                count = i - 1;
                break;
            }

            if (i == 1)
                view.setAlpha(1);
            else
                view.setAlpha(0);
            llList.add(view);
        }

        initAnimations(context);
    }

    private static void initListeners(Activity context) {
        context.findViewById(R.id.fl).setOnClickListener(view ->
                initNext());
        context.findViewById(R.id.next).setOnClickListener(view ->
                initNext());
        context.findViewById(R.id.prev).setOnClickListener(view ->
                initPrev());
        context.findViewById(R.id.textView2).setOnClickListener(view ->
                context.finish());
    }

    private static void initAnimations(Activity context) {
        for (int i = 1; ; i++)
            if (!initAnim(context.findViewById(context.getResources()
                    .getIdentifier("anim" + i, "id", context.getPackageName()))))
                break;
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

    private static boolean initAnim(View view) {
        if (view == null)
            return false;
        view.setRotation(5);
        view.animate().rotationBy(-10).setDuration(1000);
        new Handler().postDelayed(() -> view
                .animate().rotationBy(-10).setDuration(1000), 1000);
        new Handler().postDelayed(() -> view
                .animate().rotationBy(10).setDuration(1000), 2000);
        new Handler().postDelayed(() -> view
                .animate().rotationBy(10).setDuration(1000), 3000);
        new Handler().postDelayed(() -> initAnim(view), 4000);
        return true;
    }

    private static void initNext() {
        selectedLayout += 1;
        if (selectedLayout > (count - 1))
            selectedLayout = 0;
        initVisible(llList.get(selectedLayout));
    }

    private static void initPrev() {
        selectedLayout -= 1;
        if (selectedLayout <= 0)
            selectedLayout = 0;
        initVisible(llList.get(selectedLayout));
    }

}
