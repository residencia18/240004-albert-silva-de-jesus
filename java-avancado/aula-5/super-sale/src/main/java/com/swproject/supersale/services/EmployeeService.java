package com.swproject.supersale.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import com.swproject.supersale.entities.Employee;
import com.swproject.supersale.repositories.EmployeeRepository;

@Service
public class EmployeeService {
  
  @Autowired
  private EmployeeRepository  employeeRepository;

  public Employee save(@Nullable Employee employee) {

    if (employee == null) {
      throw new IllegalArgumentException("O parâmetro 'user' não pode ser nulo.");
    }

    return employeeRepository.save(employee);
  }
}
