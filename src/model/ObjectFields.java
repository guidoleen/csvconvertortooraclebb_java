package model;
import java.lang.reflect.*;

public class ObjectFields <T>
{
	String[] strMembers = null;
	T obj = null;
	
	public ObjectFields(T _obj)
	{
		this.obj = _obj;
	}
	
	public String[] getTheMemebersFromObject()
	{
		Class tclss = this.obj.getClass();
		Field[] fields = tclss.getDeclaredFields();
		
		strMembers = new String[fields.length];
		
		for (int i = 0; i < fields.length; i++)
		{
			strMembers[i] = fields[i].getName();
		}
		
		return strMembers;
	}
	
	public int getMembersObjectLengt()
	{
		if(this.strMembers == null)
			return 0;
		
		return this.strMembers.length;
	}
}

//public int getObjMemLength() 
//{
//	ObjectFields objClass = new ObjectFields( this.obj );
//	String[] strMembersInClass = objClass.getTheMemebersFromObject();
//
//	return objClass.getMembersObjectLengt();
//}
