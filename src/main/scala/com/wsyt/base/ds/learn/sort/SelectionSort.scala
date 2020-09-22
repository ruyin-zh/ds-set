package com.wsyt.base.ds.learn.sort

/**
 *
 * @Author ruyin_zh
 * @Date 2020/9/22
 * @Title 选择排序--简单排序
 * @Desc 从左到右依次选择每个位置元素与后续其他元素进行比较
 *       从第一个位
 *       插入排序是不稳定的,考虑[5,8,5,2,7]这种场景,随着选择的进行,原第一个5将会排到原第三个5后面,造成相同元素的位置移动
 *
 * */
object SelectionSort {


  def main(args: Array[String]): Unit = {
    val arr: Array[Int] = BaseUtil.generateRandomArr().toArray

    val length: Int = arr.length
    var minPos = 0
    //需要比较的数组位数为
    for (i <- 0 until length - 1){
      for (j <- i until length if arr(j) < arr(minPos)){
        minPos = j
      }

      BaseUtil.swap(arr,i,minPos)

      minPos = i + 1
    }

    BaseUtil.printArr(arr)
  }

}
