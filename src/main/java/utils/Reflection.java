package utils;

import java.lang.reflect.Method;

public class Reflection {

	public static Object getSingleMethod(Object obj,String s) throws Exception {
		Object o = null;
		Method[] m = obj.getClass().getDeclaredMethods();
		for(Method method : m) {
			if(method.getName().equals(s)) {
				o = method.invoke(obj);
			}
		}
		return o;
	}
	
	public static boolean verifyInstanceMethod(Object obj,String s) throws Exception {
		Method[] m = obj.getClass().getDeclaredMethods();
		Object o = null;
		for(Method method : m) {
			if(method.getName().equals(s)) {
				o = method.invoke(obj);
			}
		}
		if(o != null) {
			return true;
		}else {
			return false;
		}
	}
}
