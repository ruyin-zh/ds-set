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
        this(DEFAULT_CAPACITY);
    }

    public BinaryHeap(int capacity){
        currentSize = 0;
        array = (T[]) new Comparable[capacity + 1];
    }

    public BinaryHeap(T[] items){
        currentSize = items.length;
        array = (T[]) new Comparable[(currentSize + 2) * 11 / 10];

        int index = 1;
        for (T item :items){
            array[index++] = item;
        }
        buildHeap();
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
     * 若item可以放在该空穴中而不破坏堆序性质则插入完成,否则需要将空穴的父节点上的元素移入到该空穴中,如此空穴就朝着根的方向上冒一步;
     * 继续以上过程直到item能被放入到空穴中;
     *
     * */
    public void insert(T item){
        //判断是否需要扩充原数组大小
        if (currentSize == array.length - 1){
            enlargeArray(array.length * 2 + 1);
        }
        //判断是否需要通过上滤(percolate up)来进行插入
        int hold = ++currentSize;
        //hold /= 2操作在 array[hold] = array[hold / 2]之后
        for (array[0] = item; item.compareTo(array[hold / 2]) < 0; hold /= 2){
            array[hold] = array[hold / 2];
        }
        array[hold] = item;
    }

    /**
     * 获取二叉堆的最小元素
     *
     * */
    public T findMin(){
        if (isEmpty()){
            throw new UnderflowException();
        }
        return array[1];
    }

    /**
     * 删除二叉堆最小元素
     * 1、将最小位置使用堆中最后元素填充并缩减堆中有效元素数;
     * 2、从起始位置进行下滤操作;
     * 3、返回被移除的元素;
     * */
    public T deleteMin(){
        if (isEmpty()){
            throw new UnderflowException();
        }

        //获取二叉堆最小值
        T minItem = findMin();
        //将最小值位置使用堆中最后一个元素移入空穴
        //同时当前堆中元素总数将减少1
        array[1] = array[currentSize--];
        percolateDown(1);
        return minItem;
    }


    public boolean isEmpty(){
        return currentSize == 0;
    }

    /**
     * 清空堆中记录数,核心逻辑由currentSize控制
     * */
    public void makeEmpty(){
        currentSize = 0;
    }

    //默认大小
    private static final int DEFAULT_CAPACITY = 10;
    //当前堆中元素数
    private int currentSize;
    //当前维护数组结构
    private T[] array;

    /**
     * 内部下滤操作方法
     * @param hold 下滤操作位置
     * */
    private void percolateDown(int hold){
        int child;
        T tmp = array[hold];

        for (; hold * 2 <= currentSize; hold = child){
            child = hold * 2;
            if (child != currentSize && array[child + 1].compareTo(array[child]) < 0){
                child++;
            }
            if (array[child].compareTo(tmp) < 0){
                array[hold] = array[child];
            }else {
                break;
            }
        }
        array[hold] = tmp;
    }

    private void buildHeap(){
        for (int i = currentSize / 2;i > 0;i--){
            percolateDown(i);
        }
    }

    private void enlargeArray(int newSize){
        T[] old = array;
        array = (T[]) new Comparable[newSize];

        for (int i = 0; i< old.length; i++){
            array[i] = old[i];
        }
    }
}
