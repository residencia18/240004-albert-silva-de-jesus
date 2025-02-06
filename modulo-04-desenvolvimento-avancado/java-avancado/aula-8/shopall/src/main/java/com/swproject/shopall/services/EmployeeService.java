package com.swproject.shopall.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swproject.shopall.entities.Employee;
import com.swproject.shopall.exception.EntityNotFoundException;
import com.swproject.shopall.repositories.EmployeeRepository;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  public Employee save(@Nullable Employee employee) {

    if (employee == null) {
      throw new IllegalArgumentException("O parâmetro 'user' não pode ser nulo.");
    }
    return employeeRepository.save(employee);
  }

  @Transactional(readOnly = true)
  public Employee findById(@NonNull Long id) {
    return employeeRepository.findById(id).orElseThrow(
        () -> new EntityNotFoundException(String.format("Usuário id=%s não encontrado", id)));
  }

  @Transactional(readOnly = true)
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }
}