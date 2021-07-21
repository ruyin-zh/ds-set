package org.code.ruyin.ds.hash.collision;

import java.util.Arrays;

/**
 * @author hjxz
 * @date 2021/7/8
 * @title 平方探测法
 * @description
 * @see package-info
 *
 */
public class QuadraticProbingHashTable<T> {

    public QuadraticProbingHashTable(){
        this(DEFAULT_TABLE_SIZE);
    }

    public QuadraticProbingHashTable(int size){
        allocateArray(size);
        makeEmpty();
    }

    public void makeEmpty(){
        occupied = 0;
        Arrays.fill(array, null);
    }

    public int size(){
        return currentSize;
    }

    public int capacity(){
        return array.length;
    }


    public boolean contains(T element){
        int pos = findPos(element);
        return isActive(pos);
    }

    public boolean insert(T element){
        int currentPos = findPos(element);
        if (isActive(currentPos)){
            return false;
        }

        if (array[currentPos] == null){
            ++occupied;
        }

        array[currentPos] = new HashEntry<>(element);
        currentSize++;

        if (occupied > array.length / 2){
            rehash();
        }

        return true;
    }

    /**
     *
     * 移除散列表对应元素,因探测法依赖散列表所有元素,故不可真实删除,只做标记
     *
     * */
    public boolean remove(T element){
        int pos = findPos(element);
        if (isActive(pos)){
            array[pos].active = false;
            currentSize--;
            return true;
        }
        return false;
    }


    private static class HashEntry<T>{

        private T element;
        private boolean active;

        public HashEntry(T element){
            this(element,true);
        }

        public HashEntry(T element, boolean active){
            this.element = element;
            this.active = active;
        }
    }


    private static final int DEFAULT_TABLE_SIZE = 11;

    //散列表数据存储结构
    private HashEntry<T>[] array;
    //当前散列表已被占据单元,包含标记删除记录
    private int occupied;
    //当前散列表数据变更次数
    private int currentSize;


    private void allocateArray(int arraySize){
        array = new HashEntry[nextPrime(arraySize)];
    }

    private boolean isActive(int currentPos){
        return array[currentPos] != null && array[currentPos].active;
    }

    private int findPos(T element){
        int offset = 1;

        int currentPos = myHash(element);
        while (array[currentPos] != null && !array[currentPos].element.equals(element)){
            currentPos += offset;
            offset += 2;
            if (currentPos >= array.length){
                currentPos -= array.length;
            }
        }
        return currentPos;
    }

    /**
     * 重散列
     * */
    private void rehash(){
        HashEntry<T>[] oldArr = array;

        allocateArray(nextPrime(oldArr.length * 2));
        currentSize = 0;
        occupied = 0;

        for (int i = 0; i < oldArr.length; i++){
            if (oldArr[i] != null && array[i].active){
                insert(oldArr[i].element);
            }
        }
    }


    private int myHash(T element){
        int hashVal = element.hashCode();

        hashVal %= array.length;
        if (hashVal < 0){
            hashVal += array.length;
        }
        return hashVal;
    }

    private static int nextPrime(int num){
        if (num % 2 == 0){
            num ++;
        }

        for (; !isPrime(num); num += 2){
            ;
        }
        return num;
    }

    private static boolean isPrime(int num){
        if (num == 2 || num == 3){
            return true;
        }

        if (num == 1 || num % 2 == 0){
            return false;
        }

        for (int i = 3; i * i <= num; i += 2){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
