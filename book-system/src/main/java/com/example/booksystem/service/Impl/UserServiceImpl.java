package com.example.booksystem.service.Impl;

import com.example.booksystem.entity.Book;
import com.example.booksystem.entity.User;
import com.example.booksystem.mapper.UserMapper;
import com.example.booksystem.service.UserService;
import com.example.booksystem.vo.DataVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean editPasswordByUser(User user, String password) {
        user.setuPassword(password);
        int jud = userMapper.editPasswordByUser(user);
        return jud != 0;
    }

    @Override
    public User checkUser(String name, String password) {
        User user = userMapper.checkUser(new User(name, password));
        return user;
    }

    @Override
    public List<User> selectUsers(User user) {
        return userMapper.selectUsers(user);
    }

    @Override
    public DataVO<User> selectUsersPage(Integer uId, String uName, String uGender, String uDepartment, Integer uGrade, Integer page, Integer limit) {
        int start = (page-1) * limit;

        Map<String, Object> map = new HashMap<>();
        map.put("uId", uId);
        map.put("uName", uName);
        map.put("uGender", uGender);
        map.put("uDepartment", uDepartment);
        map.put("uGrade", uGrade);
        map.put("start", start);
        map.put("limit", limit);

        User user = new User();
        user.setuId(uId);
        user.setuName(uName);
        user.setuGender(uGender);
        user.setuDepartment(uDepartment);
        user.setuGrade(uGrade);

        int count = userMapper.selectCount(user);
        List<User> users = userMapper.selectUsersByMaps(map);

        DataVO<User> dataVO = new DataVO<>(0, "", count, users);
        return dataVO;
    }

    @Override
    public int editUser(User user) {
        return userMapper.editUser(user);
    }

    @Override
    public int saveUser(User user) {
        return userMapper.saveUser(user);
    }

    //根据当前用户有无借书情况判断是否能够删除
    @Override
    public int deleteUser(int id) {
        return userMapper.deleteUser(id);
    }
}
