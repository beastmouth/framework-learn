package com.narcos.frameworklearn.transaction.impl;

import com.narcos.frameworklearn.transaction.TransactionTestOneService;
import com.narcos.frameworklearn.transaction.TransactionTestService;
import com.narcos.frameworklearn.transaction.TransactionTestTwoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/06/18 14:55
 **/
@Service
public class TransactionTestServiceImpl implements TransactionTestService {
    private final TransactionTestOneService transactionTestOneService;
    private final TransactionTestTwoService transactionTestTwoService;

    public TransactionTestServiceImpl(TransactionTestOneService transactionTestOneService, TransactionTestTwoService transactionTestTwoService) {
        this.transactionTestOneService = transactionTestOneService;
        this.transactionTestTwoService = transactionTestTwoService;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void hadException() {
        // 外部有事务
        // 第一个（没事务）不抛异常 第二个（没事务）抛异常
        // 第一个第二个都回滚
        // 传播行为为默认的 PROPAGATION_REQUIRED 如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
        boolean save = transactionTestOneService.save();
        System.out.println("TransactionTestOneService save result : " + save);
        boolean saveHadException = transactionTestTwoService.saveHadException();
        System.out.println("TransactionTestTwoService save result : " + saveHadException);
    }

    @Override
    public void kidOneTransaction() {
        // 外部无事务
        // 第一个（有事务）不抛异常 第二个（没事务）抛异常
        // 第一个第二个都正常保存
        // 传播行为为默认的 PROPAGATION_REQUIRED 如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
        boolean save = transactionTestOneService.saveTransaction();
        System.out.println("TransactionTestOneService save result : " + save);
        boolean saveHadException = transactionTestTwoService.saveHadException();
        System.out.println("TransactionTestTwoService save result : " + saveHadException);
    }

    @Override
    public void kidAllTransaction() {
        // 外部无事务
        // 第一个（有事务）不抛异常 第二个（有事务）抛异常
        // 第一个正常保存第二个回滚
        // 传播行为为默认的 PROPAGATION_REQUIRED 如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
        boolean save = transactionTestOneService.saveTransaction();
        System.out.println("TransactionTestOneService save result : " + save);
        boolean saveHadException = transactionTestTwoService.saveHadExceptionTransaction();
        System.out.println("TransactionTestTwoService save result : " + saveHadException);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void kidOneTransactionFatherTransaction() {
        // 外部有事务
        // 第一个（有事务）不抛异常 第二个（没事务）抛异常
        // 第一个第二个都回滚
        // 传播行为为默认的 PROPAGATION_REQUIRED 如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
        boolean save = transactionTestOneService.saveTransaction();
        System.out.println("TransactionTestOneService save result : " + save);
        boolean saveHadException = transactionTestTwoService.saveHadException();
        System.out.println("TransactionTestTwoService save result : " + saveHadException);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void kidAllTransactionFatherTransaction() {
        // 外部有事务
        // 第一个（有事务）不抛异常 第二个（有事务）抛异常
        // 第一个第二个都回滚
        // 传播行为为默认的 PROPAGATION_REQUIRED 如果当前没有事务，就新建一个事务，如果已经存在一个事务中，加入到这个事务中。这是最常见的选择。
        boolean save = transactionTestOneService.saveTransaction();
        System.out.println("TransactionTestOneService save result : " + save);
        boolean saveHadException = transactionTestTwoService.saveHadExceptionTransaction();
        System.out.println("TransactionTestTwoService save result : " + saveHadException);
    }
}
