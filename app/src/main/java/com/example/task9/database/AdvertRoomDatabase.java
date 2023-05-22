package com.example.task9.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Advert.class},version = 1,exportSchema = false)
public abstract class AdvertRoomDatabase extends RoomDatabase {

    public abstract advertDAO advertDAO();

    private  static volatile AdvertRoomDatabase INSTANCE;

    static final int num_threads = 4;

    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(num_threads);

    public static AdvertRoomDatabase getDatabase(final Context context)
    {
        if(INSTANCE == null){
            synchronized (AdvertRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    AdvertRoomDatabase.class, "advert_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static Callback sRoomDatabaseCallback = new Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(()->{
                advertDAO dao = INSTANCE.advertDAO();
                dao.deleteAll();
            });
        }
    };
}
