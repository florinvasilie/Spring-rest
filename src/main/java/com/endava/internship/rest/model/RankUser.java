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

    public RankUser(List<User> users, Integer idRank, String rank) {
        this.users = users;
        this.idRank = idRank;
        this.rank = rank;
    }

}
