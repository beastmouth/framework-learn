package com.narcos.frameworklearn.bean;

import lombok.extern.slf4j.Slf4j;

/**
 * @author hbj
 * @date 2019/10/21 23:18
 */
@Slf4j
public class BeanTwo {
    private String words;

    public BeanTwo(String words) {
        this.words = words;
    }

    public String getWords() {
        return "say ： " + words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public void init() {
        log.info("准备初始化BeanTwo");
    }

    public void destroy() {
        log.info("准备销毁BeanTwo");
    }
}
