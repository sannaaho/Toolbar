package com.example.toolbar;

import android.graphics.Picture;

import java.util.List;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Entity;

@Entity
public class MyEntity {
    @PrimaryKey(autoGenerate = true)
    int id;

    String nimi;
    int maara;

    //@Dao
    public interface MyTableDao {

        @Query("SELECT * FROM myentity ORDER BY id desc")
        List<Picture> getAllInDescendingOrder();

        @Insert
        void InsertMyEntity(MyEntity myentity);

        @Delete
        void DeleteMyEntity(MyEntity myentity);
    }
}
