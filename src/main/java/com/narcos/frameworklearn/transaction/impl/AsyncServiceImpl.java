package com.narcos.frameworklearn.transaction.impl;

import com.narcos.frameworklearn.dao.repository.TransactionTestTwoRepository;
import com.narcos.frameworklearn.entity.po.TransactionTestTwo;
import com.narcos.frameworklearn.transaction.AsyncService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hbj
 * @date 2019/10/25 9:46
 */
@Slf4j
@Service
@AllArgsConstructor
public class AsyncServiceImpl implements AsyncService {
    private final TransactionTestTwoRepository transactionTestTwoRepository;

    @Async
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void asyncTransaction() {
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("我开始执行啦");
        TransactionTestTwo transactionTestTwo = new TransactionTestTwo();
        transactionTestTwo.setId(1);
        transactionTestTwo.setName("gg");
        transactionTestTwoRepository.save(transactionTestTwo);
    }
}
