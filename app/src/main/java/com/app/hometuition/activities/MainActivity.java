package com.app.hometuition.activities;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.app.hometuition.R;
import com.app.hometuition.TTSSingleton;
import com.app.hometuition.activities.english.English47;
import com.app.hometuition.activities.english.English79;
import com.app.hometuition.activities.maths.Math47;
import com.app.hometuition.activities.maths.Math79;
import com.app.hometuition.activities.quiz.EnglishQuiz;
import com.app.hometuition.activities.quiz.MathQuizActivity;
import com.app.hometuition.activities.quiz.UrduQuizActivity;
import com.app.hometuition.activities.urdu.Urdu47;
import com.app.hometuition.activities.urdu.Urdu79;
import com.app.hometuition.utils.DialogUtils;

public class MainActivity extends AppCompatActivity {

    Dialog ageDialog;
    int selection = 1;

    public void initAgeDialog() {
        ageDialog.setContentView(R.layout.dialog_age);
        ageDialog.setCanceledOnTouchOutside(false);
        DialogUtils.setDefaultDialogProperties(ageDialog);
        CardView cv47 = ageDialog.findViewById(R.id.cv_age_4_7);
        CardView cv79 = ageDialog.findViewById(R.id.cv_age_7_9);
        CardView cvQuiz = ageDialog.findViewById(R.id.cv_quiz);
        cv79.setOnClickListener(view -> {
            ageDialog.dismiss();
            switch (selection) {
                case 1:
                    startActivity(new Intent(this, English79.class));
                    break;
                case 2:
                    startActivity(new Intent(this, Math79.class));
                    break;
                case 3:
                    startActivity(new Intent(this, Urdu79.class));
                    break;
            }
        });
        cv47.setOnClickListener(view -> {
            ageDialog.dismiss();
            switch (selection) {
                case 1:
                    startActivity(new Intent(this, English47.class));
                    break;
                case 2:
                    startActivity(new Intent(this, Math47.class));
                    break;
                case 3:
                    startActivity(new Intent(this, Urdu47.class));
                    break;
            }
        });
        cvQuiz.setOnClickListener(view -> {
            ageDialog.dismiss();
            switch (selection) {
                case 1:
                    startActivity(new Intent(this, EnglishQuiz.class));
                    break;
                case 2:
                    startActivity(new Intent(this, MathQuizActivity.class));
                    break;
                case 3:
                    startActivity(new Intent(this, UrduQuizActivity.class));
                    break;
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ageDialog = new Dialog(this);
        initAgeDialog();

        TTSSingleton.getInstance(this);
        TTSSingleton.getUrduInstance(this);
        TTSSingleton.getHindiInstance(this);

    }

    public void exit(View view) {
        finishAffinity();
    }

    public void english(View view) {
        ageDialog.show();
        selection = 1;
    }

    public void maths(View view) {
        ageDialog.show();
        selection = 2;
    }

    public void urdu(View view) {
        ageDialog.show();
        selection = 3;
    }
}