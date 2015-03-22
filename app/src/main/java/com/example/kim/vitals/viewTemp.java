package com.example.kim.vitals;


import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class viewTemp extends Activity {

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        setContentView(R.layout.activity_view_temp);
        TextView tv=(TextView)findViewById(R.id.tvSQLinfo);
        // Show all the incomes sorted by date
        String URL = "content://com.example.kim.vitals.provider.VTS/temperatures";
        Uri friends = Uri.parse(URL);
        Cursor c = getContentResolver().query(friends, null, null, null, "date");
        String result = "";

        if (!c.moveToFirst()) {
            Toast.makeText(this, result + " no content yet!", Toast.LENGTH_LONG).show();
        }else{
            do{
                result = result + "\n" + c.getString(c.getColumnIndex(KimzProvider.DATE)) +
                        "\t\t\t\t\t\t\t\t\t"+  c.getString(c.getColumnIndex(KimzProvider.DEGREE));
                tv.setText(result);
            } while (c.moveToNext());

        }
    }
}