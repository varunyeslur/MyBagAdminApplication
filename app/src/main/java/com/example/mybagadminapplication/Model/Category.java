package com.example.mybagadminapplication.Model;

public class Category {

    String name;
    int dp;

    public Category(String name, int dp) {
        this.name = name;
        this.dp = dp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDp() {
        return dp;
    }

    public void setDp(int dp) {
        this.dp = dp;
    }
}
