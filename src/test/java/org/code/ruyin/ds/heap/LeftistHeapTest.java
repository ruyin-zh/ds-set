package org.code.ruyin.ds.heap;

import org.code.ruyin.ds.BaseTest;
import org.junit.jupiter.api.Test;

/**
 * @author adsk
 * @date 2022/2/17
 * @title
 * @description
 */
public class LeftistHeapTest extends BaseTest {


    @Test
    public void leftistHeapTest(){
        int numItems = 100;
        LeftistHeap<Integer> lhs = new LeftistHeap<>();
        LeftistHeap<Integer> rhs = new LeftistHeap<>();

        int i = 37;

        for (i = 37; i !=0; i = (i + 37) % numItems){
            if (i % 2 == 0){
                rhs.insert(i);
            }else {
                lhs.insert(i);
            }
        }
        lhs.merge(rhs);
        for (i = 1; i < numItems; i++){
            if (lhs.deleteMin() != i){
                System.out.println("Oops!" + i);
            }
        }
    }

}
