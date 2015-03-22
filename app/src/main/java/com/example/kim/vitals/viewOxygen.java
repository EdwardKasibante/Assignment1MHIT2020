package com.example.kim.vitals;


import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.TextView;

import java.sql.SQLException;

public class viewOxygen extends Activity {

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_view_rate);
        TextView tv=(TextView)findViewById(R.id.pk);
        SqlSettings info=new SqlSettings(this);
        try {
            info.open();
            String data = info.getData2();
            info.close();
            tv.setText(data);
        }
        catch(SQLException e)
        {
            String error=e.toString();
            Dialog d=new Dialog(this);
            d.setTitle("RESULT FAIL");
            TextView rv=new TextView(this);
            rv.setText(error);
            d.setContentView(rv);
            d.show();
        }
    }
}