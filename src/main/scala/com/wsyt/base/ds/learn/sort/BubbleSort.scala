package com.wsyt.base.ds.learn.sort

/**
 *
 * @Author ruyin_zh
 * @Date 2020/9/22
 * @Title 冒泡排序--简单排序
 * @Desc 1、描述:从左到右依次令相邻元素进行比较
 *       2、步骤:从数组第一个位置开始向后比较:
 *            1)、相邻两元素一次对比,若小于(或大于)则交换,每一轮需要对比的元素数为n-1;
 *            2)、循环1)步骤直至外层循环结束;
 *          不论数组是否有序,时间复杂度都将为n²,空间复杂度为1;
 *       3、稳定性: 稳定
 * */
object BubbleSort {


  def sort(arr: Array[Int]): Unit ={
    val length: Int = arr.length

    for (_ <- 1 until length) {
      for (j <- 0 until length - 1 if arr(j) > arr(j+1)){
        BaseUtil.swap(arr,j,j+1)
      }
    }
  }

}
