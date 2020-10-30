package com.wsyt.base.ds.learn.sort

/**
  *
  * @author ruyin_zh
  * @date 2020-09-23
  * @title 快速排序
  * @description  1、描述:基于分治法对数组进行多躺排序
  *               2、步骤:1)、先从数组中取出一个数作为基准数(一般取第一个数);
  *                      2)、分区过程中将比这个数大的放在它的右边,小的数放在其左边;
  *                      3)、再对左右分区重复第二步,直到各区间只剩一个数;
  *               3、稳定性:稳定
  *
  */
object QuickSort {


  //Dutch National Flag
  def main(args: Array[String]): Unit = {
    val arr = Array(1,3,4,6,7,9,11,12,15,81,92,211,985,123,453,1000)
    quickSort(arr,0,arr.length - 1)

    //val list: List[Int] = quickSort(arr.toList)
    BaseUtil.printArr(arr)

  }

  def quickSort(list: List[Int]): List[Int] ={
    if (list.length < 2) list
    else quickSort(list.filter(list.head > _)) ++
    list.filter(list.head == _) ++
    quickSort(list.filter(list.head < _))
  }


  def quickSort(arr:Array[Int],begin:Int,end:Int): Unit = {
    if (begin < end){
      val pivot: Int = quickSort0(arr,begin,end)
      quickSort(arr,begin,pivot - 1)
      quickSort(arr,pivot + 1,end)
    }
  }

  private def quickSort0(arr:Array[Int],begin:Int,end:Int): Int ={
    var start = begin
    var stop = end

    val tmp = arr(start)
    while (start < stop){
      while (start < stop && arr(stop) >= tmp){
        stop = stop - 1
      }

      if (start < stop){
        arr(start) = arr(stop)
        start = start + 1
      }

      while (start < stop && arr(start) < tmp){
        start = start + 1
      }

      if (start < stop){
        arr(stop) = arr(start)
        stop = stop - 1
      }
    }

    arr(start) = tmp

    start
  }

}
