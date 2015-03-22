package com.example.kim.vitals;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;


public class hrate extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TabHost host = getTabHost();

        host.addTab(host.newTabSpec("one")
                .setIndicator("Add Heart Rate")
                .setContent(new Intent(this, addRate.class)));
        host.addTab(host.newTabSpec("two")
                .setIndicator("View Heart Rates")
                .setContent(new Intent(this, viewRate.class)));
    }
}
