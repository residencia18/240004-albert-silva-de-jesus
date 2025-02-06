package com.swproject.buyeverything.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;

import java.util.Locale;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.github.javafaker.Faker;
import com.swproject.buyeverything.entities.Employee;
import com.swproject.buyeverything.repositories.EmployeeRepository;
import com.swproject.buyeverything.services.EmployeeService;
import com.swproject.buyeverything.web.dto.form.EmployeeForm;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest {

  @Mock
  private EmployeeRepository employeeRepository;

  @InjectMocks
  private EmployeeService employeeService;

  private Employee employee;
  private Faker faker;

  @BeforeEach
  void setUp() {
    faker = new Faker(new Locale("en-US"));
    // Gerando dados fictícios com o FAKER
    employee = new Employee();
    employee.setId(1L); // Garantindo um ID para os testes de update
    employee.setName(faker.name().fullName());
    employee.setCpf(faker.idNumber().valid());
    employee.setBirthDate(faker.date().birthday().toInstant());
  }

  @Test
  void testCreateFakeEmployee() {
    // Configura o Mockito para retornar o mesmo funcionario quando o repositório
    // salvar qualquer funcionario
    given(employeeRepository.save(any(Employee.class))).willReturn(employee);

    // Ação:
    Employee savedEmployee = employeeService.save(employee);

    // Assert
    // Verifica se o método save do repositório foi chamado
    verify(employeeRepository).save(any(Employee.class));

    // verifica as propriedades do funcionario retornado para assegurar que elas
    // correspondem ao esperado
    assertNotNull(savedEmployee, "O funcionario salvo não deve ser nulo");
    assertEquals(employee.getName(), savedEmployee.getName(), "O nome do funcionario não corresponde ao esperado");
    assertEquals(employee.getCpf(), savedEmployee.getCpf(), "O CPF do funcionario não corresponde ao esperado");
    assertEquals(employee.getBirthDate(), savedEmployee.getBirthDate(),
        "A data de nascimento do funcionario não corresponde ao esperado");
  }

  @Test
  void shouldUpdateEmployeeSuccessfully() {
    Employee updatedEmployee = new Employee();
    updatedEmployee.setName("Jane Doe");
    updatedEmployee.setCpf("123.456.789-00");
    updatedEmployee.setBirthDate(faker.date().birthday().toInstant());

    // Assert
    when(employeeRepository.findById(employee.getId())).thenReturn(Optional.of(employee));
    when(employeeRepository.save(any(Employee.class))).thenReturn(updatedEmployee);

    EmployeeForm employeeForm = new EmployeeForm();
    employeeForm.setName(updatedEmployee.getName());
    employeeForm.setCpf(updatedEmployee.getCpf());
    employeeForm.setBirthDate(updatedEmployee.getBirthDate());

    Employee result = employeeService.update(employee.getId(), employeeForm);

    // Assert
    assertNotNull(result, "O funcionário atualizado não deve ser nulo");
    assertEquals(updatedEmployee.getName(), result.getName(),
        "O nome do funcionário atualizado não corresponde ao esperado");
    assertEquals(updatedEmployee.getCpf(), result.getCpf(),
        "O CPF do funcionário atualizado não corresponde ao esperado");
    assertEquals(updatedEmployee.getBirthDate(), result.getBirthDate(),
        "A data de nascimento do funcionário atualizado não corresponde ao esperado");

    verify(employeeRepository).findById(employee.getId());
    verify(employeeRepository).save(any(Employee.class));
  }

}
