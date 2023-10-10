package com.example.primerparcial.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.primerparcial.Entitys.Producto;

import java.util.List;

@Dao
public interface ProductDAO {
    @Insert
    void insertProduct(Producto producto);

    @Update
    void updateProduct(Producto producto);

    @Delete
    void deleteProduct(Producto producto);

}
