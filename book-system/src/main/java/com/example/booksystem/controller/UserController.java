package com.example.booksystem.controller;

import com.example.booksystem.entity.Borrow;
import com.example.booksystem.entity.User;
import com.example.booksystem.service.BorrowService;
import com.example.booksystem.service.UserService;
import com.example.booksystem.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private BorrowService borrowService;

    @RequestMapping("/selectUsers")
    public DataVO getUsers(Integer uId, String uName, String uGender, String uDepartment, Integer uGrade) {
        User user = new User(uId, uName, uGender, uDepartment, uGrade);
        List<User> users = userService.selectUsers(user);
        DataVO dataVO = new DataVO(0, "", users.size(), users);
        return dataVO;
    }

    @RequestMapping("/selectUsersPage")
    public DataVO getUsersPage(Integer uId, String uName, String uGender, String uDepartment, Integer uGrade, Integer page, Integer limit) {
        DataVO<User> dataVO = userService.selectUsersPage(uId, uName, uGender, uDepartment, uGrade, page, limit);
        return dataVO;
    }



    @PostMapping("/addUser")
    public Boolean addUser(String uName, String uPassword, String uGender, String uDepartment, Integer uGrade) {
        User user = new User(uName, uPassword, uGender, uDepartment, uGrade);
        return userService.saveUser(user) != 0;
    }

    @PostMapping("/editUser")
    public Boolean editUser(Integer uId, String uName, String uGender, String uDepartment, Integer uGrade) {
        User user = new User();
        user.setuId(uId);
        user.setuName(uName);
        user.setuGender(uGender);
        user.setuDepartment(uDepartment);
        user.setuGrade(uGrade);
        return userService.editUser(user) != 0;
    }


    //根据用户有无已选书籍判断能否删除
    @RequestMapping("/deleteUser")
    public Boolean deleteUser(int uId) {
        Borrow borrow = new Borrow();
        borrow.setUserId(uId);
        if (borrowService.getUserAllBorrow(borrow).size() != 0) {
            return false;
        }
        return userService.deleteUser(uId) != 0;
    }
}
