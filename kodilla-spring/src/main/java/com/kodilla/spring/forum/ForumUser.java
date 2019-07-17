package com.kodilla.spring.forum;

import org.springframework.stereotype.Component;

@Component
public class ForumUser implements Forum {
    @Override
    public String getUserName() {
        return "John Smith";
    }
}
