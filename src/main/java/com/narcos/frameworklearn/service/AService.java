package com.narcos.frameworklearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huangbangjing
 * @date 2023/6/14 10:49
 */
@Service
public class AService {
    @Autowired
    private BService bService;

    public void sayHello1() {
        bService.sayHello1();
    }

    public void sayHello2() {
        System.out.println("hello");
    }
}
