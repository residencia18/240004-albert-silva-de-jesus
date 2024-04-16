package com.swprojets.productsales.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swprojets.productsales.entities.Employee;
import com.swprojets.productsales.exception.DatabaseException;
import com.swprojets.productsales.exception.EntityNotFoundException;
import com.swprojets.productsales.repositories.EmployeeRepository;
import com.swprojets.productsales.web.dto.EmployeeResponseDto;
import com.swprojets.productsales.web.dto.form.EmployeeForm;

import lombok.RequiredArgsConstructor;

@Service
@Primary //para indicar qual implementação deve ser preferida quando o Spring procura injetar um bean
@Qualifier("v2")
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class EmployeeServiceV2 {
  
  @Autowired
  private EmployeeRepository employeeRepository;

  public Employee create(@Nullable Employee employee) {

    if (employee == null) {
      throw new IllegalArgumentException("O parâmetro 'employee' não pode ser nulo.");
    }
    return employeeRepository.save(employee);
  }

  @Transactional(readOnly = true)
  public Optional<Employee> findById(@NonNull Long id) {
    // return employeeRepository.findById(id);
    return Optional.ofNullable(employeeRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException(String.format("Employee id=%s não encontrado", id))));
  }

  @Transactional(readOnly = true)
	public Page<EmployeeResponseDto> findAllPaged(Pageable pageable) {
		Page<Employee> list = employeeRepository.findAll(pageable);
		return list.map(x -> new EmployeeResponseDto(x));
	}

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
