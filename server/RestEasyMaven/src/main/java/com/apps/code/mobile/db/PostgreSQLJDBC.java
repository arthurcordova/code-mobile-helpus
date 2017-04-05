package com.apps.code.mobile.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class PostgreSQLJDBC {
	public Connection conectar() {
		Connection c = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         
//	         String URL = "jdbc:postgresql://postgres124494-env-7102451.jelasticlw.com.br/postgres";	         			
//	         c = DriverManager.getConnection(URL, "webadmin","hYOWNuN6Iv");
	         
	         String URL = "jdbc:postgresql://localhost:5432/test1";
	         c = DriverManager.getConnection(URL,"postgres", "root");
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      System.out.println("Opened database successfully");
	      return c;
	}
}
