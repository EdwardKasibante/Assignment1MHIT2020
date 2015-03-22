package com.example.kim.vitals;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;


public class pressure extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TabHost host = getTabHost();

        host.addTab(host.newTabSpec("one")
                .setIndicator("Add BloodPressure Level")
                .setContent(new Intent(this, addPressure.class)));
        host.addTab(host.newTabSpec("two")
                .setIndicator("View BloodPressure Levels")
                .setContent(new Intent(this, viewPressure.class)));
    }
}
