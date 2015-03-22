package com.example.kim.vitals;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;


public class oxygen extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TabHost host = getTabHost();

        host.addTab(host.newTabSpec("one")
                .setIndicator("Add Oxygen Level")
                .setContent(new Intent(this, addOxygen.class)));
        host.addTab(host.newTabSpec("two")
                .setIndicator("View Oxygen Levels")
                .setContent(new Intent(this, viewOxygen.class)));
    }
}
