package com.narcos.frameworklearn.transaction;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/06/18 15:10
 **/
public interface TransactionTestOneService {
    boolean save();

    boolean saveTransaction();

    boolean saveHadException();
}
