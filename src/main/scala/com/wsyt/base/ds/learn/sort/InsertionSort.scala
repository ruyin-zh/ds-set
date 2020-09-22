package com.wsyt.base.ds.learn.sort

/**
 *
 * @Author ruyin_zh
 * @Date 2020/9/22
 * @Title 插入排序--简单排序
 * @Desc 从左到右以第二个元素为起始向前比较并交换
 *
 * */
object InsertionSort {

  def main(args: Array[String]): Unit = {
    val arr: Array[Int] = Array(5, 3, 6, 8, 1, 7, 9, 4, 2)

    val length: Int = arr.length

    for (i <- 1 until length){
      for (j <- i until 0 by -1){
        if (arr(j) < arr(j-1)){
          Base.swap(arr,j,j-1)
        }
      }
    }

    Base.printArr(arr)
  }

}
