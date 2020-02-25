package com.narcos.frameworklearn.ioc.ann;

import org.springframework.stereotype.Component;

/**
 * @author hbj
 * @date 2020/2/22 17:17
 */
@Component
public class Teacher {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
