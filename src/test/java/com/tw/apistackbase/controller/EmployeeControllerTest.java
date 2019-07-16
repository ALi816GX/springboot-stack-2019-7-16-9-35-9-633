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
 * @Time:00:07
 * @description:
 */


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void should_return_employees_when_call_get_employees() throws Exception {

        String jsonResult = "[{\"id\":0,\"name\":\"Leo0\",\"gender\":\"male\",\"age\":10},{\"id\":1,\"name\":\"Leo1\",\"gender\":\"male\",\"age\":11},{\"id\":2,\"name\":\"Leo2\",\"gender\":\"male\",\"age\":12},{\"id\":3,\"name\":\"Leo3\",\"gender\":\"male\",\"age\":13},{\"id\":4,\"name\":\"Leo4\",\"gender\":\"male\",\"age\":14},{\"id\":5,\"name\":\"Leo5\",\"gender\":\"male\",\"age\":15},{\"id\":6,\"name\":\"Leo6\",\"gender\":\"male\",\"age\":16},{\"id\":7,\"name\":\"Leo7\",\"gender\":\"male\",\"age\":17},{\"id\":8,\"name\":\"Leo8\",\"gender\":\"male\",\"age\":18},{\"id\":9,\"name\":\"Leo9\",\"gender\":\"male\",\"age\":19}]";

        mockMvc.perform(get("/employees"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json(jsonResult));

    }



    @Test
    public void should_return_employee_when_call_get_employees_given_id_0() throws Exception {

        String jsonResult = "{\"id\":0,\"name\":\"Leo0\",\"gender\":\"male\",\"age\":10}";

        mockMvc.perform(get("/employees/0"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json(jsonResult));

    }

    @Test
    public void should_return_employees_when_call_get_employees_given_page_1_and_pageSize_5() throws Exception {

        String jsonResult = "[{\"id\":0,\"name\":\"Leo0\",\"gender\":\"male\",\"age\":10},{\"id\":1,\"name\":\"Leo1\",\"gender\":\"male\",\"age\":11},{\"id\":2,\"name\":\"Leo2\",\"gender\":\"male\",\"age\":12},{\"id\":3,\"name\":\"Leo3\",\"gender\":\"male\",\"age\":13},{\"id\":4,\"name\":\"Leo4\",\"gender\":\"male\",\"age\":14}]";

        mockMvc.perform(get("/employees?page=1&pageSize=5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json(jsonResult));

    }


    @Test
    public void should_return_employees_when_call_get_employees_given_gender_male() throws Exception {

        String jsonResult = "[{\"id\":0,\"name\":\"Leo0\",\"gender\":\"male\",\"age\":10},{\"id\":1,\"name\":\"Leo1\",\"gender\":\"male\",\"age\":11},{\"id\":2,\"name\":\"Leo2\",\"gender\":\"male\",\"age\":12},{\"id\":3,\"name\":\"Leo3\",\"gender\":\"male\",\"age\":13},{\"id\":4,\"name\":\"Leo4\",\"gender\":\"male\",\"age\":14},{\"id\":5,\"name\":\"Leo5\",\"gender\":\"male\",\"age\":15},{\"id\":6,\"name\":\"Leo6\",\"gender\":\"male\",\"age\":16},{\"id\":7,\"name\":\"Leo7\",\"gender\":\"male\",\"age\":17},{\"id\":8,\"name\":\"Leo8\",\"gender\":\"male\",\"age\":18},{\"id\":9,\"name\":\"Leo9\",\"gender\":\"male\",\"age\":19}]";

        mockMvc.perform(get("/employees?gender=male"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json(jsonResult));

    }
}