package com.example.dictsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/home")
    public String getHome() {
        return "index";
    }

    @GetMapping("/searchPage")
    public String searchPage() {
        return "page/search-visitor";
    }

    @GetMapping("/detail")
    public String detail(Model model, int ID) {
        model.addAttribute("ID", ID);
        return "page/table/detail";
    }

    @GetMapping("/userInfo")
    public String infoPage() {
        return "page/notice-visitor";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "page/login-3";
    }
}
