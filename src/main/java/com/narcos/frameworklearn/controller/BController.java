package com.narcos.frameworklearn.controller;

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
@RequestMapping(value = "/b")
public class BController {
    @Autowired
    private BService bService;

    @GetMapping("/test2")
    public void sayHello() {
        bService.sayHello1();
    }
}
