package com.endava.internship.rest.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fvasile on 7/15/2016.
 */
public class RankUser {

    private List<User> users=new ArrayList<>();
    private Integer idRank;
    private String rank;
    private Integer id;

    public RankUser(List<User> users, Integer idRank, String rank) {
        this.users = users;
        this.idRank = idRank;
        this.rank = rank;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getIdRank() {
        return idRank;
    }

    public void setIdRank(Integer idRank) {
        this.idRank = idRank;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }




}
