package main;

import java.sql.SQLException;
import java.util.Scanner;

import model.Country;
import model.CountryORCLDAO;
import model.CsvReader;
import model.IDataDestination;
import model.ObjectFields;

public class MainLauncher 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Selecteer een csv bestand...");
		String strF = sc.nextLine();
		
		CsvReader csvR = new CsvReader(strF, new Country("code", "landnaam"), ";");
		IDataDestination destOrcl = null;
		
		try 
		{
			destOrcl = 
					(CountryORCLDAO) new CountryORCLDAO("jdbc:oracle:thin:TCMDB@//localhost:1521/orcl.transfer-solutions.local", 
					"TCMDB", "guidoleen123.", 
					"insert into land(landnaam, code)");
			
			csvR.readCsv(destOrcl);
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	// C:\Users\guido_leen\Desktop\Weg\landen.csv
	// C:\Users\guido_leen\Desktop\Weg\country.csv
}
