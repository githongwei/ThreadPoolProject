package com.pack.service.imp;

import com.pack.dao.UserDao;
import com.pack.po.User;
import com.pack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpI implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findUser(String name) {
        if (null != name){
            User user = userDao.selectUser(name);
            return user;
        }
        return null;
    }

    @Override
    public List<User> userAll() {
        return userDao.findAll();
    }
}
