package com.nwh.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


/**
 * @WebMvcTest
 * 1. Web(Spring Mvc)에 집중할 수 있는 어노테이션이다.
 * 2. 선언할 경우 @Controller, @ControllerAdvice 등을 사용할 수 있다.
 * 3. 단, @Service, @Component, @Repository 등은 사용할 수 없다.
 *
 * TOOD : 스프링 어노테이션 조사
 */
@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    // 스프링이 관리하는 Bean을 주입 받는다.
    @Autowired

    // 웹 API를 테스트할 때 사용하며, HTTP GET, POST 등에 대한 API 테스트를 할 수 있다.
    private MockMvc mvc;

    @Test
    public void hello_return_hello() throws Exception {
        String hello = "hello";

        mvc.perform(MockMvcRequestBuilders.get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }
}
