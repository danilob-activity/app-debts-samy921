package com.example.danilo.appdebts.Classes;

/**
 * Created by aluno on 27/06/19.
 */

public class Category {
    private long mId;
    public String mType;

    public Category() {
    }

    public Category(String type) {
        mType = type;
    }

    public long getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }
}