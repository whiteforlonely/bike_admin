package com.bike.admin.util;

import java.lang.reflect.Method;

/**
 * 定制的枚举类型数据转换<br/>
 * 如：id转换成name；id转换成viewName
 * @author mym
 *
 */
public class EnumUtil {
	
	/**
	 * 根据id值获取对应的viewName。前提：枚举类中至少含有getViewNameById或getViewNameByCode方法进行获取。否则返回id的string值作为返回值
	 * @param eumnClass
	 * @param id
	 * @return
	 */
	public static String getViewNameFromEumnById(Class<?> eumnClass, int id){
		String viewName = "";
		try {
			Method getViewName = eumnClass.getMethod("getViewNameById", new Class[]{int.class});
			viewName = (String) getViewName.invoke(null, id);
			
		} catch (Exception e) {
			try {
				Method getViewNameByCode = eumnClass.getMethod("getViewNameByCode", new Class[]{int.class});
				viewName = (String) getViewNameByCode.invoke(null, id);
			} catch (Exception e1) {
				viewName = String.valueOf(id);
			}
		}
		return viewName;
	}

}
