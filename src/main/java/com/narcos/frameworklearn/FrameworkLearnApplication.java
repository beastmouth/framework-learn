package com.narcos.frameworklearn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * SpringBootApplication 包含了 @ComponentScan
 * ComponentScan 只能扫描 FrameworkLearnApplication 所在当前包一下的 如果不在当前包 需要另外指定包的路径
 *
 * @author hbj
 */
@Slf4j
@SpringBootApplication
public class FrameworkLearnApplication {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(FrameworkLearnApplication.class, args);
//        Person personBean = applicationContext.getBean(Person.class);
//        Person person = (Person) applicationContext.getBean("person");
//        System.out.println("personBean : " + personBean.toString() + " personName : " + person.toString());
//        person.call();
    }
}
