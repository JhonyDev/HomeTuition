package com.app.hometuition.activities.maths;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.app.hometuition.R;

import java.util.ArrayList;
import java.util.List;

public class Math47OrdinalNumbers extends AppCompatActivity {

    int selectedLayout = 1;
    private List<LinearLayout> llList;
    private int count = 8;

    private void initAnimations(Activity context) {
        for (int i = 1; ; i++) {
            if (i % 2 == 0)
                continue;
            View view = context.findViewById(context.getResources()
                    .getIdentifier("anim" + i, "id", context.getPackageName()));
            if (view == null)
                break;
            new Handler().postDelayed(() -> initAnim(view), i * 250L);
        }
    }

    private void initAnim(View view) {
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

    private void initListeners(Activity context) {
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

    public void initLayouts(Activity context) {
        selectedLayout = 0;
        try {
            initListeners(context);
        } catch (Exception e) {
            e.printStackTrace();
        }

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

    private void initNext() {
        selectedLayout += 1;
        if (selectedLayout > (count - 1))
            selectedLayout = 0;
        initVisible(llList.get(selectedLayout));
    }

    private void animateVisibility(float visibility, LinearLayout ll) {
        if (visibility == 1)
            new Handler().postDelayed(() ->
                    ll.animate().alpha(visibility).setDuration(250), 250);
        else
            ll.animate().alpha(visibility).setDuration(250);
    }

    private void initVisible(LinearLayout ll1) {
        for (LinearLayout ll : llList)
            if (ll == ll1)
                animateVisibility(1, ll);
            else
                animateVisibility(0, ll);
    }

    private void initPrev() {
        selectedLayout -= 1;
        if (selectedLayout <= 0)
            selectedLayout = 0;
        initVisible(llList.get(selectedLayout));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math47_ordinal_numbers);
        initLayouts(this);
    }
}