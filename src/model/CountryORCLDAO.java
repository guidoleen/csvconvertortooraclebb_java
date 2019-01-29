package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CountryORCLDAO implements IDataDestination
{
	String strSql = "";
	Connection conn = null;
	
	public CountryORCLDAO(String _strConn, String _usr, String _pwd, String _strSql) throws SQLException
	{
		// "jdbc:oracle:thin:TCMDB@//localhost:1521/orcl.transfer-solutions.local"
		
		this.strSql = _strSql;
		this.conn = new OrclConnector().getOrclConnector(_strConn, _usr, _pwd);
	}
	
	// Insert into
	private void insertInto(String _strIn)
	{
		try 
		{
			Statement stmt = this.conn.createStatement();
			stmt.executeQuery(_strIn);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	@Override
	public void writeToDest(String[] _strval, String _splitter, String[] _columns) 
	{
		Country cntr = null;
		int iTel = 0;
		
		for (int i = 0; i < _strval.length; i++) // Regel voor regel uit het csv bestand (row)
		{
			String[] strVal = _strval[i].split(_splitter);
			String sql = this.strSql + "values (";

			int iColLen = strVal.length < _columns.length ? strVal.length : _columns.length;
			
			for (int j = 0; j < iColLen; j++) // Column voor column (col)
			{
				sql += "'" + strVal[j] + "'";
				
				if( (j != _columns.length -1) && iColLen != 1)
				{
					sql += ",";
				}
			}
			
			sql += ")";
			
			// this.insertInto(sql); // THE SQL INsert Statement...
			System.out.println(sql);
		}
	}
}
