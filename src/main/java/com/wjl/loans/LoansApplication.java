package com.wjl.loans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoansApplication {

    public static void main(String[] args) {
        System.out.println("应用启动中。。。");
        SpringApplication.run(LoansApplication.class, args);
        System.out.println("应用已成功启动！");
    }

}
