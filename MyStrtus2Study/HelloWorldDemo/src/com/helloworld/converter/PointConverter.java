package com.helloworld.converter;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.helloworld.model.Point;

/**
 **自定义类型转换器
 * @author BREEZE
 *
 */
@SuppressWarnings("rawtypes")
public class PointConverter extends StrutsTypeConverter {

	/**
     * Converts one or more String values to the specified class.
     * *表单提交的数据在这个方法中被转换
     * @param context the action context
     * @param values  the String values to be converted, such as those submitted from an HTML form
     * @param toClass the class to convert to
     * @return the converted object
     */
	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		
		System.out.println("将 String 转换为指定类型！");
		
		String value = values[0];	//(2, 3)
		Point point = new Point();
		point.setX(Integer.parseInt(value.substring(1, value.indexOf(","))));
		point.setY(Integer.parseInt(value.substring(value.indexOf(",") + 1, value.length() - 1)));
		
		return point;
	}

	/**
     * Converts the specified object to a String.
     **使用 ognl 表达式时调用此方法
     * @param context the action context
     * @param o       the object to be converted
     * @return the converted String
     */ 
	@Override
	public String convertToString(Map context, Object o) {
		System.out.println("将指定类型转换为 String");
		Point point = (Point)o;
		return "("+ point.getX() + "," + point.getY() +")";
	}

}
