package com.example.kim.vitals;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SqlSettings {
    //fields for heart rate table
    public static final String KEY_ROWID="_id";
    public static final String KEY_DATE="date";
    public static final String KEY_HEARTRATE="heartrate";

    //fields for oxygen level table
    public static final String KEY_ROWID2="_id";
    public static final String KEY_DATE2="date";
    public static final String KEY_OXY="oxygen";

     //fields for pressure level table
    public static final String KEY_ROWID3="_id";
    public static final String KEY_DATE3="date";
    public static final String KEY_PRES="pressure";

    public static final String DATABASE_NAME="vitals2";
    public static final String DATABASE_TABLE="heartrate";
    public static final String DATABASE_TABLE2="oxygen";
    public static final String DATABASE_TABLE3="pressure";
    public static final int DATABASE_VERSION=1;

    public DbHelper ourHelper;
    public final Context ourContext;
    public SQLiteDatabase ourDatabase;


    private static class DbHelper extends SQLiteOpenHelper
    {
        public DbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(
                    "CREATE TABLE " + DATABASE_TABLE + " ("
                            + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                            + KEY_HEARTRATE + " INTEGER,"
                            + KEY_DATE + " TEXT);"

            );
            db.execSQL(
                    "CREATE TABLE " + DATABASE_TABLE2 + " ("
                            + KEY_ROWID2 + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                            + KEY_OXY + " INTEGER,"
                            + KEY_DATE2 + " TEXT);"

            );
            db.execSQL(
                    "CREATE TABLE " + DATABASE_TABLE3 + " ("
                            + KEY_ROWID3 + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
                            + KEY_PRES + " INTEGER,"
                            + KEY_DATE3 + " TEXT);"

            );

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE );
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE2 );
           db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE3 );
            onCreate(db);
        }
    }
    public SqlSettings(Context c)
    {
        ourContext=c;
    }
    public SqlSettings open() throws SQLException
    {
        ourHelper=new DbHelper(ourContext);
        ourDatabase=ourHelper.getWritableDatabase();
        return  this;
    }
    public  void close()
    {

        ourHelper.close();
    }
    public long createEntry(String hra) {
        ContentValues cv=new ContentValues();
        cv.put(KEY_HEARTRATE,hra);
        //get current date
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        cv.put(KEY_DATE,currentDate);
        return ourDatabase.insert(DATABASE_TABLE, null, cv);
    }
    public long createEntry2(String ox) {
        ContentValues cv=new ContentValues();
        cv.put(KEY_OXY,ox);
        //get current date
        String currentDate = new  SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        cv.put(KEY_DATE2,currentDate);
        return ourDatabase.insert(DATABASE_TABLE2, null, cv);
    }
    public long createEntry3(String press) {
        ContentValues cv=new ContentValues();
        cv.put(KEY_PRES,press);
        //get current date
        String currentDate = new  SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
        cv.put(KEY_DATE3,currentDate);
        return ourDatabase.insert(DATABASE_TABLE3, null, cv);
    }

    public String getData() {
        String[] columns=new String[]{KEY_DATE,KEY_HEARTRATE};
        Cursor c=ourDatabase.query(DATABASE_TABLE,columns,null,null,null,null,null);
        String result="";
        int iDate=c.getColumnIndex(KEY_DATE);
        int irate=c.getColumnIndex(KEY_HEARTRATE);
        for (c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            result=result  + c.getString(iDate) + "\t\t\t\t" + c.getString(irate) + "\n";

        }

        return result;
    }
    public String getData2() {
        String[] columns=new String[]{KEY_DATE2,KEY_OXY};
        Cursor c=ourDatabase.query(DATABASE_TABLE2,columns,null,null,null,null,null);
        String result="";
        int iDate=c.getColumnIndex(KEY_DATE2);
        int irate=c.getColumnIndex(KEY_OXY);
        for (c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            result=result  + c.getString(iDate) + "\t\t\t\t" + c.getString(irate) + "\n";

        }

        return result;
    }

    public String getData3() {
        String[] columns=new String[]{KEY_DATE3,KEY_PRES};
        Cursor c=ourDatabase.query(DATABASE_TABLE3,columns,null,null,null,null,null);
        String result="";
        int iDate=c.getColumnIndex(KEY_DATE3);
        int irate=c.getColumnIndex(KEY_PRES);
        for (c.moveToFirst();!c.isAfterLast();c.moveToNext())
        {
            result=result  + c.getString(iDate) + "\t\t\t\t" + c.getString(irate) + "\n";

        }

        return result;
    }


}



