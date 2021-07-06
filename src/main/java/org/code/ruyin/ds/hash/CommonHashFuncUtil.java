package org.code.ruyin.ds.hash;

/**
 * @author hjxz
 * @date 2021/7/6
 * @title
 * @description 一般hash方法
 */
public final class CommonHashFuncUtil {


    /**
     *
     * 根据字符串的ascii或unicode计算hash值
     *
     * */
    public static int hashByAsciiCode(String key, int tableSize){
        int hashVal = 0;

        for (int i = 0; i < key.length(); i++){
            hashVal += key.charAt(i);
        }

        return hashVal % tableSize;
    }


    /**
     *
     * 根据关键字前三位计算hash值
     *
     * */
    public static int hashByFirst(String key, int tableSize){
        return (key.charAt(0) + key.charAt(1) * 27 + key.charAt(2) * 729) % tableSize;
    }



    /**
     *
     * 赋予每位字符以常量并做补偿机制(允许溢出)
     *
     * */
    public static int hashBySupply(String key, int tableSize){
        int hashVal = 0;

        for (int i = 0; i < key.length(); i++){
            //可能存在溢出
            hashVal = 37 * hashVal + key.charAt(i);
        }

        hashVal %= tableSize;
        if (hashVal < 0){
            hashVal += tableSize;
        }

        return hashVal;
    }

}
