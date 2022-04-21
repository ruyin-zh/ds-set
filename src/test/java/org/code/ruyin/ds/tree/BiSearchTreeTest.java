package org.code.ruyin.ds.tree;

/**
 * @author adsk
 * @date 2022/2/22
 *
 */
public class BiSearchTreeTest<T extends Comparable<? super T>> {

    private BiTreeNode<T> root;


    public T findMin(){
        return findMin(root).element;
    }

    private BiTreeNode<T> findMin(BiTreeNode<T> node){
        if (node == null){
            return null;
        }

        if (node.left != null){
            return findMin(node.left);
        }

        return node;
    }

    public T findMax(){
        return findMax(root).element;
    }

    private BiTreeNode<T> findMax(BiTreeNode<T> node){
        if (node == null){
            return null;
        }

        while (node.right != null){
            node = node.right;
        }

        return node;
    }

    public boolean contains(T element){
        return contains(element,root);
    }

    private boolean contains(T element, BiTreeNode<T> node){
        int comRet = element.compareTo(node.element);
        if (comRet < 0){
            return contains(element,node.left);
        }else if(comRet > 0){
            return contains(element,node.right);
        }else {
            return true;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty(){
        root = null;
    }

    public void insert(T element){
        root = insert(element,root);
    }

    private BiTreeNode<T> insert(T element, BiTreeNode<T> node){
        if (node == null){
            return new BiTreeNode<>(element, null, null);
        }

        int comRet = element.compareTo(node.element);
        if (comRet < 0){
            node.left = insert(element, node.left);
        }else if (comRet > 0){
            node.right = insert(element, node.right);
        }else {
            //nop
        }

        return node;
    }

    public void remove(T element){
        root = remove(element, root);
    }

    private BiTreeNode<T> remove(T element, BiTreeNode<T> node){
        if (node == null){
            return null;
        }

        int comRet = element.compareTo(node.element);

        if (comRet < 0){
            node.left = remove(element, node.left);
        } else if (comRet > 0){
            node.right = remove(element, node.right);
        } else if (node.left != null && node.right != null){
            node.element = findMin(node.right).element;
            node.right = remove(element,node.right);
        } else {
            node = node.left != null ? node.left : node.right;
        }

        return node;
    }

    public void printTree(){
        printTree(root);
    }

    private void printTree(BiTreeNode<T> node){
        if (node == null){
            return;
        }

        printTree(node.left);
        System.out.println(node.element);
        printTree(node.right);
    }


    public static class BiTreeNode<T> {

        private T element;
        private BiTreeNode<T> left;
        private BiTreeNode<T> right;

        public BiTreeNode(T element, BiTreeNode<T> left, BiTreeNode<T> right){
            this.element = element;
            this.left = left;
            this.right = right;
        }

    }


    public static void main(String[] args) {
        BiSearchTreeTest<Integer> tree = new BiSearchTreeTest<>();
        tree.insert(4);
        tree.insert(1);
        tree.insert(28);
        tree.insert(19);
        tree.insert(3);
        tree.insert(5);
        tree.insert(2);
        tree.printTree();

        tree.remove(3);
        System.out.println("--------------");
        tree.printTree();
    }


}
