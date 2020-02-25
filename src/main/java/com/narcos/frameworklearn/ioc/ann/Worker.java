package com.narcos.frameworklearn.ioc.ann;

import org.springframework.stereotype.Component;

/**
 * @author hbj
 * @date 2020/2/25 14:39
 */
@Component
public class Worker {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
