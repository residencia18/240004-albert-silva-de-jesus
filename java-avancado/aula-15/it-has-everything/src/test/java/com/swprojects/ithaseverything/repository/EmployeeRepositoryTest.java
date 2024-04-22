package com.swprojects.generalproducts.repository;

import static org.assertj.core.api.Assertions.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.github.javafaker.Faker;
import com.swprojects.generalproducts.entities.Employee;
import com.swprojects.generalproducts.repositories.EmployeeRepository;

import br.com.caelum.stella.tinytype.CPF;

@DataJpaTest
public class EmployeeRepositoryTest {

  @Autowired
  private EmployeeRepository employeeRepository;

  @Autowired
  private TestEntityManager testEntityManager;

  @Autowired
  private Faker faker;

  @AfterEach
  public void setup() {
    // faker = new Faker();
  }

  @TestConfiguration
  static class FakerTestConfig {

    @Bean
    public Faker faker() {
      return new Faker();
    }
  }

  @Test
  void injectedComponentsAreNotNull() {
    assertThat(testEntityManager).isNotNull();
    assertThat(employeeRepository).isNotNull();
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
  void createEmployee_WithValidData_ReturnsEmployee() {
    Employee employee = generateFakeEmployee();

    Employee savedEmployee = employeeRepository.save(employee);

    assertThat(savedEmployee).isNotNull();
    assertThat(savedEmployee.getId()).isGreaterThan(0); // Não é muito útil nesse caso
    assertThat(savedEmployee.getName()).isEqualTo(employee.getName());
    assertThat(savedEmployee.getCpf()).isEqualTo(employee.getCpf());
    assertThat(savedEmployee.getBirthDate()).isEqualTo(employee.getBirthDate());
    assertThat(savedEmployee.getIsActive()).isEqualTo(employee.getIsActive());
    assertThat(savedEmployee.getStartDate()).isEqualTo(employee.getStartDate());
    assertThat(savedEmployee.getExperienceYears()).isEqualTo(employee.getExperienceYears());
  }

  @Test
  void createEmployee_WithExistingCpf_ThrowsException() {
    Employee employee1 = generateFakeEmployee();
    testEntityManager.persistFlushFind(employee1); // Força a persistência imediata

    Employee employee2 = generateFakeEmployee();
    employee2.setCpf(employee1.getCpf());

    assertThatThrownBy(() -> employeeRepository.save(employee2)).isInstanceOf(Exception.class);
  }

  @Test
  void findEmployee_ById_ReturnsEmployee() {
    Employee employee = generateFakeEmployee();
    Employee persistedEmployee = testEntityManager.persistFlushFind(employee);

    Optional<Employee> foundEmployee = employeeRepository.findById(persistedEmployee.getId());

    assertThat(foundEmployee).isNotEmpty();
    assertThat(foundEmployee.get().getId()).isEqualTo(persistedEmployee.getId());
  }

  @Test
  void findEmployee_ByName_ReturnsEmployee() {
    Employee employee = generateFakeEmployee();
    Employee persistedEmployee = testEntityManager.persistFlushFind(employee);

    Optional<Employee> foundEmployee = employeeRepository.findByName(persistedEmployee.getName());

    assertThat(foundEmployee).isNotEmpty();
    assertThat(foundEmployee.get().getName()).isEqualTo(persistedEmployee.getName());
  }

  @Test
  void listEmployees_ReturnsAllEmployees() {
    Employee employee1 = generateFakeEmployee();
    Employee employee2 = generateFakeEmployee();
    testEntityManager.persistFlushFind(employee1);
    testEntityManager.persistFlushFind(employee2);

    List<Employee> employees = employeeRepository.findAll();

    assertThat(employees).hasSizeGreaterThanOrEqualTo(2);
  }

  @Test
  void deleteEmployee_WithExistingId_RemovesEmployee() {
    Employee employee = generateFakeEmployee();
    Employee persistedEmployee = testEntityManager.persistFlushFind(employee);

    employeeRepository.deleteById(persistedEmployee.getId());

    Employee deletedEmployee = testEntityManager.find(Employee.class, persistedEmployee.getId());
    assertThat(deletedEmployee).isNull();
  }
}
