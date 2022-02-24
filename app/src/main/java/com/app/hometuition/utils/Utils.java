package com.app.hometuition.utils;

import android.os.Handler;
import android.widget.LinearLayout;

import java.util.List;

public class Utils {

    public static void animateVisibility(float visibility, LinearLayout ll) {
        if (visibility == 1)
            new Handler().postDelayed(() -> ll.animate().alpha(visibility).setDuration(250), 250);
        else
            ll.animate().alpha(visibility).setDuration(250);
    }

    public static void initVisible(LinearLayout ll1, List<LinearLayout> llList) {
        for (LinearLayout ll : llList)
            if (ll == ll1)
                Utils.animateVisibility(1, ll);
            else
                Utils.animateVisibility(0, ll);
    }
}
