package com.example.dictsystem.interceptor;

import com.example.dictsystem.entity.Admin;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String type = (String) request.getSession().getAttribute("TYPE");
        if (type != null && type.equals("admin")) {
            return true;
        }
        response.sendRedirect("/");
        return false;
    }
}
