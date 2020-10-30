package com.wsyt.base.ds.learn.sort

/**
 *
 * @Author ruyin_zh
 * @Date 2020/9/22
 * @Title 选择排序--简单排序
 * @Desc 从左到右依次选择每个位置元素与后续其他元素进行比较
 *       从第一个位置与指定的最小位置元素比较:
 *          1)、若当前位置元素比选中最小位置元素小,交换两元素下标;
 *          2)、剩余元素依次与当前最小位置元素对比,若比当前最小位置元素小,继续1)步骤,直至数组尾部;
 *       插入排序是不稳定的,考虑[5,8,5,2,7]这种场景,随着选择的进行,原第一个5将会排到原第三个5后面,造成相同元素的位置移动
 *
 * */
object SelectionSort {


  def sort(arr: Array[Int]): Unit ={
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
  }

}
