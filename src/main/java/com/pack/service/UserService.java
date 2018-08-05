package com.pack.service;

import com.pack.po.User;

import java.util.List;

public interface UserService {

    User findUser(String name);

    List<User> userAll();

}
