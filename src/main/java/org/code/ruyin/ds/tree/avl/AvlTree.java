package org.code.ruyin.ds.tree.avl;

import org.code.ruyin.ds.tree.UnderflowException;

import java.util.Optional;

/**
 * @author hjxz
 * @date 2021/6/24
 * @title
 * @description 针对二叉搜索树移除和插入操作之后出现的不平衡进行处理,防止出现最坏情况演变成线性结构
 *              平衡二叉树的性质: 任何节点左右子树高度差不可超过1;
 *
 */
public class AvlTree<T extends Comparable<T>> {

    private AvlNode<T> root;

    public AvlTree(){
        this.root = null;
    }

    public T findMin(){
        if (isEmpty()){
            throw new UnderflowException();
        }

        return findMin(root).map(AvlNode::getElement).orElse(null);
    }

    public T findMax(){
        if (isEmpty()){
            throw new UnderflowException();
        }

        return findMax(root).map(AvlNode::getElement).orElse(null);
    }

    public boolean isEmpty(){
        return root == null;
    }

    private Optional<AvlNode<T>> findMin(AvlNode<T> node){
        if (node == null){
            return Optional.empty();
        }

        if (node.leftNode == null){
            return Optional.of(node);
        }

        return findMin(node.leftNode);
    }


    private Optional<AvlNode<T>> findMax(AvlNode<T> node){
        if (node == null){
            return Optional.empty();
        }

        if (node.rightNode == null){
            return Optional.of(node);
        }

        return findMax(node.rightNode);
    }

    /**
     *
     * 获取当前节点的高度,节点为空则返回-1
     * @param node
     *
     * */
    private int height(AvlNode<T> node){
        return node == null ? -1 : node.height;
    }


    /**
     *
     * 从指定节点插入一个对象
     * @param node
     * @param element
     *
     * */
    private AvlNode<T> insert(T element, AvlNode<T> node){
        if (node == null){
            return new AvlNode<>(element);
        }

        int result = element.compareTo(node.element);
        if (result < 0){
            node.leftNode = insert(element,node.leftNode);
        }else if (result > 0){
            node.rightNode = insert(element,node.rightNode);
        }else {
            ;
        }

        return balance(node);
    }

    //每个节点的左右子树允许的高度差
    private static final int ALLOWED_IMBALANCE = 1;

    /**
     *
     * 从当前节点开始评估当前是否处于平衡状态
     * 核心方法
     * @param node 根节点
     *
     * */
    private AvlNode<T> balance(AvlNode<T> node){
        if (node == null){
            return null;
        }
        if (height(node.leftNode) - height(node.rightNode) > ALLOWED_IMBALANCE){
            if (height(node.leftNode.leftNode) >= height(node.rightNode.rightNode)){
                node = rotateWithLeftChild(node);
            }else {
                node = doubleWithLeftChild(node);
            }
        }else if (height(node.rightNode) - height(node.leftNode) > ALLOWED_IMBALANCE){
            if (height(node.rightNode.rightNode) >= height(node.rightNode.leftNode)){
                node = rotateWithRightChild(node);
            }else {
                node = doubleWithRightChild(node);
            }
        }

        node.height = Math.max(height(node.leftNode),height(node.rightNode)) + 1;
        return node;
    }

    private AvlNode<T> remove(T element, AvlNode<T> node){
        if (node == null){
            return null;
        }

        int cmpResult = element.compareTo(node.element);
        if (cmpResult < 0){
            node.leftNode = remove(element,node.leftNode);
        }else if (cmpResult > 0){
            node.rightNode = remove(element,node.rightNode);
        }else if (node.leftNode != null && node.rightNode != null){
            node.element = findMin(node.rightNode).map(AvlNode::getElement).orElse(null);
            node.rightNode = remove(node.element,node.rightNode);
        }else {
            node = node.leftNode != null ? node.leftNode : node.rightNode;
        }
        return balance(node);
    }



    /**
     *
     * 通过LL进行平衡节点高度
     * @param k2 左右高度不平衡节点
     * @return 返回节点替换原高度不平衡位置
     *
     * */
    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2){
        AvlNode<T> k1 = k2.leftNode;
        k2.leftNode = k1.rightNode;
        k1.rightNode = k2;

        k2.height = Math.max(height(k2.leftNode),height(k2.rightNode)) + 1;
        k1.height = Math.max(height(k1.leftNode), height(k1.rightNode)) + 1;
        return k1;
    }

    /**
     * 通过LR进行平衡节点高度
     * @param alphaNode 左右高度不平衡节点
     * @return 返回节点替换原高度不平衡位置
     * */
    private AvlNode<T> doubleWithLeftChild(AvlNode<T> alphaNode){
        alphaNode.leftNode = rotateWithRightChild(alphaNode.leftNode);
        return rotateWithLeftChild(alphaNode);
    }


    /**
     *
     * 通过RR进行平衡节点高度
     * @param k2 左右高度不平衡节点
     * @return  返回节点替换原高度不平衡位置
     * */
    private AvlNode<T> rotateWithRightChild(AvlNode<T> k2){
        AvlNode<T> k1 = k2.rightNode;
        k2.rightNode = k1.leftNode;
        k1.leftNode = k2;

        k2.height = Math.max(height(k2.leftNode),height(k2.rightNode)) + 1;
        k1.height = Math.max(height(k1.leftNode),height(k1.rightNode)) + 1;
        return k1;
    }

    /**
     *
     * 通过RL进行平衡节点高度
     * @param alphaNode 左右高度不平衡节点
     * @return  返回节点替换原高度不平衡位置
     * */
    private AvlNode<T> doubleWithRightChild(AvlNode<T> alphaNode){
        alphaNode.rightNode = rotateWithLeftChild(alphaNode.rightNode);
        return rotateWithLeftChild(alphaNode);
    }



    private static class AvlNode<T> {

        AvlNode(T element){
            this(element,null,null);
        }

        AvlNode(T element, AvlNode<T> leftNode, AvlNode<T> rightNode){
            this.element = element;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.height = 0;
        }

        private T element;
        private AvlNode<T> leftNode;
        private AvlNode<T> rightNode;
        private int height;

        public T getElement() {
            return element;
        }
    }
}
