package com.sww.work;

import androidx.room.Database;
import androidx.room.RoomDatabase;

/**
 * 定义数据库
 */
@Database(entities = {Student.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {

    public abstract StudentDao userDao();

}