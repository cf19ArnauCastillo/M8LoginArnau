package com.example.LoginArnau.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.LoginArnau.Model.Song;
import com.example.LoginArnau.DB.SongsList.*;  //mira esto el miercolesxº

import java.util.ArrayList;

public class SongsDBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "songs.db";
    //Context context: Context d'acció per al helper.
    //String name: Nom de l'arxiu amb extensió .db, on s'emmagatzemarà la base de dades, que al seu torn correspon a el nom de la base de dades.
    //CursorFactory factory: Assignem null, per ara no cal comprendre el funcionament d'aquest paràmetre.
    //int versió: Enter que representa la versió de la base de dades. El seu valor inicial per defecte és 1. Si en algun moment la versió és més gran es diu al mètode onUpgrade () per actualitzar la base de dades a la nova versió. Si és menor, es diu a downUpgrade () per tornar a una versió prèvia

    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + SongsList.SongsEntry.TABLE_NAME + "("
                    + SongsList.SongsEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + SongsList.SongsEntry.COLUMN_NAME_SONG + " TEXT, "
                    + SongsList.SongsEntry.COLUMN_NAME_ARTIST + " TEXT )";


    public SongsDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
/*
    public void dropTable(SQLiteDatabase db){
        db.execSQL("DROP TABLE " + SongsList.SongsEntry.TABLE_NAME);
    }
*/
    public void delete(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS "+SongsList.SongsEntry.TABLE_NAME);
        onCreate(db);
    }

    public void insertSong(SQLiteDatabase db, Song s){
        //Check the bd is open
        if (db.isOpen()){
            //Creation of the register for insert object with the content values
            ContentValues values = new ContentValues();

            //Insert the contacts getting all values
            values.put(SongsList.SongsEntry.COLUMN_NAME_SONG, s.getNombre());
            values.put(SongsList.SongsEntry.COLUMN_NAME_ARTIST, s.getArtista());
            db.insert(SongsList.SongsEntry.TABLE_NAME, null, values);
        }else{
            Log.i("sql","Database is closed");
        }
    }

    public ArrayList<Song> getAllSongs(SQLiteDatabase db){
        ArrayList<Song> arraySongs = new ArrayList<>();

        Cursor cursor = db.query (SongsList.SongsEntry.TABLE_NAME, new String [] {"name", "artist"}, null, null, null, null, null);
        Song s;
        while (cursor.moveToNext ()) {
            s = new Song (cursor.getString (0), cursor.getString (1));
            arraySongs.add (s);
        }
        cursor.close ();
        return arraySongs;
    }

}
