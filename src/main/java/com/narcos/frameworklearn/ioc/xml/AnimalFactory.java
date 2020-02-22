package com.narcos.frameworklearn.ioc.xml;

/**
 * @author hbj
 * @date 2020/2/22 14:31
 */
public class AnimalFactory {
    public Animal getAnimal(String type) {
        if ("dog".equals(type)) {
            return new Dog();
        } else {
            return new Cat();
        }
    }
}
