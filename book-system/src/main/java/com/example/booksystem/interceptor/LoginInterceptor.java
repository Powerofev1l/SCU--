package com.example.booksystem.interceptor;

import com.example.booksystem.entity.Admin;
import com.example.booksystem.entity.User;
import com.example.booksystem.util.Const;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        Admin admin = (Admin)request.getSession().getAttribute(Const.ADMIN);
        User user = (User) request.getSession().getAttribute(Const.USER);
        if (user != null || admin != null) {
            return true;
        }
        response.sendRedirect("/system/login");
        return false;
    }
}
