package com.narcos.frameworklearn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author huangbangjing
 * @date 2023/6/14 10:49
 */
@Service
public class BService {
    @Autowired
    private AService aService;

    public void sayHello1() {
        aService.sayHello2();
    }

    public void sayHello2() {
        aService.sayHello1();
    }
}
