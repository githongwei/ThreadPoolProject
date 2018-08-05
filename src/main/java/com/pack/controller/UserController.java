package com.pack.controller;

import com.pack.po.User;
import com.pack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add/{name}",method = RequestMethod.GET)
    @ResponseBody
    public User addUser(@PathVariable String name){
        User user = userService.findUser(name);
        return user;
    }

    @RequestMapping("/list")
    @ResponseBody
    public List<User> userList(){
        return userService.userAll();
    }

}
