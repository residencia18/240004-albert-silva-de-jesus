package com.swproject.sellgenius.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swproject.sellgenius.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
  
}
