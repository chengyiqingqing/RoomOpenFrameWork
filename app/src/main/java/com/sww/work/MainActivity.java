package com.sww.work;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread() {
            @Override
            public void run() {
                super.run();
                AppDatabase HongxDB = Room.databaseBuilder(
                        getApplicationContext(),
                        AppDatabase.class,
                        "HongxDB"
                )
//                        .addMigrations(MIGRATION_2_4, MIGRATION_4_5, MIGRATION_5_6, MIGRATION_6_7)
                        .addMigrations(MIGRATION_2_4, MIGRATION_4_5, MIGRATION_5_6, MIGRATION_6_7)
                        .fallbackToDestructiveMigration()
                        .build();

                // 1.......
               /* StudentDao dao = HongxDB.userDao();
                dao.insert(new Student(1, "stu1", 1));
                dao.insert(new Student(2, "stu1", 1));
                dao.insert(new Student(2, "stu2", 2));
                dao.insert(new Student(3, "stu3", 3));
                dao.insert(new Student(4, "stu4", 4));*/
                // 1......

                // 2......
                /*TeacherDao dao = HongxDB.getTeacherDao();
                dao.insert(new Teacher(2, "stu1", 11, 1,new FamilyMember("小红1","小明1")));
                dao.update(new Teacher(2, "stu2", 2222222, 1,new FamilyMember("小红2","小明2")));
                dao.insert(new Teacher(2, "stu3", 22, 1,new FamilyMember("小红3","小明3")));
                dao.insert(new Teacher(3, "stu3", 3, 1,new FamilyMember("小红4","小明4")));
                dao.insert(new Teacher(4, "stu4", 4, 1,new FamilyMember("小红15","小明5")));

                List<Teacher> list = dao.getAll();
                Log.e(TAG, "run: " + list.size());
                Log.e(TAG, "run: " + list.toString());*/
                // 2......

                // 3......
                DogDao dao3 = HongxDB.getDogDao();
                dao3.insert(new Dog(2, "stu1", 11,true));
                dao3.insert(new Dog(2, "stu2", 22,false));
                dao3.insert(new Dog(3, "stu3", 3,true));
                dao3.insert(new Dog(4, "stu4", 4, false));
                List<Dog> list3 = dao3.getAll();
                Log.e(TAG, "run: " + list3.size());
                Log.e(TAG, "run: " + list3.toString());
                // 3......


            }
        }.start();
    }

    /**
     * 1.添加表的迁移：
     */
    static final Migration MIGRATION_2_4 = new Migration(2, 4) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `Teacher` (" +
                    "`uid` INTEGER NOT NULL," +
                    "`name` TEXT," +
                    " PRIMARY KEY(`uid`))");
        }
    };

    /**
     * 2.修改表的迁移：
     */
    static final Migration MIGRATION_4_5 = new Migration(4, 5) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE Teacher "
                    + " ADD COLUMN age INTEGER NOT NULL DEFAULT 0"); // Integet要非空且要有默认的值
        }
    };

    static final Migration MIGRATION_5_6 = new Migration(5, 6) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `Dog` (" +
                    "`uid` INTEGER NOT NULL," +
                    "`name` TEXT  NOT NULL," +
                    "`age` INTEGER  NOT NULL," +
                    " PRIMARY KEY(`uid`,`name`))");
        }
    };

    static final Migration MIGRATION_6_7 = new Migration(6, 7) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE Teacher "
                    + " ADD COLUMN familyMember TEXT");
        }
    };

}