package com.example.booksystem.service;

import com.example.booksystem.entity.Admin;
import org.springframework.stereotype.Service;


public interface AdminService {
    public Admin checkAdmin(String name, String password);

    public boolean editAdminPassword(Admin admin, String password);
}
