package com.endava.internship.rest.model;

/**
 * Created by fvasile on 7/15/2016.
 */
public class User {
    private Integer id;

    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
    }
}
