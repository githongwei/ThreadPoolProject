package com.pack.test;

import org.quartz.Scheduler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/spring-quartz.xml");
        Scheduler scheduler = (Scheduler) context.getBean("scheduler");

        try {
            scheduler.start();
        }catch (Exception e){

        }
    }

}
