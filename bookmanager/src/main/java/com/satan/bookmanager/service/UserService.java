package com.satan.bookmanager.service;

import com.satan.bookmanager.dao.UserDao;
import com.satan.bookmanager.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2021-08-10 12:39:49
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public int addUser(User user) {
        return userDao.addUser(user);
    }

    public User getUser(String email){
        return userDao.selectByEmail(email);
    }

    public User getUser(int uid){
        return userDao.selectById(uid);
    }


}