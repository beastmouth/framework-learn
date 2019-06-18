package com.narcos.frameworklearn.controller;

import com.narcos.frameworklearn.transaction.TransactionTestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/06/18 15:19
 **/
@RestController("/transaction")
public class TransactionTestController {
    private final TransactionTestService transactionTestService;

    public TransactionTestController(TransactionTestService transactionTestService) {
        this.transactionTestService = transactionTestService;
    }

    @GetMapping("/exception")
    public String sayHello() {
        transactionTestService.hadException();
        return "exception";
    }
}
