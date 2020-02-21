package com.narcos.frameworklearn.event;

/**
 * @author hbj
 * @date 2020/2/20 18:22
 */
public class RainEvent extends WeatherEvent {
    @Override
    public String getWeather() {
        return "rain";
    }
}
