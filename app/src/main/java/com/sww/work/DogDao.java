package com.sww.work;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * @description:
 * @author: shaowenwen
 * @create: 2021/05/07 11:44
 */
@Dao
public interface DogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Dog... dogs);

    @Delete
    void delete(Dog dog);

    @Update
    void update(Dog dog);

    @Query("select * from Dog")
    List<Dog> getAll();

}
