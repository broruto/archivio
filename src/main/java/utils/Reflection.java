package utils;

import java.lang.reflect.Method;

import model.config.ConfigBinding;

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
	
	public ConfigBinding<String> binding(ConfigBinding<String> field, Object obj) throws Exception {
			String[] split= null;
			split= field.getBinding().split("\\.");
			Method[] m = obj.getClass().getDeclaredMethods();
			Object objTemp= null;
			for(String campo: split) {
				String s1 = campo.substring(0, 1).toUpperCase();
			    String getName ="get"+ s1 + campo.substring(1);
				if(objTemp == null) {
					for(Method method : m) {
						if(method.getName().equals(getName)) {
							objTemp = method.invoke(obj);
						}
					}
				}else {
					Method[] mTemp = objTemp.getClass().getDeclaredMethods();
					for(Method method : mTemp) {
						if(method.getName().equals(getName)) {
							objTemp = method.invoke(obj);
						}
					}
				}
			}
			field.setContent(objTemp.toString());
		return field;
	}
}
