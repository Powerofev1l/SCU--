package com.example.booksystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserEntranceController {

    @GetMapping("/main")
    public String getMain() {
        return "user/main2";
    }

    @GetMapping("/getBooks")
    public String getBooks() {
        return "user/books";
    }

    @GetMapping("/getBorrows")
    public String getBorrows() {
        return "user/borrows";
    }
}
