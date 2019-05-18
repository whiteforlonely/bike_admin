package com.bike.admin.util;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import com.bike.admin.util.ParameterUtil;

public class ParameterUtil {
	
	/**
	 * 获取字符型参数，若输入字符串为null，则返回设定的默认值
	 * @param str 输入字符串
	 * @param defaults 默认值 
	 * @return 字符串参数
	 */
    public static String getStringParameter(String str, String defaults)
    {
        if(str == null)
        {
            return defaults;
        }
        else
        {
            return str;
        }
    }
        
    /**
     * 获取int参数，若输入字符串为null，则返回设定的默认值
     * @param str 输入字符串
     * @param defaults 默认值
     * @return int参数
     */
    public static int getIntParameter(String str, int defaults)
    {
        if(str == null)
        {
            return defaults;
        }        
        try
        {
            return Integer.parseInt(str);
        }
        catch(Exception e)
        {
            return defaults;
        }
    }
    
    /**
     * 获取long型参数，若输入字符串为null，则返回设定的默认值
     * @param str 输入字符串
     * @param defaults 默认值
     * @return long参数
     */
    public static long getLongParameter(String str, long defaults)
    {
        if(str == null)
        {
            return defaults;
        }        
        try
        {
            return Long.parseLong(str);
        }
        catch(Exception e)
        {
            return defaults;
        }
    }
    
    /**
     * 获取boolean型参数，若输入字符串为null，则返回设定的默认值
     * @param str 输入字符串
     * @param defaults 默认值
     * @return boolean参数
     */
    public static Boolean getBooleanParameter(String str, boolean defaults)
    {
        if(str == null)
        {
            return defaults;
        }        
        try
        {
            return Boolean.parseBoolean(str);
        }
        catch(Exception e)
        {
            return defaults;
        }
    }
    
    /**
     * 获取double型参数，若输入字符串为null，则返回设定的默认值
     * @param str 输入字符串
     * @param defaults 默认值
     * @return double型参数
     */
    public static double getDoubleParameter(String str, double defaults)
    {
        if(str == null)
        {
            return defaults;
        }
        try
        {
            return Double.parseDouble(str);
        }
        catch(Exception e)
        {
            return defaults;
        }
    }
    
    /**
     * 获取short型参数，若输入字符串为null，则返回设定的默认值
     * @param str 输入字符串
     * @param defaults 默认值
     * @return short型参数
     */
    public static short getShortParameter(String str, short defaults)
    {
        if(str == null)
        {
            return defaults;
        }
        try
        {
            return Short.parseShort(str);
        }
        catch(Exception e)
        {
            return defaults;
        }
    }
    
    /**
     * 获取float型参数，若输入字符串为null，则返回设定的默认值
     * @param str 输入字符串
     * @param defaults 默认值
     * @return float型参数
     */
    public static float getFloatParameter(String str, float defaults)
	{
        if(str == null)
        {
            return defaults;
        }
        try
        {
            return Float.parseFloat(str);
        }
        catch(Exception e)
        {
            return defaults;
        }
	}
    
    /**
     * 获取页面输入的String类型参数
     * @param request ServletRequest的实例
     * @param name 参数名字
     * @param defaults 设定的默认值
     * @return String型的输入参数
     */
    public static String getStringParameter(ServletRequest request, String name, String defaults)
    {
        return getStringParameter(request.getParameter(name), defaults);
    }

    /**
     * 获取页面输入的int类型参数
     * @param request ServletRequest的实例
     * @param name 参数名字
     * @param defaults 设定的默认值
     * @return int型的输入参数
     */
    public static int getIntParameter(ServletRequest request, String name, int defaults)
    {
    	return getIntParameter(request.getParameter(name), defaults);
    }
    
    /**
     * 获取页面输入的int类型参数，若无该输入参数，则返回0
     * @param request ServletRequest的实例
     * @param name 参数名字
     * @return int型的输入参数
     */
    public static int getIntParameter(ServletRequest request, String name){
    	return getIntParameter(request, name, 0);
    }
    
    /**
     * 获取页面输入的long类型参数
     * @param request ServletRequest的实例
     * @param name 参数名字
     * @param defaults 设定的默认值
     * @return long型的输入参数
     */
    public static long getLongParameter(ServletRequest request, String name, long defaults){
    	return getLongParameter(request.getParameter(name), defaults);
    }
    
