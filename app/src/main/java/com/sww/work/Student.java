package com.sww.work;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * 这就相当于表的结构信息
 */
@Entity
public class Student {

    //设置主键，自增长
    @PrimaryKey
    private int uid;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "addressId")
    private int addressId;

    public Student(int uid, String name, int addressId) {
        this.uid = uid;
        this.name = name;
        this.addressId = addressId;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", addressId=" + addressId +
                '}';
    }
}

