package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvReader<T>
{
	List<String> csvVal = new ArrayList<String>();
	String csvF = null;
	T obj = null;
	String _split = null;
	
	public CsvReader(String _csvF, T _obj, String _split)
	{
		this.csvF =_csvF;
		this.obj = _obj;
		this._split = _split;
	}
	
	// readCsv and put into db based on columns in object definition
	public void readCsv(IDataDestination datadest)
	{
		try
		{
			this.putCsvToArrList();
			datadest.writeToDest( this.getCsvToStringArray(), this._split, getColumnNames() );
		}
		catch (FileNotFoundException e) 
		{
			// e.printStackTrace();
			System.out.println("No file found....");
		}
		catch (IOException e) 
		{
			// e.printStackTrace();
			System.out.println("No file found....");
		}
		catch(NullPointerException e)
		{
			System.out.println("Finished....");
		}
		catch (java.util.NoSuchElementException e) 
		{
			// e.printStackTrace();
			System.out.println("Finished....");
		}
	}
	
	// Put csv file into arraylist
	private List<String> putCsvToArrList() throws IOException, FileNotFoundException, NullPointerException, java.util.NoSuchElementException
	{
		File f = new File(this.csvF);
		BufferedReader brf = new BufferedReader(new FileReader(f));

			String strReadVal = "";
			
			while((strReadVal=brf.readLine()) != null)
			{
				csvVal.add(strReadVal);
			}
			
		brf.close();
		
		return this.csvVal;
	}
	
	// Put ArrayList into String Array
	public String[] getCsvToStringArray()
	{
		int csvL = this.csvVal.size();
		String[] strArr = new String[csvL];
		
		for (int i = 0; i < csvL; i++)
		{
			strArr[i] = this.csvVal.get(i).trim().replace(" ", "");
		}
		
		return strArr;
	}
	
	// Get the array of column names from an object
	private String[] getColumnNames()
	{
		ObjectFields objClass = new ObjectFields( this.obj );
		String[] strMembersInClass = objClass.getTheMemebersFromObject();
		
		return strMembersInClass;
	}
}
