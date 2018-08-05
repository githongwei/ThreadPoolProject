package com.pack.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * 启动dubbo服务
 * @author 娃哈哈
 */
public class StartDubbo {

    /**
     * 仅限在本地测试启动
     * @param args
     */
    public static void main(String[] args){

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"dubbo/dubbo-start.xml"});

        System.out.println("服务启动中。。。。！");

        context.start();

        try {
            System.in.read();
        } catch (IOException e){
            System.out.println("服务连接异常。。。");
        }

    }
}
