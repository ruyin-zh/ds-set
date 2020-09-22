package com.wsyt.base.ds.learn.sort

/**
 *
 * @Author ruyin_zh
 * @Date 2020/9/22
 * @Title 选择排序--简单排序
 * @Desc 从左到右依次选择每个位置元素与后续其他元素进行比较
 *
 * */
object SelectionSort {


  def main(args: Array[String]): Unit = {
    val arr: Array[Int] = Array(5, 3, 6, 8, 1, 7, 9, 4, 2)

    val length: Int = arr.length
    var minPos = 0
    for (i <- 0 until length - 1){
      for (j <- i until length){
        if (arr(j) < arr(minPos)){
          minPos = j
        }
      }

      Base.swap(arr,i,minPos)

      minPos = i + 1
    }

    Base.printArr(arr)
  }

}
