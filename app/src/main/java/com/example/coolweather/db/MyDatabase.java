package com.example.coolweather.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {City.class,County.class,Province.class},version = 1,exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {
    private static MyDatabase instance;
    static synchronized MyDatabase getDataBase(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),MyDatabase.class,"coolweather_database")
                    .build();
        }
        return instance;
    }

    public abstract CityDao getCityDao();
    public abstract CountyDao getCountyDao();
    public abstract ProvinceDao getProvinceDao();
}
