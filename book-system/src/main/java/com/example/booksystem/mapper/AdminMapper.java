package com.example.booksystem.mapper;

import com.example.booksystem.entity.Admin;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMapper {
    //编辑管理员密码
    int editPasswordByAdmin(Admin admin);

    //根据用户名和密码判断用户
    Admin checkAdmin(Admin admin);
}
