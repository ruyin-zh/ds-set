package org.code.ruyin.ds.hash;

import org.code.ruyin.ds.BaseTest;
import org.code.ruyin.ds.hash.collision.SeparateChainingHashTable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author hjxz
 * @date 2021/7/7
 * @title
 * @description
 */
public class SeparateChainingHashTableTest extends BaseTest {


    @Test
    @DisplayName("测试分离链表的效率")
    public void testBuild(){
        SeparateChainingHashTable<Integer> h = new SeparateChainingHashTable<>();
        long startTime = System.currentTimeMillis();
        final int NUMS = 2000000;
        final int GAP = 37;
        System.out.println("Checking... no more output means success");
        for (int i = GAP; i != 0;i = (i + GAP) %NUMS){
            h.insert(i);
        }

        for (int i = 1; i < NUMS; i += 2){
            h.remove(i);
        }

        for (int i = 2; i < NUMS; i += 2){
            if (!h.contains(i)){
                System.out.println("Find fails " + i);
            }
        }

        for (int i = 1; i < NUMS; i += 2){
            if (h.contains(i)){
                System.out.println("OOPS!!! " + i);
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time:" + (endTime - startTime));
    }



}
