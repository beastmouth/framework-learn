package com.narcos.frameworklearn;

import com.narcos.frameworklearn.ioc.ann.MyBeanImport;
import com.narcos.frameworklearn.ioc.xml.HelloService2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hbj
 * @date 2020/2/22 14:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Import(MyBeanImport.class)
//@ContextConfiguration(locations = "classpath:ioc/demo.xml")
public class BeanTest {
    @Autowired
    private HelloService2 helloService2;

    @Test
    public void test() {
        System.out.println(helloService2.hello2());
    }
}
