package org.code.ruyin.ds.tree;

import org.code.ruyin.ds.BaseTest;
import org.code.ruyin.ds.tree.binary.BinarySearchTree;
import org.junit.jupiter.api.Test;

/**
 * @author hjxz
 * @date 2021/6/24
 * @title
 * @description
 */
public class BinarySearchTreeTest extends BaseTest {


    @Test
    public void buildBinarySearchTree(){
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        tree.insert(6);
        tree.insert(2);
        tree.insert(8);
        tree.insert(1);
        tree.insert(5);
        tree.insert(3);
        tree.insert(4);

        tree.printTree();

        tree.remove(2);
    }

}
