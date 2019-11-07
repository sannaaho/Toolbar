package com.example.toolbar;
import android.graphics.Picture;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {MyEntity.class}, version = 1)
public abstract class Tietokanta extends RoomDatabase {
    public static final String NIMI = "TIETOKANTA";
    public abstract MyEntity.MyTableDao myTableDao();
}
