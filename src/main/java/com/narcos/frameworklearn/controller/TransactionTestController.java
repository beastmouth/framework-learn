package com.narcos.frameworklearn.controller;

import com.narcos.frameworklearn.transaction.AsyncService;
import com.narcos.frameworklearn.transaction.TransactionTestService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/06/18 15:19
 **/
@RestController("/transaction")
@AllArgsConstructor
public class TransactionTestController {
    private final TransactionTestService transactionTestService;
    private final AsyncService asyncService;

    @GetMapping("/exception")
    public String sayHello() {
        transactionTestService.hadException();
        return "exception";
    }

    @GetMapping("/async")
    public String testAsyncTransaction() {
        return transactionTestService.asyncTransaction();
    }
}
