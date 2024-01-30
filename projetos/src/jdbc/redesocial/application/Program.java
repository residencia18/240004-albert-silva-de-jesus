package jdbc.redesocial.application;

import java.sql.Connection;

import jdbc.redesocial.db.DB;

public class Program {

  public static void main(String[] args) {

    Connection conn = DB.getConnection();
    DB.closeConnection();
    
  }
}
