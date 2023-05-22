package com.example.task9.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "adverts")
public class Advert implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name="name")
    String name;

    @NonNull
    @ColumnInfo(name="desc")
    String description;

    @NonNull
    @ColumnInfo(name="phoneNo")
    String phoneNo;

    @NonNull
    @ColumnInfo(name="date")
    String date;

    @NonNull
    @ColumnInfo(name="location")
    String location;

    @NonNull
    @ColumnInfo(name="found")
    Boolean found;

    @NonNull
    @ColumnInfo(name = "lat")
    Double lat;

    @NonNull
    @ColumnInfo(name = "long")
    Double lon;

    public Advert(int id, @NonNull String name, @NonNull String description,
                  @NonNull String phoneNo, @NonNull String date,
                  @NonNull String location,@NonNull Boolean found,@NonNull Double lat,@NonNull Double lon) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.phoneNo = phoneNo;
        this.date = date;
        this.location = location;
        this.found = found;
        this.lat = lat;
        this.lon = lon;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getDescription() {
        return description;
    }

    public void setDescription(@NonNull String description) {
        this.description = description;
    }

    @NonNull
    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(@NonNull String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @NonNull
    public String getDate() {
        return date;
    }

    public void setDate(@NonNull String date) {
        this.date = date;
    }

    @NonNull
    public String getLocation() {
        return location;
    }

    public void setLocation(@NonNull String location) {
        this.location = location;
    }

    @NonNull
    public Boolean getFound() {
        return found;
    }

    public void setFound(@NonNull Boolean found) {
        this.found = found;
    }
}
