package com.wsyt.base.ds.learn.sort

/**
 *
 * @Author ruyin_zh
 * @Date 2020/9/22
 * @Title 冒泡排序--简单排序
 * @Desc 从左到右依次令相邻元素进行比较
 *
 * */
object BubbleSort {

  def main(args: Array[String]): Unit = {
    val arr: Array[Int] = BaseUtil.generateRandomArr().toArray

    val length: Int = arr.length

    for (_ <- 0 until length-1) {
      for (j <- 0 until length - 1 if arr(j) > arr(j+1)){
        BaseUtil.swap(arr,j,j+1)
      }
    }

    BaseUtil.printArr(arr)
  }

}
