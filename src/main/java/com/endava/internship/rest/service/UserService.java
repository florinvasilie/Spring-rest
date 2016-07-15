package com.endava.internship.rest.service;

import com.endava.internship.rest.model.User;
import com.endava.internship.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fvasile on 7/15/2016.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.list();
    }

    public User getUser(Integer id){
        return this.userRepository.getUser(id);
    }
    public void saveUser(User user){
        userRepository.saveUser(user);
    }
}
