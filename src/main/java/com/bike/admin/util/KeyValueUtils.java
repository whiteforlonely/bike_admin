/*
 * <p>Title: KeyValueParse.java </p>
 * <p>Description:  </p>
 * <p>Copyright: digu.com (c) 2012 </p>
 * <p>Company: digu</p>
 */
package com.bike.admin.util;

import java.util.HashMap;
import java.util.Map;
/**
 * 字符串与Map的转换工具
 * @version 1.0.0
 * @author zhangzk
 * @created 2012-10-23 上午11:31:04
 */
public class KeyValueUtils {

    private static final char KEY_VALUE_SPLIT = '=';
    private static final char KEY_VALUE_GROUP_SPLIT = ';';

    /**
     * 将Map<String,String>转换为格式化的字符串， key/value对之间的分隔符号为";",key与value之间的分隔符号为"="
     * @param mapData
     * @return String
     */
    public static String parseMap2String(Map<String, String> mapData) {
        StringBuilder sb = new StringBuilder(512);
        for (Map.Entry<String, String> mapEntry : mapData.entrySet()) {
            String key = mapEntry.getKey();
            String value = mapEntry.getValue();

            if (value == null || value.trim().length() ==0) {
            	continue;
            }
            
            dataFormatCheck(key);
            dataFormatCheck(value);

            sb.append(key);
            sb.append(KEY_VALUE_SPLIT);
            sb.append(value);
            sb.append(KEY_VALUE_GROUP_SPLIT);
        }
        return sb.toString();
    }

    /**
     * 将key/value对构成的字符串拆分为map， key/value对之间的分隔符号为";",key与value之间的分隔符号为"="
     * @param stringData  k1=v1;k2=v2
     * @return Map<String,String>
     */
    public static Map<String, String> parseString2Map(String stringData) {
        Map<String, String> map = new HashMap<String, String>();
        if (stringData != null && stringData.trim().length() != 0 ) {
            String[] strList = stringData.split(String.valueOf(KEY_VALUE_GROUP_SPLIT));
            for (String line : strList) {
            	if( line == null || line.trim().length() ==0 ){
            		continue;
            	}            	
                String[] kv = line.split(String.valueOf(KEY_VALUE_SPLIT));
                if (kv != null && kv.length >= 2) {
                    map.put(kv[0], kv[1]);
                }
            }
        }
        return map;
    }

    private static void dataFormatCheck(String str) {
        if (str.indexOf(KEY_VALUE_GROUP_SPLIT) != -1 || str.indexOf(KEY_VALUE_SPLIT) != -1) {
            throw new RuntimeException("character '=' or ';' key value structure is not allowed:[" + str + "]");
        }
    }
}


