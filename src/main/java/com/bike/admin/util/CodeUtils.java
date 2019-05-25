package com.bike.admin.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CodeUtils {
	
	
	public static synchronized String getNum(String idStr){
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
        String today = formatter.format(new Date());
		
		idStr = CodeUtils.fillString(idStr,"0",7);
		
		return today+idStr;
	}
    
	
	private static String fillString(String orig, String fillStr, int scale){
		StringBuffer result = new StringBuffer(orig);
		int strLen = orig.length();
		if(strLen >= scale)
			return orig.substring(orig.length()-scale, orig.length());
		for(int i = 0; i < (scale - strLen); i ++){
			result.insert(0, fillStr);
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		
//System.err.println("****"+SkuCodeClient.getNext());
		/*for (int i = 14; i < 69; i++) {
			System.err.println("编号:"+SkuCodeUtils.getCarNumber(i+""));
		}*/
		System.err.println("编号:"+CodeUtils.getNum(15+""));
	
	}
	
	

}

