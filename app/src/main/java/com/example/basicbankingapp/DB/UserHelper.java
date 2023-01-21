package com.example.basicbankingapp.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.basicbankingapp.DB.UserContract.UserEntry;
import com.example.basicbankingapp.Data.User;

public class UserHelper extends SQLiteOpenHelper {

    String TABLE_NAME = UserEntry.TABLE_NAME;

    /** Name of the database file */
    private static final String DATABASE_NAME = "User.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.*/
    private static final int DATABASE_VERSION = 1;

    public UserHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
        String SQL_CREATE_USER_TABLE =  "CREATE TABLE " + UserEntry.TABLE_NAME + " ("
                + UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " INTEGER, "
                + UserEntry.COLUMN_USER_NAME + " VARCHAR, "
                + UserEntry.COLUMN_USER_EMAIL + " VARCHAR, "
                + UserEntry.COLUMN_USER_IFSC_CODE + " VARCHAR, "
                + UserEntry.COLUMN_USER_PHONE_NO + " VARCHAR, "
                + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " INTEGER NOT NULL);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_USER_TABLE);

        // Insert Into Table
        db.execSQL("insert into " + TABLE_NAME + " values(1234567890,'Rohit Sharma', ' rohit.sharma@gmail.com','IFSC00001','9876543210', 15000)");
        db.execSQL("insert into " + TABLE_NAME + " values(2345678901,'Priya Gupta', ' rohit.sharma@gmail.com','IFSC00002','9876543211', 5000)");
        db.execSQL("insert into " + TABLE_NAME + " values(3456789012,'Rohan Patel', ' rohan.patel@gmail.com','IFSC00003','9876543212', 1000)");
        db.execSQL("insert into " + TABLE_NAME + " values(4567890123,'Vaishali Sharma', 'vaishali.sharma@gmail.com','IFSC00004','9876543213', 8000)");
        db.execSQL("insert into " + TABLE_NAME + " values(5678901234,'Manish Kumar', 'manish.kumar@gmail.com ','IFSC00005','9095648962', 7500)");
        db.execSQL("insert into " + TABLE_NAME + " values(6789012345,'Aarav Patel', 'aarav.patel@gmail.com','IFSC00006','8855640238', 6500)");
        db.execSQL("insert into " + TABLE_NAME + " values(7890123456,'Shreya Shah', ' shreya.shah@gmail.com ','IFSC00007','8895640215', 4500)");
        db.execSQL("insert into " + TABLE_NAME + " values(8901234567,'Rishi Desai', ' rishi.desai@gmail.com','IFSC00008','9985021539', 2500)");
        db.execSQL("insert into " + TABLE_NAME + " values(9012235678,'Megha Patel', 'megha.patel@gmail.com','IFSC00009','9309565238', 10500)");
        db.execSQL("insert into " + TABLE_NAME + " values(1784237890,'Aditya Gupta', 'aditya.gupta@gmail.com','IFSC00010','8292591201', 9900)");
        db.execSQL("insert into " + TABLE_NAME + " values(1654457890,'Kunal Shah', ' kunal.shah@gmail.com','IFSC00011','9015641200', 9800)");
        db.execSQL("insert into " + TABLE_NAME + " values(1124647890,'Uday Singh', 'uday.singh@gmail.com','IFSC00012','9995641999', 11000)");
        db.execSQL("insert into " + TABLE_NAME + " values(1874567890,'Anjali Sharma', 'anjali.sharma@gmail.com','IFSC00013','9119541001', 5800)");
        db.execSQL("insert into " + TABLE_NAME + " values(1783444789,'Riya Patel', 'riya.patel@gmail.com','IFSC00014','6254642205', 3500)");
        db.execSQL("insert into " + TABLE_NAME + " values(1234677890,'Abhinav Shah', 'abhinav.shah@gmail.com','IFSC00015','6893641266', 1010)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + UserEntry.TABLE_NAME);
            onCreate(db);
        }
    }

    public Cursor readAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME, null);
        return cursor;
    }

    public Cursor readParticularData (int accountNo) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("select * from " + UserEntry.TABLE_NAME + " where " +
                                        UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo, null);
        return cursor;
    }

    public void updateAmount(int accountNo, int amount) {
        Log.d ("TAG", "update Amount");
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update " + UserEntry.TABLE_NAME + " set " + UserEntry.COLUMN_USER_ACCOUNT_BALANCE + " = " + amount + " where " +
                UserEntry.COLUMN_USER_ACCOUNT_NUMBER + " = " + accountNo);
    }
}