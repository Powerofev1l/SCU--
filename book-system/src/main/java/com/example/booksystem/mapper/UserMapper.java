package com.example.booksystem.mapper;

import com.example.booksystem.entity.Admin;
import com.example.booksystem.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {

    //编辑用户密码
    int editPasswordByUser(User user);

    //根据用户名和密码判断用户
    User checkUser(User user);

    //查看查询数量 - 根据分页
    int selectCount(User user);

    //查询用户根据user
    List<User> selectUsers(User user);

    //根据map查询user
    List<User> selectUsersByMaps(Map map);

    //添加用户根据user
    int saveUser(User user);

    //编辑用户根据user
    int editUser(User user);

    //删除用户根据user
    int deleteUser(int id);
}
