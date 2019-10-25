package com.narcos.frameworklearn.transaction.impl;

import com.narcos.frameworklearn.dao.repository.TransactionTestOneRepository;
import com.narcos.frameworklearn.dao.repository.TransactionTestTwoRepository;
import com.narcos.frameworklearn.entity.po.TransactionTestOne;
import com.narcos.frameworklearn.entity.po.TransactionTestTwo;
import com.narcos.frameworklearn.transaction.AsyncService;
import com.narcos.frameworklearn.transaction.TransactionTestOneService;
import com.narcos.frameworklearn.transaction.TransactionTestService;
import com.narcos.frameworklearn.transaction.TransactionTestTwoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/06/18 14:55
 **/
@Service
@AllArgsConstructor
public class TransactionTestServiceImpl implements TransactionTestService {
    private final TransactionTestOneService transactionTestOneService;
    private final TransactionTestTwoService transactionTestTwoService;
    private final TransactionTestOneRepository transactionTestOneRepository;
    private final TransactionTestTwoRepository transactionTestTwoRepository;
    private final AsyncService asyncService;
    private final PlatformTransactionManager platformTransactionManager;

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

    @Override
//    @Transactional(rollbackFor = Exception.class)
    public String asyncTransaction() {
        TransactionTestOne transactionTestOne = new TransactionTestOne();
        transactionTestOne.setId(1);
        transactionTestOne.setName("aa");
        TransactionTestTwo transactionTestTwo = new TransactionTestTwo();
        transactionTestTwo.setId(1);
        // 事务定义
        DefaultTransactionDefinition def = new DefaultTransactionDefinition();
        // 设置事务的传播行为
        def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
        // 开启事务并获取事务状态
        TransactionStatus status = platformTransactionManager.getTransaction(def);
        try {

            transactionTestOneRepository.save(transactionTestOne);
            transactionTestTwoRepository.save(transactionTestTwo);
            platformTransactionManager.commit(status);
//            throw new RuntimeException("我在这里抛异常啦");
        } catch (Exception e) {
            platformTransactionManager.rollback(status);
        }
//        asyncService.asyncTransaction();
        return "成功啦";
    }
}
