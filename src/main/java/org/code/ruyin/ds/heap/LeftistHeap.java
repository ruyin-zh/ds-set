package org.code.ruyin.ds.heap;

import org.code.ruyin.ds.ex.UnderflowException;

/**
 * @author adsk
 * @date 2021/9/16
 * @title 左式堆
 * @description
 *      左式堆结构定义缘由: 设计一种堆结构像二叉堆那样有效地支持合并操作且只使用一个数组似乎很困难;
 *      左式堆与二叉堆类似,同样具有结构性和有序性;
 *      左式堆与二叉堆唯一区别:左式堆不是理想平衡的(perfectly balanced),而实际上趋向于非常不平衡;
 *
 *      ☆定义: 任一节点x的零路径长(null path length)npl(x)定义为从x到一个不具有两个儿子的节点的最短路径的长,故具有0个或一个儿子节点的npl为0,而npl(null)=-1;
 *      ☆左式堆性质: 对于堆中的每个节点x,左儿子的零路径长不小于右儿子零路径长;
 */
public class LeftistHeap<T extends Comparable<? super T>> {

    private LeftistNode<T> root;

    public LeftistHeap(){
        this.root = null;
    }

    public void merge(LeftistHeap<T> rhs){
        if (this == rhs){
            return;
        }

        root = merge(root, rhs.root);
    }

    private LeftistNode<T> merge(LeftistNode<T> h1, LeftistNode<T> h2){
        if (h1 == null){
            return h2;
        }

        if (h2 == null){
            return h1;
        }

        if (h1.ele.compareTo(h2.ele) < 0){
            return merge0(h1, h2);
        } else {
            return merge0(h2, h1);
        }

    }

    private LeftistNode<T> merge0(LeftistNode<T> h1, LeftistNode<T> h2){
        if (h1.left == null){
            h1.left = h2;
        } else {
            h1.right = merge(h1.right, h2);
            if (h1.left.npl < h1.right.npl){
                swapChild(h1);
            }
            h1.npl = h1.right.npl + 1;
        }

        return h1;
    }

    private void swapChild(LeftistNode<T> node){
        LeftistNode<T> tmp = node.left;
        node.left = node.right;
        node.right = tmp;
    }

    public void insert(T x){
        root = merge(new LeftistNode<>(x), root);
    }

    public T findMin(){
        if (isEmpty()){
            throw new UnderflowException();
        }

        return root.ele;
    }

    public T deleteMin(){
        if (isEmpty()){
            throw new UnderflowException();
        }

        T minItem = root.ele;
        root = merge(root.left, root.right);
        return minItem;
    }

    public boolean isEmpty(){
        return root == null;
    }

    public void makeEmpty(){
        root = null;
    }

    private static class LeftistNode<T> {

        private T ele;
        private LeftistNode<T> left;
        private LeftistNode<T> right;
        private int npl;

        LeftistNode(T ele){
            this(ele,null,null);
        }

        LeftistNode(T ele, LeftistNode<T> lt, LeftistNode<T> rt){
            this.ele = ele;
            this.left = lt;
            this.right = rt;
            this.npl = 0;
        }

    }


}
