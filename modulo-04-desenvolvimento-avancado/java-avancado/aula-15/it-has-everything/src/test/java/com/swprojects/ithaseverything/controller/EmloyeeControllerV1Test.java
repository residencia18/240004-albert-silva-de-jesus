package com.swprojects.ithaseverything.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Optional;

import br.com.caelum.stella.tinytype.CPF;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.swprojects.ithaseverything.entities.Employee;
import com.swprojects.ithaseverything.services.EmployeeServiceV1;
import com.swprojects.ithaseverything.services.UserSystemService;
import com.swprojects.ithaseverything.web.controllers.EmployeeControllerV1;
import com.swprojects.ithaseverything.web.dto.form.EmployeeForm;
import com.swprojects.ithaseverything.web.dto.mapper.EmployeeMapper;

@WebMvcTest(EmployeeControllerV1.class)
public class EmloyeeControllerV1Test {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private EmployeeServiceV1 employeeService;

    @MockBean
    private UserSystemService usuarioService;

    @Autowired
    private Faker faker;

    @TestConfiguration
    static class FakerTestConfig {

        @Bean
        public Faker faker() {
            return new Faker();
        }
    }

    private Employee generateFakeEmployee() {
        Instant instantBirthDate = faker.date().birthday().toInstant().truncatedTo(ChronoUnit.SECONDS);
        String cpfString = faker.number().digits(11);
        String cpfFormatado = new CPF(cpfString).getNumeroFormatado();
        Employee employee = new Employee();

        employee.setName(faker.name().fullName());
        employee.setCpf(cpfFormatado);
        employee.setBirthDate(instantBirthDate);
        employee.setIsActive(faker.bool().bool());
        employee.setStartDate(faker.date().past(365 * 2, java.util.concurrent.TimeUnit.DAYS));
        employee.setExperienceYears(faker.number().numberBetween(1, 20));
        return employee;
    }

    @Test
    void createEmployee_WithValidData_ReturnsCreated() throws Exception {
        Employee newEmployee = generateFakeEmployee();

        // Gerando um empregado fictício que simula o retorno do serviço após a criação
        // Normalmente, isso incluiria um ID e quaisquer outros campos que são gerados
        // ou alterados na criação
        Employee savedEmployee = generateFakeEmployee();
        savedEmployee.setId(faker.number().randomNumber()); // Simulando o ID que seria gerado durante a criação

        when(employeeService.create(any(Employee.class))).thenReturn(savedEmployee);

        mockMvc.perform(post("/api/v1/employees")
                .content(objectMapper.writeValueAsString(newEmployee))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(EmployeeMapper.toDto(savedEmployee))));
    }

    @Test
    void getAllEmployees_ReturnsEmployeeList() throws Exception {
        Employee employee = generateFakeEmployee();
        when(employeeService.findAll()).thenReturn(Arrays.asList(employee));

        mockMvc.perform(get("/api/v1/employees/"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content()
                        .json(objectMapper.writeValueAsString(EmployeeMapper.toListDto(Arrays.asList(employee)))));
    }

    @Test
    void getEmployeeById_WhenEmployeeExists_ReturnsEmployee() throws Exception {
        Employee employee = generateFakeEmployee();
        when(employeeService.findById(1L)).thenReturn(Optional.of(employee));

        mockMvc.perform(get("/api/v1/employees/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(EmployeeMapper.toDto(employee))));
    }

    @Test
    void getEmployeeById_WhenEmployeeDoesNotExist_ReturnsNotFound() throws Exception {
        when(employeeService.findById(any(Long.class))).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/employees/{id}", 1))
                .andExpect(status().isNotFound());
    }

    @Test
    void updateEmployee_WhenEmployeeExists_ReturnsUpdatedEmployee() throws Exception {
        Employee updateInfo = generateFakeEmployee(); // Usando Faker para gerar dados de atualização
        Employee updatedEmployee = generateFakeEmployee(); // Supondo que seria outra versão dos dados do empregado

        // Forçando uma mudança para garantir que o empregado foi atualizado
        updatedEmployee.setName("Updated " + updatedEmployee.getName());
        when(employeeService.update(any(Long.class), any(EmployeeForm.class))).thenReturn(Optional.of(updatedEmployee));

        mockMvc.perform(put("/api/v1/employees/{id}", 1)
                .content(objectMapper.writeValueAsString(updateInfo))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(EmployeeMapper.toDto(updatedEmployee))));
    }

}
