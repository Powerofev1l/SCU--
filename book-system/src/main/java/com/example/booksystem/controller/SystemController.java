package com.example.booksystem.controller;


import com.example.booksystem.entity.Admin;
import com.example.booksystem.entity.User;
import com.example.booksystem.service.AdminService;
import com.example.booksystem.service.UserService;
import com.example.booksystem.util.Const;
import com.example.booksystem.vo.LoginVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }


    /**
     * 判断用户名、密码、验证码以及用户类型匹配情况而登录；
     * 验证验证码时已传递向session域传递验证码信息，此处取出检验并通过session判断登录是否超时；
     * 根据session判断登录是否超时 - 默认20min
     * @param username 输入的用户名
     * @param password 输入的密码
     * @param type 登录用户类型
     * @param session session域数据
     * @return LoginVO
     */
    @PostMapping("/login")
    @ResponseBody
    public LoginVO judgeLogin(String username, String password, String type, HttpSession session) {
        LoginVO loginVO = new LoginVO();

        if (type.equals("1")) {
            User user = userService.checkUser(username, password);
            if (user != null) {
                session.setAttribute(Const.USER, user);
                session.setAttribute(Const.USERTYPE, type);
                loginVO.setSuccess(true);
                return loginVO;
            }
        } else {
            Admin admin = adminService.checkAdmin(username, password);
            if (admin != null) {
                session.setAttribute(Const.ADMIN, admin);
                session.setAttribute(Const.USERTYPE, type);
                loginVO.setSuccess(true);
                return loginVO;
            }
        }
        loginVO.setSuccess(false);
        loginVO.setMessage("用户名或密码错误，请重试");
        return loginVO;
    }

    @GetMapping("/editPassword")
    public String editPassword() {
        return "password";
    }

    @ResponseBody
    @PostMapping("/editPassword")
    public Boolean editPassword(HttpSession session, String old_password, String new_password) {
        String type = (String) session.getAttribute(Const.USERTYPE);
        if (type.equals("1")) {
            User user = (User) session.getAttribute(Const.USER);
            if (!user.getuPassword().equals(old_password)) {
                return false;
            }
            userService.editPasswordByUser(user, new_password);
            session.removeAttribute(Const.USER);
        } else {
            Admin admin = (Admin) session.getAttribute(Const.ADMIN);
            if (!admin.getaPassword().equals(old_password)) {
                return false;
            }
            adminService.editAdminPassword(admin, new_password);
            session.removeAttribute(Const.ADMIN);
        }
        //修改成功后重新登陆
        session.removeAttribute(Const.USERTYPE);
        return true;
    }

    @GetMapping("/exit")
    public String exit(HttpSession session) {
        String type = (String) session.getAttribute(Const.USERTYPE);
        if (type.equals("1")) {
            session.removeAttribute(Const.USER);
        } else {
            session.removeAttribute(Const.ADMIN);
        }
        session.removeAttribute(Const.USERTYPE);
        return "login";
    }
}
