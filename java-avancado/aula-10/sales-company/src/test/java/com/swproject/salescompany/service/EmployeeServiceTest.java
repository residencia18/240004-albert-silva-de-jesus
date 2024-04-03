package com.swproject.salescompany.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.dao.DataIntegrityViolationException;

import com.github.javafaker.Faker;
import com.swproject.salescompany.entities.Employee;
import com.swproject.salescompany.repositories.EmployeeRepository;
import com.swproject.salescompany.services.EmployeeService;
import com.swproject.salescompany.web.dto.form.EmployeeForm;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

  @Mock
  private EmployeeRepository employeeRepository;

  @InjectMocks
  private EmployeeService employeeService;

  private Faker faker;

  @BeforeEach
  void setUp() {
    faker = new Faker();
  }

  private Employee generateFakeEmployee() {
    Employee employee = new Employee();
    employee.setId(1L);
    employee.setName(faker.name().fullName());
    employee.setIsActive(faker.bool().bool());
    employee.setStartDate(faker.date().past(365 * 2, TimeUnit.DAYS));
    employee.setExperienceYears(faker.number().numberBetween(1, 20));
    return employee;
  }

  @Test
  void createEmployee_WithValidData_ReturnsEmployee() {
    Employee fakeEmployee = generateFakeEmployee();
    fakeEmployee.setIsActive(true); // nesse caso queremos um funcionário ativo
    given(employeeRepository.save(any(Employee.class))).willReturn(fakeEmployee);

    Employee savedEmployee = employeeService.save(fakeEmployee);

    assertNotNull(savedEmployee);
    assertEquals(fakeEmployee.getName(), savedEmployee.getName());
    assertTrue(savedEmployee.getIsActive());
    verify(employeeRepository).save(any(Employee.class));
  }

  @Test
  void createEmployee_WithNameAlreadyExists_ThrowsDataIntegrityViolationException() {
    // Simula a criação de um Employee
    Employee fakeEmployee = generateFakeEmployee();

    // Configura o repositório para lançar uma exceção específica quando tentarmos
    // salvar um Employee,
    // simulando uma violação da restrição de unicidade do campo "name".
    willThrow(DataIntegrityViolationException.class).given(employeeRepository)
        .save(argThat(newEmployee -> newEmployee.getName().equals(fakeEmployee.getName())));

    // Tenta criar o Employee, esperando que a exceção seja lançada devido à
    // violação da unicidade do nome.
    assertThrows(DataIntegrityViolationException.class, () -> employeeService.save(fakeEmployee));

    // Verifica se o método save foi de fato chamado, indicando que a tentativa de
    // salvar o Employee foi realizada.
    then(employeeRepository).should().save(any(Employee.class));
  }

  @Test
  void findEmployeeById_WithExistingId_ReturnsEmployee() {
    Employee fakeEmployee = generateFakeEmployee();
    given(employeeRepository.findById(fakeEmployee.getId())).willReturn(Optional.of(fakeEmployee));

    Optional<Employee> foundEmployee = employeeService.findById(fakeEmployee.getId());

    assertTrue(foundEmployee.isPresent());
    assertEquals(fakeEmployee.getId(), foundEmployee.get().getId());
    verify(employeeRepository).findById(fakeEmployee.getId());
  }

  @Test
  void findEmployeeById_WithUnexistingId_ReturnsEmpty() {
    Long fakeId = faker.number().randomNumber();
    given(employeeRepository.findById(fakeId)).willReturn(Optional.empty());

    Optional<Employee> result = employeeService.findById(fakeId);

    assertFalse(result.isPresent());
    verify(employeeRepository).findById(fakeId);
  }

  // @Test
  // void findEmployeeByName_WithExistingName_ReturnsEmployee() {
  // Employee fakeEmployee = generateFakeEmployee();
  // given(employeeRepository.findByName(fakeEmployee.getName())).willReturn(Optional.of(fakeEmployee));

  // Optional<Employee> result =
  // employeeService.findByName(fakeEmployee.getName());

  // assertTrue(result.isPresent());
  // assertEquals(fakeEmployee.getName(), result.get().getName());
  // verify(employeeRepository).findByName(fakeEmployee.getName());
  // }

  // @Test
  // void findEmployeeByName_WithUnexistingName_ReturnsEmpty() {
  // String fakeName = faker.name().fullName();
  // given(employeeRepository.findByName(fakeName)).willReturn(Optional.empty());

  // Optional<Employee> result = employeeService.findByName(fakeName);

  // assertFalse(result.isPresent());
  // verify(employeeRepository).findByName(fakeName);
  // }

  @Test
  void shouldUpdateEmployeeSuccessfully() {
    Employee originalEmployee = generateFakeEmployee();

    Employee updatedEmployee = generateFakeEmployee();

    // Assert
    when(employeeRepository.findById(originalEmployee.getId())).thenReturn(Optional.of(originalEmployee));
    when(employeeRepository.save(any(Employee.class))).thenReturn(updatedEmployee);

    EmployeeForm employeeForm = new EmployeeForm();
    employeeForm.setName(updatedEmployee.getName());
    employeeForm.setCpf(updatedEmployee.getCpf());
    employeeForm.setBirthDate(updatedEmployee.getBirthDate());

    Optional<Employee> result = employeeService.update(originalEmployee.getId(), employeeForm);

    assertTrue(result.isPresent());
    assertEquals(updatedEmployee.getName(), result.get().getName());
    assertEquals(updatedEmployee.getIsActive(), result.get().getIsActive());
    verify(employeeRepository).findById(originalEmployee.getId());
    verify(employeeRepository).save(any(Employee.class));
  }

  @Test
  void listAllEmployees_ReturnsAllEmployees() {
    List<Employee> employees = Collections.singletonList(generateFakeEmployee());
    given(employeeRepository.findAll()).willReturn(employees);

    List<Employee> foundEmployees = employeeService.findAll();

    assertFalse(foundEmployees.isEmpty());
    assertEquals(1, foundEmployees.size());
    verify(employeeRepository).findAll();
  }

  @Test
  void deleteEmployee_WithExistingId_DoesNotThrowAnyException() {
    Long employeeId = faker.number().randomNumber();
    willDoNothing().given(employeeRepository).deleteById(employeeId);

    assertDoesNotThrow(() -> employeeService.delete(employeeId));
    verify(employeeRepository).deleteById(employeeId);
  }

  @Test
  void deleteEmployee_WithUnexistingId_ThrowsException() {
    Long fakeId = faker.number().randomNumber();
    willThrow(new RuntimeException("Employee not found")).given(employeeRepository).deleteById(fakeId);

    assertThrows(RuntimeException.class, () -> employeeService.delete(fakeId), "Employee not found");
    verify(employeeRepository).deleteById(fakeId);
  }
}