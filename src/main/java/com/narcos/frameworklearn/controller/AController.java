package com.narcos.frameworklearn.controller;

import com.narcos.frameworklearn.service.AService;
import com.narcos.frameworklearn.service.BService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangbangjing
 * @date 2023/6/14 10:50
 */
@RestController
@RequestMapping("/a")
public class AController {
    @Autowired
    private AService aService;
    @Autowired
    private BService bService;

    @GetMapping("/test1")
    public void sayHello() {
        aService.sayHello1();
        bService.sayHello2();
    }
}
