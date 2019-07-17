package com.tw.apistackbase.controller;

import com.alibaba.fastjson.JSON;
import com.tw.apistackbase.model.Company;
import com.tw.apistackbase.model.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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

    @Test
    public void should_return_company_when_call_get_companies_given_id_1() throws Exception {

        String jsonResult = "{\"id\":1,\"name\":\"OOCL1\",\"age\":1,\"employees\":null}";

        mockMvc.perform(get("/companies/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json(jsonResult));

    }


    @Test
    public void should_return_companies_when_call_get_companies_given_page_1_and_pageSize_5() throws Exception {

        String jsonResult = "[{\"id\":0,\"name\":\"OOCL0\",\"age\":0,\"employees\":[{\"id\":0,\"name\":\"Leo0\",\"gender\":\"male\",\"age\":10},{\"id\":1,\"name\":\"Leo1\",\"gender\":\"male\",\"age\":11},{\"id\":2,\"name\":\"Leo2\",\"gender\":\"male\",\"age\":12}]},{\"id\":1,\"name\":\"OOCL1\",\"age\":1,\"employees\":null},{\"id\":2,\"name\":\"OOCL2\",\"age\":2,\"employees\":null},{\"id\":3,\"name\":\"OOCL3\",\"age\":3,\"employees\":null},{\"id\":4,\"name\":\"OOCL4\",\"age\":4,\"employees\":null}]";

        mockMvc.perform(get("/companies?page=1&pageSize=5"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(content().json(jsonResult));

    }


    @Test
    public void should_return_employees_when_call_get_employees_given_company_id() throws Exception {

        String jsonResult = "[{\"id\":0,\"name\":\"Leo0\",\"gender\":\"male\",\"age\":10},{\"id\":1,\"name\":\"Leo1\",\"gender\":\"male\",\"age\":11},{\"id\":2,\"name\":\"Leo2\",\"gender\":\"male\",\"age\":12}]";

        mockMvc.perform(get("/companies/0/employees"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().json(jsonResult));

    }


    @Test
    public void should_return_Success_when_call_add_companies_given_company() throws Exception {

        String jsonResult = "Success";
        Company company = new Company(1, "2", 3);
        String companyContent = JSON.toJSONString(company);

        mockMvc.perform(post("/companies")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(companyContent)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string(jsonResult));

    }



    @Test
    public void should_return_Success_when_call_put_companies_given_company_and_id() throws Exception {

        String jsonResult = "Success";
        Company company = new Company(1, "2", 3);
        String companyContent = JSON.toJSONString(company);

        mockMvc.perform(put("/companies/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(companyContent)
        )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string(jsonResult));

    }



    @Test
    public void should_return_success_when_call_delete_companies_given_company_id() throws Exception {


        String jsonResult = "Success";

        mockMvc.perform(delete("/companies/0")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string(jsonResult));

    }



}