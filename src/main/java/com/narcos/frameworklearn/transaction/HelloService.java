package com.narcos.frameworklearn.transaction;

import com.narcos.frameworklearn.entity.po.TransactionTestOne;

/**
 * @author hbj
 * @date 2020/1/13 16:47
 */
public interface HelloService {
    TransactionTestOne saveOne();

    TransactionTestOne findOne(Integer id);
}
