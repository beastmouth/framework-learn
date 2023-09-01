package com.narcos.frameworklearn;

import com.narcos.frameworklearn.service.ATestOrderServiceImpl;
import com.narcos.frameworklearn.service.TestOrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import java.util.LinkedList;
import java.util.List;

/**
 * @author huangbangjing
 * @date 2023/9/1 17:14
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BeanOrderTest {
    @Autowired
    private List<TestOrderService> testOrderServiceList;
    @Autowired
    private ATestOrderServiceImpl aTestOrderService;

    @Test
    public void changeOrder() {
        LinkedList<TestOrderService> list = new LinkedList<>();
        boolean needAddA = false;
        StopWatch sw = new StopWatch();
        sw.start();
        for (TestOrderService testOrderService : testOrderServiceList) {
            if (testOrderService instanceof ATestOrderServiceImpl) {
                needAddA = true;
                continue;
            }
            list.add(testOrderService);
        }
        if (needAddA) {
            list.add(aTestOrderService);
        }
        sw.stop();
        System.out.println("耗时:" + sw.getTotalTimeMillis());
        list.forEach(temp -> System.out.println(temp.getClass().getSimpleName()));


        LinkedList<TestOrderService> list2 = new LinkedList<>();
        StopWatch sw2 = new StopWatch();
        sw2.start();
        for (TestOrderService testOrderService : testOrderServiceList) {
            list2.add(testOrderService);
        }
        sw2.stop();
        System.out.println("耗时:" + sw2.getTotalTimeMillis());
        list2.forEach(temp -> System.out.println(temp.getClass().getSimpleName()));
    }
}
