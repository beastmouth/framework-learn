package com.narcos.frameworklearn.transaction.impl;

import com.narcos.frameworklearn.dao.repository.TransactionTestOneRepository;
import com.narcos.frameworklearn.dao.repository.TransactionTestTwoRepository;
import com.narcos.frameworklearn.entity.po.TransactionTestOne;
import com.narcos.frameworklearn.transaction.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author hbj
 * @date 2020/1/13 16:48
 */
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class HelloServiceImpl implements HelloService {
    private final TransactionTestOneRepository oneRepository;
    private final TransactionTestTwoRepository twoRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public TransactionTestOne saveOne() {
        TransactionTestOne one = new TransactionTestOne();
        one.setName("aaa");
        one = oneRepository.save(one);
        return one;
    }

    @Override
    public TransactionTestOne findOne(Integer id) {
        Optional<TransactionTestOne> byId = oneRepository.findById(id);
        if (!byId.isPresent()) {
            System.out.println("没找到");
            return null;
        }
        return byId.get();
    }

}
