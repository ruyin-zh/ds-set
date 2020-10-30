package com.wsyt.base.ds.learn.sort

/**
  *
  * @author ruyin_zh
  * @date 2020-09-23
  * @title 归并排序
  * @description
  *
  */
object MergeSort {

  def sort(arr:Array[Int]):Unit = {
    val temp = new Array[Int](arr.length)

    sort(arr,0, arr.length - 1,temp)
  }

  def sort(arr: Array[Int], left: Int, right: Int, temp: Array[Int]): Unit ={
    if (left < right){
      val mid = left + (right - left) / 2
      sort(arr,left,mid,temp)
      sort(arr,mid + 1,right,temp)
      merge(arr,left,mid,right,temp)
    }
  }

  def merge(arr:Array[Int], left:Int, mid:Int, right:Int, temp:Array[Int]): Unit = {
    var dyLeft = left
    var dyRight = mid + 1
    var pos = 0

    while (dyLeft <= mid && dyRight <= right){
      //算法稳定性要求
      if (arr(dyLeft) <= arr(dyRight)){
        temp(pos) = arr(dyLeft)
        pos = pos + 1
        dyLeft = dyLeft + 1
      }else {
        temp(pos) = arr(dyRight)
        pos = pos + 1
        dyRight = dyRight + 1
      }
    }

    while (dyLeft <= mid){
      temp(pos) = arr(dyLeft)
      pos = pos + 1
      dyLeft = dyLeft + 1
    }

    while (dyRight <= right){
      temp(pos) = arr(dyRight)
      pos = pos + 1
      dyRight = dyRight + 1
    }

    pos = 0
    if (left <= right){
      for (p <- left to right){
        arr(p) = temp(pos)
        pos = pos + 1
      }
    }
  }

}
