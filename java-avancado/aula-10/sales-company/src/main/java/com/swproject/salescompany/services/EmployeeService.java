package com.swproject.salescompany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swproject.salescompany.entities.Employee;
import com.swproject.salescompany.exception.EntityNotFoundException;
import com.swproject.salescompany.repositories.EmployeeRepository;
import com.swproject.salescompany.web.dto.form.EmployeeForm;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  public Employee save(@Nullable Employee employee) {

    if (employee == null) {
      throw new IllegalArgumentException("O parâmetro 'employee' não pode ser nulo.");
    }
    return employeeRepository.save(employee);
  }

  // @Transactional(readOnly = true)
  // public Employee findById(@NonNull Long id) {
  //   return employeeRepository.findById(id).orElseThrow(
  //       () -> new EntityNotFoundException(String.format("Employee id=%s não encontrado", id)));
  // }

  @Transactional(readOnly = true)
  public Optional<Employee> findById(@NonNull Long id) {
    return employeeRepository.findById(id);
  }

  @Transactional(readOnly = true)
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  // public Employee update(@NonNull Long id, EmployeeForm employeeForm) {
  // Employee obj = findById(id);
  // obj.setName(employeeForm.getName());
  // obj.setCpf(employeeForm.getCpf());
  // obj.setBirthDate(employeeForm.getBirthDate());
  // return employeeRepository.save(obj);
  // }

  public Optional<Employee> update(@NonNull Long id, EmployeeForm employeeForm) {
    return findById(id).map(employee -> {
      employee.setName(employeeForm.getName());
      employee.setCpf(employeeForm.getCpf());
      employee.setBirthDate(employeeForm.getBirthDate());
      return employeeRepository.save(employee);
    });
  }

  public void delete(@NonNull Long id) {
    employeeRepository.deleteById(id);
  }

  public Boolean isExisteId(@NonNull Long id) {
    if (employeeRepository.existsById(id)) {
      return true;
    } else {
      return false;
    }
  }
}