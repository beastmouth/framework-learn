package com.narcos.frameworklearn.ioc.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author hbj
 * @date 2020/2/22 14:23
 */
@Component
public class HelloService {
    private Student student;

    @Autowired
    // 指定使用哪个实现类
    @Qualifier("bird")
    private Animal animal;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String hello() {
        return student.toString();
    }

    public String hello2() {
//        return "hello";
        return animal.getName();
    }
}
