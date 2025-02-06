package com.swproject.supersale.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.swproject.supersale.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
  
}
