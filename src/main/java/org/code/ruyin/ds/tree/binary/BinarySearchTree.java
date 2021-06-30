package org.code.ruyin.ds.tree.binary;

import org.code.ruyin.ds.tree.UnderflowException;

import java.util.Comparator;
import java.util.Optional;

/**
 * @author hjxz
 * @date 2021/5/27
 * @title
 * @description 使二叉树成为二叉搜索树的性质:
 *              对于树中的每个节点X,它的左子树中所有项的值小于X中的项,它的右子树中所有项的值都大于X中的项;
 */
public class BinarySearchTree<T extends Comparable<T>> {

    //此处为了简单起见,各项值之间互斥不存在重复值
    private BinaryNode<T> root;
    //此处不限定T继承于Comparable而改用Comparator是考虑到更多可能性;
    private Comparator<? super T> cmp;

    public BinarySearchTree() {
        this(null);
    }

    public BinarySearchTree(Comparator<? super T> cmp) {
        this.root = null;
        this.cmp = cmp;
    }

    public void makeEmpty() {
        this.root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }


    public boolean contains(T x) {
        return contains(x, root);
    }

    public T findMin() {
        if (isEmpty()) {
            throw new UnderflowException();
        }

        return findMin(root).map(BinaryNode::getElement).orElse(null);
    }

    public T findMax() {
        if (isEmpty()) {
            throw new UnderflowException();
        }

        return findMax(root).map(BinaryNode::getElement).orElse(null);
    }

    public void insert(T x) {
        root = insert(x, root);
    }

    public void remove(T x) {
        root = remove(x, root);
    }

    public void printTree() {
        printTree(root);
    }


    /**
     * 给定一个值判断该值在当前树中是否存在
     *
     * @param x    待确认项
     * @param node 当前节点
     */
    private boolean contains(T x, BinaryNode<T> node) {
        if (node == null) {
            return false;
        }
        //优化之后的比较方法
        int cmpResult = compatibleCompare(x, node.element);
        //TODO 此处调用可以替换为尾递归,避免调用栈过深
        if (cmpResult < 0) {
            return contains(x, node.left);
        } else if (cmpResult > 0) {
            return contains(x, node.right);
        } else {
            return true;
        }
    }

    /**
     * 从指定节点查找最小值,使用递归查找
     *
     * @param node 当前节点
     */
    private Optional<BinaryNode<T>> findMin(BinaryNode<T> node) {
        if (node == null) {
            return Optional.empty();
        }

        if (node.left == null) {
            return Optional.of(node);
        }

        return findMin(node.left);
    }

    /**
     * 从当前节点查找最大值,使用尾递归方式查找
     *
     * @param node 当前节点
     */
    private Optional<BinaryNode<T>> findMax(BinaryNode<T> node) {
        if (node == null) {
            return Optional.empty();
        }

        while (node.right != null) {
            node = node.right;
        }
        return Optional.of(node);
    }

    /**
     * @param x    欲插入值
     * @param node 当期节点
     */
    private BinaryNode<T> insert(T x, BinaryNode<T> node) {
        if (node == null) {
            return new BinaryNode<>(x, null, null);
        }

        int cmpResult = compatibleCompare(x, node.element);
        if (cmpResult < 0) {
            node.left = insert(x, node.left);
        } else if (cmpResult > 0) {
            node.right = insert(x, node.right);
        } else {
            //nop
        }
        return node;
    }

    private BinaryNode<T> remove(T x, BinaryNode<T> node) {
        //不存在左右节点则直接赋值为null
        if (node == null) {
            return null;
        }

        int cmpResult = compatibleCompare(x, node.element);
        if (cmpResult < 0) {
            node.left = remove(x, node.left);
        } else if (cmpResult > 0) {
            node.right = remove(x, node.right);
        }
        //存在两个子节点
        else if (node.left != null && node.right != null) {
            node.element = findMin(node.right).map(BinaryNode::getElement).orElse(null);
            node.right = remove(node.element, node.right);
        } else {
            node = node.left != null ? node.left : node.right;
        }
        return node;
    }

    private void printTree(BinaryNode<T> node) {
        if (node == null) {
            return;
        }

        printTree(node.left);
        System.out.println(node.element);
        printTree(node.right);
    }


    private int compatibleCompare(T lhs, T rhs) {
        if (cmp != null) {
            return cmp.compare(lhs, rhs);
        }

        return lhs.compareTo(rhs);
    }

    /**
     * @title
     * @description 树实际上是图, 故而节点表示为为圆圈; 具有N个节点的二叉树需要N+1个null链
     */
    private static class BinaryNode<T> {

        //节点数据
        private T element;
        //左节点
        private BinaryNode<T> left;
        //右节点
        private BinaryNode<T> right;

        public BinaryNode(T element, BinaryNode<T> left, BinaryNode<T> right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        public T getElement() {
            return element;
        }
    }
}
