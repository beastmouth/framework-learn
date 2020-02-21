package com.narcos.frameworklearn.event;

import org.springframework.stereotype.Component;

/**
 * @author hbj
 * @date 2020/2/20 18:30
 */
@Component
public class WeatherEventMulticaster extends AbstractEventMulticaster {

    @Override
    void doStart() {
        System.out.println("开始广播天气事件");
    }

    @Override
    void doEnd() {
        System.out.println("结束广播天气事件");
    }

}
