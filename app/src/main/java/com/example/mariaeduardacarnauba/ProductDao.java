package com.example.mariaeduardacarnauba;

import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Dao;
import java.util.List;

@Dao
public interface ProductDao {
    @Insert
    void insert(Product product);
    @Query("SELECT * FROM product")
    List<Product> getAllProducts();
}