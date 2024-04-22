package com.swprojects.ithaseverything.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swprojects.ithaseverything.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
  
  Optional<Employee> findByName(String name);

  Page<Employee> findByIsActive(boolean isActive, Pageable pageable);
}
