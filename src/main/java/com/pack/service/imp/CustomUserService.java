package com.pack.service.imp;

import com.pack.dao.UserDao;
import com.pack.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userDao.selectUser(s);
        if (user == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        System.out.printf("s"+s);
        System.out.printf("userName:"+user.getName()+";password:"+user.getPassword());

        return user;
    }
}
