package org.code.ruyin.ds.tree;

/**
 * @author hjxz
 * @date 2021/5/27
 * @title
 * @description
 */
public class TreeNode<T> {

    private T element;

    private TreeNode<T> firstChild;

    private TreeNode<T> nextSibling;


    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public TreeNode<T> getFirstChild() {
        return firstChild;
    }

    public void setFirstChild(TreeNode<T> firstChild) {
        this.firstChild = firstChild;
    }

    public TreeNode<T> getNextSibling() {
        return nextSibling;
    }

    public void setNextSibling(TreeNode<T> nextSibling) {
        this.nextSibling = nextSibling;
    }
}
