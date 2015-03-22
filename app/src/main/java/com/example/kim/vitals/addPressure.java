package com.example.kim.vitals;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class addPressure extends Activity implements View.OnClickListener {
    Button submitButton ;
    EditText eText;
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_add_pressure);
        submitButton=(Button)findViewById(R.id.submit);
        eText=(EditText)findViewById(R.id.PressureText);
        submitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.submit:
                boolean diditwork=true;
                try {
                    String pre = eText.getText().toString();
                    SqlSettings entry = new SqlSettings(this);
                    entry.open();
                    entry.createEntry3(pre);
                    entry.close();
                }
                catch(Exception e)
                {

                    diditwork=false;
                    String error=e.toString();
                    Dialog d=new Dialog(this);
                    d.setTitle("RESULT FAIL");
                    TextView rv=new TextView(this);
                    rv.setText(error);
                    d.setContentView(rv);
                    d.show();
                }
                finally {
                    if(diditwork)
                    {
                        Dialog d=new Dialog(this);
                        d.setTitle("RESULT");
                        TextView rv=new TextView(this);
                        rv.setText("Blood Pressure Level Successfully Saved");
                        d.setContentView(rv);
                        d.show();
                    }
                }
                break;
        }
    }
}