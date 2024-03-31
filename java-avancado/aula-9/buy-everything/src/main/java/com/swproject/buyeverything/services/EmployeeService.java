package com.swproject.buyeverything.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swproject.buyeverything.entities.Employee;
import com.swproject.buyeverything.exception.EntityNotFoundException;
import com.swproject.buyeverything.repositories.EmployeeRepository;
import com.swproject.buyeverything.web.dto.form.EmployeeForm;

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

  @Transactional(readOnly = true)
  public Employee findById(@NonNull Long id) {
    return employeeRepository.findById(id).orElseThrow(
        () -> new EntityNotFoundException(String.format("Employee id=%s não encontrado", id)));
  }

  @Transactional(readOnly = true)
  public List<Employee> findAll() {
    return employeeRepository.findAll();
  }

  public Employee update(@NonNull Long id, EmployeeForm employeeForm) {
    Employee obj = findById(id);
    obj.setName(employeeForm.getName());
    obj.setCpf(employeeForm.getCpf());
    obj.setBirthDate(employeeForm.getBirthDate());
    return employeeRepository.save(obj);
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