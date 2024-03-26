package com.swproject.tradein.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swproject.tradein.entities.Employee;
import com.swproject.tradein.entities.Usuario;
import com.swproject.tradein.exception.EntityNotFoundException;
import com.swproject.tradein.repositories.EmployeeRepository;
import com.swproject.tradein.web.dto.form.EmployeeForm;

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
}