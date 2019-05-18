
package com.bike.admin.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ConfigUtil {
	private static String filename="config.properties";
	private static HashMap<String , String> config = new HashMap<String , String>();
	//需要启动的线程
	private static List<String> threadList = new ArrayList<String>(); 
	
	static{
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		InputStream input = cl.getResourceAsStream(filename);
		
		if( input != null )
		{
			try
			{
				BufferedReader URLinput = new BufferedReader(new InputStreamReader(input, "gbk"));
				String line = null;
				while ((line = URLinput.readLine()) != null)
				{
					if (line.trim().length() != 0)
					{
						int index = line.indexOf('=');
						if(index>0){
							String name = line.substring(0, index).trim();
							String value = line.substring(index + 1).trim();
							config.put(name, value);
						}
					}
				}
				URLinput.close();
				input.close();
	
			} catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
				System.err.println("配置文件"+filename+"找不到！");
				e.printStackTrace();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				System.err.println("读取配置文件"+filename+"错误！");
				e.printStackTrace();
			}
		}
	}

	public static HashMap<String, String> getConfig() {
		return config;
	}

	public static List<String> getThreadList() {
		return threadList;
	}
	
}


