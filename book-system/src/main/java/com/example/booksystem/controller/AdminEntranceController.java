package com.example.booksystem.controller;

import com.example.booksystem.entity.Book;
import com.example.booksystem.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminEntranceController {

    @GetMapping("/main")
    public String getMain() {
        return "admin/main1";
    }

    @GetMapping("/books")
    public String getBooks() {
        return "admin/books";
    }

    @GetMapping("/users")
    public String getUsers() {
        return "admin/users";
    }

    @GetMapping("/outusers")
    public String getOut() {
        return "admin/outUsers";
    }

    @GetMapping("/editBookPage")
    public String getEditPage(Model model, Integer bId, String bName, String bAuthor, String bPublisher, String bDigest) {
        Book book = new Book(bId, bName, bAuthor, bPublisher, bDigest);
        model.addAttribute("book", book);
        return "admin/editBook";
    }

    @GetMapping("/addBookPage")
    public String getAddPage() {
        return "admin/addBook";
    }

    @GetMapping("/addUserPage")
    public String addUserPage() {
        return "admin/addUser";
    }

    @GetMapping("/editUserPage")
    public String editUserPage(Model model, Integer uId, String uName, String uGender, String uDepartment, Integer uGrade) {
        User user = new User(uName, null, uGender, uDepartment, uGrade);
        user.setuId(uId);
        model.addAttribute("user", user);
        return "admin/editUser";
    }

    @GetMapping("/getOutUsers")
    public String getOutUser() {
        return "admin/outUsers";
    }
}
