package com.sww.work;

import androidx.annotation.NonNull;
import androidx.room.Entity;

/**
 * @description:
 * @author: shaowenwen
 * @create: 2021/05/07 11:37
 */
@Entity(primaryKeys = {"uid","name"})
public class Teacher {

    public int uid = 0;
    @NonNull
    public String name = "xx";
    public int age;
    public int level;
    public FamilyMember familyMember;

    public Teacher(int uid, @NonNull String name, int age, int level, FamilyMember familyMember) {
        this.uid = uid;
        this.name = name;
        this.age = age;
        this.level = level;
        this.familyMember = familyMember;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", level=" + level +
                ", familyMember=" + familyMember +
                '}';
    }
}
