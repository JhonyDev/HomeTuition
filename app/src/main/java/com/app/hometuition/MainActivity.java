package com.app.hometuition;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.app.hometuition.activities_4_7.English47;
import com.app.hometuition.activities_4_7.Math47;
import com.app.hometuition.activities_4_7.Urdu47;
import com.app.hometuition.activities_7_9.English79;
import com.app.hometuition.activities_7_9.Math79;
import com.app.hometuition.activities_7_9.Urdu79;
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
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ageDialog = new Dialog(this);
        initAgeDialog();

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