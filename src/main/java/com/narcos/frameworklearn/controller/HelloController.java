package com.narcos.frameworklearn.controller;

import com.narcos.frameworklearn.entity.po.TransactionTestOne;
import com.narcos.frameworklearn.transaction.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/04/20 13:49
 **/
@RestController
@RequestMapping(value = "/hello")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HelloController {
    private final HelloService helloService;

    @GetMapping("sayHello")
    public String sayHello() {
        String str = "Hello world";
        System.out.println(str);
        return str;
    }

    @GetMapping(value = "/test")
    public String test() {
        TransactionTestOne transactionTestOne = helloService.saveOne();
        helloService.findOne(transactionTestOne.getId());
        return "我好了";
    }
}