    /**
     * 获取页面输入的long类型参数，若无该输入参数，则返回0
     * @param request ServletRequest的实例
     * @param name 参数名字
     * @return long型的输入参数
     */
    public static long getLongParameter(ServletRequest request, String name){
    	return getIntParameter(request, name, 0);
    }
    
    /**
     * 获取页面输入的double类型参数
     * @param request ServletRequest的实例
     * @param name 参数名字
     * @param defaults 设定的默认值
     * @return double型的输入参数
     */
    public static double getDoubleParameter(ServletRequest request, String name, double defaults){
    	return getDoubleParameter(request.getParameter(name), defaults);
    }
    
    /**
     * 获取页面输入的double类型参数，若无该参数，则返回0.0
     * @param request ServletRequest的实例
     * @param name 参数名字
     * @return long型的输入参数
     */
    public static double getDoubleParameter(ServletRequest request, String name){
    	return getDoubleParameter(request, name, 0.0);
    }
    
    /**
     * 获取页面输入的short类型参数
     * @param request ServletRequest的实例
     * @param name 参数名字
     * @param defaults 设定的默认值
     * @return short型的输入参数
     */
    public static short getShortParameter(ServletRequest request, String name, short defaults)
    {
        return getShortParameter(request.getParameter(name), defaults);
    }
    
    /**
     * 获取页面输入的short类型参数，若无该参数，则返回0
     * @param request ServletRequest的实例
     * @param name 参数名字
     * @return short型的输入参数
     */
    public static short getShortParameter(ServletRequest request, String name)
    {
        return getShortParameter(request, name, (short)0);
    }
    
    /**
     * 获取页面输入的float类型参数
     * @param request ServletRequest的实例
     * @param name 参数名字
     * @param defaults 设定的默认值
     * @return float型的输入参数
     */
    public static float getFloatParameter(ServletRequest request, String name, float defaults)
    {
    	return getFloatParameter(request.getParameter(name), defaults);
    }
    
    /**
     * 获取页面输入的float类型参数，若无该参数，则返回0.0
     * @param request ServletRequest的实例
     * @param name 参数名字
     * @return long型的输入参数
     */
    public static float getFloatParameter(ServletRequest request, String name)
    {
    	return getFloatParameter(request, name, (float)0.0);
    }
    
    /**
     * 获取页面输入的boolean类型参数，若无该参数，则返回默认值
     * @param request ServletRequest的实例
     * @param name 参数名字
     * @return boolean型的输入参数
     */
    public static boolean getBooleanParameter( ServletRequest request,String name,boolean defaults)
    {
    	String flag = request.getParameter(name);
    	if(flag==null){return defaults;}
    	try{
    		defaults = Boolean.parseBoolean(flag);
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return defaults;
    }
    
    public static String getParameter(HttpServletRequest request, String name){
		String value = request.getParameter(name);
		if(value==null){
			value="";
		}
		//<<TOMCAT测试的话，需要以下代码
		try {
			value = new String(value.getBytes("ISO-8859-1"),"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//>>
		value = value.trim();
		return value;
	}

    
    
   // --------------------- 由map获得得值 -------------------- //
    
   public static String getStringParameter(Map<String, Object> paramsMap,String name,String defaults){
	   if(paramsMap == null ){
		   return ""; 
	   }
	   if(defaults == null){
		   defaults = "";
	   }
	   return ParameterUtil.getStringParameter((String)paramsMap.get(name), defaults);
   }
   
   public static int getIntParameter(Map<String, Object> paramsMap,String name,int defaults){
	   if(paramsMap == null ){
		   return 0;
	   }
	   
	   return ParameterUtil.getIntParameter((String)paramsMap.get(name), defaults);
   }
   
   public static double getDoubleParameter(Map<String, Object> paramsMap,String name,double defaults){
	   if(paramsMap == null ){
		   return 0;
	   }
	   
	   return ParameterUtil.getDoubleParameter((String)paramsMap.get(name), defaults);
   }
   
   public static long getLongParameter(Map<String, Object> paramsMap,String name,int defaults){
	   if(paramsMap == null ){
		   return 0;
	   }
	   
	   return ParameterUtil.getLongParameter((String)paramsMap.get(name), defaults);
   }
   
   public static Boolean getBooleanParameter(Map<String, Object> paramsMap,String name,boolean defaults){
	   if(paramsMap == null ){
		   return false;
	   }
	   
	   return ParameterUtil.getBooleanParameter((String)paramsMap.get(name), defaults);
   }

}
