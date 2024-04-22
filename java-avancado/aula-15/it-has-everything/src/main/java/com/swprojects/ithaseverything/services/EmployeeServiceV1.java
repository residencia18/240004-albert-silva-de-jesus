package com.swprojects.generalproducts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swprojects.generalproducts.entities.Employee;
import com.swprojects.generalproducts.exception.DatabaseException;
import com.swprojects.generalproducts.exception.EntityNotFoundException;
import com.swprojects.generalproducts.repositories.EmployeeRepository;
import com.swprojects.generalproducts.web.dto.form.EmployeeForm;

import lombok.RequiredArgsConstructor;

@Service
@Qualifier("employeeServiceV1")
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class EmployeeServiceV1 {

  @Autowired
  private EmployeeRepository employeeRepository;

  public Employee create(@Nullable Employee employee) {

    if (employee == null) {
      throw new IllegalArgumentException("O parâmetro 'employee' não pode ser nulo.");
    }
    return employeeRepository.save(employee);
  }

  // @Transactional(readOnly = true)
  // public Employee findById(@NonNull Long id) {
  // return employeeRepository.findById(id).orElseThrow(
  // () -> new EntityNotFoundException(String.format("Employee id=%s não
  // encontrado", id)));
  // }

  @Transactional(readOnly = true)
  public Optional<Employee> findById(@NonNull Long id) {
    return Optional.ofNullable(employeeRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException(String.format("Employee id=%s não encontrado", id))));
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
    if (isExisteId(id)) {
      employeeRepository.deleteById(id);

    } else {
      throw new EntityNotFoundException("Employee id=" + id + " não encontrado");
    }
    throw new DatabaseException("Integrity violation");
  }

  public Boolean isExisteId(@NonNull Long id) {
    if (employeeRepository.existsById(id)) {
      return true;
    } else {
      return false;
    }
  }
}