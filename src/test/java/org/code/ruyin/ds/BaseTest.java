package org.code.ruyin.ds;

import org.junit.jupiter.api.Test;

/**
 * @author hjxz
 * @date 2021/6/24
 * @title
 * @description
 */
public abstract class BaseTest {


    @Test
    public void baseOpRule(){
        int i = 5;
        int j = i--; // j = i; i = i - 1; return j;
        int k = --i; // i = i - 1; k = i; return k;
        System.out.println(j + ":" + i + ":" + k) ;
    }
}
