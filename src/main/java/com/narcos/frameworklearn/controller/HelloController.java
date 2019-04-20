package com.narcos.frameworklearn.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/04/20 13:49
 **/
@RestController
public class HelloController {
    @GetMapping("sayHello")
    public String sayHello() {
        String str = "Hello world";
        System.out.println(str);
        return str;
    }
}
