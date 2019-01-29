package model;

public class Country 
{
	String code;
	String landnaam;
	
	public Country(String _countryName, String _code)
	{
		this.code = _code;
		this.landnaam = _countryName;
	}
	
	@Override
	public String toString()
	{
		return "Code: " + this.code + " Name: " + this.landnaam;
	}
}
