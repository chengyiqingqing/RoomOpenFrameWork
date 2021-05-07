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
    @ColumnInfo(name = "pwd")
    private String password;
    @ColumnInfo(name = "addressId")
    private int addressId;

    public Student(String name, String password, int id) {
        this.name = name;
        this.password = password;
        this.uid = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
                ", password='" + password + '\'' +
                ", addressId=" + addressId +
                '}';
    }
}

