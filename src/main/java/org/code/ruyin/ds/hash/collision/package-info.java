/**
 * @author hjxz
 * @date 2021/7/6
 * @title
 * @description 键冲突时可取的方法
 */
package org.code.ruyin.ds.hash.collision;

/**
 *
 * 第一类:分离链接法
 *      使用数组链表实现
 *
 * 第二类:几何探测法
 *      1)、线性探测法: hi(x) = (hash(x) + f(i)) mod TableSize, f(i) = i
 *      2)、平方探测法: hi(x) = (hash(x) + f(i)) mod TableSize, f(i) = i^2
 *      3)、双散列: hi(x) = (hash(x) + f(i)) mod TableSize, f(i) = i * hash2(x)
 * */