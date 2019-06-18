package com.narcos.frameworklearn;

import com.narcos.frameworklearn.transaction.TransactionTestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/06/18 15:22
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TransactionTest {
    @Autowired
    TransactionTestService transactionTestService;

    @Test
    public void test1() {
        transactionTestService.hadException();
    }

    @Test
    public void test2() {
        transactionTestService.kidOneTransaction();
    }

    @Test
    public void test3() {
        transactionTestService.kidAllTransaction();
    }

    @Test
    public void test4() {
        transactionTestService.kidOneTransactionFatherTransaction();
    }

    @Test
    public void test5() {
        transactionTestService.kidAllTransactionFatherTransaction();
    }
}
