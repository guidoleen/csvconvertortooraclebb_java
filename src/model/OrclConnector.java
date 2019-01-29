package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import oracle.jdbc.OracleDriver;

public class OrclConnector 
{
	Connection conn = null;
	
	public Connection getOrclConnector(String _db, String _usr, String _pwd) throws SQLException
	{
		DriverManager.registerDriver (new oracle.jdbc.OracleDriver());
		 
		this.conn = DriverManager.getConnection(_db, _usr, _pwd);
		return this.conn;
	}
}
