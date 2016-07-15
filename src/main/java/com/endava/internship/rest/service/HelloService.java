package com.endava.internship.rest.service;

import com.endava.internship.rest.model.HelloMessage;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public HelloMessage getHelloMessage() {
        HelloMessage helloMessage = new HelloMessage();
        helloMessage.setMessage("HELLO");
        return helloMessage;
    }
}
