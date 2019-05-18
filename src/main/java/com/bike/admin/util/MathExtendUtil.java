package com.bike.admin.util;

import java.math.BigDecimal;

/**
 * @Title: MathExtendUtil.java
 * @author cony
 * @date 2014-1-8 上午9:21:45
 * @version V1.0
 */
public class MathExtendUtil {


	private static final int DEFAULT_SCALE = 2;
	private static final int DEFAULT_DIV_SCALE = 10;

    /**
     * 提供精确的加法运算。
     * 
     * @param v1
     * @param v2
     * @return 两个参数的和
     */
    public static double add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).setScale(DEFAULT_SCALE, BigDecimal.ROUND_HALF_EVEN).doubleValue();
    }
    public static long add(long v1, long v2) {
        BigDecimal b1 = new BigDecimal(Long.toString(v1));
        BigDecimal b2 = new BigDecimal(Long.toString(v2));
        return b1.add(b2).setScale(DEFAULT_SCALE, BigDecimal.ROUND_UP).longValue();
    }
    public static double addToDouble(long v1, double v2) {
        BigDecimal b1 = new BigDecimal(Long.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).setScale(DEFAULT_SCALE, BigDecimal.ROUND_UP).doubleValue();
    }
    public static double add(double v1, double v2, int scale) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).setScale(scale, BigDecimal.ROUND_UP).doubleValue();
    }
    public static String add(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.add(b2).setScale(DEFAULT_SCALE, BigDecimal.ROUND_UP).toString();
    }

    /**
     * 提供精确的减法运算。
     * 
     * @param v1
     * @param v2
     * @return 两个参数的差
     */
    public static double subtract(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).setScale(DEFAULT_SCALE, BigDecimal.ROUND_UP).doubleValue();
    }
    public static long subtract(long v1, long v2) {
        BigDecimal b1 = new BigDecimal(Long.toString(v1));
        BigDecimal b2 = new BigDecimal(Long.toString(v2));
        return b1.subtract(b2).setScale(DEFAULT_SCALE, BigDecimal.ROUND_UP).longValue();
    }
    public static double subtractToDouble(long v1, double v2) {
        BigDecimal b1 = new BigDecimal(Long.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).setScale(DEFAULT_SCALE, BigDecimal.ROUND_UP).doubleValue();
    }
    public static double subtract(double v1, double v2, int scale) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).setScale(scale, BigDecimal.ROUND_UP).doubleValue();
    }
    public static double subtract(double v1, double v2, int scale, int scaleMethod) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).setScale(scale, scaleMethod).doubleValue();
    }
    public static String subtract(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.subtract(b2).setScale(DEFAULT_SCALE, BigDecimal.ROUND_UP).toString();
    }


    /**
     * 提供精确的乘法运算。
     * 
     * @param v1
     * @param v2
     * @return 两个参数的积
     * @slace 保留几位小数点
     */
    public static double multiply(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).setScale(DEFAULT_SCALE, BigDecimal.ROUND_UP).doubleValue();
    }
    public static long multiply(long v1, long v2) {
        BigDecimal b1 = new BigDecimal(Long.toString(v1));
        BigDecimal b2 = new BigDecimal(Long.toString(v2));
        return b1.multiply(b2).setScale(DEFAULT_SCALE, BigDecimal.ROUND_UP).longValue();
    }
    public static long multiplyToLong(long v1, double v2) {
        BigDecimal b1 = new BigDecimal(Long.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).setScale(DEFAULT_SCALE, BigDecimal.ROUND_UP).longValue();
    }
    public static double multiply(double v1, double v2, int slace) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).setScale(slace, BigDecimal.ROUND_UP).doubleValue();
    }
    public static String multiply(String v1, String v2) {
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.multiply(b2).setScale(DEFAULT_SCALE, BigDecimal.ROUND_UP).toString();
    }

    /**
     * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入,舍入模式采用ROUND_HALF_EVEN
     * 
     * @param v1
     * @param v2
     * @return 两个参数的商
     */
    public static double divide(double v1, double v2) {
        if (v2 == 0) {
            return 0;
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, DEFAULT_SCALE, BigDecimal.ROUND_HALF_EVEN).doubleValue();
    }
    public static long divide(long v1, long v2) {
        if (v2 == 0) {
            return 0;
        }
        BigDecimal b1 = new BigDecimal(Long.toString(v1));
        BigDecimal b2 = new BigDecimal(Long.toString(v2));
        return b1.divide(b2, DEFAULT_SCALE, BigDecimal.ROUND_UP).longValue();
    }
    public static double divideToDouble(long v1, double v2) {
        if (v2 == 0) {
            return 0;
        }
        BigDecimal b1 = new BigDecimal(Long.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, DEFAULT_SCALE, BigDecimal.ROUND_UP).doubleValue();
    }
    public static double divide(double v1, double v2, int scale) {
        return divide(v1, v2, scale, BigDecimal.ROUND_UP);
    }
    public static double divide(double v1, double v2, int scale, int round_mode) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        if (v2 == 0) {
            return 0;
        }
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2, scale, round_mode).doubleValue();
    }
    public static String divide(String v1, String v2) {
        return divide(v1, v2, DEFAULT_DIV_SCALE);
    }
    public static String divide(String v1, String v2, int scale) {
        return divide(v1, v2, scale, BigDecimal.ROUND_UP);
    }
    public static String divide(String v1, String v2, int scale, int round_mode) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, scale, round_mode).toString();
    }

    /**
     * 提供精确的小数位四舍五入处理,舍入模式采用ROUND_HALF_EVEN
     * 
     * @param v 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果
     */
    public static double round(double v, int scale) {
        return round(v, scale, BigDecimal.ROUND_UP);
    }

    /**
     * 提供精确的小数位四舍五入处理
     * 
     * @param v 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @param round_mode 指定的舍入模式
     * @return 四舍五入后的结果
     */
    public static double round(double v, int scale, int round_mode) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(Double.toString(v));
        return b.setScale(scale, round_mode).doubleValue();
    }

    /**
     * 提供精确的小数位四舍五入处理,舍入模式采用ROUND_HALF_EVEN
     * 
     * @param v 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @return 四舍五入后的结果，以字符串格式返回
     */
    public static String round(String v, int scale) {
        return round(v, scale, BigDecimal.ROUND_UP);
    }

    /**
     * 提供精确的小数位四舍五入处理
     * 
     * @param v 需要四舍五入的数字
     * @param scale 小数点后保留几位
     * @param round_mode 指定的舍入模式
     * @return 四舍五入后的结果，以字符串格式返回
     */
    public static String round(String v, int scale, int round_mode) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b = new BigDecimal(v);
        return b.setScale(scale, round_mode).toString();
    }

    
    public static String toPercentage(String v1, String v2, int scale, int round_mode) {
        if (scale < 0) {
            throw new IllegalArgumentException("The scale must be a positive integer or zero");
        }
        BigDecimal b1 = new BigDecimal(v1);
        BigDecimal b2 = new BigDecimal(v2);
        return b1.divide(b2, scale, round_mode).multiply(new BigDecimal(100)).setScale(scale-2, round_mode) + "%";
    }
    
    public static double calMoneyMutiAround(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).setScale(DEFAULT_SCALE, BigDecimal.ROUND_HALF_EVEN).doubleValue();
    }
    
    /*public static void main(String[] args) {
    	double i = MathExtendUtil.divideToDouble(1800000, 2000000);
    	System.out.println(i);
//    	double j = MathExtendUtil.divide(i, 3);
//    	System.out.println(j);
    }*/

}
