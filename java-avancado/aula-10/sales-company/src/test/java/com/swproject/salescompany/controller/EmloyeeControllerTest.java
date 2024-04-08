package com.swproject.salescompany.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.swproject.salescompany.services.EmployeeService;
import com.swproject.salescompany.web.controllers.EmployeeController;

@WebMvcTest(EmployeeController.class)
public class EmloyeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EmployeeService employeeService;

    @Autowired
    private Faker faker;

    @TestConfiguration
    static class FakerTestConfig {

        @Bean
        public Faker faker() {
            return new Faker();
        }
    }
}
