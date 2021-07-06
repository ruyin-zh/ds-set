package org.code.ruyin.ds.hash.collision;

import java.util.LinkedList;
import java.util.List;

/**
 * @author hjxz
 * @date 2021/7/7
 * @title 1、分离链接法
 * @description 除链表外,其它方案同样可解决冲突问题: 一颗二叉查找树或另一个散列表都可,
 *              不过若散列表是大的且散列函数是好的,那么所有的链表都应该是短的,这时其它方案就可不做考虑了;
 *
 *              注意所有的匹配都是基于equals方法
 */
public class SeparateChainingHashTable<T> {

    public SeparateChainingHashTable(){
        this(DEFAULT_TABLE_SIZE);
    }

    public SeparateChainingHashTable(int size){
        list = new LinkedList[nextPrime(size)];
        for (int i = 0; i < list.length; i++){
            list[i] = new LinkedList<>();
        }
    }

    public void insert(T element){
        List<T> ts = list[myHash(element)];
        if (ts.contains(element)){
            return;
        }
        ts.add(element);
        if (++currentSize > list.length){
            rehash();
        }
    }

    public void remove(T element){
        List<T> ts = list[myHash(element)];
        if (ts.contains(element)){
            ts.remove(element);
            currentSize--;
        }
    }

    public boolean contains(T element){
        List<T> ts = list[myHash(element)];
        return ts.contains(element);
    }

    public void makeEmpty(){
        for (int i = 0; i < list.length; i++){
            list[i].clear();
        }
        currentSize = 0;
    }

    private static final int DEFAULT_TABLE_SIZE = 101;

    private List<T>[] list;

    private int currentSize;

    private void rehash(){
        List<T>[] oldList = list;

        list = new LinkedList[nextPrime(list.length * 2)];
        for (int i = 0; i < list.length; i++){
            list[i] = new LinkedList<>();
        }

        currentSize = 0;
        for (int i = 0; i < oldList.length; i++){
            for (T element : oldList[i]){
                insert(element);
            }
        }
    }

    /**
     *
     * 自定义hash函数
     *
     * */
    private int myHash(T element){
        int hashVal = element.hashCode();

        hashVal %= list.length;
        if (hashVal < 0){
            hashVal += list.length;
        }

        return hashVal;
    }

    private static int nextPrime(int num){
        if (num % 2 == 0){
            num++;
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

        for (int i = 3; i * i <= num; i+= 2){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(nextPrime(12));
        System.out.println(nextPrime(15));
        System.out.println(nextPrime(2));
        System.out.println(nextPrime(1));
        System.out.println(nextPrime(101));
        System.out.println(nextPrime(4));
        System.out.println(isPrime(5));
    }
}
