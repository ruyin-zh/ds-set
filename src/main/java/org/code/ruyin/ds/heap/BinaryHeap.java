package org.code.ruyin.ds.heap;

import org.code.ruyin.ds.ex.UnderflowException;

/**
 * @author hjxz
 * @date 2021/7/17
 * @title 二叉堆
 * @description 时刻谨记结构性质及堆序性质
 */
public class BinaryHeap<T extends Comparable<? super T>> {


    public BinaryHeap(){

    }

    public BinaryHeap(int capacity){

    }

    public BinaryHeap(T[] items){

    }

    /******************************/
    /****                      ****/
    /****        基础操作       ****/
    /****                      ****/
    /******************************/
    /**
     * 插入操作
     *
     * 为将一个元素item插入到堆中,需要在下一个可用位置上创建一个空穴,否则该堆将不是完全树;
     * 若item可以放在该空穴中而不破坏堆序性质则插入完成,否则需要将空穴的父节点上的元素移入到该空穴中,如此空穴就朝着根的方向上冒一部;
     * 继续以上过程直到item能被放入到空穴中;
     *
     * */
    public void insert(T item){
        //判断是否需要扩充原数组大小
        if (currentSize == array.length - 1){
            enlargeArray(array.length * 2 + 1);
        }
        //判断是否需要通过上虑来进行插入
        int hold = ++currentSize;
        for (array[0] = item; item.compareTo(array[hold / 2]) < 0; hold /= 2){
            array[hold] = array[hold / 2];
        }
        array[hold] = item;
    }

    public T findMin(){

        return null;
    }

    public T deleteMin(){
        if (isEmpty()){
            throw new UnderflowException();
        }

        //获取二叉堆最小值
        T minItem = findMin();
        //将最小值位置使用完全树的最后一位进行填充
        array[1] = array[currentSize--];

        return null;
    }

    public boolean isEmpty(){

        return false;
    }

    public void makeEmpty(){


    }

    //默认大小
    private static final int DEFAULT_CAPACITY = 10;
    //当前堆中元素数
    private int currentSize;
    //当前维护数组结构
    private T[] array;


    private void percolateDown(){

    }

    private void buildHeap(){


    }

    private void enlargeArray(int newSize){


    }
}
