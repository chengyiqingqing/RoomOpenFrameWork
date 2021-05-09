package com.sww.work;

import androidx.annotation.NonNull;
import androidx.room.Entity;

/**
 * @description:
 * @author: shaowenwen
 * @create: 2021/05/07 16:17
 */
@Entity(primaryKeys = {"uid", "name"})
public class Dog {

    @NonNull
    public int uid = 0;
    @NonNull
    public String name = "xx";
    public int age;
    public boolean sex;

    public Dog(int uid, @NonNull String name, int age, boolean sex) {
        this.uid = uid;
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
