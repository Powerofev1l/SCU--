package com.example.booksystem.service;

import com.example.booksystem.entity.User;
import com.example.booksystem.vo.DataVO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    //编辑用户密码
    boolean editPasswordByUser(User user, String password);

    //根据用户名和密码判断用户
    User checkUser(String name, String password);

    List<User> selectUsers(User user);

    DataVO<User> selectUsersPage(Integer uId, String uName, String uGender, String uDepartment, Integer uGrade, Integer page, Integer limit);

    int editUser(User user);

    int saveUser(User user);

    int deleteUser(int id);
}
