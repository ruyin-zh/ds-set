package org.code.ruyin.ds.heap;

import org.code.ruyin.ds.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author hjxz
 * @date 2021/7/21
 * @title
 * @description
 */
public class BinaryHeapTest extends BaseTest {

    @Test
    @DisplayName("二叉堆操作")
    public void heapOperate(){
        int numItems = 10000;

        BinaryHeap<Integer> heap = new BinaryHeap<>();
        int i = 37;
        for (i = 37; i != 0; i = (i + 37) % numItems){
            heap.insert(i);
        }

        for (i = 1; i < numItems; i++){
            if (heap.deleteMin() != i){
                System.out.println("Oops!" + i);
            }
        }
    }

}
