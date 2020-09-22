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
    val arr: Array[Int] = Array(5, 3, 6, 8, 1, 7, 9, 4, 2)

    val length: Int = arr.length

    for (_ <- 0 until length-1) {
      for (j <- 0 until length - 1){
        if (arr(j) > arr(j+1)){
          Base.swap(arr,j,j+1)
        }
      }
    }

    Base.printArr(arr)
  }

}
