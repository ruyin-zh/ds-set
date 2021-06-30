package org.code.ruyin.ds.tree;

import org.code.ruyin.ds.BaseTest;
import org.code.ruyin.ds.tree.avl.AvlTree;
import org.junit.jupiter.api.Test;

/**
 * @author hjxz
 * @date 2021/6/30
 * @title
 * @description
 */
public class AvlTreeTest extends BaseTest {


    @Test
    public void buildAvlTree(){
        AvlTree<Integer> avlTree = new AvlTree<>();
        avlTree.insert(3);
        avlTree.insert(2);
        avlTree.insert(1);
        avlTree.insert(4);
        avlTree.insert(5);
        avlTree.insert(6);
        avlTree.insert(7);
        avlTree.insert(16);
        avlTree.insert(15);
        avlTree.insert(14);
        avlTree.insert(13);
        avlTree.insert(12);
        avlTree.insert(11);
        avlTree.insert(10);
        avlTree.insert(8);
        avlTree.insert(9);

        avlTree.printTree();
    }

}
