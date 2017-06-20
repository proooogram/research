package com.z.util;

/**
 * Created by agui on 2017/6/20.
 */
public class Empty {
    public static final byte[] empty_byte_array = new byte[0];
    public static boolean isEmpty(byte[] data){
        return (null == data || 0 == data.length);
    }
}
