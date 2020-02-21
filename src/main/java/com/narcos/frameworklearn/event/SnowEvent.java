package com.narcos.frameworklearn.event;

/**
 * @author hbj
 * @date 2020/2/20 18:21
 */
public class SnowEvent extends WeatherEvent {
    @Override
    public String getWeather() {
        return "snow";
    }
}
