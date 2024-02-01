package tutorial.jdbc.dao;

import tutorial.jdbc.db.DB;
import tutorial.jdbc.dao.impl.DepartmentDaoJDBC;
import tutorial.jdbc.dao.impl.SellerDaoJDBC;

public class DaoFactory {

	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
	
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}
}
