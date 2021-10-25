package com.example.LoginArnau.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.LoginArnau.Model.Song;
import com.example.LoginArnau.DB.SongsList.*;

public class SongsDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "songs.db";

    //Context context: Context d'acció per al helper.
    //String name: Nom de l'arxiu amb extensió .db, on s'emmagatzemarà la base de dades, que al seu torn correspon a el nom de la base de dades.
    //CursorFactory factory: Assignem null, per ara no cal comprendre el funcionament d'aquest paràmetre.
    //int versió: Enter que representa la versió de la base de dades. El seu valor inicial per defecte és 1. Si en algun moment la versió és més gran es diu al mètode onUpgrade () per actualitzar la base de dades a la nova versió. Si és menor, es diu a downUpgrade () per tornar a una versió prèvia
    public SongsDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " +
                    SongsList.SongsEntry.TABLE_NAME +
                    "(" +
                    SongsList.SongsEntry.ID +
                    " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    SongsList.SongsEntry.COLUMN_NAME_TITLE +
                    " TEXT)";
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void insertSong(SQLiteDatabase db, Song c){
        //Check the bd is open
        if (db.isOpen()){
            //Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the contacts getting all values
            values.put(SongsList.SongsEntry.COLUMN_NAME_TITLE, c.getNombre());

            db.insert(SongsList.SongsEntry.TABLE_NAME, null, values);
        }else{
            Log.i("sql","Database is closed");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
