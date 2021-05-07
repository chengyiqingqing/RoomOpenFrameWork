package com.sww.work;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

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
                ).build();

                StudentDao dao = HongxDB.userDao();
                dao.insert(new Student("stu1", "11", 1));
                dao.insert(new Student("stu2", "22", 2));
                dao.insert(new Student("stu3", "33", 3));
                dao.insert(new Student("stu4", "44", 4));
                List<Student> list = dao.getAll();
                Log.e(TAG, "run: " + list.toString());
            }
        }.start();
    }

}