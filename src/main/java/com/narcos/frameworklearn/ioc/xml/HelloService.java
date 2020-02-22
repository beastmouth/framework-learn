package com.narcos.frameworklearn.ioc.xml;

/**
 * @author hbj
 * @date 2020/2/22 14:23
 */
public class HelloService {
    private Student student;

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
        return animal.getName();
    }
}
