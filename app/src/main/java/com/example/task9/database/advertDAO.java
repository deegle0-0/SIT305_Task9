package com.example.task9.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface advertDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void Insert(Advert advert);

    @Update
    void update(Advert advert);

    @Delete
    void delete(Advert advert);

    @Query("SELECT * FROM adverts ORDER BY name ASC")
    LiveData<List<Advert>> getAllAdverts();

    @Query("SELECT * FROM adverts WHERE found=1")
    LiveData<List<Advert>> getFound();

    @Query("DELETE FROM adverts")
    void deleteAll();

    @Query("SELECT lat from adverts")
    Double getlat();

    @Query("SELECT long from adverts")
    Double getlon();

}
