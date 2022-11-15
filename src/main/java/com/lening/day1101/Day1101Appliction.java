package com.lening.day1101;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.lening.day1101.mapper")
public class Day1101Appliction {
    public static void main(String[] args) {
        SpringApplication.run(Day1101Appliction.class, args);
    }
}
