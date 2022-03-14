package com.example.booksystem.config;

import com.example.booksystem.interceptor.LoginInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class SpringMVCConfig implements WebMvcConfigurer {

    //添加默认视图为登录界面
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
    }

    //添加拦截器拦截权限,放行部分初始登录界面与静态资源
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").
                excludePathPatterns("/","/system/login","/api/**","/css/**","/js/**","/images/**","/lib/**");
    }
}
