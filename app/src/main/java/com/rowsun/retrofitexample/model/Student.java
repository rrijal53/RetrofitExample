package com.rowsun.retrofitexample.model;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by roshanrijal on 2/15/18.
 */

public class Student
{
    private String id;

    private String address;

    private String name;

    public Student(String id, String address, String name) {
        this.id = id;
        this.address = address;
        this.name = name;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getAddress ()
    {
        return address;
    }

    public void setAddress (String address)
    {
        this.address = address;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}

