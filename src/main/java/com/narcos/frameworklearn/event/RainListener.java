package com.narcos.frameworklearn.event;

/**
 * @author hbj
 * @date 2020/2/20 18:24
 */
public class RainListener implements WeatherListener {
    @Override
    public void onWeatherEvent(WeatherEvent event) {
        if (event instanceof RainEvent) {
            System.out.println("hello " + event.getWeather());
        }
    }
}
