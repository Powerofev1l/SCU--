package com.example.booksystem.service.Impl;

import com.example.booksystem.entity.User;
import com.example.booksystem.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserService userService;

    @Test
    void test1() {
        User user = userService.checkUser("jing", "111111");
        System.out.println(user);
    }

}