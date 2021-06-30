package org.code.ruyin.ds.tree;

import org.code.ruyin.ds.BaseTest;
import org.code.ruyin.ds.tree.avl.AvlTree;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author hjxz
 * @date 2021/6/30
 * @title
 * @description
 */
public class AvlTreeTest extends BaseTest {

    private static int[] eleArr = new int[]{3, 2, 1, 4, 5, 6, 7, 16, 15, 14, 13, 12, 11, 10, 8, 9};


    @Test
    @DisplayName("平衡树构建")
    public void buildAvlTree() {
        AvlTree<Integer> avlTree = new AvlTree<>();
        for (int index = 0; index < eleArr.length; index++) {
            avlTree.insert(eleArr[index]);
        }

        avlTree.printTree();
    }

}
