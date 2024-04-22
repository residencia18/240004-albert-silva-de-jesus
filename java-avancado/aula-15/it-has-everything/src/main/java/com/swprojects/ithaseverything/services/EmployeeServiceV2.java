package com.swprojects.ithaseverything.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swprojects.ithaseverything.entities.Employee;
import com.swprojects.ithaseverything.exception.DatabaseException;
import com.swprojects.ithaseverything.exception.EntityNotFoundException;
import com.swprojects.ithaseverything.repositories.EmployeeRepository;
import com.swprojects.ithaseverything.web.dto.EmployeeResponseDto;
import com.swprojects.ithaseverything.web.dto.form.EmployeeForm;
import com.swprojects.ithaseverything.web.dto.mapper.EmployeeMapper;

import lombok.RequiredArgsConstructor;

@Service
@Primary // para indicar qual implementação deve ser preferida quando o Spring procura
         // injetar um bean
@Qualifier("employeeServiceV2")
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class EmployeeServiceV2 {

  public static final Logger log = LoggerFactory.getLogger(EmployeeServiceV2.class);

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
    return Optional.ofNullable(employeeRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException(String.format("Employee id=%s não encontrado", id))));
  }

  @Cacheable("employees")
  @Transactional(readOnly = true)
  public Page<EmployeeResponseDto> findAllPaged(Pageable pageable) {
    Page<Employee> list = employeeRepository.findAll(pageable);
    return list.map(x -> new EmployeeResponseDto(x));
  }

  @Cacheable("employees")
  @Transactional(readOnly = true)
  public Page<EmployeeResponseDto> findAll(Pageable pageable) {
    return employeeRepository.findAll(pageable).map(EmployeeResponseDto::new);
    // return employeeRepository.findAll(pageable).map(x -> new
    // EmployeeResponseDto(x));
  }

  @Cacheable("employees")
  @Transactional(readOnly = true)
  public List<EmployeeResponseDto> findAllSorted(String[] sort) {
    List<Order> orders = new ArrayList<>();
    for (String sortOrder : sort) {
      String[] _sort = sortOrder.split(",");
      if (_sort.length >= 2) {
        orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
      } else {
        // Lança uma exceção se o critério de ordenação não estiver no formato correto
        log.warn("Critério de ordenação inválido: {}", sortOrder);
      }
    }
    List<Employee> employees = employeeRepository.findAll(Sort.by(orders));
    return EmployeeMapper.toListDto(employees);
  }

  private Sort.Direction getSortDirection(String direction) {
    if ("asc".equals(direction)) {
      return Sort.Direction.ASC;

    } else if ("desc".equals(direction)) {
      return Sort.Direction.DESC;
    }
    return Sort.Direction.ASC;
  }

  @Cacheable("employees")
  @Transactional(readOnly = true)
  public Map<String, Object> findActiveEmployees(int page, int size) {
    List<Employee> employees = new ArrayList<>();
    Pageable paging = PageRequest.of(page, size);
    Page<Employee> pageEmployees = employeeRepository.findByIsActive(true, paging);
    employees = pageEmployees.getContent();

    Map<String, Object> response = new HashMap<>();
    response.put("employees", employees);
    response.put("currentPage", pageEmployees.getNumber());
    response.put("totalItems", pageEmployees.getTotalElements());
    response.put("totalPages", pageEmployees.getTotalPages());

    return response;
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
