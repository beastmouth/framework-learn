//package com.narcos.frameworklearn.ioc.entity;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
///**
// * Component 表明哪个类要被扫描进spring容器中
// * Autowired 根据类型注入
// * @author hbj
// * @version 1.0
// * @date 2019/04/15 16:05
// **/
//@Component("person")
//public class Person {
//    @Value("1")
//    private Long id;
//    @Value("hbj")
//    private String name;
//    @Autowired
//    private Pet pet;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public Pet getPet() {
//        return pet;
//    }
//
//    public void setPet(Pet pet) {
//        this.pet = pet;
//    }
//
//    public void call() {
//        pet.move();
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                '}';
//    }
//}
