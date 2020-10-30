package com.wsyt.base.ds.learn.sort

/**
  *
  * @author ruyin_zh
  * @date 2020-09-22
  * @title 希尔排序--优化版的插入排序
  * @description 希尔排序是基于插入排序的以下两点性质而提出的改进方法的:
  *              1、插入排序在对几乎已经排好序的数据操作时,效率高,可以达到线性排序的效率;
  *              2、插入排序一般是低效的,因为插入排序每次只能将数据移动一位;
  *
  *              希尔排序基本思路:先将整个待排序记录分割成若干子序列分别进行直接插入排序,待整个序列中的记录'基本有序'时,再对全体记录进行依次直接插入排序;
  *
  */
object ShellSort {

  //Donald Knuth算法:保持间隔序列之间元素互质
  //h=3*h+1
  def sort(arr: Array[Int]): Unit ={
    val length: Int = arr.length

    var gap: Int = 1
    while (gap < length){
      gap = gap * 3 + 1
    }

    while (gap > 0){
      //经过多轮gap插入排序完成排序操作
      for (i <- 0 until gap){
        shellInsertSort(i,gap,arr)
      }

      gap = (gap - 1) / 3
    }

    BaseUtil.printArr(arr)
  }


  private def shellInsertSort(index: Int, gap: Int, arr: Array[Int]): Unit ={

    var targetIndex = index + gap

    while (targetIndex < arr.length){
      val temp = arr(targetIndex)

      var previousIndex = targetIndex - gap

      while (previousIndex >= 0 && arr(previousIndex) > temp){
        arr(previousIndex + gap) = arr(previousIndex)
        previousIndex = previousIndex - gap
      }

      arr(previousIndex + gap) = temp

      targetIndex = targetIndex + gap
    }

  }

}
