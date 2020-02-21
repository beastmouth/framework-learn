package com.narcos.frameworklearn;

import com.narcos.frameworklearn.event.WeatherRunListener;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author hbj
 * @date 2020/2/21 13:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EventTest {
    @Autowired
    private WeatherRunListener weatherRunListener;

    @Test
    public void testEvent() {
        weatherRunListener.rain();
        weatherRunListener.snow();
    }
}
