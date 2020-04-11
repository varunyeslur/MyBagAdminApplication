package com.example.mybagadminapplication.Model;

public class Admin
{

    private String admin, password;

    public Admin()
    {

    }

    public Admin(String admin, String password) {
        this.admin = admin;
        this.password = password;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
