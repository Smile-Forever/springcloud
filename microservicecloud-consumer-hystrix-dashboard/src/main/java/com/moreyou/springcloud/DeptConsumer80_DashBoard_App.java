package com.moreyou.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class DeptConsumer80_DashBoard_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer80_DashBoard_App.class,args);
    }
}
