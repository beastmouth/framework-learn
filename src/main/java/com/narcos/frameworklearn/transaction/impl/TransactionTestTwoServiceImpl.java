package com.narcos.frameworklearn.transaction.impl;

import com.narcos.frameworklearn.dao.repository.TransactionTestTwoRepository;
import com.narcos.frameworklearn.entity.po.TransactionTestTwo;
import com.narcos.frameworklearn.transaction.TransactionTestTwoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/06/18 15:11
 **/
@Service
public class TransactionTestTwoServiceImpl implements TransactionTestTwoService {
    private final TransactionTestTwoRepository transactionTestTwoRepository;

    public TransactionTestTwoServiceImpl(TransactionTestTwoRepository transactionTestTwoRepository) {
        this.transactionTestTwoRepository = transactionTestTwoRepository;
    }

    @Override
    public boolean save() {
        TransactionTestTwo transactionTestTwo = new TransactionTestTwo();
        transactionTestTwo.setName("bbb");
        transactionTestTwoRepository.save(transactionTestTwo);
        return true;
    }

    @Override
    public boolean saveHadException() {
        TransactionTestTwo transactionTestTwo = new TransactionTestTwo();
        transactionTestTwo.setName("bbb");
        transactionTestTwoRepository.save(transactionTestTwo);
        throw new RuntimeException("保存 TransactionTestTwo 抛异常");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveHadExceptionTransaction() {
        TransactionTestTwo transactionTestTwo = new TransactionTestTwo();
        transactionTestTwo.setName("bbb");
        transactionTestTwoRepository.save(transactionTestTwo);
        throw new RuntimeException("保存 TransactionTestTwo 抛异常");
    }
}
