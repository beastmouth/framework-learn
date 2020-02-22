package com.narcos.frameworklearn.ioc.ann;

import com.narcos.frameworklearn.ioc.xml.Animal;
import com.narcos.frameworklearn.ioc.xml.Cat;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author hbj
 * @date 2020/2/22 15:18
 */
@Component
public class MyCat implements FactoryBean<Animal> {
    @Override
    public Animal getObject() throws Exception {
        return new Cat();
    }

    @Override
    public Class<?> getObjectType() {
        return Animal.class;
    }
}
