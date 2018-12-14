package edu.yangtzeu.lmis.model;
import java.lang.reflect.Method;
import java.sql.SQLException;
import edu.yangtzeu.lmis.model.AbstractModel;


public abstract class AbstractModel {

	public Object getFieldValue(Class<?> objectClass,String methodName)
	throws Exception{
		// TODO Auto-generated method stub
		Method[] allMethods = objectClass.getDeclaredMethods();
		for(Method m:allMethods) {
			String mname=m.getName();
			if(mname.equals(methodName)) {
				return m.invoke(this, null);
			}
		}
		return null;
	}

}
