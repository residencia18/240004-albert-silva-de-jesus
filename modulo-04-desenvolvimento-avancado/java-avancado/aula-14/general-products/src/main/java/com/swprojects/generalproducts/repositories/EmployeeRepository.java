package com.swprojects.generalproducts.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swprojects.generalproducts.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
  
  Optional<Employee> findByName(String name);

  Page<Employee> findByIsActive(boolean isActive, Pageable pageable);
}
