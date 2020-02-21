package com.narcos.frameworklearn.event;

/**
 * @author hbj
 * @date 2020/2/20 18:26
 */
public interface EventMulticaster {
    void multicastEvent(WeatherEvent event);

    void addListener(WeatherListener weatherListener);

    void removeListener(WeatherListener weatherListener);
}
