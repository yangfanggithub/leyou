package com.leyou.common.utils;

import java.util.UUID;

public class UuidUtils {

    /**
     * 获取20位长度的uuid
     * @return
     */
    public static String getUUID20(){
        return getUUID(20).toString();
    }

    /**
     * 得到指定数量的UUID，以数组的形式返回
     * @param num
     * @return
     */
    public static String[] getUUID(int num){
        if( num <= 0) return null;
        String[] uuidArr = new String[num];
        for (int i = 0; i < uuidArr.length; i++) {
            uuidArr[i] = getUUID32();
        }
        return uuidArr;
    }

    /**
     * 得到32位的uuid
     */
    public static String getUUID32(){
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

}
