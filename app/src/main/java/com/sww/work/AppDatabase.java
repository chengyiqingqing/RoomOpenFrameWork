package com.sww.work;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

/**
 * 定义数据库
 */
@Database(entities = {Student.class, Teacher.class, Dog.class}, version = 8)
@TypeConverters(FamilyMemberStringConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    public abstract StudentDao userDao();

    public abstract TeacherDao getTeacherDao();

    public abstract DogDao getDogDao();

}