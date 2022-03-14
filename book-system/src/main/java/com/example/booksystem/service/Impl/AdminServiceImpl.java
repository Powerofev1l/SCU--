package com.example.booksystem.service.Impl;

import com.example.booksystem.entity.Admin;
import com.example.booksystem.mapper.AdminMapper;
import com.example.booksystem.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    //根据管理员姓名和密码查询完整管理员信息
    public Admin checkAdmin(String name, String password) {
        Admin admin = adminMapper.checkAdmin(new Admin(name, password));
        return admin;
    }

    //根据完整管理员信息编辑管理员密码，返回更改成功与否
    public boolean editAdminPassword(Admin admin, String password) {
        admin.setaPassword(password);
        int jud = adminMapper.editPasswordByAdmin(admin);
        return jud != 0;
    }
}
