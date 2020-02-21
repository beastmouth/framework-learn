package com.narcos.frameworklearn.event;

import org.springframework.stereotype.Component;

/**
 * @author hbj
 * @date 2020/2/20 18:24
 */
@Component
public class RainListener implements WeatherListener {
    @Override
    public void onWeatherEvent(WeatherEvent event) {
        if (event instanceof RainEvent) {
            System.out.println("hello " + event.getWeather());
        }
    }
}
