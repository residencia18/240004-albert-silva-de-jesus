package tutorial.jdbc.dao;

import java.util.List;

import tutorial.jdbc.entities.Department;

public interface DepartmentDao {

  void insert(Department obj);

  void update(Department obj);

  void deleteById(Integer id);

  Department findById(Integer id);

  List<Department> findAll();
}
