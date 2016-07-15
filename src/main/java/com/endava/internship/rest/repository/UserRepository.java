package com.endava.internship.rest.repository;

import com.endava.internship.rest.model.RankUser;
import com.endava.internship.rest.model.User;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fvasile on 7/15/2016.
 */
@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();

    public List<User> list(){
        return this.users;
    }
    public void saveUser(User user){
        users.add(user);
    }
    public User getUser(Integer id){
        for (User user : list()){
            if(id==user.getId()) return user;
        }
        return null;
    }

}
