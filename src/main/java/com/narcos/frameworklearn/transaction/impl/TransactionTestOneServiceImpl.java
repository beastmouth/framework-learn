package com.narcos.frameworklearn.transaction.impl;

import com.narcos.frameworklearn.dao.repository.TransactionTestOneRepository;
import com.narcos.frameworklearn.entity.po.TransactionTestOne;
import com.narcos.frameworklearn.transaction.TransactionTestOneService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/06/18 15:10
 **/
@Service
public class TransactionTestOneServiceImpl implements TransactionTestOneService {
    private final TransactionTestOneRepository transactionTestOneRepository;

    public TransactionTestOneServiceImpl(TransactionTestOneRepository transactionTestOneRepository) {
        this.transactionTestOneRepository = transactionTestOneRepository;
    }

    @Override
    public boolean save() {
        TransactionTestOne transactionTestOne = new TransactionTestOne();
        transactionTestOne.setName("aaa");
        transactionTestOneRepository.save(transactionTestOne);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveTransaction() {
        TransactionTestOne transactionTestOne = new TransactionTestOne();
        transactionTestOne.setName("aaa");
        transactionTestOneRepository.save(transactionTestOne);
        return true;
    }

    @Override
    public boolean saveHadException() {
        TransactionTestOne transactionTestOne = new TransactionTestOne();
        transactionTestOne.setName("aaa");
        throw new RuntimeException("保存 TransactionTestOne 抛异常");
    }
}
