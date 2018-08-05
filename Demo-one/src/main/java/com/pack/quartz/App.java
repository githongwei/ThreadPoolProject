package com.pack.quartz;

import com.pack.service.UserService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 任务调度
 */
@Component
public class App {

    @Resource
    private UserService userService;

    public void upDateTodayReward(){

        System.out.println("执行---------------");

    }

}
