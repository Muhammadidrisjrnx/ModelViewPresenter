package com.example.rplrus24.modelviewpresenter;

public class user {
    private String name = "", email = "";

    public user() {
    }

    public user(String Name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Email : " + email + "\n Name : " + name;
    }
}

