package com.narcos.frameworklearn;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author hbj
 * @date 2020/1/13 16:57
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestHello {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void before() throws Exception {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testHello() throws InterruptedException {
        class TestThread extends Thread {
            @Override
            public void run() {
                try {
                    mockMvc.perform(
                            MockMvcRequestBuilders.get("/hello/test")
                                    .contentType(MediaType.APPLICATION_JSON_UTF8))
                            .andExpect(MockMvcResultMatchers.status().isOk())
                            .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("我好了")));
                } catch (Exception e) {
                    System.out.println("发送请求失败");
                }
            }
        }

        for (int i = 0; i < 1000; i++) {
            new TestThread().start();
        }

        Thread.sleep(10000000);
    }
}
