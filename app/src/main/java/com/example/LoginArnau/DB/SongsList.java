package com.example.LoginArnau.DB;

import android.provider.BaseColumns;

public class SongsList {
    private SongsList(){}
    public static class SongsEntry implements BaseColumns {
        public static final String TABLE_NAME ="songs";
        public static final String ID = "id";
        public static final String COLUMN_NAME_SONG = "name";
        public static final String COLUMN_NAME_ARTIST = "artist" ;
    }
}

