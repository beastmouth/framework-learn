package com.narcos.frameworklearn.transaction;

/**
 * @author hbj
 * @version 1.0
 * @date 2019/06/18 14:54
 **/
public interface TransactionTestService {
    void hadException();

    void kidOneTransaction();

    void kidAllTransaction();

    void kidOneTransactionFatherTransaction();

    void kidAllTransactionFatherTransaction();
}