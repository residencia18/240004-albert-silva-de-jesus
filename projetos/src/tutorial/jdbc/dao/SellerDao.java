package jdbc.dao;

import java.util.List;

import jdbc.entities.Department;
import jdbc.entities.Seller;

public interface SellerDao {

  void insert(Seller obj);

  void update(Seller obj);

  void deleteById(Integer id);

  Seller findById(Integer id);

  List<Seller> findAll();

  List<Seller> findByDepartment(Department department);
}
