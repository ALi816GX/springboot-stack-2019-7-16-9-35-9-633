package com.tw.apistackbase.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created with IDEA
 *
 * @author:linGuangXiong
 * @Date:2019/7/17
 * @Time:00:08
 * @description:
 */

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class CompanyControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_companies_when_call_get_companies() throws Exception {

        String jsonResult = "[{\"id\":0,\"name\":\"OOCL0\",\"age\":0,\"employees\":[{\"id\":0,\"name\":\"Leo0\",\"gender\":\"male\",\"age\":10},{\"id\":1,\"name\":\"Leo1\",\"gender\":\"male\",\"age\":11},{\"id\":2,\"name\":\"Leo2\",\"gender\":\"male\",\"age\":12}]},{\"id\":1,\"name\":\"OOCL1\",\"age\":1,\"employees\":null},{\"id\":2,\"name\":\"OOCL2\",\"age\":2,\"employees\":null},{\"id\":3,\"name\":\"OOCL3\",\"age\":3,\"employees\":null},{\"id\":4,\"name\":\"OOCL4\",\"age\":4,\"employees\":null},{\"id\":5,\"name\":\"OOCL5\",\"age\":5,\"employees\":null},{\"id\":6,\"name\":\"OOCL6\",\"age\":6,\"employees\":null},{\"id\":7,\"name\":\"OOCL7\",\"age\":7,\"employees\":null},{\"id\":8,\"name\":\"OOCL8\",\"age\":8,\"employees\":null},{\"id\":9,\"name\":\"OOCL9\",\"age\":9,\"employees\":null}]";

        mockMvc.perform(get("/companies"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json(jsonResult));

    }
}