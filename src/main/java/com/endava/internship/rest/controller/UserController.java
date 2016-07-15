package com.endava.internship.rest.controller;

import com.endava.internship.rest.model.User;
import com.endava.internship.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * Created by fvasile on 7/15/2016.
 */

@RestController
@RequestMapping(path = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<Resources<Resource<User>>> getUsers(){

        List<User> users=userService.getUsers();

//        for(User user:users){
//            System.out.println(user.getId()+user.getUsername());
//        }

        Resources<Resource<User>> userResources = Resources.wrap(users);

        userResources.add(linkTo(methodOn(UserController.class).getUsers()).withRel("custom-self"));

        for(Resource<User> userRes: userResources){
            userRes.add(linkTo(methodOn(UserController.class).getUser(userRes.getContent().getId())).withRel("custom-self"));
        }

        return new ResponseEntity<>(userResources, HttpStatus.OK);
    }
    @RequestMapping(path = "/{userId}", method = RequestMethod.GET)
    public HttpEntity<Resource<User>> getUser(@PathVariable Integer userId) {
        User user=userService.getUser(userId);

        Resource<User> userResource = new Resource<>(user);
        userResource.add(linkTo(methodOn(UserController.class).getUser(userId)).withRel("another-self"));

        return new ResponseEntity<>(userResource, HttpStatus.OK);
    }


}
