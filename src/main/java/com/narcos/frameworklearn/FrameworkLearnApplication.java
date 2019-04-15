package com.narcos.frameworklearn;

import com.narcos.frameworklearn.ioc.entity.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * SpringBootApplication 包含了 @ComponentScan
 * ComponentScan 只能扫描 FrameworkLearnApplication 所在当前包一下的 如果不在当前包 需要另外指定包的路径
 * @author hbj
 */
@SpringBootApplication
public class FrameworkLearnApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(FrameworkLearnApplication.class, args);
        Person personBean = ctx.getBean(Person.class);
        Person person = (Person) ctx.getBean("person");
        System.out.println("personBean : " + personBean.toString() + " personName : " + person.toString());
        person.call();
    }

}
