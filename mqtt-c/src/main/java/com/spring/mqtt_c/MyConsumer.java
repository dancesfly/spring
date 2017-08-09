package com.spring.mqtt_c;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MyConsumer {
    
    public void consumerForBusiness(String message) {
        System.out.println("开始处理：" + message);
        
        int random = new Random().nextInt(2); // 这里只测试0、1两种情况。TODO 2即抛出异常的情况需另外处理
        if (random == 0) {
        	System.out.println("模拟业务正常完成");
            
        } else if (random == 1) {
        	System.out.println("模拟处理业务需时一段时间");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        } else if (random == 2) {
        	System.out.println("模拟抛出异常");
            throw new RuntimeException("模拟抛出异常");
            
        }
        
        System.out.println("完成处理：");
    }
}