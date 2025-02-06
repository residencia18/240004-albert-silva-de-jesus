package com.swprojects.salesofeverything.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swprojects.salesofeverything.entities.Employee;
import com.swprojects.salesofeverything.exception.EntityNotFoundException;
import com.swprojects.salesofeverything.repositories.EmployeeRepository;
import com.swprojects.salesofeverything.web.dto.EmployeeResponseDto;
import com.swprojects.salesofeverything.web.dto.mapper.EmployeeMapper;

import lombok.RequiredArgsConstructor;

@Service
@Primary // para indicar qual implementação deve ser preferida quando o Spring procura
         // injetar um bean
@Qualifier("employeeServiceV2")
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class EmployeeServiceV2 {

  @Autowired
  private EmployeeRepository employeeRepository;

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

  public Page<Employee> findAll(Pageable pageable) {
    return employeeRepository.findAll(pageable);
  }

  public List<EmployeeResponseDto> findAllSorted(String[] sort) {
    List<Order> orders = new ArrayList<>();
    for (String sortOrder : sort) {
      String[] _sort = sortOrder.split(",");
      orders.add(new Order(getSortDirection(_sort[1]), _sort[0]));
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
}
