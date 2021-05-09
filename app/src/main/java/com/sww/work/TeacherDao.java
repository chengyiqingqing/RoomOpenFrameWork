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
public interface TeacherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Teacher... teachers);

    @Delete
    void delete(Teacher teacher);

    @Update
    void update(Teacher teacher);

    @Query("select * from Teacher")
    List<Teacher> getAll();

}
