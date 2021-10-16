package tr.com.getir.book.util;


import java.util.Collection;

public class Util {
	
	public static boolean isEmpty(String string) {
		if (string == null) {
			return true;
		}
		return string.trim().equals("");
	}
	
	public static boolean isEmpty(Collection collection) {
		if (collection == null) {
			return true;
		}
		return collection.isEmpty();
	}
	
	public static boolean isEmpty(Object[] objectArray) {
		if (objectArray == null) {
			return true;
		}
		return objectArray.length == 0;
	}
	
	public static boolean isEmpty(Object object) {
		if (object == null) {
			return true;
		}
		if (object instanceof String) {
			return ((String) object).trim().equals("");
		}
		if (object instanceof Collection) {
			return ((Collection) object).isEmpty();
		}
		if (object instanceof Object[]) {
			return ((Object[]) object).length == 0;
		}
		return false;
	}
	
	public static boolean isNotEmpty(String string) {
		return !isEmpty(string);
	}
	
	public static boolean isNotEmpty(Collection collection) {
		return !isEmpty(collection);
	}
	
	public static boolean isNotEmpty(Object[] objectArray) {
		return !isEmpty(objectArray);
	}
	
	public static boolean isNotEmpty(Object object) {
		return !isEmpty(object);
	}
	
}