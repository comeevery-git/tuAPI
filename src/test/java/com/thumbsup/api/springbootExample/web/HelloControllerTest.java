package com.thumbsup.api.springbootExample.web;

import com.thumbsup.api.springbootExample.web.HelloController;
import com.thumbsup.api.springbootExample.web.dto.HelloResponseDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello_test_return() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));

     }

    @Test
    public void hello_dto_test() throws Exception {
        //given
        String name = "test";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                .param("name",name)
                .param("amount",String.valueOf(amount)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name",is(name)))
            .andExpect(jsonPath("$.amount",is(amount)));

    }


}
