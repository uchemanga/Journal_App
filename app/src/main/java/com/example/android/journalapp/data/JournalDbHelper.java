package com.example.android.journalapp.data;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.journalapp.data.JournalContract.JournalAppEntry;

    /**
     * Database helper for journalApp app. Manages database creation and version management.
     */
    public class JournalDbHelper extends SQLiteOpenHelper {

        public static final String LOG_TAG = JournalDbHelper.class.getSimpleName();

        /** Name of the database file */
        private static final String DATABASE_NAME = "shelter.db";

        /**
         * Database version. If you change the database schema, you must increment the database version.
         */
        private static final int DATABASE_VERSION = 1;

        /**
         * Constructs a new instance of {@link JournalDbHelper}.
         *
         * @param context of the app
         */
        public JournalDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        /**
         * This is called when the database is created for the first time.
         */
        @Override
        public void onCreate(SQLiteDatabase db) {
            // Create a String that contains the SQL statement to create the journalApp table
            String SQL_CREATE_JOURNALAPP_TABLE =  "CREATE TABLE " + JournalAppEntry.TABLE_NAME + " ("
                    + JournalAppEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + JournalAppEntry.COLUMN_JOURNAL_TITLE + " TEXT NOT NULL, "
                    + JournalAppEntry.COLUMN_JOURNAL_BODY + " TEXT);";
                    //+ PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL, "
                    //+ PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";

            // Execute the SQL statement
            db.execSQL(SQL_CREATE_JOURNALAPP_TABLE);
        }

        /**
         * This is called when the database needs to be upgraded.
         */
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // The database is still at version 1, so there's nothing to do be done here.
        }
    }
