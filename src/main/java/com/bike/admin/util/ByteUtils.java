package com.bike.admin.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class ByteUtils
{
    
    public static byte[] getBytes(String str)
    {
        return str.getBytes();
    }
    
    public static InputStream byteToInputStream(byte[] bytes)
                    throws IOException
    {
        return new ByteArrayInputStream(bytes);
    }
    
    public static byte[] inputStreamToByte(InputStream is)
                    throws IOException
    {
        ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
        int ch;
        while ((ch = is.read()) != -1)
        {
            bytestream.write(ch);
        }
        byte imgdata[] = bytestream.toByteArray();
        bytestream.close();
        return imgdata;
    }
    
    /**
     * Redintegrate a serialized object.
     * 
     * @param serial
     *            a byte array of the serialized object.
     * @return the original object or null if an error occurs.
     */
    public static Object deserialize(byte[] serial)
    {
        ByteArrayInputStream bais = new ByteArrayInputStream(
                        serial);
        ObjectInputStream ois = null;
        try
        {
            ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (IOException e)
        {
            return null;
        } catch (ClassNotFoundException e)
        {
            return null;
        } finally
        {
            try
            {
                if (ois != null)
                    ois.close();
            } catch (IOException e)
            {
            }
        }
    }
    
    /**
     * Serialize an object.
     * 
     * @param obj
     *            a serializable object.
     * @return a byte array of the serialized object or null if an error occurs.
     */
    public static byte[] serialize(Object obj)
    {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try
        {
            oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.flush();
            baos.flush();
            return baos.toByteArray();
        } catch (IOException e)
        {
            return null;
        } finally
        {
            try
            {
                if (oos != null)
                    oos.close();
            } catch (IOException e)
            {
            }
        }
    }
    
    /**
     * @Title: getPicHightAndWidth
     * @Description: TODO(获取宽和高)
     * @param in
     *            : 图片输入流
     * @return Map<String,Long>: 返回图片的宽和高
     * @throws
     */
    public static Map<String, Integer> getPicHightAndWidth(InputStream in) throws IOException {
        Map<String, Integer> map = new HashMap<String, Integer>();
        BufferedImage bi = ImageIO.read(in);
        map.put("width", bi.getWidth());
        map.put("height", bi.getHeight());
        return map;
    }

    /**
     * @Title: getPicHightAndWidth
     * @Description: TODO(获取宽和高)
     * @param in
     *            : 图片输入流
     * @return Map<String,Long>: 返回图片的宽和高
     * @throws
     */
    public static Map<String, Integer> getPicHightAndWidth(byte[] bytes) throws IOException {
        Map<String, Integer> map = new HashMap<String, Integer>();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        BufferedImage bi = ImageIO.read(in);
        map.put("width", bi.getWidth());
        map.put("height", bi.getHeight());
        return map;
    }
}
