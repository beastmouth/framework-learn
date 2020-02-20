package com.narcos.frameworklearn.controller;

import com.narcos.frameworklearn.initializer.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hbj
 * @date 2020/2/19 22:43
 */
@RestController
@RequestMapping(value = "/test")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestController {
    private final TestService testService;

    @GetMapping("/init")
    public String sayHello() {
        String test1 = testService.test();
        String test2 = testService.test2();
        String test3 = testService.test3();
        System.out.println(test1);
        System.out.println(test2);
        System.out.println(test3);
        return test1;
    }
}
