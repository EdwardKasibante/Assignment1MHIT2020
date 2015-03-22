package com.example.kim.vitals;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;


public class Temperature extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TabHost host = getTabHost();

        host.addTab(host.newTabSpec("one")
                .setIndicator("Add Temperature")
                .setContent(new Intent(this, addTemp.class)));
        host.addTab(host.newTabSpec("two")
                .setIndicator("View Temperatures")
                .setContent(new Intent(this, viewTemp.class)));
    }
}
