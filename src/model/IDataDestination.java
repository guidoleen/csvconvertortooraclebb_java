package model;

public interface IDataDestination 
{
	public void writeToDest(String[] _strval, String _splitter, String[] _columns);
}
