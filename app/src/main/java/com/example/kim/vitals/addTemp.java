package com.example.kim.vitals;


import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.view.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class addTemp extends Activity implements View.OnClickListener {
    Button submitButton ;
    EditText TempText;
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_add_temp);
        submitButton=(Button)findViewById(R.id.submit);
        TempText =(EditText)findViewById(R.id.tempText);
        submitButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        // Add a new Temperature record
        ContentValues values = new ContentValues();

        values.put(KimzProvider.DEGREE,
                ((EditText)findViewById(R.id.tempText)).getText().toString());

        //get current date
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());


        values.put(KimzProvider.DATE, (currentDate));

        Uri uri = getContentResolver().insert(
                KimzProvider.CONTENT_URI, values);

        Toast.makeText(getBaseContext(),
                "New Temperature Record Successfully Inserted!", Toast.LENGTH_LONG).show();

    }
}