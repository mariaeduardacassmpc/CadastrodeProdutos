package com.example.mariaeduardacarnauba;

import androidx.room.RoomDatabase;
import androidx.room.Room;
import android.content.Context;
import androidx.room.Database;


@Database(entities = {Product.class}, version = 1)
public abstract class ProductDatabase extends RoomDatabase {
    public abstract ProductDao productDao();
    private static ProductDatabase instance;

    public static synchronized ProductDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                            context.getApplicationContext(), ProductDatabase.class, "product-database")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
}
