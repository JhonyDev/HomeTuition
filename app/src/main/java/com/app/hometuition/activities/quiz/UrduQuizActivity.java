package com.app.hometuition.activities.quiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.app.hometuition.R;
import com.app.hometuition.utils.Utils;

public class UrduQuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urdu_quiz);
        Utils.initQuiz(this);
    }

    public void correct(View view) {
        Toast.makeText(this, "Congratulations Correct Answer", Toast.LENGTH_SHORT).show();
    }

    public void wrong(View view) {
        Toast.makeText(this, "Wrong Answer", Toast.LENGTH_SHORT).show();
    }

    public void prev(View view) {
        Utils.initQuiz(this);
    }

    public void next(View view) {
        Utils.initQuiz(this);
    }

}