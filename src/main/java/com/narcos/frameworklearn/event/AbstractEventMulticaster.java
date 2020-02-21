package com.narcos.frameworklearn.event;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hbj
 * @date 2020/2/20 18:27
 */
public abstract class AbstractEventMulticaster implements EventMulticaster {
    private List<WeatherListener> listenerList = new ArrayList<>();

    @Override
    public void multicastEvent(WeatherEvent event) {
        doStart();
        listenerList.forEach(o -> o.onWeatherEvent(event));
        doEnd();
    }

    @Override
    public void addListener(WeatherListener weatherListener) {
        listenerList.add(weatherListener);
    }

    @Override
    public void removeListener(WeatherListener weatherListener) {
        listenerList.remove(weatherListener);
    }

    abstract void doStart();

    abstract void doEnd();

}
